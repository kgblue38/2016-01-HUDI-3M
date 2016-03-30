package inpoker.room.model;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Rooms {
	private static final Logger logger = LoggerFactory.getLogger(Rooms.class);
	private static Rooms rooms = null;
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
		logger.debug("L : {}", room);
	}
	
	public Room getRoom(int roomId) {
		return createdRooms.get(roomId);
	}
	
	public int getRoomCount() {
		return createdRooms.size();
	}
}
