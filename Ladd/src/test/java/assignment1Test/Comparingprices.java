package assignment1Test;

import org.testng.Reporter;
import org.testng.annotations.Test;

import assignment1.AmazonPages;
import assignment1.FlipkartPage;
import genericlib.BaseClass;


public class Comparingprices extends BaseClass  {
	 @Test
		public void  camginName() throws Throwable
		{
		 AmazonPages Amazonpage=new AmazonPages(driver);
		 /*searching ihone name by using method for amazon
		  * 
		  */
		 Amazonpage.passingIphonename();
		 /*getting amazoniphone price*/
		 int amazonprice = Amazonpage.getAmazonprice();
		 FlipkartPage flippage=new FlipkartPage(driver);
		 /*searching ihone name by using method for flipkart
		  * 
		  */
		 flippage.passingIphonename();
		 /*getting flipkartiphone price*/
		 int flipprice = flippage.getFlipprice();
		 /**
		  * comparing prices of amazon and flipkart
		  */
		 if(amazonprice<flipprice)
		 {
			 Reporter.log("amazon iphone price is lesscost:"+amazonprice,true);
		 }
		 else if(flipprice<amazonprice)
		 {
			 Reporter.log("flipkart iphone cost is morecost :"+flipprice,true);
		 }
		 else
		 {
			 Reporter.log("bothprices are equal",true);
		 }
		 
		 }
}
