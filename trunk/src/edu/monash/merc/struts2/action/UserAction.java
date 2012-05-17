package edu.monash.merc.struts2.action;

import java.util.GregorianCalendar;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import edu.monash.merc.common.service.ldap.LDAPService;
import edu.monash.merc.domain.User;
import edu.monash.merc.domain.UserType;
import edu.monash.merc.dto.LDAPUser;
/**
 * Action class for user actions
 * 
 * @author  Sindhu Emilda &nbsp;&nbsp;&nbsp;&nbsp;
 * <a href="mailto:sindhu.emilda@monash.edu">sindhu.emilda@monash.edu</a>
 * @version 1.0
 */
@Scope("prototype")
@Controller("user.userAction")
public class UserAction extends BaseAction 
{
	@Autowired
	private LDAPService ldapService;

	private Logger logger = Logger.getLogger(this.getClass().getName());
	
	public String registerLdapUser() {
		logger.debug("registerLdapUser......");
		LDAPUser ldapUsr = null;
		try {
			// if validate ldap user failed, just return to the ldap user registration page.
			ldapUsr = checkLdapUserInfo();
			if (ldapUsr == null) {
				return INPUT;
			}
			// try to register ldap user in the database
			user.setDisplayName(ldapUsr.getDisplayName());
			user.setFirstName(ldapUsr.getFirstName());
			user.setLastName(ldapUsr.getLastName());
			// set ldap user password as ldap
			user.setPassword("ldap");
			user.setRegistedDate(GregorianCalendar.getInstance().getTime());
			// set user email which get from ldap server
			user.setEmail(ldapUsr.getMail());

			user.setActivated(false);
			user.setUserType(UserType.REGUSER.code());

			this.userService.saveUser(user);
			// site name
			String serverQName = getServerQName();
			// start to send register email to admin for approval
			//String activateURL = constructActivationURL(serverQName, user.getId(), user.getActivationHashCode());
			//sendRegMailToAdmin(serverQName, user.getDisplayName(), user.getEmail(), p.getOrganization(), activateURL);

		} catch (Exception e) {
			// log the database error
			logger.error(e.getMessage());
			// reponse the action error
			addActionError(getText("user.register.failed"));
			return ERROR;
		}
		// set action finished messsage
		addActionMessage(getText("user.register.finished.msg", new String[] { user.getDisplayName() }));
		// set action success info
		return SUCCESS;
	}
	
	private LDAPUser checkLdapUserInfo() {
		LDAPUser ldapUsr = null;

		try {
			ldapUsr = this.ldapService.validateLdapUser(user.getUniqueId(), user.getPassword());
			if (ldapUsr == null) {
				logger.debug("LDAP user not found");
				addFieldError("idorpasswd", getText("user.register.ldap.invalid.authcateId.or.password"));
				return null;
			}
		} catch (Exception e) {
			logger.error(e);
			addFieldError("ldaperror", getText("user.register.ldap.check.ldap.account.failed"));
			return null;
		}
		logger.debug("LDAP user found, check unique Id");
		try {
			boolean existed = this.userService.checkUserUniqueIdExisted(user.getUniqueId());
			if (existed) {
				addFieldError("authcateid", getText("user.register.ldap.authcate.id.already.registed"));
				// set ldap user to null
				logger.error("user authcate id is already registered in the system.");
				return null;
			} else {
				boolean emailRegistered = this.userService.checkEmailExisted(ldapUsr.getMail());
				if (emailRegistered) {
					addFieldError("email", getText("user.register.ldap.email.already.registed"));
					logger.error("user email is already registered in the system.");
					return null;
				}
			}
		} catch (Exception e) {
			addFieldError("checkdb", getText("user.register.ldap.check.db.account.failed"));
			logger.error(e);
			ldapUsr = null;
		}

		return ldapUsr;
	}
	
	public String login() 
	{
		logger.debug("login...done");
		if (validateLoginInputs()) {
			return INPUT;
		}
		
		User loginUser = validateUserLogin(user.getUniqueId(), user.getPassword());
		// can't find user login info
		if (loginUser == null) {
			addFieldError("userIdorPassword", getText("user.login.invalid.user.id.password"));
			return INPUT;
		}
        return SUCCESS;
    }

	private User validateUserLogin(String uniqueId, String password) 
	{
		try {
			User existedUser = this.userService.getUserByUnigueId(uniqueId);
			if (existedUser != null) {
				// user existed and account is activated already, just return user, otherwis return null.
				if (existedUser.isActivated()) {
					//boolean success = this.ldapService.ldapUserLogin(uniqueId, password);
					//if (success) {
						return existedUser;
					//}
				}
			}
			return null;
		} catch (Exception e) {
			logger.error("failed to validate user login, " + e);
			return null;
		}
	}

	private boolean validateLoginInputs() 
	{
		boolean errors = false;
		if (user.getUniqueId() == null || (user.getUniqueId().trim().equals(""))) {
			addFieldError("uniqueId", getText("user.login.unique.id.required"));
			errors = true;
		}
		if (user.getPassword() == null || (user.getPassword().trim().equals(""))) {
			addFieldError("password", getText("user.login.password.required"));
			errors = true;
		}
		return errors;
	}
	
	private String getServerQName() {
        String scheme = request.getScheme();
        String hostName = request.getServerName();
        int port = request.getServerPort();

        StringBuffer buf = new StringBuffer();
        if (scheme.equals(ActionConts.HTTP_SCHEME)) {
            buf.append(ActionConts.HTTP_SCHEME).append(ActionConts.HTTP_SCHEME_DELIM);
        } else {
            buf.append(ActionConts.HTTPS_SCHEME).append(ActionConts.HTTP_SCHEME_DELIM);
        }
        buf.append(hostName);
        if (port == 80 || port == 443) {
            return new String(buf);
        }
        buf.append(ActionConts.COLON_DEIM).append(port);
        return new String(buf);
    }

}
