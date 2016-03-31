package inpoker.room.model;

import inpoker.user.model.User;

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
	
	public String getUserId() {
		return user.getUserId();
	}
	
	public boolean isUserReady() {
		return userStatus.equals("ready");
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
	
	public boolean isMatchedUserId(String userId) {
		return user.isMatchedUserId(userId);
	}

	@Override
	public String toString() {
		return "RoomUser [user=" + user + ", userStatus=" + userStatus + "]";
	}
}
