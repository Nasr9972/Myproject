package Com.FreeCRM.TestCases;

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

public class HomePageTest extends TestBase {

	ElementsLoginPage login ;
	ElementsHomePage LogfromHome;

	public HomePageTest() throws IOException {
		super();

	}

	@Parameters({"browser"})
	@BeforeMethod  
	public void PreConditionSetup (String browser ,Method method) throws ATUTestRecorderException, IOException {

		Record = new ATUTestRecorder("C:\\Users\\M.Nasr\\eclipse-workspace\\FreeCrm.Project\\Vedios",method.getName(), true);
		Record.start();
		Setup(browser);
		login = new ElementsLoginPage();
		LogfromHome=login.LoginBox();
	}

	@AfterMethod    
	public void AfterTest(Method method) throws ATUTestRecorderException, Exception{

		TestUtils.TakesScreenShoots(method.getName());
		Driver.quit();
		Record.stop();

	}


	@Test(priority = 5)
	public void ClickOnContactsTest () throws IOException {

		//ActualResault Is Always Search in the Website 
		//ExpectedResault Is Always get data throw selenium from the website
		LogfromHome.ClickonContact();
		boolean Exp =true;
		boolean Act = LogfromHome.LableNewContactsIsDisplayed();
		System.out.println(Act);
		Assert.assertEquals(Exp, Act);

	}
	@Test(priority = 6) 
	public void TaskesButton () {

		LogfromHome.ClickonTasksButton();
		
		boolean Exp =true;
		boolean Act = LogfromHome.LableTextTaskIsDisplayed();
		System.out.println(Act);
		Assert.assertEquals(Exp, Act);


	}
	@Test(priority = 7)
	public void EmailButton ()  {

		LogfromHome.ClickonEmailButton();
		boolean Exp =true;
		boolean Act = LogfromHome.TextInboxLableIsDisplayed();
		System.out.println(Act);
		Assert.assertEquals(Exp, Act);


	}

	@Test(priority = 8)
	public void LogOut () throws IOException {

		LogfromHome.LogoutButton();
		String Exp ="input";
		String Actual = LogfromHome.GetTagname();
		System.out.println(Actual);
		Assert.assertEquals(Exp, Actual);


	}

}
