package assignment1;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericlib.CommonLib;
import genericlib.Filelib;

public class FlipkartPage {
	 
/*
 * 
 * @author kalpana
 */
		
		@FindBy(xpath = "//button[text()='✕']")
		private WebElement closeLogin;
		
		@FindBy(xpath = "//div[text()='Apple iPhone XR (Yellow, 64 GB)']/../following-sibling::div/div/div/div")
		private WebElement productPrice;
		
		@FindBy(name = "q")
		private WebElement searchBox;
		
		private WebDriver driver;
		
		
		Filelib flib = new Filelib(); 
		CommonLib common= new CommonLib(driver);
		/**
		 * passing iphone  name in search field
		 * @throws Throwable
		 */
		public FlipkartPage(WebDriver driver) throws Throwable  {
			// TODO Auto-generated constructor stub
			driver.get(common.getPropertyval("urlFlipkart"));
			PageFactory.initElements(driver, this);
			this.driver = driver;
			common = new CommonLib(driver);
		}
		/**
		 * getting flipkart iphone price
		 * @return
		 */
		
		public void passingIphonename() throws Throwable
		{
			closeLogin.click();
			String value = flib.getcellData("Sheet1",2,0);
			searchBox.sendKeys(value,Keys.ENTER);
		}
		/**
		 * intializing through the constructor
		 * @param urlflipkart
		 *  @throws Throwable
		 */

	public int getFlipprice()
	{
		common.waitForElemetToBePresent(productPrice);
		String price=productPrice.getText();
		int productPrice = common.removeSpecialChars(price);
		System.out.println(productPrice);
		return productPrice;
		
	}
}