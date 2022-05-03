package com.samuelkong.gongju.worldtime.util;

import com.samuelkong.gongju.common.PropsUtil;

public interface PropsValues {

	public static final String[] DEFAULT_TIME_ZONES = PropsUtil.getArray(
		"default.time.zones");

	public static final String PINNED_TIME_ZONE = PropsUtil.get(
		"pinned.time.zone");

	public static final String[] TIME_ZONE_ALIAS_MAP = PropsUtil.getArray(
		"time.zone.alias.map");

}