package com.samuelkong.gongju.i18n;

import com.samuelkong.gongju.common.FileUtil;
import com.samuelkong.gongju.i18n.util.PropsValues;

import java.io.File;
import java.io.IOException;

public class ZHConverter {

	public static final String SIMPLIFIED_TO_TRADITIONAL = "s2t";

	public static final String TRADITIONAL_TO_SIMPLIFIED = "t2s";

	public static void main(String[] args) throws Exception {
		convert(
			PropsValues.INPUT_FILE_SIMPLIFIED, SIMPLIFIED_TO_TRADITIONAL,
			PropsValues.OUTPUT_FILE_TRADITIONAL);

		convert(
			PropsValues.INPUT_FILE_TRADITIONAL, TRADITIONAL_TO_SIMPLIFIED,
			PropsValues.OUTPUT_FILE_SIMPLIFIED);
	}

	protected static void convert(
			String inputPath, String direction, String outputPath)
		throws IOException {

		File file = new File(inputPath);

		if (!file.exists()) { 
			return;
		}

		String result = convert(file, direction);

		FileUtil.write(result, outputPath);
	}

	protected static String convert(File file, String direction)
		throws IOException {

		String content = FileUtil.read(file);

		if (direction.equals(TRADITIONAL_TO_SIMPLIFIED)) {
			return com.spreada.utils.chinese.ZHConverter.convert(
				content, com.spreada.utils.chinese.ZHConverter.SIMPLIFIED);
		}
		else {
			return com.spreada.utils.chinese.ZHConverter.convert(
				content, com.spreada.utils.chinese.ZHConverter.TRADITIONAL);
		}
	}

}