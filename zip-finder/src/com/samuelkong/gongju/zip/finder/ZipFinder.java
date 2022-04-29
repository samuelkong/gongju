package com.samuelkong.gongju.zip.finder;

import com.samuelkong.gongju.common.Validator;
import com.samuelkong.gongju.zip.finder.util.PropsValues;

import java.io.File;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;

public class ZipFinder {

	public static void main(String[] args) throws Exception {
		String needle = null;
		String haystack = null;

		if ((args.length >= 2) && !Validator.isNull(args[0]) &&
			!Validator.isNull(args[1])) {

			needle = args[0];
			haystack = args[1];
		}
		else {
			needle = PropsValues.NEEDLE_FILE;
			haystack = PropsValues.HAYSTACK;
		}

		if (Validator.isNull(needle) || Validator.isNull(haystack)) {
			System.out.println("ERROR: Invalid arguments");

			return;
		}

		File haystackFile = new File(haystack);

		run(needle, haystackFile);
	}

	public static void run(String needle, File haystack) throws IOException {
		List<String> locations = null;

		if (haystack.isDirectory()) {
			locations = findInFolder(needle, haystack);
		}

		if (haystack.isFile()) {
			locations = findInFile(needle, haystack);
		}

		print(locations);
	}

	protected static List<String> findInFile(String needle, File file) 
		throws IOException {

		ZipFile zipFile = null;

		try {
			zipFile = new ZipFile(file);

			return findInZipFile(needle, zipFile);
		}
		catch (ZipException ze) {
			System.err.println("[WARN] " + file + "is not a zip file");
		}
		finally {
			if (zipFile != null) {
				zipFile.close();
			}
		}

		return new ArrayList<String>();
	}

	protected static List<String> findInFolder(String needle, File folder) 
		throws IOException {

		List<String> locations = new ArrayList<>();

		if (!folder.isDirectory()) {
			return locations;
		}

		File[] files = folder.listFiles();

		for (File file : files) {
			if (file.isDirectory()) {
				locations.addAll(findInFolder(needle, file));
			}

			if (file.isFile()) {
				locations.addAll(findInFile(needle, file));
			}
		}

		return locations;
	}

	protected static List<String> findInZipFile(
		String needle, ZipFile zipFile) {

		List<String> locations = new ArrayList<>();

		Enumeration<? extends ZipEntry> e = zipFile.entries();

		while (e.hasMoreElements()) {
			ZipEntry zipEntry = e.nextElement();

			String entryName = zipEntry.getName();

			if (entryName.indexOf(needle) >= 0) {
				locations.add(zipFile.getName() + "/" + entryName);
			}
		}

		return locations;
	}

	protected static void print(List<String> locations) {
		for (String location : locations) {
			System.out.println(location);
		}
	}

}