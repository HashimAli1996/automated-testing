package assessment;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class feature1 {
	
	WebDriver webdriver;
	
	@Before
	public void before() {
		webdriver = new ChromeDriver();
	}
	
	@Test
	public void method() {
		webdriver.get("http://www.phptravels.net");
		
		webdriver.findElement(By.xpath("//*[@id=\"s2id_autogen10\"]/a/span[1]")).click();
		webdriver.findElement(By.xpath("//*[@id=\"select2-drop\"]/div/input")).sendKeys("London");
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(webdriver)
				 .withTimeout(30, TimeUnit.SECONDS)
				 .pollingEvery(2, TimeUnit.SECONDS)
				 .ignoring(NoSuchElementException.class);
				WebElement foo = wait.until(new Function<WebDriver, WebElement>() 
				{ 
					public WebElement apply(WebDriver driver) {
						return driver.findElement(By.xpath("//*[@id=\"select2-drop\"]/ul/li/ul/li[1]/div"));
				 	}
				 }); 

		webdriver.findElement(By.xpath("//*[@id=\"select2-drop\"]/ul/li/ul/li[1]/div")).click();
		
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		
		webdriver.findElement(By.xpath("//*[@id=\"dpd1\"]/input")).clear();
		webdriver.findElement(By.xpath("//*[@id=\"dpd1\"]/input")).sendKeys(dateFormat.format(date));
		webdriver.findElement(By.xpath("/html/body/div[14]/div[1]/table/tbody/tr[5]/td[6]")).click();
		
		//dateFormat.format(date);
		
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		c.add(Calendar.DATE, 3);  // number of days to add
		
		webdriver.findElement(By.xpath("//*[@id=\"dpd2\"]/input")).clear();
		webdriver.findElement(By.xpath("//*[@id=\"dpd2\"]/input")).sendKeys(dateFormat.format(c.getTime()));
		webdriver.findElement(By.xpath("/html/body/div[15]/div[1]/table/tbody/tr[6]/td[2]")).click();
		
		
		webdriver.findElement(By.xpath("//*[@id=\"adults\"]")).click();
		
		
//		List<WebElement> listy = webdriver.findElements(By.xpath("//*[@id=\"adults\"]/option[3]"));
//		System.out.println(listy.size());
//		
//		Actions actionthing = new Actions(webdriver);
//		actionthing.moveToElement(listy.get(0)).doubleClick();
		
		//listy.get(0).click();
		
		webdriver.findElement(By.cssSelector("#adults > option:nth-child(3)")).click();
		
		webdriver.findElement(By.xpath("//*[@id=\"body-section\"]/div[1]/div")).click();
		
		webdriver.findElement(By.xpath("//*[@id=\"HOTELS\"]/form/div[3]/div[3]/button")).click();
		
		webdriver.findElement(By.xpath("//*[@id=\"body-section\"]/div[5]/div[3]/div/table/tbody/tr/td/div[2]/div/div[5]/a/button")).click();
		
		webdriver.findElement(By.xpath("//*[@id=\"ROOMS\"]/div/table/tbody/tr[1]/td/div[2]/div[3]/div[3]/button")).click();
		
		
//		webdriver.findElement(By.xpath("//*[@id=\"guestform\"]/div[1]/div/input")).sendKeys("Hashim");
//		webdriver.findElement(By.xpath("//*[@id=\"guestform\"]/div[2]/div/input")).sendKeys("Ali");
//		webdriver.findElement(By.xpath("//*[@id=\"guestform\"]/div[3]/div/input")).sendKeys("hashim@email.com");
//		webdriver.findElement(By.xpath("//*[@id=\"guestform\"]/div[4]/div/input")).sendKeys("hashim@email.com");
//		webdriver.findElement(By.xpath("//*[@id=\"guestform\"]/div[6]/div/input")).sendKeys("01287998996");
//		webdriver.findElement(By.xpath("//*[@id=\"guestform\"]/div[7]/div/input")).sendKeys("12 address lane");
//		
//		webdriver.findElement(By.xpath("//*[@id=\"s2id_autogen1\"]/a/span[1]")).click();
//		
//		Actions actionthing = new Actions(webdriver);
//		
//		actionthing.clickAndHold().sendKeys("united Kingdom");
//		
//		
//		Wait<WebDriver> wait2 = new FluentWait<WebDriver>(webdriver)
//				 .withTimeout(30, TimeUnit.SECONDS)
//				 .pollingEvery(2, TimeUnit.SECONDS)
//				 .ignoring(NoSuchElementException.class);
//				WebElement foo1 = wait.until(new Function<WebDriver, WebElement>() 
//				{ 
//					public WebElement apply(WebDriver driver) {
//						return driver.findElement(By.xpath("//*[@id=\"select2-drop\"]/div/input"));
//				 	}
//				 });
//		
//		webdriver.findElement(By.xpath("//*[@id=\"select2-drop\"]/div/input")).click();
//		
//		webdriver.findElement(By.xpath("//*[@id=\"body-section\"]/div[2]/div/div/div[1]/div[2]/div[2]/div[4]/button")).click();
		
		
		//Book a hotel in London for 2 nights for 3 adults as
		//a guest user to the website.
		
		
		
		
	}
	
	@After
	public void after() {
		//webdriver.quit();
	}
	
	
}
