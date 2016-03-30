package inpoker.room.model;

import java.util.Arrays;

public class Room {
	private static int idCount;
	private int roomId;
	private String roomStatus;
	private RoomUser waittingUser[] = new RoomUser[2];
	
	public Room(int roomId, String roomStatus, RoomUser waittingUser1, RoomUser waittingUser2) {
		this.roomId = roomId;
		this.roomStatus = roomStatus; // start,notStart 상태를 가진다.
		this.waittingUser[0] = waittingUser1;
		this.waittingUser[1] = waittingUser2;
	}
	
	public Room(RoomUser wattingUser1, RoomUser waittingUser2) {
		this(++idCount, "notStart", wattingUser1, waittingUser2);
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

	public RoomUser[] getWaittingUser() {
		return waittingUser;
	}

	public void setWaittingUser(RoomUser[] waittingUser) {
		this.waittingUser = waittingUser;
	}

	@Override
	public String toString() {
		return "Room [roomId=" + roomId + ", roomStatus=" + roomStatus + ", waittingUser="
				+ Arrays.toString(waittingUser) + "]";
	}
}
