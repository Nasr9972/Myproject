package Freecrm.Utils;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import Freecrm.Base.TestBase;

public class TestUtils extends TestBase {

	public TestUtils() throws IOException {
		super();

	}


	public static void TakesScreenShoots(String name) throws IOException {

		File srcfile = ((TakesScreenshot)Driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcfile, new File("C:\\Users\\M.Nasr\\eclipse-workspace\\FreeCrm.Project\\ScreenShoots\\"+name+".png"));

	}


	public static Object[][] GetDataFromExcel(String SheetName) throws Throwable {

		File file = new File ("C:\\Users\\M.Nasr\\eclipse-workspace\\FreeCrm.Project\\TestData\\Data.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		Sheet sheet = workbook.getSheet(SheetName);

		int countrow=sheet.getLastRowNum();
		int contcolums = sheet.getRow(0).getLastCellNum();

		Object data[][]= new Object[countrow][contcolums];

		for(int i=0 ; i<countrow ; i++) {
			for(int k = 0 ; k < contcolums ; k++) {
				data[i][k] = sheet.getRow(i).getCell(k).toString();
				workbook.close();
			}
		}
		return data;

	}

}



