package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver ldriver;

	public LoginPage(WebDriver driver) {
		this.ldriver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "Email")
	@CacheLookup
	WebElement mailtxt;

	@FindBy(id = "Password")
	@CacheLookup
	WebElement passtxt;

	@FindBy(xpath = "//button[text()='Log in']")
	@CacheLookup
	WebElement loginbutton;

	@FindBy(xpath = "//a[text()='Logout']")
	@CacheLookup
	WebElement logoutbutton;

	public void setuserName(String uname) {
		mailtxt.clear();
		mailtxt.sendKeys(uname);
	}

	public void setpassword(String pass) {
        passtxt.clear();
		passtxt.sendKeys(pass);

	}
	
	public void login() {
		loginbutton.click();
	}
	public void logout() {
		logoutbutton.click();
	}

}