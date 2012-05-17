package edu.monash.merc.struts2.action;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import edu.monash.merc.service.EditService;
/**
 * Action class for home page
 *
 * @author  Sindhu Emilda &nbsp;&nbsp;&nbsp;&nbsp;
 * <a href="mailto:sindhu.emilda@monash.edu">sindhu.emilda@monash.edu</a>
 * @version 1.0
 */
@Controller("basic.homeAction")
public class HomeAction extends ActionSupport {
	
	@Autowired
	private EditService editService ;
	
	private Logger logger = Logger.getLogger(this.getClass().getName());
	
	/** Provide default valuie for Message property. */
    public static final String MESSAGE = "home.message";
   
    /** Field for Message property. */
    private String message;

	public String execute() throws Exception {
        return SUCCESS;
    }

    
	public String home() {
		setMessage(getText(MESSAGE));
		logger.debug("home...done");
        return SUCCESS;
    }

	public void setEditService(EditService editService) {
		this.editService = editService;
	}
	
	/**
     * Return Message property.
     *
     * @return Message property
     */
    public String getMessage() {
    	System.out.println("get...home msg");
        return message;
    }

    /**
     * Set Message property.
     *
     * @param message Text to display on home page.
     */
    public void setMessage(String message) {
        this.message = message;
    }
	
}
