package inpoker.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/wait")
public class WaitRoomFormController {
	@RequestMapping("/roomForm")
	public String goRoomForm() throws ServletException, IOException {
		return "/waittingroom.jsp";
	}
}