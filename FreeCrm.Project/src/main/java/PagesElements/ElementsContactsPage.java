package PagesElements;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Freecrm.Base.TestBase;

public class ElementsContactsPage extends TestBase {

	public ElementsContactsPage() throws IOException {
		PageFactory.initElements(Driver, this);
		
		
	}
	
	@FindBy (xpath="//input[@name='first_name']")
	WebElement FirstName;

	@FindBy (xpath="//input[@name='last_name']")
	WebElement LastName;

	@FindBy (xpath="//div[@name='company']//input[@class='search']")
	WebElement Company ;

	@FindBy (xpath="//input[@placeholder='Email address']")
	WebElement Email;

	@FindBy (xpath="//textarea[@name='description'")
	WebElement Description;

	@FindBy (xpath="//button[@class='ui linkedin button']")
	WebElement SaveButton;

	public void AddNewContact(String Fname,String Lname,String Cname,String Emailname,String DesName) {
		
		
		FirstName.sendKeys(Fname);
		LastName.sendKeys(Lname);
		Company.sendKeys(Cname);
		Email.sendKeys(Emailname);
		Description.sendKeys(DesName);
		SaveButton.click();
	
	}
}
