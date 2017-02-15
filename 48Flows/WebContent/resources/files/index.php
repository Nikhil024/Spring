<?php
// Define path to application directory
defined('APPLICATION_PATH')
        || define('APPLICATION_PATH', realpath(dirname(__FILE__) . '/../application'));

// Define application environment
defined('APPLICATION_ENV')
        || define('APPLICATION_ENV', (getenv('APPLICATION_ENV') ? getenv('APPLICATION_ENV') : 'production'));

// Define application environment
defined('PERSONAL_APPLICATION_ENV')
        || define('PERSONAL_APPLICATION_ENV', (getenv('PERSONAL_APPLICATION_ENV') ? getenv('PERSONAL_APPLICATION_ENV') : null));

// Ensure library/ is on include_path
set_include_path(implode(PATH_SEPARATOR, array(
            realpath(APPLICATION_PATH . '/../library'),
            get_include_path(),
        )));

// Init the autoloader
require_once 'Zend/Loader/Autoloader.php';
Zend_Loader_Autoloader::getInstance();

// Set CUSTOMER_SERVICE constant if enable in the virtual host
if (getenv('CUSTOMER_SERVICE'))
{
    define('CUSTOMER_SERVICE', getenv('CUSTOMER_SERVICE'));
}

// Set CMS constant if enable in virtual host
if (getenv('CMS') && !defined('CMS'))
{
    define('CMS', getenv('CMS'));
}

/** Zend_Application */
$cfg = apc_fetch('panda_Zend_Application');
if ($cfg)
{
    $cfg = unserialize($cfg[0]);
}


if (!$cfg)
{
    $cfg = new Zend_Config_Yaml(APPLICATION_PATH . "/configs/application.yaml", APPLICATION_ENV, true);
    

    if (file_exists(APPLICATION_PATH . "/configs/application." . PERSONAL_APPLICATION_ENV . '.yaml'))
    {
        $override = new Zend_Config_Yaml(APPLICATION_PATH . "/configs/application." . PERSONAL_APPLICATION_ENV . '.yaml', APPLICATION_ENV);
        if (!empty($override))
        {
            $cfg = $cfg->merge($override);
        }

    }

    apc_store('panda_Zend_Application', array(serialize($cfg)));
}


Zend_Registry::set('Zend_Application', $cfg);
// ignore constants in yaml files for the rest of the APP
Zend_Config_Yaml::setIgnoreConstants(true);

// Create application, bootstrap, and run
$application = new Zend_Application(
                APPLICATION_ENV,
                $cfg
);

$application->bootstrap()->run();

$cacheHelper = Zend_Controller_Action_HelperBroker::getStaticHelper('cache');

$cacheHelper->clear_transaction_cache();