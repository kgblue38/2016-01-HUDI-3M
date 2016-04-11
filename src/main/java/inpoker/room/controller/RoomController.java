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
		model.addAttribute("rooms", rooms.getCreatedRooms().values());
		return "/channel.jsp";
	}
	
	@RequestMapping("/wait")
	public String goWait(HttpSession session, int roomId, Model model) {
		Room room = rooms.getRoom(roomId);
		// TODO model.addAttribute("room", rooms.getRoom(roomId)); 불필요한 로컬 변수는 만들지 않는다.
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
	// TODO /game/{roomId}와 같이 path variable 사용해 구현
	public String goGame(@RequestParam int roomId, Model model) {
		Room room = rooms.getRoom(roomId);
		// TODO room.start();와 같은 형태로 구현해 상태를 바꾸는 방향은 어떨까? 지금 코드와 어떻게 바른지 비교해 본다.
		room.setRoomStatus("start");
		System.out.println(room.getRoomStatus());
		model.addAttribute("room", room);
		// TODO view 이름에 .jsp를 포함하지 않도록 설정한다.
		return "/gameMain.jsp";
	}
}
