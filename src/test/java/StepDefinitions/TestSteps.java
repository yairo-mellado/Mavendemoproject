package StepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.en.*;
import pageFactory.Cart_PF;
import pageFactory.Home_PF;
import pageFactory.Login_PF;

public class TestSteps {

	WebDriver driver = null;
	Login_PF loginPage;
	Home_PF homePage;
	Cart_PF cartPage;

	@When("I go to Sauce page")
	public void i_go_to_sauce_page() {
		ChromeOptions chromeoption=new ChromeOptions();
		chromeoption.addArguments("--remote-allow-origins=*");
		System.setProperty("webdriver.chrome.driver",
				"..\\Mavendemoproject\\Server\\chromedriver.exe");
		driver = new ChromeDriver(chromeoption);
		driver.manage().window().maximize();

		driver.get("https://www.saucedemo.com/");
	}

	@When("login with user {string} and pass {string}")
	public void login_with_user_and_pass(String user, String password) {
		loginPage = new Login_PF(driver);
		loginPage.enterUsername(user);
		loginPage.enterPassword(password);
		loginPage.clickLogin();
	}

	@When("add {string} item to the cart")
	public void add_item_to_the_cart(String itemString) {
		homePage = new Home_PF(driver);
		String itemXpath = ".//*[@data-test='add-to-cart-" + itemString.replace(" ", "-").toLowerCase() + "']";
		driver.findElement(By.xpath(itemXpath)).click();
		homePage.clickCart();
	}

	@Then("verify that {string} was added")
	public void verify_that_was_added(String itemString) {
		Assert.assertTrue(driver.getCurrentUrl().contains("cart"));
		cartPage = new Cart_PF(driver);
		cartPage.verifyItemSelected(itemString);
	}

	@After()
	public void closeBrowser() {
		driver.quit();
	}

}
