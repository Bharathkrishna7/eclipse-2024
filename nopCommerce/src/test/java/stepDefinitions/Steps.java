package stepDefinitions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.CustomersPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;

public class Steps extends BaseClass {

	@Before
	public void setup() throws IOException {
		//Reading properties
		configprop=new Properties();
		FileInputStream configPropfile=new FileInputStream("config.properties");
		configprop.load(configPropfile);
		
		String br=configprop.getProperty("browser");
		
		if(br.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(br.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(br.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		
		
		logger=Logger.getLogger("nopCommerce");	//Add logger
		PropertyConfigurator.configure("log4j.properties"); //Add logger
		
//System.setProperty("Webdriver.chrome.driver", System.getProperty("user.dir") + "//Drivers/chromedriver.exe");
		
		logger.info("===========Launching browser======");
	}
	
	@Given("User launch chrom window")
	public void user_launch_chrom_window() {
		lp = new LoginPage(driver);

	}

	@When("user open url {string}")
	public void user_open_url(String url) {
		logger.info("===========Open url======");
		driver.get(url);
		driver.manage().window().maximize();
	}

	@When("User enter email as {string} and Password as {string}")
	public void user_enter_email_as_and_Password_as(String email, String Password) { // getting data from feature file
		logger.info("===========Login details======");
		lp.setuserName(email);
		lp.setpassword(Password);
	}

	@When("Click on login")
	public void click_on_login() {

		lp.login();

	}

	@Then("Page title should be {string}")
	public void page_title_should_be(String title) {// getting title from feature file

		if (driver.getPageSource().contains("Login was unsuccessful."))// here we are performing in -ve way
		{
			driver.close();
			Assert.assertTrue(false);
		} else {
			Assert.assertEquals(title, driver.getTitle());
		}

	}

	@When("use click on logout link")
	public void use_click_on_logout_link() throws InterruptedException {
		lp.logout();
		Thread.sleep(4000);
	}

	@Then("page title is {string}")
	public void page_title_is(String title) {
		Assert.assertEquals(title, driver.getTitle());
		System.out.println("titlename  " + driver.getTitle());
	}

	@Then("close browser")
	public void close_browser() {
		driver.close();
	}
	// customers steps

	@Then("user can view Dashboard page")
	public void user_can_view_Dashboard_page() {
		cp = new CustomersPage(driver);
		Assert.assertEquals("Dashboard / nopCommerce administration", cp.getPagetitle());
	}

	@When("user click on customers menu")
	public void user_click_on_customers_menu() {
		cp.clickonCustMenu();
	}

	@When("Click on customer menuitem")
	public void click_on_customer_menuitem() {
		cp.clickonCustItem();
	}

	@When("Click on Addnew button")
	public void click_on_Addnew_button() {
		cp.ClickAddNew();
	}

	@Then("user can see Add new Customer page")
	public void user_can_see_Add_new_Customer_page() {
		Assert.assertEquals("Add a new customer / nopCommerce administration", cp.getPagetitle());
	}

	@When("user enter customer info")
	public void user_enter_customer_info() throws InterruptedException {
		String email = randomString() + "@gmail.com";
		cp.entermail(email);
		cp.enterPassword("krishna77");
		cp.enterfname("bharath");
		cp.enterLname("krishna");
		cp.setgender("Male");
		cp.dateofBirth("7/06/1994");
		cp.enterCompanyName("societe generel");
		cp.taxempt();
		cp.Newsletter();
		cp.newsDrop();
		cp.clickcustomer();
//	     cp.CustomerRoles("Administrators");

		cp.managetVendor("Vendor 1");

		cp.adminComment("this is bangalore");
	}

	@When("Click on save button")
	public void click_on_save_button() {
		cp.savedata();
	}

	@Then("user can see conformation message {string}")
	public void user_can_see_conformation_message(String string) {
		Assert.assertTrue(driver.findElement(By.tagName("body")).getText() // it will give entire body and search data
				.contains("The new customer has been added successfully."));
	}

	// steps for searching a customer using email id
	@When("User Enters Customers email")
	public void user_Enters_Customers_email() {
		sp = new SearchCustomerPage(driver);
		sp.setEmail("victoria_victoria@nopCommerce.com");
	}

	@When("Click on Search button")
	public void click_on_Search_button() {
		sp.ClickSearch();
	}

	@Then("User should find email in the search table")
	public void user_should_find_email_in_the_search_table() throws InterruptedException {

		boolean status = sp.searchCustomerByMail("victoria_victoria@nopCommerce.com");
		System.out.println("status is "+ status);

		Assert.assertEquals(false, status);

	}

}
