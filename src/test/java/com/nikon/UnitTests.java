package com.nikon;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class UnitTests {
	@Ignore
	@Test
	public void canGoToHomePage() {
		Pages.homePage().goTo();
		Assert.assertTrue(Pages.homePage().isAt());
		
	}
	@Ignore
	@Test
	public void searchString() {
		Pages.homePage().goTo();
		Pages.homePage().serachField();
		Assert.assertTrue(Pages.homePage().isSearchKeyword());
		Browser.close();
	}

	@Ignore
	@Test
	public void sortPrice() {
		Pages.homePage().sortPrice();
		Assert.assertTrue(Pages.homePage().isPriceSorted());
		Browser.close();
	}
	@Ignore
	@Test
	public void productSearch()
	{
		Pages.homePage().searchSecondProduct();
		
	}
	
	@Test
	public void productName()
	{
		Pages.homePage().searchSecondProductName();
		
	}
	
	@AfterClass
	public static void cleanup() {
		Browser.close();
	}

}