package inpoker.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import inpoker.users.dao.UserDao;

// ajax 통신 로직은 여기서 관리하다가 나중에 좀 분리할 예정
@Controller
@RequestMapping("/api")
public class ApiController {
	@Autowired
	UserDao userDao;
	
	//http://www.nextree.co.kr/p11205/, 
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public @ResponseBody Map<String, String> checkUserExist(@RequestParam String userId) {
		Map<String, String> userExist = new HashMap<>();
		userDao.findUserById(userId);
		if (userDao.findUserById(userId) == null) {
			userExist.put("userId", "notExist");
			return userExist;
		}
		userExist.put("userId", "exist");
		return userExist;
	}
}