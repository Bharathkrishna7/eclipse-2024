package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CustomersPage {

	public WebDriver ldriver;

	public CustomersPage(WebDriver driver) {
		this.ldriver = driver;
		PageFactory.initElements(ldriver, this);
	}

	By Customer_Menu = By.xpath("//i[@class='nav-icon far fa-user']/following-sibling::p");
	By Customermenu_item = By.xpath("//p[text()=' Customers']");
	By Addnew = By.xpath("//i[@class='fas fa-plus-square']/..");
	By email = By.id("Email");
	By password = By.id("Password");
	By firstName = By.id("FirstName");
	By Lastname = By.id("LastName");
	By genderMale = By.xpath("//input[@id='Gender_Male']");
	By genderFemale = By.id("Gender_Female");
	By DateofBirth = By.id("DateOfBirth");
	By CompanyName = By.id("Company");
	By taxExempt = By.id("IsTaxExempt");
	By NewsLetter = By.xpath("//label[text()='Newsletter']/../../following-sibling::div");
	By newsStoreName = By.xpath("//li[text()='Test store 2']");

	By CustomerRole = By.xpath("//label[text()='Customer roles']/../../following-sibling::div");
	By drplistAdmin = By.xpath("//li[text()='Administrators']");
	By drpguest = By.xpath("//li[text()='Guests']");
	By drpregister = By.xpath("//li[text()='Registered']");
	By drpvendors = By.xpath("//li[text()='Vendors']");

	By vendor = By.id("VendorId");
	By Active = By.xpath("//input[@id='Active']");
	By AdminComment = By.xpath("//textarea[@id='AdminComment']");
	By saveButton = By.xpath("//button[@name='save']");

	// Actions methods

	public String getPagetitle() {
		return ldriver.getTitle();
	}

	public void clickonCustMenu() {
		ldriver.findElement(Customer_Menu).click();
	}

	public void clickonCustItem() {

		ldriver.findElement(Customermenu_item).click();
	}

	public void ClickAddNew() {
		ldriver.findElement(Addnew).click();
	}

	public void entermail(String mail) {
		ldriver.findElement(email).sendKeys(mail);
	}

	public void enterPassword(String pass) {
		ldriver.findElement(password).sendKeys(pass);
	}

	public void enterfname(String fname) {
		ldriver.findElement(firstName).sendKeys(fname);
	}

	public void enterLname(String lname) {
		ldriver.findElement(Lastname).sendKeys(lname);
	}

	public void setgender(String gender) {
		if (gender.equals("Male")) {
			ldriver.findElement(genderMale).click();
		} else if (gender.equals("Female")) {
			ldriver.findElement(genderFemale).click();
		} else {
			ldriver.findElement(genderMale).click();// Default
		}
	}

	public void dateofBirth(String dob) {
		ldriver.findElement(DateofBirth).sendKeys(dob);
	}

	public void enterCompanyName(String cname) {
		ldriver.findElement(CompanyName).sendKeys(cname);
	}

	public void taxempt() {
		ldriver.findElement(taxExempt).click();
	}

	public void Newsletter() {
		ldriver.findElement(NewsLetter).click();
	}

	public void newsDrop() throws InterruptedException {
		Thread.sleep(2000);
		ldriver.findElement(newsStoreName).click();
	}

	public void clickcustomer() throws InterruptedException {
		Thread.sleep(2000);
		ldriver.findElement(CustomerRole).click();
	}
	
//	public void CustomerRoles(String role) throws InterruptedException {
//		Thread.sleep(2000);
//		if(role.equals("Administrators")) {
//			ldriver.findElement(drplistAdmin).click();
//		} else if (role.equals("Guests")) {
//			   ldriver.findElement(drpguest);
//		} else if (role.equals("Registered")) {
//			 ldriver.findElement(drpregister);
//		} else if (role.equals("Vendors")) {
//			 ldriver.findElement(drpvendors);
//		}
//		
//	}

//	public void CustomerRoles(String role) throws InterruptedException {
//		if (!role.equals("Vendors")) {
//			ldriver.findElement(By.xpath("//li[text()='Vendors']"));
//		}
//		ldriver.findElement(CustomerRole).click();
//
//		WebElement listitem;
//		Thread.sleep(4000);
//		if (role.equals("Administrators")) {
//			listitem = ldriver.findElement(drplistAdmin);
//		} else if (role.equals("Guests")) {
//			listitem = ldriver.findElement(drpguest);
//		} else if (role.equals("Registered")) {
//			listitem = ldriver.findElement(drpregister);
//		} else if (role.equals("Vendors")) {
//			listitem = ldriver.findElement(drpvendors);
//		} else {
//			listitem = ldriver.findElement(drpguest);
//		}
//		listitem.click();
//
	

	public void managetVendor(String value) throws InterruptedException {
		Thread.sleep(3000);
		Select dp = new Select(ldriver.findElement(vendor));
		dp.selectByVisibleText(value);
		
	}


	public void adminComment(String comment) throws InterruptedException {
		Thread.sleep(3000);
		ldriver.findElement(AdminComment).sendKeys(comment);
	}

	public void savedata() {
		ldriver.findElement(saveButton).click();
	}

}
