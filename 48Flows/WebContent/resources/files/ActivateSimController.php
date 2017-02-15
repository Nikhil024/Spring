<?php
use App\Wizard\WizardManager;

class Ux_ActivateSimController extends Ux_Library_48_ControllerAction implements App_Controller_WizardInterface
{

    /**
     * undocumented class variable
     *
     * @var string
     **/
    const DEFAULT_LAYOUT = 'ux/48/controllers/activate-sim/1column-layout';

    /**
     * undocumented class variable
     *
     * @var string
     **/
    const SIDEBAR_LAYOUT  = 'ux/48/controllers/activate-sim/2column-right-layout';

    /**
     * undocumented class variable
     *
     * @var string
     **/
    public function getWizardDependentActions()
    {
        return array('registration-code', 
                     'account', 
                     'portin-options', 
                     'portin-phone-number', 
                     'portin-account-details');
    }

    /**
     * undocumented class variable
     *
     * @var string
     **/
    public function preDispatch()
    {

        // almost all actions have a sidebar layout attached
        $this->setLayout(self::SIDEBAR_LAYOUT);
        // call parent implementation
        return parent::preDispatch();
    }

    /**
     * undocumented class variable
     *
     * @var string
     **/
    public function getPublicActions()
    {
        // return
        return array('registration-code', 'account');
    }

    /**
     * Drop a view into /order/layout/sidebar/{action-name}
     * and it will be displayed in the sidebar when layout == self::SIDEBAR_LAYOUT
     *
     * @var string - possible values: self::SIDEBAR_LAYOUT, self::DEFAULT_LAYOUT
     **/
    protected function setLayout($script, $sidebar = null, $disableSidebarProgress = false)
    {
        // layout
        $layout = $this->_helper->layout();
        // set top content 
        $layout->topContent = 'activate-sim/layout/topbar.phtml';

        // if is sidebar layout
        if($script == self::SIDEBAR_LAYOUT && (is_null($sidebar) && !isset($layout->sidebar))) {
            // set default sidebar
            $sidebar = 'activate-sim/layout/sidebar.phtml';
        }
        // view
        $view   = $this->view;
        // should we disable the sidebar progress ?
        $view->disableSidebarProgress = $disableSidebarProgress;
        // call parent implementation
        return parent::setLayout($script, $sidebar);
    }



    /**
     * Occures after dispatching
     *
     * @var string
     **/
    public function postDispatch()
    {
       // layout
        $layout = $this->_helper->layout();
        // get current wizard
        $wizard = WizardManager::getInstance()->getActiveWizard();

 
        // we are in the wizard process
        if($wizard) {
            // get active step
            $step   = $wizard->getActiveStep();
            // if not sim registration
            if(!$wizard->isComplete() && $step->getId() !== 'sim_registration_code') {
                // disable header
                $layout->header = false;
                // disable fotoer
                $layout->footer = false;
            }


        }
        // call parent implementation
        return parent::postDispatch();
    }

