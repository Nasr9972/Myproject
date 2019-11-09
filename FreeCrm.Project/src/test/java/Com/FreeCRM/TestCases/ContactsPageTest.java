package Com.FreeCRM.TestCases;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import Freecrm.Base.TestBase;
import Freecrm.Utils.TestUtils;
import PagesElements.ElementsContactsPage;
import PagesElements.ElementsHomePage;
import PagesElements.ElementsLoginPage;
import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;

public class ContactsPageTest extends TestBase {

	ElementsLoginPage loginpage ;
	ElementsHomePage  homepage;
	ElementsContactsPage LogFromContacts;

	public ContactsPageTest() throws IOException {
		super();	
	}


	@Parameters({"browser"})
	@BeforeMethod
	public void Beforetest (String browser, Method method) throws ATUTestRecorderException, IOException {
		Setup(browser);
		loginpage = new ElementsLoginPage();
		homepage = loginpage.LoginBox();
		Record = new ATUTestRecorder("C:\\Users\\M.Nasr\\eclipse-workspace\\FreeCrm.Project\\Vedios",method.getName(), true);
		Record.start();
		
	}


	@Test(dataProvider="TestData")
	public void ContactsData (String Fname,String Lname,String Cname,String Emailname,String DesName) throws IOException, InterruptedException {
		
		LogFromContacts = homepage.ClickonContact2();
		LogFromContacts.AddNewContact(Fname, Lname, Cname, Emailname, DesName);
		Thread.sleep(3000);
	}

	@AfterMethod
	public void AfterTest(Method method) throws ATUTestRecorderException, IOException {

		TestUtils.TakesScreenShoots(method.getName());
		Driver.quit();
		Record.stop();
	}


	@DataProvider
	public Object[][] TestData () throws Throwable  {

		Object data [][] = TestUtils.GetDataFromExcel("ContactsData");

		return data;
	}

}
