package com.samuelkong.gongju.zip.deepfinder.util;

import com.samuelkong.gongju.common.PropsUtil;

public interface PropsValues {

	public static final String HAYSTACK = PropsUtil.get("haystack");

	public static final String[] IGNORED_PATHS = PropsUtil.getArray(
		"ignored.paths");

	public static final String[] TEXT_FILES = PropsUtil.getArray(
		"text.files");

	public static final String NEEDLE_FILE = PropsUtil.get("needle.file");

	public static final String TMP_FOLDER = PropsUtil.get("tmp.folder");

}