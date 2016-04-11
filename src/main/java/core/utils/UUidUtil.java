package core.utils;

import java.util.UUID;

public class UUidUtil {
	// TODO 사용하는 곳도 없는데 왜 추가했나?
	public static String createUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}
}
