package com.samuelkong.gongju.rapid7.log.model;

public class TrafficMetadata {

	public TrafficMetadata(String log) {
		_log = log.trim();

		String[] metadata = log.split("\\R");

		for (String curMetadata : metadata) {
			curMetadata = curMetadata.trim();

			if (curMetadata.startsWith(_FIELD_URL)) {
				_url = curMetadata.substring(_FIELD_URL.length());
			}

			if (curMetadata.startsWith(_FIELD_OPERATION)) {
				_operation = curMetadata.substring(_FIELD_OPERATION.length());
			}
		}
	}

	public String getLog() {
		return _log;
	}

	public String getOperation() {
		return _operation;
	}

	public String getUrl() {
		return _url;
	}

	private String _log;
	private String _operation;
	private String _url;

	private String _FIELD_OPERATION = "Operation: ";
	private String _FIELD_URL = "URL: ";

}