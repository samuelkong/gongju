package com.samuelkong.gongju.pwned.passwords;

import com.samuelkong.gongju.common.FileUtil;
import com.samuelkong.gongju.common.HashUtil;
import com.samuelkong.gongju.common.StringUtil;
import com.samuelkong.gongju.common.Validator;
import com.samuelkong.gongju.pwned.passwords.model.AuthInfo;
import com.samuelkong.gongju.pwned.passwords.model.Spreadsheet;
import com.samuelkong.gongju.pwned.passwords.util.HttpUtil;
import com.samuelkong.gongju.pwned.passwords.util.PropsValues;

import java.io.File;
import java.io.IOException;

import java.security.NoSuchAlgorithmException;

import java.util.ArrayList;
import java.util.List;

public class PwnedPasswords {

	public static void main(String[] args) throws Exception {
		if ((args.length >= 1) && !Validator.isNull(args[0])) {
			run(args[0]);

			return;
		}

		run();
	}

	public static void run() throws IOException {
		List<AuthInfo> myPwnedPasswords = new ArrayList<AuthInfo>();

		Spreadsheet spreadshet = new Spreadsheet(
			PropsValues.XLS_FILE, PropsValues.XLS_PASSWORD,
			PropsValues.SHEET_NAME);

		List<AuthInfo> authInfos = spreadshet.getAuthInfos(
			PropsValues.COLUMN_PASSWORD, PropsValues.COLUMN_SITE,
			PropsValues.COLUMN_OLD);

		for (AuthInfo authInfo : authInfos) {
			String password = authInfo.getPassword();

			if (isPwned(password)) {
				myPwnedPasswords.add(authInfo);
			}
		}

		print(myPwnedPasswords);
	}

	public static void run(String password) throws IOException {
		if (isPwned(password)) {
			System.out.println("Password has been pwned. Do not use.");
		}
		else {
			System.out.println("Password does not appear in pwned passwords.");
		}
	}

	protected static String getRangeFileContent(String range)
		throws IOException {

		String filename = PropsValues.CACHE_DIR + "/" + range;

		File file = new File(filename);

		if (!file.exists()) {
			String url = _API_URL_BASE + range;

			System.out.println("INFO: Fetching " + url);

			String content = HttpUtil.urlToString(url);

			FileUtil.write(content, filename);
		}

		String content = FileUtil.read(filename);

		content = content.trim();

		if (content.equals("")) {
			System.out.println(
				"WARN: Range '" + range + "' returned an empty file.");
		}

		return content;
	}

	protected static boolean isPwned(String password) throws IOException {
		try {
			String hash = HashUtil.hash(password, HashUtil.SHA1);

			String prefix = hash.substring(0, 5);
			String suffix = hash.substring(5);

			String content = getRangeFileContent(prefix);

			String[] lines = content.split("\n");

			for (String line : lines) {
				String lineSuffix = line.substring(0, 35);

				if (suffix.equals(lineSuffix)) {
					return true;
				}
			}
		}
		catch (NoSuchAlgorithmException nsae) {
			System.out.println(
				"NoSuchAlgorithmException: System does not support SHA-1");

			System.exit(1);
		}

		return false;
	}

	protected static void print(List<AuthInfo> authInfos) {
		int maxPasswordColumnLength = 0;
		int maxSiteColumnLength = 0;

		for (AuthInfo authInfo : authInfos) {
			if (authInfo.getPassword().length() > maxPasswordColumnLength) {
				maxPasswordColumnLength = authInfo.getPassword().length();
			}

			if (authInfo.getSite().length() > maxSiteColumnLength) {
				maxSiteColumnLength = authInfo.getSite().length();
			}
		}

		StringBuilder sb = new StringBuilder();

		for (AuthInfo authInfo : authInfos) {
			String password = StringUtil.padRight(
				authInfo.getPassword(), maxPasswordColumnLength);
			String site = StringUtil.padRight(
				authInfo.getSite(), maxSiteColumnLength);

			sb.append(site);
			sb.append(" | ");
			sb.append(password);
			sb.append(" | ");

			if (authInfo.isOld()) {
				sb.append("OLD");
			}

			sb.append("\n");
		}

		System.out.println(sb.toString());
	}

	private static final String _API_URL_BASE =
		"https://api.pwnedpasswords.com/range/";

}