package com.samuelkong.gongju.zip.deepfinder.util;

import com.samuelkong.gongju.common.PropsUtil;

public interface PropsValues {

	public static final String HAYSTACK = PropsUtil.get("haystack");

	public static final String[] MANIFEST_FILES = PropsUtil.getArray(
		"manifest.files");

	public static final String NEEDLE_FILE = PropsUtil.get("needle.file");

}