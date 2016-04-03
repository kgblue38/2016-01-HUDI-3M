package inpoker.room.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import inpoker.room.model.GameAutoStartUsers;
import inpoker.room.model.Room;
import inpoker.room.model.Rooms;
import inpoker.user.model.User;
import inpoker.user.model.Users;

@Controller
@RequestMapping("/room")
public class RoomController {
	private Users users = Users.getInstance();
	private Rooms rooms = Rooms.getInstance();
	private GameAutoStartUsers gameAutoStartUsers = GameAutoStartUsers.getInstance();
	private static final Logger logger = LoggerFactory.getLogger(RoomController.class);
	
	@RequestMapping("/channel")
	public String goChannel(Model model, HttpSession session) {
		// 테스트하기 위해서 그냥 넣음..
		logger.debug("[Session.User Test] : {}", session.getAttribute("user"));
		System.out.println(session.getAttribute("user"));
		GameAutoStartUsers.getInstance().addUser((User)session.getAttribute("user"));
		model.addAttribute("users", users);
		model.addAttribute("rooms", rooms);
		return "/channel.jsp";
	}
	
	// test Case 
	@RequestMapping("/wait")
	public String goWait(HttpSession session, Model model) {
		System.out.println("in /room/wait");
		Room room;
		System.out.println("rooms.getRoomCount() : " + rooms.getRoomCount());
		if (rooms.getRoomCount() == 0) {
			room = gameAutoStartUsers.makeRoom();
		} else {
			room = Rooms.getInstance().getRoom();
		}
		System.out.println(room);
		logger.debug("room : {}", room);
//		logger.debug("session.User : {}", session.getAttribute("user"));
//		logger.debug("session.User : {}", session.getAttribute("user"));
		System.out.println("session.User : " + session.getAttribute("user"));
		model.addAttribute("room", room);
		return "/waittingroom.jsp";
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






