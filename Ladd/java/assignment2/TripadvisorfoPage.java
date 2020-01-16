package assignment2;


	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;

	
import genericlib.CommonLib;
import genericlib.Filelib;

	/**
	 * 
	 * @author kalpana
	 *
	 */
	public class TripadvisorfoPage {
		private WebDriver driver;
	 CommonLib common=new CommonLib(driver);
		Filelib flib = new Filelib();
		public TripadvisorfoPage(WebDriver driver) throws Throwable{
			
			this.driver = driver;
			driver.get(common.getPropertyval("urltripadvisor"));
			PageFactory.initElements(driver, this);
			common = new CommonLib(driver);
		}
		@FindBy(xpath= "//div[@title='Search']") 
		private WebElement searchBox;
		
		@FindBy(xpath = "//input[@id='mainSearch']")
		private WebElement searchBtn;
		
		@FindBy(id = "SEARCH_BUTTON_CONTENT")
		private WebElement searchBtn2;
		
		@FindBy(xpath= "//input[@title='Search']")
		private WebElement searchBox2;
		@FindBy(xpath = "//div[@class='result-title']/span[.='Club Mahindra Emerald Palms']")
		private WebElement textResult;
		@FindBy(xpath = "//a[text()='Write a review']")
		private WebElement reviewscrl;
		@FindBy(id = "ReviewTitle")
		private WebElement ReviewTitle;
		@FindBy(id = "ReviewText")
		private WebElement ReviewText;
		@FindBy(xpath = "//div[text()='Hotel Ratings']")
		private WebElement ratingScroll;
		@FindBy(id = "SUBMIT")
		private WebElement submitBtn;
		@FindBy(xpath="//em[text()='Excellent']")private WebElement starBtn;
		public void searchInTripAdvisor() throws Throwable {
			try {
				searchBox.click();
				WebDriverWait wait = new WebDriverWait(driver, 20);
				wait.until(ExpectedConditions.elementToBeClickable(searchBtn));
				searchBtn.sendKeys(flib.getcellData("Sheet1",1,1));
				searchBtn2.click();
			}catch(Exception e) {
				searchBox2.sendKeys(flib.getcellData("Sheet1",1,1));
				
			}
		}
		/* Search for  reviewTitleTripAdvisor inTripAdvisor */
		public void reviewTrip() throws Throwable {
			textResult.click();
			common.switchToChildWindow();
			Actions act = new Actions(driver);
			act.moveToElement(reviewscrl).perform();
			reviewscrl.click();
			common.switchWindow(driver, "Write a review");
			ReviewTitle.sendKeys(flib.getcellData("Sheet1",2,1));
		}
		/* Search for  reviewTextTripAdvisor inTripAdvisor */
		public void reviewTextAdvisor() throws Throwable {
			ReviewText.sendKeys(flib.getcellData("Sheet1",2,1));
			common.scroll(driver,ratingScroll);
			common.scroll(driver, submitBtn);
			submitBtn.click();
			
		}
		}

