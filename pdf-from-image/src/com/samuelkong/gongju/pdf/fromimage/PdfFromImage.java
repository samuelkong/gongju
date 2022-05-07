package com.samuelkong.gongju.pdf.fromimage;

import com.samuelkong.gongju.common.Validator;
import com.samuelkong.gongju.pdf.fromimage.util.PropsValues;

import java.io.File;
import java.io.FileInputStream;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.edit.PDPageContentStream;
import org.apache.pdfbox.pdmodel.graphics.xobject.PDJpeg;
import org.apache.pdfbox.pdmodel.graphics.xobject.PDXObjectImage;


public class PdfFromImage {

	public static void main(String[] args) throws Exception {
		String input = null;

		if ((args.length > 0) && !Validator.isNull(args[0])) {
			input = args[0];
		}
		else {
			input = PropsValues.INPUT;
		}

		if (Validator.isNull(input)) {
			System.out.println("ERROR: Nothing to convert");

			return;
		}

		run(input);
	}

	public static void run(String input) throws Exception {
		run(new File(input));
	}

	public static void run(File input) throws Exception {
		PDDocument document = new PDDocument();

		if (input.isFile()) {
			addImageToPdf(document, input);
		}
		else if (input.isDirectory()){
			for (File imageFile : input.listFiles()) {
				addImageToPdf(document, imageFile);
			}

		}

		document.save(PropsValues.OUTPUT_FILE);

		document.close();

		System.out.println("Result saved to " + PropsValues.OUTPUT_FILE);
	}

	protected static PDRectangle getPageSize() {
		if (PropsValues.PAGE_SIZE.equals("A4")) {
			return PDPage.PAGE_SIZE_A4;
		}

		return PDPage.PAGE_SIZE_LETTER;
	}

	protected static PDPage addImageToPdf(
			PDDocument document, File imageFile)
		throws Exception {

		PDPage page = new PDPage(getPageSize());

		document.addPage(page);

		PDXObjectImage image = new PDJpeg(
			document, new FileInputStream(imageFile));

		PDRectangle pageDimension = page.getArtBox();

		PDPageContentStream contentStream = new PDPageContentStream(
			document, page);

		contentStream.drawXObject(
			image, 0, 0, pageDimension.getWidth(), pageDimension.getHeight());

		contentStream.close();

		return page;
	}

}