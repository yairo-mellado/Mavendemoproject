package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class Login_PF {
	
	WebDriver driver;
	
	public Login_PF(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
	}
	
	@FindBy(xpath = ".//input[@data-test='username']")
	WebElement txt_username;
	
	@FindBy(xpath = ".//input[@data-test='password']")
	WebElement txt_password;
	
	@FindBy(xpath = ".//input[@data-test='login-button']")
	WebElement btn_submit;
	
	public void enterUsername(String username) {
		txt_username.sendKeys(username);
	}
	
	public void enterPassword(String password) {
		txt_password.sendKeys(password);
	}
	
	public void clickLogin() {
		btn_submit.click();
	}

}
