package Com.FreeCRM.TestCases;


import static org.testng.Assert.assertEquals;
import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import Freecrm.Base.TestBase;
import Freecrm.Utils.TestUtils;
import PagesElements.ElementsHomePage;
import PagesElements.ElementsLoginPage;
import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;
import junit.framework.Assert;

public class LoginPageTest extends TestBase{


	
	public LoginPageTest() throws IOException {
		super();  
	}

	ElementsLoginPage loginpage;
	ElementsHomePage logfromhome ; 


	@Parameters({"browser"})
	@BeforeMethod
	public void PreConditionSetup (String browser, Method method) throws ATUTestRecorderException, IOException {

		Setup(browser);
		loginpage = new ElementsLoginPage();
		Record = new ATUTestRecorder("C:\\Users\\M.Nasr\\eclipse-workspace\\FreeCrm.Project\\Vedios",method.getName(), true);
		Record.start();
	}

	@AfterMethod      
	public void AfterTest(Method method) throws ATUTestRecorderException, IOException {
		TestUtils.TakesScreenShoots(method.getName());
		Driver.quit();
		Record.stop();
	}

	@Test(priority = 1)  
	public void TitlePage(Method method) throws IOException {

		String ExpectedResualt = "Free CRM #1 cloud software for any business large or small";
		String ActualResualt = loginpage.gettittle();
		System.out.println(ActualResualt);
		Assert.assertEquals(ExpectedResualt, ActualResualt);

	}

	@Test(priority = 2 )   
	public void LogoTest(Method method) throws IOException {

		boolean ExpectedResault = true;
		boolean ActualResault = loginpage.LogoisDisplayed();
		System.out.println(ActualResault);
		assertEquals(ActualResault, ExpectedResault);

	}


	@Test(priority = 3)   
	public void LoginTest(Method method) throws IOException {
		
		logfromhome = loginpage.LoginBox();
		//Search for Title and get it
		String EXPECTEDTITLE = "Cogmento CRM";
		String	 ACTUALRESUALT = loginpage.GetTittle();
		System.out.println(ACTUALRESUALT);
		Assert.assertEquals(EXPECTEDTITLE, ACTUALRESUALT);

	}
	@Test (priority = 4)
	public void URLcheck(Method method) throws IOException {

		String ExpectedResault = "https://freecrm.com/";
		String ActualResault = loginpage.GetURL();
		System.out.println(ActualResault);
		Assert.assertEquals(ExpectedResault, ActualResault);

	}

}

