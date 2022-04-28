package com.samuelkong.gongju.common;

public class ArrayUtil {

	public static boolean contains(Object needle, Object[] haystack) {
		if ((haystack == null) || (haystack.length == 0) || (needle == null)) {
			return false;
		}

		for (Object obj : haystack) {
			if (needle.equals(obj)) {
				return true;
			}
		}

		return false;
	}

}