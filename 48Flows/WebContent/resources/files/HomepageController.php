<?

class Ux_HomepageController extends Zend_Controller_Action
{
    public function init() {
        // stuff for all pages
        $this->view->headImageDisplay = true;
	///Mon- 85 reverted back the double credit banners
		$this->view->headImagePath = '/css/ux2/images/content-headers/homepage-header.png';
		
    }

    public function indexAction() {
        // stuff for default index page

    }
}