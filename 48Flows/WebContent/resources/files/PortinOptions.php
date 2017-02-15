<?php 
/**
* 
*/
class Ux_Form_ActivateSim_PortinOptions extends App_Form
{

    /**
     * undocumented class variable
     *
     * @var string
     **/
    const OPTION_NEW_NUMBER = 'new_number';

    /**
     * undocumented class variable
     *
     * @var string
     **/
    const OPTION_PORT_NUMBER = 'port_number';

    /**
     * undocumented class variable
     *
     * @var string
     **/
    protected function createChoiceRadioElement()
    {
        // fied
        $field = new App_Form_Element_Radio('choice');
        // decorators
        $field->setDecorators(array('InputRadioOption'));
        // style
        $field->setAttrib('data-style', 'virtual');
        // options
        $field->addMultiOptions(array(self::OPTION_PORT_NUMBER => 'I want to keep my number', self::OPTION_NEW_NUMBER => 'I want a new number'), true);
        // return
        return $field;
    }

    /**
     * undocumented class variable
     *
     * @var string
     **/
    public function createSubmitKeepNumberElement()
    {
        // submit
        $button = new Zend_Form_Element_Submit(sprintf('submit_%s',  self::OPTION_PORT_NUMBER));
        // options
        $button->setAttrib('id', sprintf('submit-%s', self::OPTION_PORT_NUMBER));
        // value
        $button->setValue('Move my number to 48');
        // value
        $button->setLabel($button->getValue());
        // attr
        $button->setAttribs(array('data-style' => 'control', 'class' => 'highlight'));
        // decorations
        $button->setDecorators(array('InputSubmit'));
        // return button
        return $button;
    }

    /**
     * undocumented class variable
     *
     * @var string
     **/
    public function createSubmitNewNumberElement()
    {
        // submit
        $button = new Zend_Form_Element_Submit(sprintf('submit_%s',  self::OPTION_NEW_NUMBER));
        // options
        $button->setAttrib('id', sprintf('submit-%s', self::OPTION_NEW_NUMBER));
        // attr
        $button->setAttribs(array('data-style' => 'control', 'class' => 'highlight'));
        // value
        $button->setValue('Get a new number');
        // value
        $button->setLabel($button->getValue());
        // decorationps
        $button->setDecorators(array('InputSubmit'));
        // return button
        return $button;
    }

    /**
     * undocumented class variable
     *
     * @var string
     **/
    protected function createConfirmCheckboxElement()
    {
        // create field
        $field = new Zend_Form_Element_Checkbox('confirm_porting');
        // auto
        $field->autocomplete = 'off';
        // set attributes
        $field->setAttribs(array('label_class' => 'small'));
        // attrib
        $field->setAttrib('data-style', 'virtual');
        // onclick
        $field->setAttrib('onclick', 'app.activate_sim.enrolment.confirmClick(this);');
        // remove decorator
        $field->removeDecorator('Label');
        // checkbox required (?)
        $field->addValidator('GreaterThan', false, array(0));
        // return
        return $field;
    }

    /**
     * undocumented class variable
     *
     * @var string
     **/
    public function isValid($data)
    {
        // BOOL if user should keep the number
        $keep = isset($data['keep']) && $data['keep'] == self::OPTION_PORT_NUMBER;
        // // fix zend button bug which sets value to empty for buttons. grr
        $inverseButton = $keep == self::OPTION_PORT_NUMBER ? $this->getElement(sprintf("submit_%s", self::OPTION_NEW_NUMBER)) : $this->getElement(sprintf("submit_%s", self::OPTION_PORT_NUMBER));
        // fix
        $data[$inverseButton->getName()] = $inverseButton->getValue();
        // if should keep
        if(!$keep) {
            // confirm element
            $element = $this->getElement('confirm_porting');
            // don't set required
            $element->setRequired(false);
            // clear validators
            $element->clearValidators();
        }
        // call
        return parent::isValid($data);
    }

    /**
     * undocumented class variable
     *
     * @var string
     **/
    public function getSelectedOption(array $data)
    {
        return isset($data[sprintf('submit_%s', self::OPTION_PORT_NUMBER)]) ? self::OPTION_PORT_NUMBER : self::OPTION_NEW_NUMBER;
    }

    /**
     * Method that creates and boots all the fields within the form
     * @return void
     */
    public function init()
    {

        // set description
        $this->setDescription("Your mobile number");
        // set legend
        $this->setLegend("Keep your old number or get a new one.Whatever the choice, make sure you read our instructions. It's important stuff!");
        // Add display Group (Fieldset wit custom decorator)
        $this->addElements(array($this->createCsrfTokenElement(), $this->createChoiceRadioElement(), $this->createConfirmCheckboxElement(), $this->createSubmitKeepNumberElement(), $this->createSubmitNewNumberElement()));
        // init
        return parent::init();
     }

    /**
     * undocumented class variable
     *
     * @var string
     **/
    public function getDefaultAttribs()
    {
        return array(
            'method'            => self::METHOD_POST,
            'enctype'           => self::ENCTYPE_URLENCODED,
            'autocomplete'      => 'off',
            'data-style'        => 'portin',
            'data-role'         => 'collect-portin-option',
            'id'                => 'activate-sim___portin-options',
            'name'              => 'activate-sim-your-phone-number-form'
        );
    }
}