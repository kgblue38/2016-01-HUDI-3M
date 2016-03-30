package inpoker.room.controller;

import java.io.IOException;
import javax.servlet.ServletException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import inpoker.user.model.Users;

@Controller
@RequestMapping("/room")
public class RoomController {

	@RequestMapping("/channel")
	public String goChannel() {
		return "/channel.jsp";
	}
	
	@RequestMapping("/wait")
	public String goWait() {
		return "/waittingroom.jsp";
	}
}