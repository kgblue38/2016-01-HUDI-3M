package inpoker.room.model;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import inpoker.user.model.User;
import scala.annotation.meta.setter;


public class Room {
	private static int idCount;
	private int roomId;
	private String roomStatus;
	private Map<String, RoomUser> roomUsers = new HashMap<>();
	
	public Room(int roomId, String roomStatus, RoomUser roomUser1, RoomUser roomUser2) {
		this.roomId = roomId;
		this.roomStatus = roomStatus; // start,notStart 상태를 가진다.
		this.roomUsers.put(roomUser1.getUserId(), roomUser1);
		this.roomUsers.put(roomUser2.getUserId(), roomUser2);
	}
	public Room(RoomUser roomUser1, RoomUser roomUser2) {
		this(++idCount, "notStart", roomUser1, roomUser2);
	}
	
	public boolean validateStart() {
		if (!isFullRoom()) {
			return false;
		}
		if (!allUserReady()) {
			return false;
		}
		return true;
	}
	
	private boolean isFullRoom() {
		return roomUsers.size() == 2;
	}
	
	private boolean allUserReady() {
		for (RoomUser roomUser : roomUsers.values()) {
			if (!roomUser.isUserReady()) {
				return false;
			}
		}
		return true;
	}
	
	public String getUserStatus(String userId) {
		return roomUsers.get(userId).getUserStatus();
	}
	
	public Map<String, String> getAllUserStatus() {
		Map<String, String> result = new HashMap<>(); 
		for (Map.Entry<String, RoomUser> entry : roomUsers.entrySet()) {
			result.put(entry.getKey(), entry.getValue().getUserStatus());
		}
		return result;
	}
	
	public void setUserStatus(String userId, String userStatus) {
		roomUsers.get(userId).setUserStatus(userStatus);
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
	
	public Map<String, RoomUser> getRoomUsers() {
		return roomUsers;
	}

	public void setRoomUsers(Map<String, RoomUser> roomUsers) {
		this.roomUsers = roomUsers;
	}
	@Override
	public String toString() {
		return "Room [roomId=" + roomId + ", roomStatus=" + roomStatus + ", roomUsers=" + roomUsers + "]";
	}

	
}
