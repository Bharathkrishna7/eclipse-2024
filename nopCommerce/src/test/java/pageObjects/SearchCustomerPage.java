package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utilites.WaitHelper;

public class SearchCustomerPage {

	public WebDriver ldriver;

	WaitHelper waithelper;

	public SearchCustomerPage(WebDriver driver) {
		this.ldriver = driver;
		PageFactory.initElements(ldriver, this);
		waithelper = new WaitHelper(ldriver);
	}

	@FindBy(how = How.ID, using = "search-customers")
	@CacheLookup
	WebElement searchmail;

	@FindBy(how = How.XPATH, using = "//input[@id='SearchEmail']")
	@CacheLookup
	WebElement txtmail;

	@FindBy(how = How.XPATH, using = "//div[@id='customers-grid_wrapper']")
	@CacheLookup
	WebElement table;

	@FindBy(how = How.XPATH, using = "//div[@id='customers-grid_wrapper']//tbody/tr")
	@CacheLookup
	List<WebElement> tableRows;

	@FindBy(how = How.XPATH, using = "//div[@id='customers-grid_wrapper']//tbody/tr/td")
	@CacheLookup
	List<WebElement> tableColumns;

	public void setEmail(String email) {
		waithelper.WaitforElement(txtmail, 10);
		txtmail.clear();
		txtmail.sendKeys(email);
	}

	public void ClickSearch() {
		searchmail.click();
	}

	public int getnumOfRows() {
		return (tableRows.size());
	}

	public int getnumOfColumns() {
		return (tableColumns.size());
	}

	public boolean searchCustomerByMail(String email) throws InterruptedException {
		boolean flag = false;
		Thread.sleep(2000);
		for (int i = 1; i < getnumOfRows(); i++) {

			String emailid = table
					.findElement(By.xpath("//div[@id='customers-grid_wrapper']//tbody/tr[" + i + "]/td[2]")).getText();

			System.out.println(emailid);

			if (emailid.equals(email)) {
				flag = true;
			}

		}
		return flag;

	}

}
