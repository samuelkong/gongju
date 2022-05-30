package com.samuelkong.gongju.liferay.versions.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.Properties;

public class MavenMapUtil {

	public static String get(String key) {
		if (_mavenMap == null) {
			loadMap();
		}

		return _mavenMap.getProperty(key);
	}
	protected static void loadMap() {
		_mavenMap = new Properties();

		try {
			_mavenMap.load(
				new FileInputStream(new File("maven-map.properties")));
		}
		catch (FileNotFoundException fnfe) {
		}
		catch (IOException ioe) {
		}

	}

	private static Properties _mavenMap;

}