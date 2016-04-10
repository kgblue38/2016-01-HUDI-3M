package inpoker.room.model;

import java.util.HashMap;
import java.util.Map;

import inpoker.user.model.User;

public class GameAutoStartUsers {
	private static GameAutoStartUsers gameAutoWaitUsers = null;
	private static Map<String, User> autoGameUsers = new HashMap<String, User>();
	private static int roomId = -1;
	private GameAutoStartUsers() {
	}

	public static synchronized GameAutoStartUsers getInstance() {
		if (gameAutoWaitUsers == null) {
			gameAutoWaitUsers = new GameAutoStartUsers();
		}
		return gameAutoWaitUsers;
	}
	
	public static MatchJsonData addUser(User user) {
		autoGameUsers.put(user.getUserId(), user);
		System.out.println(autoGameUsers.size());
		if(autoGameUsers.size() <= 1){
			MatchJsonData data =MatchJsonData.getFail();
			System.out.println(data);
			return data;
		}else if(autoGameUsers.size() == 2){
			MatchJsonData data = MatchJsonData.getSuccess(makeRoom());
			return data;
		}
		return null;
	}
	
	public User getUser(String userId) {
		return autoGameUsers.get(userId);
	}
	
	public int getUserCount() {
		return autoGameUsers.size();
	}
	
	//make testCase
	private static int makeRoom() {
		Object[] users = autoGameUsers.values().toArray();
		if(roomId == -1){
			User user1 = (User)users[0];
			User user2 = (User)users[1];
			Room room = new Room(user1, user2);
			Rooms.getInstance().addRoom(room);
			roomId = room.getRoomId();
		}
		return roomId;
	}
}
