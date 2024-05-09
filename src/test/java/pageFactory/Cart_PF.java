package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

public class Cart_PF {
	
	WebDriver driver;
	
	public Cart_PF(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
	}
	
	@FindBy(xpath = ".//*[@id='cart_contents_container']//*[@class='cart_quantity']")
	WebElement label_qty;
	
	@FindBy(xpath = ".//*[@class='inventory_item_name']")
	WebElement label_itemSelected;

	public void verifyItemSelected(String itemString) {
		Assert.assertTrue(label_qty.getText().compareTo("1") == 0 && label_itemSelected.getText().contains(itemString));
	}

}
