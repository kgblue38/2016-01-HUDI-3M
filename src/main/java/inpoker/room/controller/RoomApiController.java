package inpoker.room.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import inpoker.room.model.Room;
import inpoker.room.model.Rooms;
///api/room/channel/autoPlay
@RestController
@RequestMapping("/api/room")
public class RoomApiController {
	@RequestMapping(value = {"/wait/ready"}, method = {RequestMethod.PUT})
	public Room ready(@RequestParam String userId, @RequestParam int roomId, @RequestParam String userStatus) {
		System.out.println("userId : " + userId);
		System.out.println("roomId : " + roomId);
		System.out.println("userStatus : " + userStatus);
		Rooms.getInstance().getRoom(roomId).setUserStatus(userId, userStatus);
		return Rooms.getInstance().getRoom(roomId);
	}
	
	@RequestMapping(value = {"/wait/check"}, method = {RequestMethod.GET})
	public Room check(@RequestParam int roomId) {
		return Rooms.getInstance().getRoom(roomId);
	}
	//	@RequestMapping('/channel/autoPlay')
}
