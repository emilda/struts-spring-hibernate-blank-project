package edu.monash.merc.struts2.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

import edu.monash.merc.domain.User;
import edu.monash.merc.service.UserService;

public class BaseAction extends ActionSupport implements SessionAware, ServletRequestAware, ServletResponseAware {
	
	protected User user;
	
	@Autowired
    protected UserService userService;

	protected HttpServletResponse response;

	protected HttpServletRequest request;

	protected Map<String, Object> session;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}
	
	public HttpServletResponse getServletResponse() {
        return response;
    }

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	
	public HttpServletRequest getServletRequest() {
        return request;
    }

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	
	public Map<String, Object> getSession() {
        return session;
    }
}
