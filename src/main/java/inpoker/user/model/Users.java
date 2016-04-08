package inpoker.user.model;

import java.util.HashMap;
import java.util.Map;

public class Users {
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
		loginUsers.put(user.getUserId(), user);
	}
	
	public User getUser(String userId) {
		return loginUsers.get(userId);
	}
	
	public int getUserCount() {
		return loginUsers.size();
	}

	public static Users getUsers() {
		return users;
	}

	public static void setUsers(Users users) {
		Users.users = users;
	}

	public Map<String, User> getLoginUsers() {
		return loginUsers;
	}

	public static void setLoginUsers(Map<String, User> loginUsers) {
		Users.loginUsers = loginUsers;
	}	
}
