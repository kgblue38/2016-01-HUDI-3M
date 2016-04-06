package inpoker.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import core.utils.SessionUtils;
import inpoker.room.model.Rooms;
import inpoker.user.dao.UserDao;
import inpoker.user.model.User;
import inpoker.user.model.UserLoginFailedException;
import inpoker.user.model.Users;

@RequestMapping("/user")
@Controller
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	UserDao userDao;
	Users users = Users.getInstance();
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public String create(@Valid User user, BindingResult bindingResult) {
		if (!bindingResult.hasErrors()) {
			userDao.addUser(user);
			logger.debug("user create() completed");
		}
		return "redirect:/";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam String userId, @RequestParam String userPassword, HttpServletRequest request) {
		try {
			isCorrectLogin(userId, userPassword);
		} catch (UserLoginFailedException e) {
			return "redirect:/";
		}
		
		User user = userDao.findUserById(userId);
		users.addUser(user);
		request.getSession().setAttribute("user", user);
		return "redirect:/room/channel";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		session.removeAttribute("user");
		return "redirect:/";
	}
	
	@RequestMapping(value = "", method = RequestMethod.PUT)
	public String update(@RequestParam String userPassword, HttpSession session) {
		userDao.updateUser(userPassword, SessionUtils.getUserValue(session, "user"));
		return "redirect:/room/channel";
	}
	
	private void isCorrectLogin(String userId, String userPassword) throws UserLoginFailedException {
		User dbUser = userDao.findUserById(userId);
		if (dbUser == null || !dbUser.isCorrectLogin(userId, userPassword)) {
			throw new UserLoginFailedException();
		}
	}
}