    /**
     * undocumented class variable
     *
     * @var string
     **/
    public function registrationCodeAction()
    {
        // get hosts
        $host = $_SERVER['HTTP_HOST'];
        // get config object
        $config = Zend_Registry::get('Zend_Config');
        // auth
        $auth = Zend_Auth::getInstance();
        // get current wizard
        $wizard = WizardManager::getInstance()->getActiveWizard();
        // get active step
        $step   = $wizard->getActiveStep();
        // get identity
        $user = $auth->hasIdentity() ? $auth->getIdentity() : false;

        if($user) {
            // next step
            $nextStep = $wizard->getNextStep();
            // get data
            $data = $nextStep->getData();

            // signup item is not editable and yet the data inside it 
            // is empty ? This means we set the editing flag to false in Ux_Event_Subscriber_UserAuthentication::onUserAuthentication
            // so the user is not at the first visit with us
            if((empty($data) && !$nextStep->isEditable() && !$step->isComplete()) && $user->getRole() == Panda_Service_Entity_User::ROLE_REGISTERED) {
                // notification
                $notification = new Ux_Library_48_Layout_Notification();
                // locked
                $notification->setLocked(true);
                // content
                $notification->setContent('Hi, your account isn\'t fully set up yet or is no longer active.<br />Enter your SIM activation code below to continue.');
                // add notification
                $this->_helper->notificationManager()->add($notification);
            }
        }

        // form
        $form   = new Ux_Form_ActivateSim_RegistrationCode();
        // defaults
        if($step->isComplete()) {
            // set defaults
            $form->populate($step->getData());
        }
        // request
        $request = $this->getRequest();
        // if is post
        if ($step->isEditable() && $request->isPost()) {
            // clear step
            $step->clear();
            // data
            $data = $request->getPost();
            // if is valid
            if ($form->isValid($data)) {
                // values
                $values = $form->getValues();
                // element
                $element = $form->getElement('registration_code');
                // sim service
                $simService = Zend_Controller_Action_HelperBroker::getStaticHelper('ux_services')->sims();
                try {
                    // sim
                    $sim = $simService->getSimByActivationCode($element->getValue());
                    // true if SIM is a replacement sim
                    $replacementSim = in_array($sim->getProduct(), array(Panda_Service_Entity_Sim::TYPE_REPLACEMENT, Panda_Service_Entity_Sim::TYPE_SIMSWAP));

                    // if we're dealing with a replacement sim
                    if($replacementSim) {
                        // get url
                        $url = sprintf('%s?code=%s', $this->_helper->url->url(array(), 'change_my_sim'), $element->getValue());
                        // redirect to url
                        return $this->_helper->redirect($url);
                    }


                    // set complete step
                    $step->setComplete(true);
                    // set data
                    $step->setData($values);
                    // next step
                    $nextStep = $wizard->getNextStep();
                    // url
                    $url      = $nextStep->getUrl();
                    // redirect
                    return $this->_redirect($url);
                } catch (\App_ManagedException $e) {
                    // add error
                    $element->addError($e->getMessage());
                } catch (\Exception $e) {
                    throw new \Exception($e->getMessage(), $e->getCode(), $e);
                }
            }
        } 
        // set layout and disable right progress
        $this->setLayout(self::SIDEBAR_LAYOUT, null, true);
        // wizard
        $this->view->wizard = $wizard;
        // form
        $this->view->form   = $form;
        // step helper
        $this->view->stepHelper = $step->getId();

       if(!$step->isEditable()) {
             // set columns
            $this->setLayout(self::DEFAULT_LAYOUT);
            // inject success page
            $script = "confirmation-pages/registration-code";
            // set renderer
            $this->_helper->viewRenderer->setRender($script);
        }
    }

    /**
     * Activates sim in wizard context
     *
     * @var string
     **/
    protected function _activateSim($portinObject = false)
    {
        // get wizard
        $wizard = WizardManager::getInstance()->getActiveWizard();
        // get identity data
        $identityData = $wizard->getFirstStep()->getData();
        // sim code
        $simCode = $identityData['registration_code'];
        // sim service
        $simService = Zend_Controller_Action_HelperBroker::getStaticHelper('ux_services')->sims();
        // Load SIM data (anonymous and protected service)
        $sim  = $simService->getSimByActivationCode($simCode);
        // activate sim
        $simService->activateSim($sim, null, $portinObject);
        // refresh user cache
        $this->_helper->services->users()->refreshUserCache();
        // notify completion
        $this->lockSimRegistrationAccess();
    }

