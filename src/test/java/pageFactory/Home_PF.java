package pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

public class Home_PF {
	
	WebDriver driver;
	
	public Home_PF(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
	}
	
	@FindBy(xpath = ".//*[@class='shopping_cart_link']")
	WebElement btn_cart;

	public void clickCart() {
		Assert.assertTrue(btn_cart.findElement(By.xpath("//*[@class='shopping_cart_badge']")).getText().compareTo("1") == 0);
		btn_cart.click();
	}

}
