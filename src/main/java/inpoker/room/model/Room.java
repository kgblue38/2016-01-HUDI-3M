package inpoker.room.model;

import inpoker.user.model.User;

public class Room {
	private static int idCount;
	private int roomId;
	private String roomStatus;
	private RoomUser roomUser1;
	private RoomUser roomUser2;
	private boolean canStart = false;
	
	public Room(int roomId, String roomStatus, RoomUser roomUser1, RoomUser roomUser2) {
		this.roomId = roomId;
		this.roomStatus = roomStatus; 
		this.roomUser1 = roomUser1;
		this.roomUser2 = roomUser2;
	}
	
	public Room(int roomId, String roomStatus, RoomUser roomUser1) {
		this(roomId, roomStatus, roomUser1, null);
	}

	public Room(RoomUser roomUser1, RoomUser roomUser2) {
		this(++idCount, "notStart", roomUser1, roomUser2);
	}
	
	public Room(RoomUser roomUser1) {
		this(++idCount, "notStart", roomUser1);
	}
	
	public Room(User user1, User user2) {
		this(new RoomUser(user1), new RoomUser(user2));
	}
	
	public Room(User user1) {
		this(new RoomUser(user1));
	}
	
	
	private void updateCanStart() {
		canStart = validateStart();
	}
	
	private boolean validateStart() {
		if (!isFullRoom()) {
			return false;
		}
		if (!allUserReady()) {
			return false;
		}
		return true;
	}

	private boolean isFullRoom() {
		return roomUser1 != null && roomUser2 != null;
	}

	private boolean allUserReady() {
		return roomUser1.getUserStatus().equals("ready") && roomUser2.getUserStatus().equals("ready");
	}

	public void setUserStatus(String userId, String userStatus) {
		if (roomUser1.isMatchedUserId(userId)) {
			roomUser1.setUserStatus(userStatus);
		}
		if (roomUser2.isMatchedUserId(userId)) {
			roomUser2.setUserStatus(userStatus);
		}
		updateCanStart();
	}

	public static int getIdCount() {
		return idCount;
	}

	public static void setIdCount(int idCount) {
		Room.idCount = idCount;
	}

	public int getRoomId() {
		return roomId;
	}

	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}

	public String getRoomStatus() {
		return roomStatus;
	}

	public void setRoomStatus(String roomStatus) {
		this.roomStatus = roomStatus;
	}

	public RoomUser getRoomUser1() {
		return roomUser1;
	}

	public void setRoomUser1(RoomUser roomUser1) {
		this.roomUser1 = roomUser1;
	}

	public RoomUser getRoomUser2() {
		return roomUser2;
	}

	public void setRoomUser2(RoomUser roomUser2) {
		this.roomUser2 = roomUser2;
	}

	public boolean isCanStart() {
		return canStart;
	}

	public void setCanStart(boolean canStart) {
		this.canStart = canStart;
	}

	public void exitUser(User user, int roomId) {
		if (roomUser1 != null && roomUser1.isMatchedUserId(user.getUserId())) {
			this.roomUser1 = null;
			this.canStart = false;
		}
		if (roomUser2 != null && roomUser2.isMatchedUserId(user.getUserId())) {
			this.roomUser2 = null;
			this.canStart = false;
		}
		
		if (this.roomUser1 == null && this.roomUser2 == null) {
			Rooms.getInstance().deleteRoom(roomId);
		}
	}
	
	@Override
	public String toString() {
		return "Room [roomId=" + roomId + ", roomStatus=" + roomStatus + ", roomUser1=" + roomUser1 + ", roomUser2="
				+ roomUser2 + ", canStart=" + canStart + "]";
	}

}
