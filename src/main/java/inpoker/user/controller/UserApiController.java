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