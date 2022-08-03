package com.samuelkong.gongju.pwned.passwords.model;

import com.samuelkong.gongju.common.Validator;
import com.samuelkong.gongju.pwned.passwords.util.PropsValues;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;

import java.security.GeneralSecurityException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.poifs.crypt.Decryptor;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.poifs.filesystem.NPOIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Spreadsheet {

	public Spreadsheet(String filename, String sheetName) throws IOException {
		this(filename, null, sheetName);
	}

	public Spreadsheet(String filename, String password, String sheetName)
		throws IOException {

		InputStream is = null;

		try {
			if (Validator.isNull(password)) {
				is = new FileInputStream(filename);
			}
			else {
				NPOIFSFileSystem fileSystem = new NPOIFSFileSystem(
					new File(filename));

				EncryptionInfo encryptionInfo = new EncryptionInfo(fileSystem);

				Decryptor decryptor = Decryptor.getInstance(encryptionInfo);

				if (!decryptor.verifyPassword(password)) {
					System.out.println("ERROR: Incorrect password");
				}

				is = decryptor.getDataStream(fileSystem);
			}

			_workbook = new XSSFWorkbook(is);

			_sheet = _workbook.getSheet(sheetName);
		}
		catch (GeneralSecurityException gse) {
			throw new IOException(gse.getMessage(), gse);
		}
		finally {
			if (is != null) {
				is.close();
			}
		}
	}

	public List<AuthInfo> getAuthInfos(
		String passwordColumn, String siteColumn, String oldColumn) {

		int passwordColumnIndex = CellReference.convertColStringToIndex(
			passwordColumn.toUpperCase());
		int siteColumnIndex = CellReference.convertColStringToIndex(
			siteColumn.toUpperCase());
		int oldColumnIndex = CellReference.convertColStringToIndex(
			oldColumn.toUpperCase());

		return getAuthInfos(
			passwordColumnIndex, siteColumnIndex, oldColumnIndex);
	}

	public List<AuthInfo> getAuthInfos(
		int passwordColumn, int siteColumn, int oldColumn) {

		List<AuthInfo> authInfos = new ArrayList<AuthInfo>();

		Iterator<Row> rowIterator = _sheet.rowIterator();

		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();

			if ((row.getRowNum() == 0) && PropsValues.SHEET_HEADER_ROW) {
				continue;
			}

			Cell passwordCell = row.getCell(passwordColumn);

			if (passwordCell == null) {
				continue;
			}

			String password = passwordCell.getStringCellValue();

			password = password.trim();

			if (password.equals("")) {
				continue;
			}

			AuthInfo authInfo = new AuthInfo(password);

			if (siteColumn >= 0) {
				Cell siteCell = row.getCell(siteColumn);

				authInfo.setSite(siteCell.getStringCellValue());
			}

			if (oldColumn >= 0) {
				Cell oldCell = row.getCell(oldColumn);

				if (oldCell != null) {
					authInfo.setOld(oldCell.getBooleanCellValue());
				}
			}

			authInfos.add(authInfo);
		}

		return authInfos;
	}

	public XSSFSheet getSheet() {
		return _sheet;
	}

	private XSSFSheet _sheet;
	private XSSFWorkbook _workbook;

}