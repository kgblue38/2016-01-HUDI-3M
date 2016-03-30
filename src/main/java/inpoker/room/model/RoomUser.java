package inpoker.room.model;

import inpoker.users.model.User;

public class RoomUser {
	private User user;
	private String userStatus;
	// notReady랑 ready 상태를 가진다.

	public RoomUser(User user, String userStatus) {
		this.user = user;
		this.userStatus = userStatus;
	}
	
	public RoomUser(User user) {
		this(user, "notReady");
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	@Override
	public String toString() {
		return "RoomUser [user=" + user + ", userStatus=" + userStatus + "]";
	}
}
