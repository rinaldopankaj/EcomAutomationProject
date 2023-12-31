package com.mystore.utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
public class ExcelUtility {
	private static final String FILE_PATH = System.getProperty("user.dir")+"\\TestData\\SeleniumEcomCred.xlsx";

    public static Object[][] readExcelData(String sheetName) {
        Object[][] data = null;
        try (FileInputStream fis = new FileInputStream(FILE_PATH);
             Workbook workbook = WorkbookFactory.create(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);
            int rowCount = sheet.getPhysicalNumberOfRows();
            int colCount = sheet.getRow(0).getPhysicalNumberOfCells();

            data = new Object[rowCount - 1][colCount];

            for (int i = 1; i < rowCount; i++) {
                Row row = sheet.getRow(i);
                for (int j = 0; j < colCount; j++) {
                    data[i - 1][j] = row.getCell(j).toString();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }
}
