package inpoker.users.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import inpocker.users.dao.UserDao;
import inpocker.users.model.User;

@WebServlet("users/create")
public class CreateUserController extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = new User(req.getParameter("userId"), req.getParameter("userPassword"), req.getParameter("userEmail"));
		UserDao userDao = new UserDao();
		userDao.addUser(user);
		resp.sendRedirect("/");
	}
}