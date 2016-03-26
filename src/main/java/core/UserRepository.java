package core;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

public class UserRepository {

	// 싱글톤 패턴 사용
	private static UserRepository userRepository = new UserRepository();
	
	private UserRepository() {
	}

	public static synchronized UserRepository getInstance() {
		if (userRepository == null) {
			userRepository = new UserRepository();
		}
		return userRepository;
	}

	// 로그인한 접속자를 담기위한 해시테이블
	private static Map<String, HttpSession> loginUsers = new HashMap<String, HttpSession>();

	public void valueBound(String userId, HttpSession session) {

		loginUsers.put(userId, session);
		System.out.println(userId + "님이 로그인 하셨습니다.");
		System.out.println("현재 접속자 수 : " + getUserCount());
		System.out.println(userId + " : " + session);
	}

	public int getUserCount() {
		return loginUsers.size();
	}
	
	public HttpSession getUserSession(String userId) {

		return loginUsers.get(userId);
	}



}
