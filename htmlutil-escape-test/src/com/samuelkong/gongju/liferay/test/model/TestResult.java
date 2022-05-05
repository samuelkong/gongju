package com.samuelkong.gongju.liferay.test.model;

public class TestResult {

	public TestResult(
		char c, String liferayEscapeValue, String owaspEncodeValue) {

		_c = c;
		_liferayEscapeValue = liferayEscapeValue;
		_owaspEncodeValue = owaspEncodeValue;

		_hexCodePoint = getHexCodePoint(c);
	}

	public char getChar() {
		return _c;
	}

	public String getHexCodePoint() {
		return _hexCodePoint;
	}

	public String getLiferayEscapeValue() {
		return _liferayEscapeValue;
	}

	public String getOwaspEncodeValue() {
		return _owaspEncodeValue;
	}

	protected String getHexCodePoint(int i) {
		String hex = Integer.toHexString(i);

		return "U+" + hex;
	}

	private char _c;
	private String _hexCodePoint;
	private String _liferayEscapeValue;
	private String _owaspEncodeValue;

}