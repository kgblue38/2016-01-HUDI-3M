package inpoker.user.model;

import java.util.HashMap;
import java.util.Map;

public class Users {
	// TODO 이 값 어딘가 사용하나?
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

	public Users getUsers() {
		return users;
	}

	// TODO 이 method는 무슨 용도?
	public void setUsers(Users users) {
		Users.users = users;
	}

	public Map<String, User> getLoginUsers() {
		return loginUsers;
	}

	public void setLoginUsers(Map<String, User> loginUsers) {
		Users.loginUsers = loginUsers;
	}	
}
