package core;

import java.util.Hashtable;

import javax.servlet.http.HttpSession;

public class UserRepository {

	// 싱글톤 패턴 사용
	private static UserRepository userRepository = new UserRepository();
	private UserRepository(){}
	public static synchronized UserRepository getInstance() {
		if (userRepository == null) {
			userRepository = new UserRepository();
		}
		return userRepository;
	}

	// 로그인한 접속자를 담기위한 해시테이블
	private static Hashtable<HttpSession, String> loginUsers = new Hashtable<HttpSession, String>();

	public void valueBound(HttpSession session, String userId) {

		// session값을 put한다.
		loginUsers.put(session, userId);
		System.out.println(userId + "님이 로그인 하셨습니다.");
		System.out.println("현재 접속자 수 : " + getUserCount());
		System.out.println(session + "," + userId );
		
	}
	
	public int getUserCount() {
		return loginUsers.size();
	}

}
