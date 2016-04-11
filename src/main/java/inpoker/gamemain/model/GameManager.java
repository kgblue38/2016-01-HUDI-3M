package inpoker.gamemain.model;

public class GameManager {
	// TODO 서로 관련이 있는 상수 값을 관리할 때는 가능하면 enum을 사용
	public static String user1CardNum = "-1";
	public static String user2CardNum = "-1";
	public static String leftUser;
	public static int leftUserStatus = 1;
	public static int rightUserStatus = 2;
	public static String rightUser;
	public static int user1Flag = -2;
	public static int user2Flag = -2;
	public static int leftUserCardIdx = -1;
	public static int rightUserCardIdx = -1;

	private static GameManager gameManager = new GameManager();

	private GameManager() {
	}

	public static GameManager getInstance() {

		if (gameManager == null) {
			gameManager = new GameManager();
		}
		return gameManager;
	}

	
}