    /**
     * Number porting options
     *
     * @var string
     **/
    public function portinOptionsAction()
    {

        // get current wizard
        $wizard = WizardManager::getInstance()->getActiveWizard();
        // get active step
        $step   = $wizard->getActiveStep();
        // request
        $request = $this->getRequest();
        // form
        $form   = new Ux_Form_ActivateSim_PortinOptions();
    


        /* ==============================================================
        After the user selects a Family/Business account in the last step
        the wizard is locked as for the family/business account currently
        there is a different procedure and the user must contact care.
        However, on the page displaying this notice, there is a link 'Get a new number'
        which is supposed to make the user re-enter the activation flow and auto-activate
        sim for a new number.
        This bit of code checks if the 'unlock' attribute is set in the query string and:
        - 1) Unlocks the wizard
        - 2) Forces the choice as being the new number
        - 3) Activates sim
        - 4) Re-locks the activation wizard
         In case there is an error, it re-locks the wizard and displays a notice.
         The user may try again if he pleases, and the whole procedure repeats.
        ============================================================== */


        if($request->isGet() && $wizard->isComplete()) {
            // change
            $unlock = intval($request->getParam('unlock', false));

            // user wants to switch from signup to authenticate
            if($unlock == 1 && $this->unlockSimRegistrationAccess()) {
                // initial wizard step data
                $data = $step->getData();
                // force choice to new number. the form will be populated below
                $data['choice'] = Ux_Form_ActivateSim_PortinOptions::OPTION_NEW_NUMBER;
                // set data
                $step->setData($data);
            }
        }
        /* ==============================================================
        End of the unlocking procedure
        ===============================================================*/

        // defaults
        if(is_array($step->getData())) {
            // set defaults
            $form->populate($step->getData());
        }
        // if is post
        if ($request->isPost() && $step->isEditable()) {
            // data
            $data = $request->getPost();
            // clear step
            $step->clear(false);
            // if is valid
            if ($form->isValid($data)) {
                // values
                $values = $form->getValues();
                // keep
                $port   = $form->getSelectedOption($data) == Ux_Form_ActivateSim_PortinOptions::OPTION_PORT_NUMBER;
                // set data
                $step->setData($values);
                // if should transfer
                if($port) {
                    // set complete
                    $step->setComplete(true);
                     // url
                    return $this->_redirect($step->getFirstStep()->getUrl());
                }else{

                    try {

                        // activate sim in wizard context
                        $this->_activateSim();
                        // set complete step
                        $step->setComplete(true);
                        // set editable
                        $step->setEditable(false);
                         // refresh page basically
                        return $this->_redirect($step->getUrl());
                    } catch (\App_ManagedException $e) {
                        // add the error message
                        $form->addErrorMessage(t($e->getMessage()));
                    }

                }
            }
        }

        // view
        $view = $this->view;
        // wizard
        $view->wizard = $wizard;
        // form
        $view->form = $form;
        // step helper
        $view->stepHelper = $step->getId();


        if(!$step->isEditable()) {
            // default
            $customGATrackUrl = null; 
            // get data
            $data = $step->getData();
             // set columns
            $this->setLayout(self::DEFAULT_LAYOUT);
            // user got a new number
            if($data['choice'] == Ux_Form_ActivateSim_PortinOptions::OPTION_NEW_NUMBER) {
                // set the track url
                $customGATrackUrl = 'activate-sim/getting-new-number';
                // inject success page
                $script = "confirmation-pages/new-number";
            }else{
                // get last child data
                $data = $step->getLastStep()->getData();
                // family / business account
                if($data['account_type'] == Ux_Form_Portin_AccountDetails::ACCOUNT_TYPE_BUSINESS) {
                    // inject success page
                    $script = "confirmation-pages/family_or_business_account";
                    // set the track url
                    $customGATrackUrl = 'activate-sim/family-contact-care';
                }else{
                    // set the track url
                    $customGATrackUrl = 'activate-sim/moving-your-number';
                    // inject success page
                    $script = "confirmation-pages/transfer-in-progress";
                }
            }
            // override the default one
            $view->customGATrackUrl = $customGATrackUrl;
            // set renderer
            $this->_helper->viewRenderer->setRender($script);
        }

    }

