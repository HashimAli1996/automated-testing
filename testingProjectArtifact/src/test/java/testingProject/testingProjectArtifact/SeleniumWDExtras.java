package testingProject.testingProjectArtifact;

import static org.junit.Assert.*;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SeleniumWDExtras {
	
	WebDriver webdriver;
	Actions builder;
	
	@Before
	public void before() {
		webdriver = new ChromeDriver();
	}
	
	@Test
	public void method() {
		webdriver.get("http://demoqa.com/");
		assertNotNull(webdriver.getPageSource());
		
		builder = new Actions(webdriver);
		
		WebElement uniquePicture = webdriver.findElement(By.xpath("//*[@id=\"post-9\"]/div/div[1]"));
		builder.moveToElement(uniquePicture).click().perform();
		
		//System.out.println(webdriver.getCurrentUrl());
		
		assertTrue(webdriver.getCurrentUrl() == "http://demoqa.com/wp-content/uploads/2014/08/pattern-14.png");
	
		webdriver.navigate().to("http://demoqa.com/");
	
	}
	
	@After
	public void after() {
		webdriver.quit();
	}
	
}
