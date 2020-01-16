package assignment1;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericlib.BaseClass;
import genericlib.CommonLib;
import genericlib.Filelib;
/*
 * @author kalpana
 */
public class AmazonPages extends BaseClass {
	@FindBy(id="twotabsearchtextbox")private WebElement searchfieldTB;
	@FindBy(xpath = "//span[text()='Apple iPhone XR (64GB) - Yellow']/../../../../../../..//span[@class='a-price-whole']")private WebElement pricefield;
	CommonLib common=new CommonLib(driver);
	Filelib flib=new Filelib();
	/**
	 *  passing iphone  name in search field
	 * @throws Throwable
	 */
	public void passingIphonename() throws Throwable
	{
		
		String value = flib.getcellData("Sheet1",1,0);
		 searchfieldTB.sendKeys(value,Keys.ENTER);
	}
	/**
	 * getting amazon iphone price
	 * @return
	 */
public int getAmazonprice()
{
	String price = pricefield.getText();
	int productPrice = common.removeSpecialChars(price);
	System.out.println(productPrice);
	return productPrice;
	
}
/**
 * intializing through the constructor
 * @param urlamazon
 *  @throws Throwable
 */


	public AmazonPages(WebDriver driver) throws Throwable
	{
		driver.get(common.getPropertyval("urlamazon"));
		PageFactory.initElements(driver, this);
		this.driver = driver;
		common = new CommonLib(driver);PageFactory.initElements(driver,this);
	}
		
}