    /**
     * undocumented class variable
     *
     * @var string
     **/
    public function portinPhoneNumberAction()
    {

        // main
        $mainWizard = WizardManager::getInstance()->getActiveWizard();
        // get current wizard
        $wizard = $mainWizard->getActiveStep();
        // current
        $step = $wizard->getActiveStep();
        // request
        $request = $this->getRequest();
        // view obj
        $view    = $this->view;
        // form
        $form   = new Ux_Form_Portin_PhoneNumber();
        // if data is array
        if(is_array($step->getData())) {
            // populate
            $form->populate($step->getData());
        }

        if($step->isEditable()) {
            // if is post
            if ($request->isPost()) {
                // clear step
                $step->clear();
                // data
                $data = $request->getPost();
                // set data
                $step->setData($form->getValidValues($data));
                // if is valid
                if ($form->isValid($data)) {
                    // values
                    $values = $form->getValues();
                    // get identity data
                    $identityData = $mainWizard->getFirstStep()->getData();
                    // sim code
                    $simCode = $identityData['registration_code'];
                    // sim service
                    $simService = Zend_Controller_Action_HelperBroker::getStaticHelper('ux_services')->sims();


                    try {
                        // Load SIM data (anonymous and protected service)
                        $sim  = $simService->getSimByActivationCode($simCode);
                        // get ssn
                        $ssn = $sim->getSsn();
                        // number
                        $mobileNumber = $values['mobile'];
                        // request code
                        $securityCode = $this->_helper->portin->requestSecurityCode($mobileNumber, $ssn);

                        // if supports
                        if($step->supportsSecurityCode()) {
                            // set it
                            $step->setSecurityCode($securityCode);
                        }
                        // set complete step
                        $step->setComplete(true);
                        // url
                        return $this->_redirect($wizard->getNextStep()->getUrl());
                    } catch (\App_ManagedException $e) {
                        // add the error message
                        $form->addErrorMessage(t($e->getMessage()));
                    }
                }
            }
        }

        // wizard
        $view->wizard = $mainWizard;
        // form
        $view->form = $form;
        // set renderer
        $this->_helper->viewRenderer->setRender('/portin/phone-number', null, true);
    }

    /**
     * undocumented class variable
     *
     * @var string
     **/
    public function portinAccountDetailsAction()
    {
        // main
        $mainWizard = WizardManager::getInstance()->getActiveWizard();
        // get current wizard
        $wizard = $mainWizard->getActiveStep();
        // current
        $step = $wizard->getActiveStep();
        // view
        $view = $this->view;
        // request
        $request = $this->getRequest();
        // form
        $form   = new Ux_Form_Portin_AccountDetails();
        // change data resend url attribute
        $form->setResendSecurityCodeUrl('/activate-sim/resend-security-code');


        // if data is array
        if(is_array($step->getData())) {
            // populate
            $form->populate($step->getData());
        }


        if($step->isEditable()) {
            // get previous step
            $previousStep = $wizard->getPreviousStep();
            // get data
            $history = $previousStep->getData();
            // prev
            $view->previousStep = $previousStep;
            // get mobile
            $mobileNumber = $history['mobile'];
            // mobile
            $view->mobileNumber = $mobileNumber;

            // if is post
            if ($request->isPost()) {
                // clear step
                $step->clear();
                // data
                $data = $request->getPost();
                // set data
                $step->setData($form->getValidValues($data));

                // if is valid
                if ($form->isValid($data)) {
                    // values
                    $values = $form->getValues();
                    // get history from old step
                    $history = $wizard->getPreviousStep()->getData();
                    // mobile
                    $mobileNumber = $history['mobile'];
                    // portin
                    $portinObject = $form->createRemotePortinObject($mobileNumber);
                    // get identity data
                    $identityData = $mainWizard->getFirstStep()->getData();
                    // sim code
                    $simCode = $identityData['registration_code'];
                    // sim service
                    $simService = Zend_Controller_Action_HelperBroker::getStaticHelper('ux_services')->sims();

                    try {

                        if($form->getElement('account_type')->getValue() != Ux_Form_Portin_AccountDetails::ACCOUNT_TYPE_BUSINESS) {
                            // request portin
                            $this->_activateSim($portinObject);
                        }
                        // set complete step
                        $step->setComplete(true);
                        // set editable
                        $step->setEditable(false);
                        // notify completion
                        $this->lockSimRegistrationAccess();
                         // refresh page basically
                        return $this->_redirect($wizard->getUrl());
                    }
                    catch (\App_ManagedException $e) {
                        // add form error message
                        $form->addErrorMessage(t($e->getMessage()));
                    }
                    catch (\Exception $e) {
                        // add the error message
                        $form->addErrorMessage(t('FORM_ERROR_activatesim_general'));
                    }

                }

            }
        }

        // wizard
        $view->wizard = $mainWizard;
        // form
        $view->form = $form;
        // set renderer
        $this->_helper->viewRenderer->setRender('/portin/account-details', null, true);
    }

