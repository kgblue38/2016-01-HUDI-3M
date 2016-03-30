package core.utils;

import javax.servlet.http.HttpSession;

import inpoker.user.model.User;

public class SessionUtils {
	public static User getUserValue(HttpSession session, String key) {
		return (User)session.getAttribute(key);
	}
}
