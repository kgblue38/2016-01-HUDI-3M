package inpoker.wait.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//@WebServlet("/wait/roomForm")
@Controller
public class WaitRoomFormController {
	@RequestMapping("/wait/roomForm")
	public String goRoomForm() throws ServletException, IOException {
		return "/watingroom.html";
	}
}
