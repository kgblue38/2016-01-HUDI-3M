package inpoker.controller;

import java.io.IOException;
import javax.servlet.ServletException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import core.UserRepository;

@Controller
@RequestMapping("/wait")
public class WaitRoomFormController {

	@RequestMapping("/roomForm")
	public String goRoomForm() throws ServletException, IOException {

		return "/waittingroom.jsp";
	}
}