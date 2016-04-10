package inpoker.room.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import core.utils.SessionUtils;
import inpoker.room.model.Room;
import inpoker.room.model.Rooms;
import inpoker.user.model.User;
import inpoker.user.model.Users;

@Controller
@RequestMapping("/room")
public class RoomController {
	private Users users = Users.getInstance();
	private Rooms rooms = Rooms.getInstance();
	
	@RequestMapping("/channel")
	public String goChannel(Model model, HttpSession session) {
		model.addAttribute("loginUsers", users.getLoginUsers().values());
		model.addAttribute("rooms", rooms.getCreatedRooms());
		return "/channel.jsp";
	}
	
	@RequestMapping("/wait")
	public String goWait(HttpSession session, int roomId, Model model) {
		Room room = rooms.getRoom(roomId);
		model.addAttribute("room", room);
		return "/waittingroom.jsp";
	}
	
	@RequestMapping("/wait/exit")
	public String exitRoom(@RequestParam int roomId, HttpSession session) {
		Room room = rooms.getRoom(roomId);
		User user = SessionUtils.getUserValue(session, "user");
		room.exitUser(user, roomId);
		return "redirect:/room/channel";
	}
	
	@RequestMapping("/game")
	public String goGame(@RequestParam int roomId, Model model) {
		Room room = rooms.getRoom(roomId);
		room.setRoomStatus("start");
		System.out.println(room.getRoomStatus());
		model.addAttribute("room", room);
		return "/gameMain.jsp";
	}
}
