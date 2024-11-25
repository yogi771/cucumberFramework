package utilities;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelHandler {
 
    private Workbook workbook;
    private Sheet sheet;

    // Constructor to load Excel file and sheet
    public ExcelHandler(String filePath, String sheetName) {
        try (FileInputStream fis = new FileInputStream(filePath)) {
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
                throw new IllegalArgumentException("Sheet " + sheetName + " does not exist in the Excel file");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to get cell data as String
    public String getCellData(int rowNum, int colNum) {
        Row row = sheet.getRow(rowNum);
        Cell cell = (row != null) ? row.getCell(colNum) : null;
        if (cell == null) {
            return "";
        }
        return cell.toString();
    }

    // Method to set cell data
    public void setCellData(String data, int rowNum, int colNum) {
        Row row = sheet.getRow(rowNum);
        if (row == null) {
            row = sheet.createRow(rowNum);
        }
        Cell cell = row.getCell(colNum);
        if (cell == null) {
            cell = row.createCell(colNum);
        }
        cell.setCellValue(data);
    }

    // Method to get the total row count
    public int getRowCount() {
        return sheet.getLastRowNum() + 1;
    }

    // Method to get the total column count in a row
    public int getColumnCount(int rowNum) {
        Row row = sheet.getRow(rowNum);
        return (row != null) ? row.getLastCellNum() : 0;
    }

    // Method to save changes to the Excel file
    public void saveChanges(String filePath) {
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            workbook.write(fos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to close the workbook
    public void close() {
        try {
            if (workbook != null) {
                workbook.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
//testing the pull request
//testing 2nd pull request
    }
}
