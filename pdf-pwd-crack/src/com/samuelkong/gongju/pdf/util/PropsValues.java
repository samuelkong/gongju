package com.samuelkong.gongju.pdf.util;

import com.samuelkong.gongju.common.PropsUtil;

public interface PropsValues {

	public static final String INPUT = PropsUtil.get("input");

	public static final String KNOWN_PASSWORD_PREFIX = PropsUtil.get(
		"known.password.prefix");

	public static final String KNOWN_PASSWORD_SUFFIX = PropsUtil.get(
		"known.password.suffix");

}