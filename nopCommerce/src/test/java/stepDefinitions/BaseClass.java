package stepDefinitions;

import java.util.Properties;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import pageObjects.CustomersPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;

public class BaseClass {
	
	public WebDriver driver;
	public LoginPage lp;
	public CustomersPage cp;
	public SearchCustomerPage sp;
	public static Logger logger;
	public Properties configprop;
	
	
	//Created for generating random string for unique email
	public static String randomString() {
		String generateString=RandomStringUtils.randomAlphabetic(5);
		return(generateString);
	}

}
