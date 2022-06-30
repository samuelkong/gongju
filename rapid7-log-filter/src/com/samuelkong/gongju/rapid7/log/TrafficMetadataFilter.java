package com.samuelkong.gongju.rapid7.log;

import com.samuelkong.gongju.common.FileUtil;
import com.samuelkong.gongju.rapid7.log.model.TrafficMetadata;
import com.samuelkong.gongju.rapid7.log.util.PropsValues;

import java.io.File;
import java.io.IOException;

public class TrafficMetadataFilter {

	public static void main(String[] args) throws Exception {
		File logFile = new File(PropsValues.INPUT);

		String filteredLogs = run(logFile);

		FileUtil.write(filteredLogs, PropsValues.OUTPUT);

		System.out.println(filteredLogs);
	}

	public static String run(File logFile) throws IOException {
		StringBuilder sb = new StringBuilder();

		String content = FileUtil.read(logFile);

		String[] requestLogs = content.split(_REQUEST_DELIMITER);

		for (String requestLog : requestLogs) {
			TrafficMetadata trafficMetadata = new TrafficMetadata(requestLog);

			String operation = trafficMetadata.getOperation();
			String url = trafficMetadata.getUrl();

			if (url == null) {
				continue;
			}

			if (filteredOperation(operation) && filteredUrl(url)) {
				sb.append(_REQUEST_DELIMITER);
				sb.append("\r\n");
				sb.append(trafficMetadata.getLog());
				sb.append("\r\n");
			}
		}

		return sb.toString();
	}

	protected static boolean filteredOperation(String operation) {
		operation = operation.toLowerCase();

		if (PropsValues.FILTER_OPERATION.length == 0) {
			return true;
		}

		for (String curOperation : PropsValues.FILTER_OPERATION) {
			if (operation.indexOf(curOperation) >= 0) {
				return true;
			}
		}

		return false;
	}


	protected static boolean filteredUrl(String url) {
		url = url.toLowerCase();

		if (PropsValues.FILTER_URL.length == 0) {
			return true;
		}

		for (String curUrl : PropsValues.FILTER_URL) {
			if (url.indexOf(curUrl) >= 0) {
				return true;
			}
		}

		return false;
	}

	private static String _REQUEST_DELIMITER =
		"============= Request ===================";
}