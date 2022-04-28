package com.samuelkong.gongju.hash;

import com.samuelkong.gongju.common.FileUtil;
import com.samuelkong.gongju.common.Validator;
import com.samuelkong.gongju.hash.model.FileHash;
import com.samuelkong.gongju.hash.util.PropsValues;

import java.io.File;

import java.util.ArrayList;
import java.util.List;

public class Hasher {

	public static void main(String[] args) throws Exception {
		String input = null;

		if ((args.length > 0) && !Validator.isNull(args[0])) {
			input = args[0];
		}
		else {
			input = PropsValues.INPUT;
		}

		if (Validator.isNull(input)) {
			System.out.println("ERROR: Nothing to hash");

			return;
		}

		run(input);
	}

	public static void run(String input) throws Exception {
		run(new File(input));
	}

	public static void run(File input) throws Exception {
		List<FileHash> fileHashes = new ArrayList<>();

		addFileHash(input, fileHashes);

		print(fileHashes);

		save(fileHashes);
	}

	protected static void addFileHash(File file, List<FileHash> fileHashes) {
		if (!file.isDirectory()) {
			fileHashes.add(new FileHash(file));

			return;
		}

		File[] files = file.listFiles();

		for (File curFile : files) {
			addFileHash(curFile, fileHashes);
		}
	}

	protected static void print(List<FileHash> fileHashes) throws Exception {
		for (FileHash fileHash : fileHashes) {
			System.out.println("File: " + fileHash.getFile().getName());
			System.out.println("MD5:  " + fileHash.getMD5());
			System.out.println("SHA1: " + fileHash.getSHA1());
			System.out.println();
		}

		System.out.println("Result saved to " + PropsValues.OUTPUT_FILE);
	}

	protected static void save(List<FileHash> fileHashes) throws Exception {
		StringBuilder sb = new StringBuilder();

		sb.append("FILE\tMD5\tSHA1\r\n");

		for (FileHash fileHash : fileHashes) {
			sb.append(fileHash.getFile().getName());
			sb.append("\t");
			sb.append(fileHash.getMD5());
			sb.append("\t");
			sb.append(fileHash.getSHA1());
			sb.append("\r\n");
		}

		FileUtil.write(sb.toString(), PropsValues.OUTPUT_FILE);
	}

}