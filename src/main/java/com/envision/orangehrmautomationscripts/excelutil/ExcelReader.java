package com.envision.orangehrmautomationscripts.excelutil;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;

public class ExcelReader {
    private static Sheet sheet = null;

    static {
        try (FileInputStream fis = new FileInputStream("orangehrm_testdata/orangehrm_testcase_data.xlsx")) {
            Workbook wb = WorkbookFactory.create(fis);
            ExcelReader.sheet = wb.getSheet("Sheet1");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @DataProvider(name = "orangehrm_testcase_data")
    public static Iterator<String[]> getTestCaseData(Method method) {
        int rowsCount = ExcelReader.sheet.getPhysicalNumberOfRows();

        ArrayList<String[]> allRowsData = new ArrayList<>();
        for (int rowIndex = 1; rowIndex < rowsCount; rowIndex++) {
            Row row = ExcelReader.sheet.getRow(rowIndex);
            int cellsCount = row.getPhysicalNumberOfCells();

            String testCaseName = row.getCell(1).getStringCellValue();
            String runStatus = row.getCell(2).getStringCellValue();

            if (runStatus.equalsIgnoreCase("y") && testCaseName.equalsIgnoreCase(method.getName())) {
                ArrayList<String> eachRowAllCells = new ArrayList<>();
                for (int cellDataIndex = 3; cellDataIndex < cellsCount; cellDataIndex++) {
                    String data = row.getCell(cellDataIndex).getStringCellValue();
                    eachRowAllCells.add(data);
                }
                allRowsData.add(eachRowAllCells.toArray(new String[]{}));
            }
        }
        return allRowsData.iterator();
    }
}
