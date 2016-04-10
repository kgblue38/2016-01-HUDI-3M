package inpoker.room.model;

public class MatchJsonData {
	private String result;
	private int roomId;
	private MatchJsonData(String result, int roomId){
		this.result = result;
		this.roomId = roomId;
	};
	private MatchJsonData(String result) {
		this(result, -1);
	}
	
	public static MatchJsonData getSuccess(int roomId) {
		return new MatchJsonData("success", roomId);
	}
	public static MatchJsonData getFail() {
		return new MatchJsonData("fail");
	}

	public int getRoomId() {
		return roomId;
	}
	@Override
	public String toString() {
		return "MatchJsonData [result=" + result + ", roomId=" + roomId + "]";
	}
}
