package com.samuelkong.gongju.codebashing;

import com.samuelkong.gongju.common.FileUtil;
import com.samuelkong.gongju.codebashing.util.PropsValues;

import java.io.File;
import java.io.IOException;

import java.util.HashMap;
import java.util.Map;

public class PrimaryCourseCheck {

	public static final int MODE_CSS = 4;

	public static final int MODE_HTML_ATTRIBUTE = 2;

	public static final int MODE_HTML_BODY = 1;

	public static final int MODE_JAVASCRIPT = 3;

	public static void main(String[] args) throws Exception {
		Map<String,String> expectedAssignments = getExpectedAssignments(
			new File(PropsValues.INPUT_EXPECTED));
		Map<String,String> currentAssignments = getCurrentAssignments(
				new File(PropsValues.INPUT_CURRENT));

		check(expectedAssignments, currentAssignments);
	}

	public static void check(
		Map<String,String> expectedAssignments,
		Map<String,String> currentAssignments) {

		for (String key : currentAssignments.keySet()) {
			String currentPrimaryCourse = currentAssignments.get(key);

			String expectedPrimaryCourse = expectedAssignments.get(key);

			if (expectedPrimaryCourse == null) {
				System.out.println(key);
				System.out.println("    No expected course found");

				continue;
			}

			if (!currentPrimaryCourse.equals(expectedPrimaryCourse)) {
				System.out.println(key);
				System.out.println("    Expected: " + expectedPrimaryCourse);
				System.out.println("    Found:    " + currentPrimaryCourse);

				continue;
			}
		}
	}

	public static Map<String,String> getCurrentAssignments(File file)
			throws IOException {

			String content = FileUtil.read(file);

			return getCurrentAssignments(content);
		}

		public static Map<String,String> getCurrentAssignments(String csv) {
			Map<String,String> currentAssignments = new HashMap<>();

			String[] lines = csv.split("\n");

			for (String line : lines) {
				line = line.trim();

				String[] parts = line.split(",");

				String email = parts[0];
				String primaryCourse = parts[2];

				if (email.indexOf("@") < 0) {
					continue;
				}

				currentAssignments.put(email, primaryCourse);
			}

			return currentAssignments;
		}

	public static Map<String,String> getExpectedAssignments(File file)
		throws IOException {

		String content = FileUtil.read(file);

		return getExpectedAssignments(content);
	}

	public static Map<String,String> getExpectedAssignments(String csv) {
		Map<String,String> expectedAssignments = new HashMap<>();

		String[] lines = csv.split("\n");

		for (String line : lines) {
			line = line.trim();

			String[] parts = line.split(",");

			String email = parts[0];
			String primaryCourse = parts[1];

			if (email.indexOf("@") < 0) {
				continue;
			}

			expectedAssignments.put(email, primaryCourse);
		}

		return expectedAssignments;
	}

}