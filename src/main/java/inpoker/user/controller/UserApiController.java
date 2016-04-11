package inpoker.user.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import inpoker.user.dao.UserDao;
import inpoker.user.model.UserNotFoundException;

@RestController
@RequestMapping("/api/user")
public class UserApiController {
	@Autowired
	UserDao userDao;
	
	@RequestMapping(value = "", method = RequestMethod.POST)
	public Map<String, String> checkUserExist(@RequestParam String userId) {
		// TODO 전달해야 하는 인자가 하나인데 굳이 Map을 사용해야 하나?
		Map<String, String> userExist = new HashMap<>();
		try {
			userDao.findUserById(userId);
			userExist.put("userId", "exist");
		} catch (UserNotFoundException e) {
			userExist.put("userId", "notExist");
		}
		return userExist;
	}
}