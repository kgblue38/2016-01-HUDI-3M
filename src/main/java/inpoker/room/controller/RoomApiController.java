package inpoker.room.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import core.utils.SessionUtils;
import inpoker.room.model.GameAutoStartUsers;
import inpoker.room.model.MatchJsonData;
import inpoker.room.model.Room;
import inpoker.room.model.Rooms;
import inpoker.user.model.User;
@RestController
@RequestMapping("/api/room")
public class RoomApiController {
	@RequestMapping(value = "/wait/ready", method = RequestMethod.PUT)
	public Room ready(@RequestParam String userId, @RequestParam int roomId, @RequestParam String userStatus) {
		Rooms.getInstance().getRoom(roomId).setUserStatus(userId, userStatus);
		return Rooms.getInstance().getRoom(roomId);
	}
	
	@RequestMapping(value = "/wait/check", method = RequestMethod.GET)
	public Room check(@RequestParam int roomId, HttpServletResponse response) throws IOException {
		Room room = Rooms.getInstance().getRoom(roomId);
		return room;
	}
	
	@RequestMapping(value="/channel/match", method = RequestMethod.PUT)
	public int match(@RequestParam String userId, HttpSession session){
		User user = SessionUtils.getUserValue(session, "user");
		MatchJsonData data = GameAutoStartUsers.addUser(user);	
		int roomId = data.getRoomId();
		System.out.println("match() data : " + data);
		return roomId;
	}
	
}
