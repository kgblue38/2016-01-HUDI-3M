package inpoker.users.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import inpoker.users.dao.UserDao;
import inpoker.users.model.User;

//@WebServlet("/users/login")

@Controller
public class LoginController extends HttpServlet {
	@Autowired
	UserDao userDao;
	
	@RequestMapping(value = "/users/login", method = RequestMethod.POST)
	public String doPost(HttpServletRequest req) {
		String userId = req.getParameter("userId");
		String userPassword = req.getParameter("userPassword");
		User user = userDao.findUserById(userId);
		
		if (user == null || !userId.equals(user.getUserId()) || !userPassword.equals(user.getUserPassword())) {
			return "redirect:/";
		}
		req.getSession().setAttribute("user", user);
		return "redirect:/wait/roomForm";
	}
}
 