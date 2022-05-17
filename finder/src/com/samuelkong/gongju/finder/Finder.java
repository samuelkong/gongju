package com.samuelkong.gongju.finder;

import com.samuelkong.gongju.common.Validator;
import com.samuelkong.gongju.finder.util.PropsValues;

import java.io.File;

public class Finder {

	public static void main(String[] args) throws Exception {
		String needle = PropsValues.NEEDLE;
		String haystack = PropsValues.HAYSTACK;

		if ((args.length >= 1) && !Validator.isNull(args[0])) {
			needle = args[0];
		}

		if ((args.length >= 2) && !Validator.isNull(args[1])) {
			haystack = args[1];
		}

		if (Validator.isNull(needle) || Validator.isNull(haystack)) {
			System.out.println("ERROR: Invalid arguments");

			return;
		}

		run(needle, haystack);
	}

	public static void run(String needle, File haystack) {
		String filename = haystack.getName();

		int x = filename.indexOf(needle);

		if (x >= 0) {
			System.out.println(haystack.getPath());
		}

		if (!haystack.isDirectory()) {
			return;
		}

		for (File file : haystack.listFiles()) {
			run(needle, file);
		}
	}

		public static void run(String needle, String haystack) {
		run(needle, new File(haystack));
	}

}