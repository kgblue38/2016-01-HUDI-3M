package core;

import java.util.Hashtable;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;

public class UserRepository {

	private static Hashtable loginUsers = new Hashtable();
	
	public void valueBound(HttpSession session, String userId) {
		
		
		// session값을 put한다.
		loginUsers.put(session, userId);
		System.out.println(userId + "님이 로그인 하셨습니다.");
		System.out.println("현재 접속자 수 : " + getUserCount());
	}

    public int getUserCount(){
        return loginUsers.size();
    }

	
	
}
