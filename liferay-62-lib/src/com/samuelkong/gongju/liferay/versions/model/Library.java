package com.samuelkong.gongju.liferay.versions.model;

import com.samuelkong.gongju.liferay.versions.util.MavenMapUtil;

public class Library {

	public Library(String jar, String version) {
		_jar = jar;
		_version = version;

		String mavenId = MavenMapUtil.get(getJarName());

		if (mavenId == null) {
			return;
		}

		String[] parts = mavenId.split(":");

		if (parts.length != 2) {
			return;
		}

		_group = parts[0];
		_artifact = parts[1];
	}

	public String getArtifact() {
		return _artifact;
	}

	public String getGroup() {
		return _group;
	}

	public String getJar() {
		return _jar;
	}

	public String getJarName() {
		int x = _jar.lastIndexOf(".");

		return _jar.substring(0, x);
	}

	public String getVersion() {
		return _version;
	}

	private String _artifact;
	private String _group;
	private String _jar;
	private String _version;
}