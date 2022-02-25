package pageObjectsClass;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

public class pipinObjects {

	WebDriver driver;

	@FindBy(xpath = "//input[@type='email']")

	WebElement userName;

	@FindBy(xpath = "//input[@type='password']")

	WebElement password;

	@FindBy(xpath = "//input[@type='submit']")

	WebElement login;

	public pipinObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void setUserName(String strUserName) {

		userName.sendKeys(strUserName);
	}

	// Set password in password textbox

	public void setPassword(String strPassword) {

		password.sendKeys(strPassword);

	}

	// Click on login button

	public void clickLogin() {

		login.click();

	}

	public void loginToPipin(String strUserName, String strPasword) {

		// Fill user name

		this.setUserName(strUserName);

		// Fill password

		this.setPassword(strPasword);

		// Click Login button

		this.clickLogin();

	}

	public void clickInProgress() throws InterruptedException {
		Thread.sleep(5000);
		driver.findElement(By.xpath("//a[@class='active']")).click();
	}

	public void selectRecord(String record) {
		List<WebElement> ls = new ArrayList<>();
		ls = driver.findElements(By.xpath("//tr[@class='ng-star-inserted']/td[1]/span"));
		List<String> st = new ArrayList<>();
		for (WebElement e : ls) {
			st.add(e.getText());

		}
		LinkedHashSet<String> hs = new LinkedHashSet<String>();
		hs.addAll(st);
		st.addAll(hs);
		for (int i = 0; i < hs.size(); i++) {
			if (st.get(i).equals(record)) {
				System.out.println(ls.get(i).getText());
				ls.get(i).getText();
				st.get(i);
				System.out.println("record Id is :- " + st.get(i));
				ls.get(i).click();
				break;
			}
		}
	}
	
	public String verifyRecords() throws InterruptedException {
		Thread.sleep(3000);
		WebElement rl = driver.findElement(By.xpath("//div[@class='mat-form-field-infix']/span/input"));
		String sst = rl.getAttribute("ng-reflect-value");
		return sst.trim();
	}
	
	public void logoutApplication() {
		driver.findElement(By.xpath("//div[@class='ng-star-inserted']//span[@class='mat-button-wrapper']")).click();
		driver.findElement(By.xpath("(//div[@class='mat-menu-content']//button)[4]")).click();
	}
	
}
