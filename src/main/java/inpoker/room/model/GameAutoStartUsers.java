package inpoker.room.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import inpoker.user.model.User;

public class GameAutoStartUsers {
	private static GameAutoStartUsers gameAutoWaitUsers = null;
	private static Map<String, User> autoGameUsers = new HashMap<String, User>();
	private GameAutoStartUsers() {
	}

	public static synchronized GameAutoStartUsers getInstance() {
		if (gameAutoWaitUsers == null) {
			gameAutoWaitUsers = new GameAutoStartUsers();
		}
		return gameAutoWaitUsers;
	}
	
	public void addUser(User user) {
		autoGameUsers.put(user.getUserId(), user);
	}
	
	public User getUser(String userId) {
		return autoGameUsers.get(userId);
	}
	
	public int getUserCount() {
		return autoGameUsers.size();
	}
	
	//make testCase
	public Room makeRoom() {
		String[] keyArray = (String[])autoGameUsers.keySet().toArray();
		User user1 = autoGameUsers.get(keyArray[0]);
		User user2 = autoGameUsers.get(keyArray[1]);
		Room room = new Room(user1, user2);
		Rooms.getInstance().addRoom(room);
		return room;
	}
}
