package com.samuelkong.gongju.liferay.test.util;

import com.samuelkong.gongju.common.PropsUtil;

public interface PropsValues {

	public static final String OUTPUT_FILE_CSS = PropsUtil.get(
		"output.file.css");

	public static final String OUTPUT_FILE_HTML_ATTRIBUTE = PropsUtil.get(
		"output.file.html.attribute");

	public static final String OUTPUT_FILE_HTML_BODY = PropsUtil.get(
		"output.file.html.body");

	public static final String OUTPUT_FILE_JAVASCRIPT = PropsUtil.get(
		"output.file.javascript");

}