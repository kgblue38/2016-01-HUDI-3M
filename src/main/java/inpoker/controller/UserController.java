package inpoker.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import core.UserRepository;
import inpoker.users.dao.UserDao;
import inpoker.users.model.User;
import inpoker.users.model.UserLoginFailedException;

// http://blog.remotty.com/blog/2014/01/28/lets-study-rest/#method REST api개념
@RequestMapping("/user") // Class에서 RequestMapping해주면 디폴트 URL로 지정됨
@Controller
public class UserController {

	@Autowired
	UserDao userDao;

	UserRepository userRepository = UserRepository.getInstance();

	static String userId1;
	static String userId2;

	// http://egloos.zum.com/springmvc/v/509029 @Valid 개념, BindingResult에
	// Valid해준거 자동 처리해서 에러 여부 확인 가능
	// http://springmvc.egloos.com/535572 @ModelAttribute 개념
	// @RequestParam은 자동적으로 String isExist = req.getParameter("isExist"); 해줌
	// , BindingResult bindingResult
	@RequestMapping(value = "", method = RequestMethod.POST)
	public String create(@Valid User user, BindingResult bindingResult) {
		if (!bindingResult.hasErrors()) {
			System.out.println("im in here~");
			userDao.addUser(user);
		}

		return "redirect:/";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@RequestParam String userId, @RequestParam String userPassword, HttpServletRequest req) {

		try {
			isCorrectLogin(userId, userPassword);
		} catch (UserLoginFailedException e) {
			return "redirect:/";
		}

		if (userRepository.getUserCount() >= 2) {
			System.out.println("로그인 가능한 유저는 2명입니다.");
			return "redirect:/";
		}

		userRepository.valueBound(userId, req.getSession());

		User user = userDao.findUserById(userId);
		req.getSession().setAttribute("user", user);

		if (userRepository.getUserCount() == 1) {

			userId1 = user.getUserId();
			System.out.println(userId1);
		} else {
			userId2 = userId;
			System.out.println(userId2);
		}

		return "redirect:/wait/roomForm";
	}

	public static String getUserId1() {
		return userId1;
	}

	public static String getUserId2() {
		return userId2;
	}

	// Runtime Exception으로 UserLoginFailedException을 만들어서 처리 해줌.
	private void isCorrectLogin(String userId, String userPassword) throws UserLoginFailedException {
		User dbUser = userDao.findUserById(userId);
		if (dbUser == null || !dbUser.isCorrectLogin(userId, userPassword)) {
			throw new UserLoginFailedException();
		}
	}
}
