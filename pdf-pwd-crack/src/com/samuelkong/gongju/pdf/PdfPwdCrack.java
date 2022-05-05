package com.samuelkong.gongju.pdf;

import com.samuelkong.gongju.common.Validator;
import com.samuelkong.gongju.pdf.util.PropsValues;

import java.io.IOException;

import org.apache.pdfbox.exceptions.CryptographyException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.StandardDecryptionMaterial;

public class PdfPwdCrack {

	public static void main(String[] args) throws Exception {
		String input = null;

		if ((args.length > 0) && !Validator.isNull(args[0])) {
			input = args[0];
		}
		else {
			input = PropsValues.INPUT;
		}

		if (Validator.isNull(input)) {
			System.out.println("ERROR: Nothing to crack");

			return;
		}

		run(input);
	}

	public static void run(String pdfPath) throws Exception {
		PDDocument pdfDocument = PDDocument.load(pdfPath);

		boolean isEncrypted = pdfDocument.isEncrypted();

		if (!isEncrypted) {
			System.out.println("File not encrypted");

			return;
		}

		String password = getPassword(pdfDocument);

		System.out.println("Password: " + password);
	}

	protected static String getPassword(PDDocument pdfDocument)
		throws Exception {

		for (int i = 125000; i <= 999999; i++) {
			String password = PropsValues.KNOWN_PASSWORD_PREFIX + 
				String.format("%06d", i) + PropsValues.KNOWN_PASSWORD_SUFFIX;

			if (isPassword(pdfDocument, password)) {
				return password;
			}
		}

		return "Unable to determine password";
	}

	protected static boolean isPassword(
			PDDocument pdfDocument, String password)
		throws Exception {

		StandardDecryptionMaterial sdm = new StandardDecryptionMaterial(
			password);

		try {
			pdfDocument.openProtection(sdm);
		}
		catch (CryptographyException ce) {
			return false;
		}
		catch (IOException ioe) {
			return true;
		}

		return false;
	}

}