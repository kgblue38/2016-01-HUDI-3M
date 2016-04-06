package core.utils;

import java.util.UUID;

public class UUidUtil {
	public static String createUUID() {
		return UUID.randomUUID().toString().replace("-", "");
	}
}
