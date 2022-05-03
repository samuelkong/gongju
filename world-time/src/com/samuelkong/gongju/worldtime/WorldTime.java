package com.samuelkong.gongju.worldtime;

import com.samuelkong.gongju.common.StringUtil;
import com.samuelkong.gongju.worldtime.util.PropsValues;

import java.time.ZoneId;
import java.time.zone.ZoneRulesException;

import java.util.Calendar;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TimeZone;
import java.util.TreeMap;
import java.util.TreeSet;

public class WorldTime {

	public static void main(String[] args) throws Exception {
		System.out.println();

		printTimeZoneTable(PropsValues.DEFAULT_TIME_ZONES);

		System.out.println();
		System.out.println("Enter the name of a time zone.");
		System.out.println("Enter 'ids [-PREFIX]' for a list of time zones.");
		System.out.println("Enter 'exit' to exit.");

		Scanner scanner = new Scanner(System.in);

		while (true) {
			String cmd = scanner.nextLine();

			String originalCmd = cmd;

			cmd = cmd.toLowerCase();

			if (cmd.equals("") || cmd.equals("exit") ||
				cmd.equals("quit") || cmd.equals("q")) {

				break;
			}

			if (cmd.indexOf("ids") == 0) {
				String prefix = _getIdsPrefix(originalCmd);

				printTimeZoneIds(prefix);

				continue;
			}

			String[] timeZoneIds = new String[] {
				PropsValues.PINNED_TIME_ZONE, originalCmd
			};
	
			printTimeZoneTable(timeZoneIds);
		}

		scanner.close();
	}

	public static void printTimeZoneIds(String prefix) throws Exception {
		for (String timeZoneId : getAvailableIDs()) {
			if ((prefix == null) || (timeZoneId.indexOf(prefix) == 0)) {
				System.out.println(timeZoneId);
			}
		}
	}

	public static void printTimeZoneTable(String timeZoneId) throws Exception {
		TimeZone timeZone = null;
		try {
			timeZone = getTimeZone(timeZoneId);
		}
		catch (ZoneRulesException zre) {
			System.out.println("Error: Unknown time zone.");

			return;
		}

		Calendar calendar = Calendar.getInstance(timeZone);

		calendar.setTimeInMillis(getCurrentTime());

		System.out.print(formatTimeZoneName(timeZoneId));
		System.out.print(" ");

		int hourOfDay = calendar.get(Calendar.HOUR_OF_DAY);
		//int minute = calendar.get(Calendar.MINUTE);

		for (int i = hourOfDay; i < (hourOfDay +24); i++) {
			int time = i % 24;

			System.out.print(StringUtil.padLeft(String.valueOf(time), 2, '0'));
			//System.out.print(":");
			//System.out.print(minute);
			System.out.print(" ");
		}

		System.out.println("");
	}

	public static void printTimeZoneTable(String[] timeZoneIds)
		throws Exception {


		for (String timeZoneId : timeZoneIds) {
			printTimeZoneTable(timeZoneId);
		}
	}

	protected static String formatTimeZoneName(String timeZoneId) {
		String name = timeZoneId.replace('_', ' ');

		int x = name.indexOf("/");

		if (x >= 0) {
			name = name.substring(x + 1);
		}

		if (name.length() >= _TIME_ZONE_NAME_LENGTH) {
			return name.substring(0, _TIME_ZONE_NAME_LENGTH);
		}

		return StringUtil.padRight(name, _TIME_ZONE_NAME_LENGTH);
	}

	protected static long getCurrentTime() {
		if (_CURRENT_TIME == 0) {
			Calendar calendar = Calendar.getInstance();

			_CURRENT_TIME = calendar.getTimeInMillis();
		}

		return _CURRENT_TIME;
	}

	protected static TimeZone getTimeZone(String timeZoneId) throws Exception {
		ZoneId zoneId = ZoneId.of(timeZoneId, getTimeZoneAliasMap());

		TimeZone timeZone = TimeZone.getTimeZone(zoneId);

		return timeZone;
	}

	protected static Map<String, String> getTimeZoneAliasMap()
		throws Exception {

		if (_TIME_ZONE_ALIAS_MAP != null) {
			return _TIME_ZONE_ALIAS_MAP;
		}

		_TIME_ZONE_ALIAS_MAP = new TreeMap<>();

		for (String mapping : PropsValues.TIME_ZONE_ALIAS_MAP) {
			int x = mapping.indexOf("=");

			if (x < 0) {
				throw new Exception("Malformed time zone alias map");
			}

			String key = mapping.substring(0, x);
			String value = mapping.substring(x + 1);

			_TIME_ZONE_ALIAS_MAP.put(key, value);
		}

		for (int i = 0; i <= 12; i++) {
			_TIME_ZONE_ALIAS_MAP.put("UTC+" + i, "Etc/GMT-" + i);
			_TIME_ZONE_ALIAS_MAP.put("UTC-" + i, "Etc/GMT+" + i);
		}

		return _TIME_ZONE_ALIAS_MAP;
	}

	protected static Set<String> getAvailableIDs() throws Exception {
		Set<String> availableIDs = new TreeSet<>();

		for (String timeZoneId : ZoneId.getAvailableZoneIds()) {
			availableIDs.add(timeZoneId);
		}

		for (String timeZoneAlias : getTimeZoneAliasMap().keySet()) {
			availableIDs.add(timeZoneAlias);
		}

		return availableIDs;
	}

	private static String _getIdsPrefix(String cmd) {
		if (cmd.length() <= 4) {
			return null;
		}

		return cmd.substring(4);
	}

	private static long _CURRENT_TIME = 0;

	private static Map<String, String> _TIME_ZONE_ALIAS_MAP;

	private static int _TIME_ZONE_NAME_LENGTH = 12;

}