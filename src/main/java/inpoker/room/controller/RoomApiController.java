package inpoker.room.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import core.utils.SessionUtils;
import inpoker.gamemain.model.GameManager;
import inpoker.room.model.GameAutoStartUsers;
import inpoker.room.model.MatchJsonData;
import inpoker.room.model.Room;
import inpoker.room.model.Rooms;
import inpoker.user.model.User;
import inpoker.user.model.Users;
@RestController
@RequestMapping("/api/room")
public class RoomApiController {
	@RequestMapping(value = "/wait/ready", method = RequestMethod.PUT)
	public Room ready(@RequestParam String userId, @RequestParam int roomId, @RequestParam String userStatus) {
		Rooms.getInstance().getRoom(roomId).setUserStatus(userId, userStatus);
		return Rooms.getInstance().getRoom(roomId);
	}
	
	@RequestMapping(value = "/wait/check", method = RequestMethod.GET)
	public Room check(@RequestParam int roomId, HttpServletResponse response) throws IOException {
		Room room = Rooms.getInstance().getRoom(roomId);
		return room;
	}
	
	@RequestMapping(value="/channel/match", method = RequestMethod.PUT)
	public int match(@RequestParam String userId, HttpSession session){
		User user = SessionUtils.getUserValue(session, "user");
		MatchJsonData data = GameAutoStartUsers.addUser(user);	
		int roomId = data.getRoomId();
		System.out.println("match() data : " + data);
		return roomId;
	}
	
	@RequestMapping(value = "/channel/users", method = RequestMethod.PUT)
	public Object checkUsers() {
		// TODO Users.getLoginUsers()로 구현할 수 없나?
		// TODO Map을 그냥 반환하면 안되나?
		return Users.getInstance().getLoginUsers().values();
	}
	
	@RequestMapping(value = "/channel/rooms", method = RequestMethod.PUT)
	public Object checkRooms(){
		return Rooms.getInstance().getCreatedRooms().values();
	}
	
	@RequestMapping(value = {"/start/users"}, method = {RequestMethod.POST})
	public void userInfo(@RequestParam String leftUser, @RequestParam String rightUser) {

		GameManager.leftUser = leftUser;
		GameManager.rightUser = rightUser;
	}
	
	//TODO 배열을 서버쪽에서 받는 방법 찾아야 한다.
	@RequestMapping(value = {"/start/card"}, method = {RequestMethod.POST})
	public void userPutCard(@RequestParam String userId, @RequestParam int user1PutCard, @RequestParam int user2PutCard) {

		if(GameManager.leftUser.equals(userId)){
			GameManager.user1Flag = user1PutCard;
		}else if(GameManager.rightUser.equals(userId)){
			GameManager.user2Flag = user2PutCard;
		}else{
			System.out.println("Id를 찾을 수 없습니다.");
			System.out.println(userId);
		}
		
		System.out.println("user1 put card status :" + GameManager.user1Flag);
		System.out.println("user2 put card status :" + GameManager.user2Flag);
		System.out.println("Ajax success");

	}

	@RequestMapping(value = {"/game/cardCheck"}, method = {RequestMethod.GET})
	public int checkUserCard(HttpServletResponse response) throws IOException {
		
		if(GameManager.user1Flag >= 0 && GameManager.user2Flag < 0){
			return 1;
		}else if(GameManager.user1Flag < 0 && GameManager.user2Flag >= 0){
			return 2;
		}else if(GameManager.user1Flag >= 0 && GameManager.user2Flag >= 0){
			return 3;
		}
		return -1;
	}
		
	@RequestMapping(value = {"/game/cardCheckInit"}, method = {RequestMethod.POST})
	public void UserCardInit(@RequestParam int value) throws IOException {
		
		GameManager.user1Flag = value;
		GameManager.user2Flag = value;
		
	}
	
	
	@RequestMapping(value = {"/game/cardIdxCheck"}, method = {RequestMethod.GET})
	public int checkCardIdx(HttpServletResponse response) throws IOException {
		
		if(GameManager.leftUserCardIdx >= 0 && GameManager.rightUserCardIdx >= 0)
			return 1;
		else
			return -1;
	}
	
	@RequestMapping(value = {"/game/cardIdx"}, method = {RequestMethod.POST})
	public void UserCardIdx(@RequestParam String userId, @RequestParam int idx) throws IOException {
		
		if(GameManager.leftUser.equals(userId)){
			GameManager.leftUserCardIdx = idx;
		}else if(GameManager.rightUser.equals(userId)){
			GameManager.rightUserCardIdx = idx;
		}else{
			System.out.println("Id를 찾을 수 없습니다.");
			System.out.println(userId);
		}
	}

	@RequestMapping(value = {"/game/gmaeResult"}, method = {RequestMethod.POST})
	public int gameResult(@RequestParam int leftNum, @RequestParam int rightNum) throws IOException {
		
		
		System.out.println("좌우의 숫자는 각각 "+leftNum + rightNum);
		
		int result;
		
		if(leftNum > rightNum){ //왼쪽 유저가 이겼을 때 
			result = 1; 
		}else if (leftNum < rightNum){ //오른쪽 유저가 이겼을 때 
			result = 2;		
		}else{
			result = 3;
		}
		
		System.out.println("result : " + result);
		return result;
	}
}
