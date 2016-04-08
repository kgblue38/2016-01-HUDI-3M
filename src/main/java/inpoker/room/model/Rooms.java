package inpoker.room.model;

import java.util.HashMap;
import java.util.Map;

public class Rooms {
	private static Rooms rooms = null;
	public static Rooms getRooms() {
		return rooms;
	}

	public static void setRooms(Rooms rooms) {
		Rooms.rooms = rooms;
	}

	public Map<Integer, Room> getCreatedRooms() {
		return createdRooms;
	}

	public static void setCreatedRooms(Map<Integer, Room> createdRooms) {
		Rooms.createdRooms = createdRooms;
	}

	private static Map<Integer, Room> createdRooms = new HashMap<Integer, Room>();
	
	private Rooms() {
	}

	public static synchronized Rooms getInstance() {
		if (rooms == null) {
			rooms = new Rooms();
		}
		return rooms;
	}

	public void addRoom(Room room) {
		createdRooms.put(room.getRoomId(), room);
	}
	
	public void deleteRoom(int roomId) {
		createdRooms.remove(roomId);
	}

	public Room getRoom(int roomId) {
		return createdRooms.get(roomId);
	}
	
	public int getRoomCount() {
		return createdRooms.size();
	}
	
	//method for test 
	public Room getRoom() {
		Room room = null;
		Object[] temp = createdRooms.values().toArray();
		room = (Room)temp[0];
		return room;
	}

	@Override
	public String toString() {
		return "Rooms [getRoomCount()=" + getRoomCount() + ", getRoom()=" + getRoom() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
