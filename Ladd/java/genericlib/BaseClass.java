package genericlib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
/*
 * @author kalpana
 */
/**
 * 
 *open the browser 
 *@param browser
 */
public class BaseClass {
	public WebDriver driver;
	@BeforeClass
	public void openBrowser() throws Throwable
	{
		CommonLib common=new CommonLib(driver);
		String browser = common.getPropertyval("browser");
		if(browser.equals("chrome"))
		{
	driver=new ChromeDriver();
		driver.manage().window().maximize();
	}
	
}
	@AfterClass
	public void configAC(){
		
		driver.quit();
	}
	
}

