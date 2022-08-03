package com.samuelkong.gongju.pwned.passwords.util;

import com.samuelkong.gongju.common.GetterUtil;
import com.samuelkong.gongju.common.PropsUtil;

public interface PropsValues {

	public static final String CACHE_DIR = PropsUtil.get("cache.dir");

	public static final String COLUMN_OLD = PropsUtil.get("column.old");

	public static final String COLUMN_PASSWORD = PropsUtil.get(
		"column.password");

	public static final String COLUMN_SITE = PropsUtil.get("column.site");

	public static final String SHEET_NAME = PropsUtil.get("sheet.name");

	public static final boolean SHEET_HEADER_ROW = GetterUtil.getBoolean(
		PropsUtil.get("sheet.header.row"));

	public static final String XLS_FILE = PropsUtil.get("xls.file");

	public static final String XLS_PASSWORD = PropsUtil.get("xls.password");

}