package com.samuelkong.gongju.common;

public class CSVUtil {

	public static String encode(String s) {
		if (s == null) {
			return null;
		}

		if ((s.indexOf(',') < 0) &&
			(s.indexOf('\"') < 0) &&
			(s.indexOf('\n') < 0) &&
			(s.indexOf('\r') < 0)) {

			return s;
		}

		s = s.replace("\"", "\"\"");

		return "\"" + s + "\"";
	}

}