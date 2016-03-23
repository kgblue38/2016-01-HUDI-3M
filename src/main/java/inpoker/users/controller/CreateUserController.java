package inpoker.users.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import inpoker.users.dao.UserDao;
import inpoker.users.model.User;

@Controller
public class CreateUserController extends HttpServlet{
	@Autowired
	UserDao userDao;
	
	@RequestMapping(value = "/users/create", method = RequestMethod.POST)
	public String createUser(HttpServletRequest req) {
		
		User user = new User(req.getParameter("userId"), req.getParameter("userPassword"), req.getParameter("userEmail"));
		userDao.addUser(user);
		return "redirect:/";
	}
}