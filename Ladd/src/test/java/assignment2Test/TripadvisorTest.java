package assignment2Test;

import org.testng.annotations.Test;

import assignment2.TripadvisorfoPage;
import genericlib.BaseClass;

public class TripadvisorTest extends BaseClass {
	@Test
	public void verifyingTripAdvisor() throws Throwable
	{
		TripadvisorfoPage trippage=new TripadvisorfoPage(driver);
		trippage.searchInTripAdvisor();
		trippage.reviewTrip();;
		trippage.reviewTextAdvisor();
		
	}

}
