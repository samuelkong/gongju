package com.samuelkong.gongju.common;

public class StringUtil {

	public static String padLeft(String str, int length) {
		return padLeft(str, length, ' ');
	}

	public static String padLeft(String str, int length, char pad) {
		if (str.length() == length) {
			return str;
		}
		else if (str.length() > length) {
			return str.substring(0, length);
		}
		else {
			while (str.length() != length) {
				str = pad + str;
			}

			return str;
		}
	}

	public static String padRight(String str, int length) {
		return padRight(str, length, ' ');
	}

	public static String padRight(String str, int length, char pad) {
		if (str.length() == length) {
			return str;
		}
		else if (str.length() > length) {
			return str.substring(0, length);
		}
		else {
			while (str.length() != length) {
				str = str + pad;
			}

			return str;
		}
	}

}