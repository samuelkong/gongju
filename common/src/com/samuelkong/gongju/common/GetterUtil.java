package com.samuelkong.gongju.common;

public class GetterUtil {

	public static final String[] BOOLEANS = {
		"1", "on", "t", "true", "y", "yes"
	};

	public static final boolean DEFAULT_BOOLEAN = false;

	public static final float DEFAULT_FLOAT = 0f;

	public static final int DEFAULT_INTEGER = 0;

	public static boolean getBoolean(String value) {
		return getBoolean(value, DEFAULT_BOOLEAN);
	}

	public static boolean getBoolean(String value, boolean defaultValue) {
		if (value == null) {
			return defaultValue;
		}

		value = value.trim().toLowerCase();

		if (value.equals(BOOLEANS[0]) || value.equals(BOOLEANS[1]) ||
			value.equals(BOOLEANS[2]) || value.equals(BOOLEANS[3]) ||
			value.equals(BOOLEANS[4]) || value.equals(BOOLEANS[5])) {

			return true;
		}
		else {
			return false;
		}
	}

	public static float getFloat(String value) {
		return getFloat(value, DEFAULT_FLOAT);
	}

	public static float getFloat(String value, float defaultValue) {
		if (value == null) {
			return defaultValue;
		}

		try {
			return Float.parseFloat(value);
		}
		catch (NumberFormatException nfe) {
			return defaultValue;
		}
	}

	public static int getInteger(String value) {
		return getInteger(value, DEFAULT_INTEGER);
	}

	public static int getInteger(String value, int defaultValue) {
		if (value == null) {
			return defaultValue;
		}

		try {
			return Integer.parseInt(value);
		}
		catch (NumberFormatException nfe) {
			return defaultValue;
		}
		
	}

}