  /**
     * undocumented class variable
     *
     * @var string
     **/
    protected function processAuthentication(Ux_Form_ActivateSim_Account_Authenticate $form, array $data = array())
    {

        // if validation passes
        if($form->isValid($data)) {
            // get current wizard
            $wizard = WizardManager::getInstance()->getActiveWizard();
            // step
            $step   = $wizard->getActiveStep();
            // values
            $values = $form->getValues();
            // set data
            $step->setData($values);
            // Default to not complete
            $step->setComplete(false);
            // user wants to signup
            if($form->getScenario() == Ux_Form_ActivateSim_Account_Authenticate::SCENARIO_SIGNUP) {
                // set complete
                $step->setComplete(true);
                // change step scenario 
                $step->setScenario(constant(sprintf('%s::SCENARIO_SIGNUP', get_class($step))));
                // refresh page to display the signup form
                return $this->_redirect($step->getUrl());
            }

            try {
                // adapter
                $authAdapter = new Tid_Zend_Auth_Adapter($form->email->getValue(), $form->password->getValue());
                // instance
                $auth = Zend_Auth::getInstance();
                // result
                $result = $auth->authenticate($authAdapter);
                // if succesful
                if($result->isValid()) {
                // set complete
                    $step->setComplete(true);
                    // next step
                    $nextStep = $wizard->getNextStep();
                    // url
                    $url      = $nextStep->getUrl();
                    // dispatch
                    $this->dispatchAuthenticationEvent($result->getIdentity(), $url);

                    // redirect
                    return $this->_redirect($url);
                }
                // add the error message
                $form->addErrorMessage(t('/auth/login/unable_wrong_cred'));
            } catch (Panda_Service_Exception_Login_Blocked $e) {
                // throw
                throw $e;
            }
        }

    }



