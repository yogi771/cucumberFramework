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
	    public ExcelHandler(String filePath, String sheetName) throws IOException {
	        FileInputStream fileInputStream = new FileInputStream(filePath);
	        workbook = new XSSFWorkbook(fileInputStream);
	        sheet = workbook.getSheet(sheetName);
	    }

	    // Method to get cell data as String
	    public String getCellData(int rowNum, int colNum) {
	        Row row = sheet.getRow(rowNum);
	        Cell cell = row.getCell(colNum);
	        return cell.toString();
	    }

	    // Method to write data to a cell
	    public void setCellData(int rowNum, int colNum, String data) throws IOException {
	        Row row = sheet.getRow(rowNum);
	        if (row == null) {
	            row = sheet.createRow(rowNum);
	        }
	        Cell cell = row.getCell(colNum);
	        if (cell == null) {
	            cell = row.createCell(colNum);
	        }
	        cell.setCellValue(data);

	        // Write to the Excel file
	        FileOutputStream fileOutputStream = new FileOutputStream("path_to_excel_file.xlsx");
	        workbook.write(fileOutputStream);
	        fileOutputStream.close();
	    }

	    // Method to close the workbook
	    public void closeWorkbook() throws IOException {
	        workbook.close();
	    }
	}
	

