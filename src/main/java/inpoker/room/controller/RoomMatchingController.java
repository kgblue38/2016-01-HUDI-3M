package inpoker.room.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import inpoker.room.model.Room;

@Controller
@RequestMapping("/room/channel")
public class RoomMatchingController {
	@RequestMapping(value="/match", method= {RequestMethod.PUT})
	public Room match(@RequestParam String userId, @RequestParam String userStatus){
		return null;
	}
}
