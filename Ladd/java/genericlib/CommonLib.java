package genericlib;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.Set;
/*
 * @author kalpana
 */


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonLib implements IAutoconstants {
	private WebDriver driver;
	private JavascriptExecutor jse;
	private FluentWait<WebDriver> fwait;
	
	public CommonLib(WebDriver driver) {
		this.driver=driver;
		this.jse = (JavascriptExecutor)driver;
	}
	/**
	 * getting data from property file
	 * 
	 */
	public String getPropertyval(String Key) throws Throwable
	{
	FileInputStream fis=new FileInputStream("D:\\flip\\Ladd\\src\\test\\resources\\reuse.property");
	Properties prop=new Properties();
	prop.load(fis);
return prop.getProperty(Key);
}
	public Object runScript(String script) {
		return jse.executeScript(script);
	}

	/**
	 * 
	 * waiting for page load
	 * 
	 */

	public void waitForPageToLoad(){
		fwait = new FluentWait<WebDriver>(driver)
				.pollingEvery(Duration.ofMillis(30))
				.withTimeout(Duration.ofSeconds(20))
				.ignoring(NoSuchElementException.class);

		fwait.until(new ExpectedCondition<Boolean>(){
			public Boolean apply(WebDriver input) {
				String state = (String) runScript("return document.readyState");
				if(state.equals("complete")) {
					return true;
				}
				return false;
			}
		});
	}

	/**
	 * Wait for element to be available on GUI
	 * @param element
	 */
	public void waitForElemetToBePresent(WebElement element){
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public int removeSpecialChars(String Str) {
		char[] split = Str.toCharArray();
		String s = "";
		for (int i = 0; i < split.length; i++) {
			if(Character.isDigit(split[i])) {
				s = s + split[i];
			}
		}
		return Integer.parseInt(s);
		
	}



private String parentId;
private String childId; 
private Set<String> windows;

/**
 * Obtains the parent and the child window handles
 * @return Set of window handles
 */
private Set<String> switchWindow() {
	windows = driver.getWindowHandles();
	Iterator<String> window = windows.iterator();
	parentId = window.next();
	childId = window.next();
	return windows;
}

/**
 * Switches to the child window
 */
public void switchToChildWindow() {
	switchWindow();
	driver.switchTo().window(childId);
}

/**
 * Switch to child window that contains the specified Title
 * @param title of the window to be switched to
 */
public void switchWindow(WebDriver driver, String title)
{
	Set<String> windows = driver.getWindowHandles();
	Iterator<String> it = windows.iterator() ;
	while(it.hasNext())
	{
		driver.switchTo().window(it.next());
		if(driver.getTitle().contains(title))
		{
			break;
		}
	}
}
public void scroll(WebDriver driver, WebElement element)
{
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].scrollIntoView();", element);
}

/**
 * Switch back to new parent Window
 */
public void switchToParentWindow() {
	driver.switchTo().window(parentId);
}
}








