package com.scp.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadWriteFromExcel {

	public static void main(String[] args) {
		readtestdata();
	}

	public static Object[][] readtestdata() {
		Object[][] testdata = new Object[4][3];
		int rowCount = 0;
		int cellCount = 0;
		XSSFWorkbook workbook = null;
		try {
			File file = new File("D:\\usertest.xlsx");

			// Create an object of FileInputStream class to read excel file

			FileInputStream inputStream = new FileInputStream(file);
			workbook = new XSSFWorkbook(inputStream);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			XSSFSheet sheet = workbook.getSheet("UserCredetials");
			Iterator<Row> rows = sheet.iterator();
			boolean flag = true;
			while (rows.hasNext()) {
				Row singleRow = rows.next();
				if (flag) {
					flag = false;
					continue;
				}
				System.out.println("\n");
				Iterator<Cell> cell = singleRow.iterator();
				while (cell.hasNext()) {
					Cell singleCell = (Cell) cell.next();
					if (singleCell.getCellType() == 0) {
						// System.out.print(singleCell.getNumericCellValue() + "|");
					} else if (singleCell.getCellType() == 1) {
						System.out.print(singleCell.getStringCellValue() + "|");
						String cellValue = singleCell.getStringCellValue().equals("NA") ? null
								: singleCell.getStringCellValue();

						// if("S.No".equals(cellValue))
						// continue;

						testdata[rowCount][cellCount] = cellValue;
						cellCount++;
						// System.out.print(cellValue + " | ");
					} else {
						// System.out.println("Invalid cell type -- " + singleCell.getCellType());
					}

				}
				rowCount++;
				cellCount = 0;
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
		return testdata;

	}

}
