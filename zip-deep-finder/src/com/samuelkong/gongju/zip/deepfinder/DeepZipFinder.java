package com.samuelkong.gongju.zip.deepfinder;

import com.samuelkong.gongju.common.ArrayUtil;
import com.samuelkong.gongju.common.FileUtil;
import com.samuelkong.gongju.common.Validator;
import com.samuelkong.gongju.zip.deepfinder.util.PropsValues;

import java.io.File;
import java.io.IOException;

import java.util.Random;

import net.lingala.zip4j.ZipFile;

public class DeepZipFinder {

	public static void main(String[] args) throws Exception {
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
			findInFolder(haystack, "");
		}
		else {
			findInFile(haystack, "");
		}
	}

	protected static boolean containsNeedle(String str) {
		return str.indexOf(needle) >= 0;
	}

	protected static void findInFile(File file, String currentPath)
		throws IOException {

		String fileName = file.getName();

		if (containsNeedle(fileName)) {
			print(file.getPath(), currentPath);
		}

		if (_isTextFile(file)) {
			findInManifestFile(file, currentPath);
		}
		else if (_isZip(file)) {
			findInZipFile(file, currentPath);
		}

	}

	protected static void findInFolder(File folder, String currentPath) 
		throws IOException {

		if (_isIgnored(folder)) {
			return;
		}

		String folderName = folder.getName();

		if (containsNeedle(folderName)) {
			print(folder.getPath(), currentPath);
		}

		File[] files = folder.listFiles();

		for (File file : files) {
			if (file.isDirectory()) {
				findInFolder(file, currentPath);
			}
			else {
				findInFile(file, currentPath);
			}
		}
	}

	protected static void findInFolder(String folderPath, String currentPath)
		throws IOException {

		findInFolder(new File(folderPath), currentPath);
	}

	protected static void findInManifestFile(
			File manifestFile, String currentPath)
		throws IOException {

		String content = FileUtil.read(manifestFile);

		if (containsNeedle(content)) {
			print(manifestFile.getPath(), currentPath);
		}
	}

	protected static void findInZipFile(File haystack, String currentPath)
		throws IOException {

		ZipFile zipFile = new ZipFile(haystack);

		findInZipFile(zipFile, currentPath);

		zipFile.close();
	}

	protected static void findInZipFile(ZipFile zipFile, String currentPath)
		throws IOException {

		String tmpFolder = _getTmpFolder();

		zipFile.extractAll(tmpFolder);

		findInFolder(
			tmpFolder,
			currentPath + "/" + _removeTmpFolder(zipFile.getFile().getPath()));

		FileUtil.delete(tmpFolder);
	}

	protected static void print(String location, String currentPath) {
		location = _normalizePathSeparator(location);

		location = _removeTmpFolder(location);

		String completeLocation = currentPath + "/" + location;

		System.out.println(completeLocation);
	}

	private static String _getTmpFolder() {
		Random random = new Random();

		return PropsValues.TMP_FOLDER + _TMP_FOLDER_PREFIX + random.nextInt();
	}

	private static boolean _isIgnored(File file) {
		String path = file.getPath();

		path = _normalizePathSeparator(path);

		path = _removeRootFolder(path);

		path = _removeTmpFolder(path);

		if (!path.startsWith("/")) {
			path = "/" + path;
		}

		for (String ignoredPath : PropsValues.IGNORED_PATHS) {
			if (ignoredPath.startsWith("/") && path.startsWith(ignoredPath)) {
				return true;
			}

			if (!ignoredPath.startsWith("/") &&
				(path.indexOf(ignoredPath) >= 0)) {

				return true;
			}
		}

		return false;
	}

	private static boolean _isTextFile(File file) {
		String name = file.getName();

		if (ArrayUtil.contains(name, PropsValues.TEXT_FILES)) {
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

	private static String _normalizePathSeparator(String path) {
		return path.replace('\\', '/');
	}

	private static String _removePathPrefix(String path, String prefix) {
		path = _normalizePathSeparator(path);

		if (!path.startsWith(prefix)) {
			return path;
		}

		int x = path.indexOf("/", prefix.length());

		if (x < 0) {
			return "";
		}

		return path.substring(x + 1);
	}

	private static String _removeRootFolder(String path) {
		return _removePathPrefix(path, haystack);
	}

	private static String _removeTmpFolder(String path) {
		String prefix = PropsValues.TMP_FOLDER + _TMP_FOLDER_PREFIX;

		return _removePathPrefix(path, prefix);
	}

	protected static String haystack = null;
	protected static String needle = null;

	private static String _TMP_FOLDER_PREFIX = "/tmp";

}