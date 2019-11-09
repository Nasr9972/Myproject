package Freecrm.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.asserts.SoftAssert;

import Freecrm.Utils.WebListeners;
import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static Properties prob;
	public static WebDriver Driver;
	public static SoftAssert softassert;
	public static EventFiringWebDriver E_Driver ; // WebDriverEventListener
	public static WebListeners Weblistener ;      // New object from WebListener Which created by me
	public static ATUTestRecorder Record;
	public static File file ;
	public static FileInputStream fis;
	public static XSSFWorkbook workbook ;
	public static Sheet sheet ;




	// Constractor>>> this Method the first Excute when you call a new object from public class   TestBase base  = new TestBase ();
	public TestBase() throws IOException {
		prob = new Properties();
		FileInputStream File = new FileInputStream("C:\\Users\\M.Nasr\\eclipse-workspace\\FreeCrm.Project\\src\\main\\java\\Freecrm\\config\\Config.properties");
		prob.load(File);

	}

	public static void Setup (String browser) throws ATUTestRecorderException {

		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			Driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			Driver = new FirefoxDriver(); 

		}

		Record = new ATUTestRecorder("C:\\Users\\M.Nasr\\eclipse-workspace\\FreeCrm.Project\\Vedios","FreeCrm", true);
		E_Driver = new EventFiringWebDriver(Driver);
		Weblistener = new WebListeners();
		E_Driver.register(Weblistener);
		Driver=E_Driver;
		Driver.manage().window().maximize();
		Driver.get(prob.getProperty("URL"));
		Driver.manage().deleteAllCookies();
		Driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	

	

}


