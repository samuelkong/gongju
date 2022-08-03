package com.samuelkong.gongju.pwned.passwords.model;

public class AuthInfo {

	public AuthInfo(String password) {
		_password = password;
	}

	public boolean isOld() {
		return _old;
	}

	public String getPassword() {
		return _password;
	}

	public String getSite() {
		return _site;
	}

	public void setOld(boolean old) {
		_old = old;
	}

	public void setSite(String site) {
		_site = site;
	}

	private boolean _old;
	private String _password;
	private String _site;

}