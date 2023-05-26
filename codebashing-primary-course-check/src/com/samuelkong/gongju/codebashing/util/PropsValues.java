package com.samuelkong.gongju.codebashing.util;

import com.samuelkong.gongju.common.PropsUtil;

public interface PropsValues {

	public static final String INPUT_CURRENT = PropsUtil.get(
		"input.current");

	public static final String INPUT_EXPECTED = PropsUtil.get(
		"input.expected");

}