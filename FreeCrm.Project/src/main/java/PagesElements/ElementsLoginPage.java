package PagesElements;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Freecrm.Base.TestBase;

public class ElementsLoginPage extends TestBase {

	public ElementsLoginPage() throws IOException {
		PageFactory.initElements(Driver, this);
	}

	@FindBy (xpath="//div[@class='rd-navbar-panel']")
	WebElement Logo ;

	@FindBy (xpath="//a[@class='btn btn-primary btn-xs-2 btn-shadow btn-rect btn-icon btn-icon-left']")
	WebElement LoginButton ;

	@FindBy (name="email")
	WebElement TextBoxEmail ;

	@FindBy (name="password")
	WebElement TextBoxPassword ;

	@FindBy (xpath="//div[@class='ui fluid large blue submit button']")
	WebElement Submit ;




	public String gettittle() {

		String ActualTittle = Driver.getTitle();
		return ActualTittle;
	}

	public boolean LogoisDisplayed() {

		boolean ActualLogo = Logo.isDisplayed();
		return ActualLogo;
	}

	public ElementsHomePage LoginBox() throws IOException {
		LoginButton.click();
		TextBoxEmail.sendKeys(prob.getProperty("UseName"));
		TextBoxPassword.sendKeys(prob.getProperty("Password"));
		Submit.click();
		return new ElementsHomePage();
	}
	public String GetTittle() {

		String ActualTittle = Driver.getTitle();
		return ActualTittle;
	}
	public String GetURL() {

		String ActualURL = Driver.getCurrentUrl();
		return ActualURL;
	}
}