package com.samuelkong.gongju.pdf.insert.util;

import com.samuelkong.gongju.common.GetterUtil;
import com.samuelkong.gongju.common.PropsUtil;

public interface PropsValues {

	public static final String SOURCE = PropsUtil.get("source");

	public static final String INSERT = PropsUtil.get("insert");

	public static final String OUTPUT = PropsUtil.get("output");

	public static final int OFFSET = GetterUtil.getInteger(
		PropsUtil.get("offset"));

}