    /**
     *Account
     *
     * @var string
     **/
    public function accountAction()
    {
        // get current wizard
        $wizard = WizardManager::getInstance()->getActiveWizard();
        // get active step
        $step    = $wizard->getActiveStep();
        // authentication instance
        $auth    = Zend_Auth::getInstance(); 
        // form
        $form    = $step->createForm();
        // request
        $request = $this->getRequest();
        // current scenario
        $scenario = $step->getScenario();
        // don't edit if user is authenticated
        $step->setEditable(!$auth->hasIdentity());
        // set completion
        $step->setComplete(!$step->isEditable());
         // signup
        $scenarioSignup         = constant(sprintf("%s::SCENARIO_SIGNUP",       get_class($step)));
        // auth
        $scenarioAuthenticate   = constant(sprintf("%s::SCENARIO_AUTHENTICATE", get_class($step)));


        // intercept
        if($step->isEditable()) {

            /* ==============================================================
            This bit of code allows the user to switch between Authentication
            and Signup scenarios but is currently disabled. To re-enable it
            (maybe for a future implementation) just go into the $step class file
            and return 'true' in the allowsScenarioSwitch function
            ============================================================== */
            if($step->allowsScenarioSwitch() && $scenario == $scenarioSignup) {
              // if get request
                if($request->isGet() && !$auth->hasIdentity()) {
                    // change
                    $change = intval($request->getParam('scenario', $scenarioSignup));
                    // user wants to switch from signup to authenticate
                    if($change === $scenarioAuthenticate) {
                        // set scenario
                        $step->setScenario($scenarioAuthenticate);
                        // refresh page
                        return $this->_redirect($step->getUrl());
                    }
                }
            }
            /* ==============================================================
            End of unusuded piece of code
            ============================================================== */

              // if request is post and step is editable
            if($request->isPost()) {
                // clear the step
                $step->clear();
                // get the request data
                $data = $request->getPost();

                if($step->allowsScenarioSwitch() && $scenario == $scenarioAuthenticate) {
                    // process
                    $this->processAuthentication($form, $data);
                }else{
                    // process signup
                   $this->processSignup($form, $data);
                }
            }
        }
        // wizard
        $this->view->wizard = $wizard;
        // form
        $this->view->form = $form;
        // script
        $script = $scenario == $scenarioSignup ? 'account-signup' : 'account-authenticate';
        // step helper
        $this->view->stepHelper = $step->getId();
        // if user is logged in
        if(!$step->isEditable()) {
             // set columns
            $this->setLayout(self::DEFAULT_LAYOUT);
            // inject success page
            $script = sprintf("confirmation-pages/%s", $script);
        }
        // set renderer
        $this->_helper->viewRenderer->setRender($script);


    }


    /**
     * undocumented class variable
     *
     * @var string
     **/
    protected function processSignup(Ux_Form_ActivateSim_Account_Signup $form, array $data = array())
    {

        // if is valid
        if($form->isValid($data)) {
            // get current wizard
            $wizard = WizardManager::getInstance()->getActiveWizard();
            // step
            $step   = $wizard->getActiveStep();
            // values
            $values = $form->getValues();
            // auth instance
            $auth       = Zend_Auth::getInstance();
            // @see Ux_Form_SimActivation_Signup::getAuthAdapter
            $adapter    = $form->getAuthAdapter();

            try {
                // result
                $result = $auth->authenticate($adapter);
                // if succesful
                if($result->isValid()) {
                    // set notifications
                    $this->_helper->services->users()->setNotifications($adapter->getNotifications(), false);
                    // user
                    $user = $result->getIdentity();
                   // set data
                    $step->setData($values);
                    // set complete step
                    $step->setComplete(true);
                    // next step
                    $nextStep = $wizard->getNextStep();
                    // url
                    $url      = $nextStep->getUrl();
                    // dispatch
                    $this->dispatchAuthenticationEvent($user, $url);
                    // redirect
                    return $this->_redirect($url);
                }
            }
            catch (Tid_Zend_Service_GG_IllegalArgumentsException $e) {
                throw $e;
            }
        }
    }


    /**
     * undocumented class variable
     *
     * @var string
     **/
    protected function dispatchAuthenticationEvent($user, $redirectUrl)
    {
        // bootstrap
        $bootstrap = Zend_Controller_Front::getInstance()->getParam('bootstrap');
        // dispatcher
        $dispatcher = $bootstrap->getEventDispatcher();
        // dispatch
        $event = new App_User_AuthenticationEvent($user, $redirectUrl);
        // dispatch the event
        $dispatcher->dispatch(App_User_Events::AUTHENTICATION_EVENT, $event);
    }

