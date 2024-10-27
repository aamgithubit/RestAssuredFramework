package api.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

	public class excelutility {

	    public static String[][] readexcel(String filePath) throws IOException {
	        File file = new File(filePath);
	        FileInputStream fis = new FileInputStream(file);

	        XSSFWorkbook workbook = new XSSFWorkbook(fis);
	        XSSFSheet sheet = workbook.getSheet("sheet1");

	        int rowCount = sheet.getPhysicalNumberOfRows() - 1; // Subtract header row
	        int cellCount = sheet.getRow(0).getPhysicalNumberOfCells();

	        String[][] data = new String[rowCount][cellCount];

	        for (int i = 1; i <= rowCount; i++) { // Start from 1 to skip header
	            Row row = sheet.getRow(i);
	            for (int j = 0; j < cellCount; j++) {
	                data[i - 1][j] = row.getCell(j).toString(); // Store cell value
	            }
	        }

	        workbook.close();
	        return data; // Return the data array
	    }
	}

/*
	@Test
	public static String[][] readexcel(String filepath) throws IOException {
		File file= new File("C:\\SeleniumEclipse\\RestAssuredFramework\\TestData\\exceldata.xlsx");
		FileInputStream fis= new FileInputStream(file);

		XSSFWorkbook wkbk= new XSSFWorkbook(fis);
		XSSFSheet  sheet= wkbk.getSheet("sheet1");

		int row= sheet.getPhysicalNumberOfRows();
		// without header row

		int rowcount=sheet.getLastRowNum()-sheet.getFirstRowNum();
		System.out.println("rowcountis:::"  + rowcount );

		int cellcount= sheet.getRow(0).getPhysicalNumberOfCells();
		System.out.println(row +".............."+ cellcount+ "///////////" +rowcount);

		String[][] data = new String[rowcount - 1][cellcount];
		for (int i = 1; i < rowcount; i++) { // Start from 1 to skip header
			Row row1 = sheet.getRow(i);
			for (int j = 0; j < cellcount; j++) {
				data[i - 1][j] = row1.getCell(j).toString(); // Store cell value
			}
		}
		wkbk.close();
		return data; // Return the data array
	}

	
		//iterate or printing all data from excel
		for(int i=0;i<=rowcount;i++) {			
			System.out.println("Row  "+ i+" data is :");

			for(int j=0;j<cellcount;j++) {
				System.out.println(sheet.getRow(i).getCell(j).getStringCellValue()+ ",");
			}
			System.out.println();

		}

	 */



