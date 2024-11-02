package com.samuelkong.gongju.pdf.combine;

import com.samuelkong.gongju.common.Validator;
import com.samuelkong.gongju.pdf.combine.util.PropsValues;

import java.io.File;
import java.io.IOException;

import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

public class PdfCombine {

	public static void main(String[] args) throws Exception {
		String input = null;

		if ((args.length > 0) && !Validator.isNull(args[0])) {
			input = args[0];
		}
		else {
			input = PropsValues.INPUT;
		}

		if (Validator.isNull(input)) {
			System.out.println("ERROR: Nothing to combine");

			return;
		}

		run(input);
	}

	public static void run(File folder) throws Exception {
		PDDocument document = combine(folder);

		document.save(PropsValues.OUTPUT_FILE);

		document.close();

		System.out.println("Combined PDF saved to " + PropsValues.OUTPUT_FILE);
	}

	public static void run(String folderPath) throws Exception {
		run(new File(folderPath));
	}

	protected static PDDocument combine(File folder) throws IOException {
		PDDocument combinedDocument = new PDDocument();

		for (File file : folder.listFiles()) {
			PDDocument document = PDDocument.load(file);

			List<?> pages = document.getDocumentCatalog().getAllPages();

			for (Object obj : pages) {
				PDPage page = (PDPage)obj;

				combinedDocument.addPage(page);
			}

			document.close();
		}

		return combinedDocument;
	}

}