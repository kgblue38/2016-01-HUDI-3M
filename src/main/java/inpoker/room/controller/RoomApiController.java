package inpoker.room.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import inpoker.room.model.Room;
import inpoker.room.model.Rooms;
import inpoker.user.model.User;

@Controller
@RequestMapping("/api/room")
public class RoomApiController {
	
	@RequestMapping("wait/ready")
	public @ResponseBody String ready(@RequestParam String userId, @RequestParam int roomId, @RequestParam String userStatus) {
//		room을 넘겨주느냐 roomId를 넘겨주느냐 문제 
//		클라이언트에 뭘 넘겨줘야되지...ㅋ, 넘겨줄거 없으면 요렇게 해도 되려나..
		Rooms.getInstance().getRoom(roomId).setUserStatus(userId, userStatus);
		return null;
	}
	
//	레디한 정보만 따로 관리할까도 생각 중.. , api 응답 어떻게 해야할지 감 안잡힘
	@RequestMapping("wait/check")
	public @ResponseBody Map<String, String> check(@RequestParam int roomId) {
		return Rooms.getInstance().getRoom(roomId).getAllUserStatus();
	}
}