  /**
     * undocumented class variable
     *
     * @var string
     **/
    public function resendSecurityCodeAction()
    {
        // get the request object
        $request = $this->getRequest();
        // get cotnroller
        $frontController = Zend_Controller_Front::getInstance();
        // get router
        $router = $frontController->getRouter();
        // if invalid
        if($request->isPost() && $request->isXmlHttpRequest()) {
            // sleep a while
            sleep(3);
            // Wizard
            $wizard  = WizardManager::getInstance()->get('activate_sim');
            // target step
            $targetStep = $wizard->get('portin_options')->getFirstStep();
            // we must get the data
            // with the mobile number the user inserted
            // in the specific step
            $data = $targetStep->getData();
            // now we have the mobile number
            $mobileNumber = $data['mobile'];
            // we must get the data 
            // with the sim activation code
            $data = $wizard->getFirstStep()->getData();
            // now we have the sim code
            $simCode = $data['registration_code'];
            // sim service
            $simService = Zend_Controller_Action_HelperBroker::getStaticHelper('ux_services')->sims();
            // Load SIM data (anonymous and protected service)
            $sim  = $simService->getSimByActivationCode($simCode);
            // get ssn
            $ssn = $sim->getSsn();
            // to be populated
            // and converted to json
            $response = array('errors' => array());
            try {
                // request
                $securityCode = $this->_helper->portin->requestSecurityCode($mobileNumber, $ssn);
                // check if step supported
                if($targetStep->supportsSecurityCode()) {
                    // set the security code
                    $targetStep->setSecurityCode($securityCode);
                    // push security code
                    $response['security_code'] = $securityCode;
                }
                // remove errors
                unset($response['errors']);

            } catch (\App_ManagedException $e) {
                // push errors
                $response['errors'][] = t($e->getMessage());
            }   
            // send json
            return $this->getHelper('json')->sendJson($response);
        }

        // throw exception
        throw new Zend_Controller_Action_Exception("Cannot access page in this manner", 404);
    }


    /**
     * undocumented class variable
     *
     * @var string
     **/
    protected function unlockSimRegistrationAccess()
    {
        // main wizard
        $mainWizard = WizardManager::getInstance()->getActiveWizard();
        // composite step wizard
        $wizard = $mainWizard->get('portin_options');
        // get data
        $data = $wizard->getData();
        // choice
        $choice = $data['choice'];

        if($choice == Ux_Form_ActivateSim_PortinOptions::OPTION_PORT_NUMBER) {
            // last step
            $step = $wizard->get('portin_account_details');
            // fet data from last step
            $data = $step->getData();

            if($data['account_type'] == Ux_Form_Portin_AccountDetails::ACCOUNT_TYPE_BUSINESS) {
                // items
                $items = $mainWizard->getItemsWithTags('sim_relative');
                 // editable
                foreach($items as $item) {
                    // disable editing for all
                    // steps related to the sim registation
                    $item->setEditable(true);

                }
                // get all composite items children
                $items = $wizard->getItems();
                // lock them as we will not be able to reach them again
                foreach($items as $item) {
                    // lock everything
                    $item->setLocked(false);
                    // uncomplete
                    $item->setComplete(false); // check
                    // force uneditable
                    $item->setEditable(true);
                }

                // return true
                return true;
            }
        }

        return false;
    }
   /**
     * undocumented class variable
     *
     * @var string
     **/
    protected function lockSimRegistrationAccess()
    {
        // main wizard
        $wizard = WizardManager::getInstance()->getActiveWizard();
        // items
        $items = $wizard->getItemsWithTags('sim_relative');
         // editable
        foreach($items as $item) {
            // disable editing for all
            // steps related to the sim registation
            $item->setEditable(false);
        }

        // composite step wizard
        $wizard = $wizard->get('portin_options');
        // get all composite items children
        $items = $wizard->getItems();
        // lock them as we will not be able to reach them again
        foreach($items as $item) {
            // lock everything
            $item->setLocked(true);
            // force completion
            $item->setComplete(true);
            // force uneditable
            $item->setEditable(false);
        }
    }

 }  
