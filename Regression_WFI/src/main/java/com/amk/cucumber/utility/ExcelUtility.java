package com.amk.cucumber.utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.math.BigDecimal;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	private XSSFWorkbook workbook = null;
	private XSSFSheet sheet = null;
	private XSSFRow row = null;
	private XSSFCell cell = null;
	public String path;
	public FileInputStream fis = null;
	public FileOutputStream fileOut = null;

	public ExcelUtility(String path) {

		this.path = path;
		try {
			fis = new FileInputStream(path);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheetAt(0);
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public String getXLValue(String sheetName, String colName, int rowNum) {
		try {
			// If the row number provided is <=0 it should return blank
			if (rowNum <= 0)
				return "";
			// Validate if the Sheet Exists or Not
			if (isSheetExist(sheetName)) {
				int index = workbook.getSheetIndex(sheetName);
				int col_Num = -1;
				if (index == -1)
					return "";
				// Get the index of the sheet based on the sheetName
				sheet = workbook.getSheetAt(index);
				// Get the Column no based on the Column Name
				row = sheet.getRow(0);
				for (int i = 0; i < row.getLastCellNum(); i++) {
					if (row.getCell(i).getStringCellValue().trim().equals(colName.trim()))
						col_Num = i;
				}
				// If column No returns -1 then return nothing
				if (col_Num == -1)
					return "";

				sheet = workbook.getSheetAt(index);
				row = sheet.getRow(rowNum - 1);
				if (row == null)
					return "";
				cell = row.getCell(col_Num);

				if (cell == null)
					return "";
				// Get the value of the Cell if it is a string so it should read
				// string format
				if (cell.getCellType() == CellType.STRING)
					return cell.getStringCellValue();

				else if (cell.getCellType() == CellType.FORMULA) {
					XSSFFormulaEvaluator.evaluateAllFormulaCells(workbook);
					String value = cell.getCellFormula();
					switch (cell.getCachedFormulaResultType()) {
					case NUMERIC:
						value = String.valueOf(cell.getNumericCellValue());
						/*
						 * Double e1Val = cell.getNumericCellValue(); BigDecimal bd = new
						 * BigDecimal(e1Val.toString()); long lonVal = bd.longValue();
						 */
						// System.out.println(lonVal);
						break;
					case STRING:
						value = String.valueOf(cell.getRichStringCellValue());
						break;
					}
					return value;
				}

				else if (cell.getCellType() == CellType.NUMERIC) {
					String value = String.valueOf(cell.getNumericCellValue());
					System.out.println("Before conv : : " + value);
					Double doubleValue = cell.getNumericCellValue();
					BigDecimal bd = new BigDecimal(doubleValue.toString());
					long lonVal = bd.longValue();
					value = Long.toString(lonVal).trim();
					System.out.println("After conv : : " + value);

					return value;
				}

				// Get the value of the Cell if it is a string so it should
				// return blank format
				else if (cell.getCellType() == CellType.BLANK)
					return "";
				else
					// Return a Boolean value
					return String.valueOf(cell.getBooleanCellValue());
			}
			// If the sheet does not exist then return Sheet is not present
			return "The Sheet Name: " + sheetName + " does not exist in xls";
		} catch (Exception e) {
			e.printStackTrace();
			return "The Row: " + rowNum + " or the Column Name: " + colName + " does not exist in the .xlsx file";
		}

	}

	public boolean isSheetExist(String sheetName) {
		int index = workbook.getSheetIndex(sheetName);
		if (index == -1) {
			index = workbook.getSheetIndex(sheetName.toUpperCase());
			if (index == -1)
				return false;
			else
				return true;
		} else
			return true;
	}

}
