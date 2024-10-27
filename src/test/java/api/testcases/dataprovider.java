package api.testcases;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import api.utilities.excelutility;

public class dataprovider {

	@DataProvider(name="testlogindata")
	public static String[][] dataparsing() throws IOException{
		String filepath="C:\\SeleniumEclipse\\RestAssuredFramework\\TestData\\dataprovider_exceldata.xlsx";
		return excelutility.readexcel(filepath);
		
	}
	
}
