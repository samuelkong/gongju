package com.samuelkong.gongju.hash.model;

import java.io.File;

import com.samuelkong.gongju.common.HashUtil;

public class FileHash {

	public FileHash(File file) {
		_file = file;
	}

	public File getFile() {
		return _file;
	}

	public String getMD5() throws Exception {
		if (_md5 == null) {
			_md5 = HashUtil.hashFile(getFile(), HashUtil.MD5);
		}

		return _md5;
	}

	public String getSHA1() throws Exception {
		if (_sha1 == null) {
			_sha1 = HashUtil.hashFile(getFile(), HashUtil.SHA1);
		}

		return _sha1;
	}

	private File _file;
	private String _md5;
	private String _sha1;

}