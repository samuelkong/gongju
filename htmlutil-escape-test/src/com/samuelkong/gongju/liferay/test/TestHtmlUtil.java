package com.samuelkong.gongju.liferay.test;

import com.liferay.portal.util.HtmlImpl;

import com.samuelkong.gongju.common.FileUtil;
import com.samuelkong.gongju.common.StringUtil;
import com.samuelkong.gongju.liferay.test.model.TestResult;
import com.samuelkong.gongju.liferay.test.util.PropsValues;

import java.io.File;
import java.io.IOException;

import java.util.HashSet;
import java.util.Set;

import org.owasp.encoder.Encode;

public class TestHtmlUtil {

	public static final int MODE_CSS = 4;

	public static final int MODE_HTML_ATTRIBUTE = 2;

	public static final int MODE_HTML_BODY = 1;

	public static final int MODE_JAVASCRIPT = 3;

	public static void main(String[] args) throws Exception {
		System.out.println("Running test for HTML body...");

		run(MODE_HTML_BODY, PropsValues.OUTPUT_FILE_HTML_BODY);

		System.out.println("Running test for HTML attribute...");

		run(MODE_HTML_ATTRIBUTE, PropsValues.OUTPUT_FILE_HTML_ATTRIBUTE);

		System.out.println("Running test for JavaScript...");

		run(MODE_JAVASCRIPT, PropsValues.OUTPUT_FILE_JAVASCRIPT);

		System.out.println("Running test for CSS...");

		run(MODE_CSS, PropsValues.OUTPUT_FILE_CSS);
	}

	public static void run(int mode, File outputFile) throws IOException {
		Set<TestResult> results = test(mode);

		if (results.size() == 0) {
			System.out.println("No discrepancy");
		}
		else {
			System.out.println(
				results.size() + " discrepancies found. See details in " +
				outputFile.getPath());
		}

		System.out.println();

		save(results, outputFile);
	}

	public static void run(int mode, String outputPath) throws IOException {
		run(mode, new File(outputPath));
	}

	protected static void save(Set<TestResult> results, File outputFile)
		throws IOException {

		StringBuilder sb = new StringBuilder();

		sb.append("Char  CodePoint   HtmlUtil    Encode\n");
		sb.append("----- ----------- ----------- ----------- \n");

		for (TestResult result : results) {
			sb.append(
				StringUtil.padRight(Character.toString(result.getChar()), 6));
			sb.append(StringUtil.padRight(result.getHexCodePoint(), 12));
			sb.append(StringUtil.padRight(result.getLiferayEscapeValue(), 12));
			sb.append(StringUtil.padRight(result.getOwaspEncodeValue(), 12));
			sb.append("\n");
		}

		FileUtil.write(sb.toString(), outputFile);
	}

	protected static Set<TestResult> test(int mode) {
		Set<TestResult> results = new HashSet<>();

		for (char c = 0; c < '\uffff'; c++) {
			String charString = Character.toString(c);

			String liferayEscapeValue = null;
			String owaspEncodeValue = null;

			if (mode == MODE_CSS) {
				liferayEscapeValue = _HTML_UTIL.escapeCSS(charString);
				owaspEncodeValue = Encode.forCssString(charString);
			}

			if (mode == MODE_HTML_ATTRIBUTE) {
				liferayEscapeValue = _HTML_UTIL.escapeAttribute(charString);
				owaspEncodeValue = Encode.forHtmlAttribute(charString);
			}

			if (mode == MODE_HTML_BODY) {
				liferayEscapeValue = _HTML_UTIL.escape(charString);
				owaspEncodeValue = Encode.forHtmlContent(charString);
			}

			if (mode == MODE_JAVASCRIPT) {
				liferayEscapeValue = _HTML_UTIL.escapeJS(charString);
				owaspEncodeValue = Encode.forJavaScript(charString);
			}

			if (!liferayEscapeValue.equals(owaspEncodeValue)) {
				results.add(
					new TestResult(c, liferayEscapeValue, owaspEncodeValue));
			}
		}

		return results;
	}

	private static HtmlImpl _HTML_UTIL = new HtmlImpl();

}