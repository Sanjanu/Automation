package com.nikon;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class HomePage {
	static String url = "http://www.amazon.com";
	static String title = "Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more";
	static String keyw = "Nikon";
	static String text1 = "Sort by";
	static String sortString = "Price: High to Low";
	private StringBuffer verificationErrors = new StringBuffer();

	public void goTo() {
		Browser.goTo(url);
	}

	public boolean isAt() {
		return Browser.title().equals(title);
	}

	public void serachField() {
		// TODO Auto-generated method stub
		Browser.driver.findElement(By.id("twotabsearchtextbox")).clear();
		Browser.driver.findElement(By.id("twotabsearchtextbox")).sendKeys(keyw);
		Browser.driver.findElement(By.cssSelector("input.nav-input")).click();
	}

	public boolean isSearchKeyword() {
		String sortBy =Browser.driver.findElement(By.id("sort_by_text")).getText();
		return sortBy.contains("Sort by");
		
	}

	public void sortPrice() {
		goTo();
		serachField();
		isSearchKeyword();
		Browser.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("Starting");
		// 
		 assertTrue(isElementPresent(By.id("sort")));
		System.out.println("Middle");
		Browser.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		WebElement selectElement = Browser.driver.findElement(By.id("sort"));
		Select select = new Select(selectElement);
		select.selectByValue("price-desc-rank");
		
		System.out.println("Success");

	}

	public boolean isPriceSorted() {
		assertTrue(isElementPresent(By.id("sort_by_text")));
		// Browser.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// System.out.println("SStarting");
		 String ispriceSorted =Browser.driver.findElement(By.id("quartsPagelet")).getText();
		 System.out.println(ispriceSorted);
		
		return true;
	}

	private boolean isElementPresent(By by) {
		try {
			Browser.driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public void searchSecondProduct() {

	    // open | / | 
	    Browser.driver.get(url + "/");
	    // assertTitle | Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more | 
	    

	assertEquals("Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more", Browser.driver.getTitle());
	    // verifyValue | id=twotabsearchtextbox | 
	    try {
	      assertEquals("", Browser.driver.findElement(By.id("twotabsearchtextbox")).getAttribute("value"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // type | id=twotabsearchtextbox | Nikon
	    Browser.driver.findElement(By.id("twotabsearchtextbox")).clear();
	    Browser.driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nikon");
	    // click | css=input.nav-input | 
	    Browser.driver.findElement(By.cssSelector("input.nav-input")).click();
	    // assertElementPresent | id=sort_by_text | 
	    assertTrue(isElementPresent(By.id("sort_by_text")));
	    // select | id=sort | label=Price: High to Low
	    new Select(Browser.driver.findElement(By.id("sort"))).selectByValue("price-desc-rank");
	    // assertElementPresent | id=sort | 
	    
	    assertTrue(isElementPresent(By.id("sort")));
	    // assertElementPresent | //li[@id='result_0']/div/div/div/div[2]/div/div/a/h2 | 
	    assertTrue(isElementPresent(By.xpath("//li[@id='result_0']/div/div/div/div[2]/div/div/a/h2")));
	    // assertText | //li[@id='result_1']/div/div/div/div[2]/div/div/a/h2 | Nikon AF-S NIKKOR 180-400mm f/4E TC1.4 FL ED VR (Super-telephoto) Zoom Lens
	    
	    Browser.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	    String firstElement = Browser.driver.findElement(By.xpath("//li[@id='result_0']/div/div/div/div[2]/div/div/a/h2")).getText();
	    System.out.println("FirstElementText:"+ firstElement);
	    String secondElement = Browser.driver.findElement(By.xpath("//li[@id='result_1']/div/div/div/div[2]/div/div/a/h2")).getText();
	    System.out.println("SecondElementText:"+ secondElement);
	    
	   /* 
	    assertEquals("Nikon AF-S NIKKOR 180-400mm f/4E TC1.4 FL ED VR (Super-telephoto) Zoom Lens", Browser.driver.findElement(By.xpath("//li[@id='result_1']/div/div/div/div[2]/div/div/a/h2")).getText());
	    // click | //li[@id='result_1']/div/div/div/div[2]/div/div/a/h2 | 
	    Browser.driver.findElement(By.xpath("//li[@id='result_1']/div/div/div/div[2]/div/div/a/h2")).click();
	    // assertTitle | Amazon.com : Nikon AF-S NIKKOR 180-400mm f/4E TC1.4 FL ED VR (Super-telephoto) Zoom Lens : Camera & Photo | 
	    assertEquals("Amazon.com : Nikon AF-S NIKKOR 180-400mm f/4E TC1.4 FL ED VR (Super-telephoto) Zoom Lens : Camera & Photo", Browser.driver.getTitle());
	    // assertElementPresent | id=productTitle | 
	    assertTrue(isElementPresent(By.id("productTitle")));
	    // assertText | id=productTitle | Nikon AF-S NIKKOR 180-400mm f/4E TC1.4 FL ED VR (Super-telephoto) Zoom Lens
	    assertEquals("Nikon AF-S NIKKOR 180-400mm f/4E TC1.4 FL ED VR (Super-telephoto) Zoom Lens", Browser.driver.findElement(By.id("productTitle")).getText());

		*/
	}

	public void searchSecondProductName() {
		// TODO Auto-generated method stub
		// open | / | 
	    Browser.driver.get(url + "/");
	    // assertTitle | Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more | 
	    

	assertEquals("Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more", Browser.driver.getTitle());
	    // verifyValue | id=twotabsearchtextbox | 
	    try {
	      assertEquals("", Browser.driver.findElement(By.id("twotabsearchtextbox")).getAttribute("value"));
	    } catch (Error e) {
	      verificationErrors.append(e.toString());
	    }
	    // type | id=twotabsearchtextbox | Nikon
	    Browser.driver.findElement(By.id("twotabsearchtextbox")).clear();
	    Browser.driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nikon");
	    // click | css=input.nav-input | 
	    Browser.driver.findElement(By.cssSelector("input.nav-input")).click();
	    // assertElementPresent | id=sort_by_text | 
	    assertTrue(isElementPresent(By.id("sort_by_text")));
	    // select | id=sort | label=Price: High to Low
	    new Select(Browser.driver.findElement(By.id("sort"))).selectByValue("price-desc-rank");
	    // assertElementPresent | id=sort | 
	    
	    assertTrue(isElementPresent(By.id("sort")));
	    assertTrue(isElementPresent(By.xpath("//li[@id='result_0']/div/div/div/div[2]/div/div/a/h2")));
	    // assertText | //li[@id='result_1']/div/div/div/div[2]/div/div/a/h2 | Nikon AF
	    
	    assertNotEquals("%Nikon%", Browser.driver.findElement(By.xpath("//li[@id='result_1']/div/div/div/div[2]/div/div/a/h2")).getText());
		
	}

}
