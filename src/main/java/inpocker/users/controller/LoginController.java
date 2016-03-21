package inpocker.users.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import inpocker.users.dao.UserDao;
import inpocker.users.model.User;

@WebServlet("/users/login")
public class LoginController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (!User.isCorrectLogin(req.getParameter("userId"), req.getParameter("userPassword"))) {
			resp.sendRedirect("/");
			return;
		}
		UserDao userDao = new UserDao();
		User user = userDao.findUserById(req.getParameter("userId"));
		req.getSession().setAttribute("user", user);
		resp.sendRedirect("/wait/roomForm");
	}
}
