package com.samuelkong.gongju.i18n.util;

import com.samuelkong.gongju.common.PropsUtil;

public interface PropsValues {

	public static final String INPUT_FILE_SIMPLIFIED = PropsUtil.get(
		"input.file.simplified");

	public static final String INPUT_FILE_TRADITIONAL = PropsUtil.get(
		"input.file.traditional");

	public static final String OUTPUT_FILE_SIMPLIFIED = PropsUtil.get(
		"output.file.simplified");

	public static final String OUTPUT_FILE_TRADITIONAL = PropsUtil.get(
		"output.file.traditional");

}