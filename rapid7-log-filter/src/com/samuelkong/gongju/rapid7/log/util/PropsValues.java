package com.samuelkong.gongju.rapid7.log.util;

import com.samuelkong.gongju.common.PropsUtil;

public interface PropsValues {

	public static final String[] FILTER_OPERATION = PropsUtil.getArray(
		"filter.operation");

	public static final String[] FILTER_URL = PropsUtil.getArray(
		"filter.url");

	public static final String INPUT = PropsUtil.get("input");

	public static final String OUTPUT = PropsUtil.get("output");

}