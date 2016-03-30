package inpoker.user.model;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.annotation.WebListener;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

import org.glassfish.jersey.servlet.WebServletConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Users {
	private static final Logger logger = LoggerFactory.getLogger(Users.class);
	private static Users users = null;
	private static Map<String, User> loginUsers = new HashMap<String, User>();
	
	private Users() {
	}

	public static synchronized Users getInstance() {
		if (users == null) {
			users = new Users();
		}
		return users;
	}

	public void addUser(User user) {
		logger.debug("LoginUser : {}", user);
		loginUsers.put(user.getUserId(), user);
		logger.debug("현재 접속자 수 : {}", getUserCount());
	}
	
	public User getUser(String userId) {
		return loginUsers.get(userId);
	}
	
	public int getUserCount() {
		return loginUsers.size();
	}
}
