package com.samuelkong.gongju.pwned.passwords.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class HttpUtil {

	public static String urlToString(String url) throws IOException {
		ProcessBuilder processBuilder = new ProcessBuilder();

		processBuilder.command("cmd.exe", "/c", "curl", url);

		Process process = processBuilder.start();

		InputStream inputStream = process.getInputStream();

		String content = inputStreamToString(inputStream);

		return content.trim();
	}

	protected static String inputStreamToString(InputStream inputStream)
		throws IOException {

		StringBuilder sb = new StringBuilder();

		BufferedReader bufferedReader = new BufferedReader(
			new InputStreamReader(inputStream));

		String line;

		while ((line = bufferedReader.readLine()) != null) {
			sb.append(line);
			sb.append("\n");
		}

		return sb.toString();
	}

}