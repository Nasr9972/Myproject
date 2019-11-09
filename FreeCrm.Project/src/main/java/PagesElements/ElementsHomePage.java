package PagesElements;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Freecrm.Base.TestBase;

public class ElementsHomePage extends TestBase {
	public ElementsHomePage() throws IOException {
		PageFactory.initElements(Driver, this);
	}

	@FindBy (linkText="Contacts")
	WebElement contacts ;

	@FindBy(xpath="//div[@class='ui header item mb5 light-black']")
	WebElement NewContactsLable;

	@FindBy (xpath= "//button[contains(text(),'New')]")
	WebElement NewContactsButton ;

	@FindBy (xpath="//div[@class='ui header item mb5 light-black']")
	WebElement Contact;

	@FindBy (xpath="//span[contains(text(),'Tasks')]")
	WebElement TasksButton ;

	@FindBy (xpath="//div[@class='ui header item mb5 light-black']")
	WebElement TextTask;

	@FindBy (xpath="//span[@class='item-text'][contains(text(),'Email')]")
	WebElement EmailButton ;

	@FindBy (xpath="//div[@class='ui header item mb5 light-black']")
	WebElement TextInbox ;

	@FindBy (xpath="//div[@class='ui basic button floating item dropdown']")
	WebElement SettingButton ;

	@FindBy (linkText="Log Out")
	WebElement LogoutButton ;

	@FindBy (xpath="//a[contains(text(),'Forgot your password?')]")
	WebElement ForgetPassword;

	@FindBy (xpath= "input")
	WebElement PassBoxTagName;


	public void ClickonContact() {
		contacts.click();

	}
	
	public ElementsContactsPage ClickonContact2() {
		contacts.click();
		return null;

	}
	public boolean LableNewContactsIsDisplayed() {

		boolean Lable = NewContactsLable.isDisplayed();
		return Lable;

	}
	
	
	public void ClickonTasksButton() {
		TasksButton.click();
		
	
	}
	
	public boolean LableTextTaskIsDisplayed() {

		boolean Lable = TextTask.isDisplayed();
		return Lable;

	}
	
	
	public void ClickonEmailButton() {
		EmailButton.click();
		

	}
	

	public boolean TextInboxLableIsDisplayed() {

		boolean TextInboxIsDisplayed = TextInbox.isDisplayed();
		return TextInboxIsDisplayed ;	

	}

	public ElementsLoginPage LogoutButton() throws IOException {

		SettingButton.click();
		LogoutButton.click();
		return new ElementsLoginPage(); 

	}


	public String GetTagname() {
		String TagName = PassBoxTagName.getTagName();
		return TagName;

	}
}
