package com.samuelkong.gongju.zip.deepfinder;

import com.samuelkong.gongju.common.ArrayUtil;
import com.samuelkong.gongju.common.FileUtil;
import com.samuelkong.gongju.common.Validator;
import com.samuelkong.gongju.zip.deepfinder.util.PropsValues;

import java.io.File;
import java.io.IOException;

import java.util.List;

import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.FileHeader;

public class DeepZipFinder {

	public static void main(String[] args) throws Exception {
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

		find(haystackFile);
	}

	public static void find(File haystack) throws IOException {
		if (haystack.isDirectory()) {
			findInFolder(haystack);
		}
		else {
			findInFile(haystack);
		}
	}

	protected static boolean containsNeedle(String str) {
		return str.indexOf(needle) >= 0;
	}

	protected static void findInFile(File file) throws IOException {
		String fileName = file.getName();

		if (containsNeedle(fileName)) {
			print(file.getPath());
		}

		if (_isManifest(file)) {
			findInManifestFile(file);
		}
		else if (_isZip(file)) {
			findInZipFile(file);
		}

	}

	protected static void findInFolder(File folder) 
		throws IOException {

		String folderName = folder.getName();

		if (containsNeedle(folderName)) {
			print(folder.getPath());
		}

		File[] files = folder.listFiles();

		for (File file : files) {
			find(file);
		}
	}

	protected static void findInManifestFile(File manifestFile)
		throws IOException {

		String content = FileUtil.read(manifestFile);

		if (containsNeedle(content)) {
			print(manifestFile.getPath());
		}
	}

	protected static void findInZipFile(File haystack)
		throws IOException {

		ZipFile zipFile = new ZipFile(haystack);

		findInZipFile(zipFile);

		zipFile.close();
	}

	protected static void findInZipFile(ZipFile zipFile) {
		try {
			List<FileHeader> fileHeaders = zipFile.getFileHeaders();

			for (FileHeader fileHeader : fileHeaders) {
				String zipEntryPath = fileHeader.getFileName();

				String zipEntryName = _getFileName(zipEntryPath);

				if (containsNeedle(zipEntryName)) {
					print(zipFile.getFile().getPath() + "/" + zipEntryPath);
				}
			}
		}
		catch (ZipException e) {
			e.printStackTrace();
		}
	}

	protected static void print(String location) {
		location = location.replace('\\', '/');

		System.out.println("- " + location);
	}

	private static String _getFileName(String path) {
		path = path.replace('\\', '/');

		if (path.endsWith("/")) {
			path = path.substring(0, path.length() - 1);
		}

		int x = path.lastIndexOf("/");

		if (x < 0) {
			return path;
		}

		return path.substring(x + 1);
	}

	private static boolean _isManifest(File file) {
		String name = file.getName();

		if (ArrayUtil.contains(name, PropsValues.MANIFEST_FILES)) {
			return true;
		}

		return false;
	}

	private static boolean _isZip(File file) throws IOException {
		ZipFile zipFile = new ZipFile(file);

		boolean result = zipFile.isValidZipFile();

		zipFile.close();

		return result;
	}

	protected static String needle = null;

}