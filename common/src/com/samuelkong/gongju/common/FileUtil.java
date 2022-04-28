package com.samuelkong.gongju.common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;

import java.util.Set;
import java.util.TreeSet;

public class FileUtil {

	public static String getExtension(File file) {
		return getExtension(file.getName());
	}

	public static String getExtension(String filename) {
		if (filename == null) {
			return null;
		}

		int pos = filename.lastIndexOf('.');

		if (pos > 0) {
			return filename.substring(pos + 1).toLowerCase();
		}
		else {
			return "";
		}
	}

	public static String[] listFileNames(File file) {
		return listFileNames(file, null);
	}

	public static String[] listFileNames(File file, String extension) {
		Set<String> files = new TreeSet<String>();

		File[] fileArray = file.listFiles();

		for (File currentFile : fileArray) {
			if (currentFile.isFile() &&
				((extension == null) ||
				 extension.equals(getExtension(currentFile)))) {

				files.add(currentFile.getName());
			}
		}

		return files.toArray(new String[files.size()]);
	}

	public static String[] listFileNames(String filename) {
		return listFileNames(filename, null);
	}

	public static String[] listFileNames(String filename, String extension) {
		return listFileNames(new File(filename), extension);
	}

	public static String[] listFolderNames(File file) {
		Set<String> files = new TreeSet<String>();

		File[] fileArray = file.listFiles();

		for (File currentFile : fileArray) {
			if (currentFile.isDirectory()) {
				files.add(currentFile.getName());
			}
		}

		return files.toArray(new String[files.size()]);
	}

	public static String[] listFolderNames(String filename) {
		return listFolderNames(new File(filename));
	}

	public static String read(String filename) throws IOException {
		StringBuilder sb = new StringBuilder();

		Reader reader = null;

		try {
			reader = new BufferedReader(
				new InputStreamReader(new FileInputStream(filename), UTF8));

			int length = 0;
			char[] buffer = new char[4096];

			while ((length = reader.read(buffer)) != -1) {
				sb.append(buffer, 0, length);
			}
		}
		finally {
			if (reader != null) {
				reader.close();
			}
		}

		return sb.toString();
	}

	public static void write(String content, File file)
		throws IOException {

		file.getParentFile().mkdirs();

		Writer out = new PrintWriter(file, UTF8);

		try {
			out.write(content);
		}
		finally {
			out.close();
		}
	}

	public static void write(String content, String filename)
		throws IOException {

		write(content, new File(filename));
	}

	protected static String UTF8 = "UTF-8";

}