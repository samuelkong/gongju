package com.samuelkong.gongju.pdf.insert;

import com.samuelkong.gongju.pdf.insert.util.PropsValues;

import java.io.IOException;

import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

public class PdfInsert {

	public static final int MODE_INSERT = 1;

	public static final int MODE_REPLACE = 2;

	public static void main(String[] args) throws Exception {
		int mode = MODE_INSERT;

		if ((args.length >= 1) && args[0].equals("--replace")) {
			mode = MODE_REPLACE;
		}

		run(
			PropsValues.SOURCE, PropsValues.INSERT, PropsValues.OFFSET,
			PropsValues.OUTPUT, mode);
	}

	public static void run(
			String source, String insert, int offset, String output, int mode)
		throws Exception {

		PDDocument sourcePdf = PDDocument.load(source);
		PDDocument insertPdf = PDDocument.load(insert);

		PDDocument newDocument = null;

		if (mode == MODE_REPLACE) {
			newDocument = replace(sourcePdf, insertPdf, offset);
		}
		else {
			newDocument = insert(sourcePdf, insertPdf, offset);
		}

		newDocument.save(output);

		sourcePdf.close();
		insertPdf.close();
		newDocument.close();
	}

	protected static PDDocument insert(
			PDDocument source, PDDocument insert, int offset)
		throws IOException {

		PDDocument newDocument = new PDDocument();

		List<?> sourcePages = source.getDocumentCatalog().getAllPages();
		List<?> insertPages = insert.getDocumentCatalog().getAllPages();

		for (int i = 0; i < sourcePages.size(); i++) {
			if (i == offset) {
				for (Object obj : insertPages) {
					newDocument.addPage((PDPage)obj);
				}
			}

			newDocument.addPage((PDPage)sourcePages.get(i));
		}

		if (offset >= sourcePages.size()) {
			for (Object obj : insertPages) {
				newDocument.addPage((PDPage)obj);
			}
		}

		return newDocument;
	}

	protected static PDDocument remove(
			PDDocument document, int offset, int length)
		throws IOException {

		PDDocument newDocument = new PDDocument();

		List<?> pages = document.getDocumentCatalog().getAllPages();

		for (int i = 0; i < pages.size(); i++) {
			if (i == offset) {
				i = i + length;
			}

			if (i >= pages.size()) {
				break;
			}

			newDocument.addPage((PDPage)pages.get(i));
		}

		return newDocument;
	}

	protected static PDDocument replace(
			PDDocument source, PDDocument insert, int offset)
		throws IOException {

		PDDocument tmpDocument = remove(
			source, offset, insert.getNumberOfPages());

		PDDocument newDocument = insert(tmpDocument, insert, offset);

		tmpDocument.close();

		return newDocument;
	}

}