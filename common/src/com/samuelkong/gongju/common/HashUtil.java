package com.samuelkong.gongju.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.IOException;

import java.math.BigInteger;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashUtil {

	public static String MD5 = "MD5";

	public static String SHA1 = "SHA-1";

	public static String hash(String message, String algorithm)
		throws NoSuchAlgorithmException {

		MessageDigest messageDigest = MessageDigest.getInstance(algorithm);

		messageDigest.update(message.getBytes());

		return messageDigestToString(messageDigest);
	}

	public static String hashFile(File file, String algorithm)
		throws FileNotFoundException, IOException, NoSuchAlgorithmException {

		MessageDigest messageDigest = MessageDigest.getInstance(algorithm);

		InputStream inputStream = new FileInputStream(file);

		byte[] buffer = new byte[8192];

		int read = 0;

		try {
			while ((read = inputStream.read(buffer)) > 0) {
				messageDigest.update(buffer, 0, read);
			}
		}
		finally {
			inputStream.close();
		}

		return messageDigestToString(messageDigest);
	}

	public static String hashFile(String filename, String algorithm)
		throws FileNotFoundException, IOException, NoSuchAlgorithmException {

		File file = new File(filename);

		return hashFile(file, algorithm);
	}

	protected static String messageDigestToString(MessageDigest messageDigest) {
		BigInteger intHash = new BigInteger(1, messageDigest.digest());

		String hash = intHash.toString(16);

		return normalizeHash(hash, messageDigest.getAlgorithm());
	}

	protected static int hashLength(String algorithm) {
		if (algorithm.equals(MD5)) {
			return 32;
		}
		else if (algorithm.equals(SHA1)) {
			return 40;
		}

		return -1;
	}

	protected static String normalizeHash(String hash, String algorithm) {
		int hashLength = hashLength(algorithm);

		while (hash.length() < hashLength) {
			hash = "0" + hash;
		}

		return hash.toUpperCase();
	}

}