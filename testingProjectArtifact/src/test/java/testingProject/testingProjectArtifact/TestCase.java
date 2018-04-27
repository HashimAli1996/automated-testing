package testingProject.testingProjectArtifact;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCase {
	
	WebDriver webDriver;
	
	@Before
	public void setUp() {
		webDriver = new ChromeDriver();
	}
	
	@After
	public void tearDown() {
		webDriver.quit();
	}
	
	@Test
	public void test1() throws InterruptedException {
		webDriver.get("http://thedemosite.co.uk/");
		System.out.println("Getting demosite.co.uk");
		
		webDriver.findElement(By.xpath("/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[3]")).click();
		System.out.println("Find & Click Element Add user button");
		
		WebElement usernameEl = webDriver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[1]/td[2]/p/input"));
		WebElement pwEl = webDriver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[2]/td[2]/p/input"));
		System.out.println("Find username and pw text elements");
		
		String user = "Hashom";
		String pw = "notHasho";
		
		usernameEl.sendKeys(user);
		pwEl.sendKeys(pw);
		
		webDriver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[3]/td[2]/p/input")).click();
		System.out.println("User and Pw enetered and saved, refreshing page now");
		
		webDriver.findElement(By.xpath("/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[3]")).click();		
		
		
		System.out.println("Attempting to login now");
		webDriver.findElement(By.xpath("/html/body/div/center/table/tbody/tr[2]/td/div/center/table/tbody/tr/td[2]/p/small/a[4]")).click();
		
		System.out.println("entering username and pw to login");
		webDriver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[1]/td[2]/p/input")).sendKeys(user);
		webDriver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[2]/td[2]/p/input")).sendKeys(pw);

		
		System.out.println("click login");
		webDriver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/table/tbody/tr[3]/td[2]/p/input")).click();		

		
		Boolean path = webDriver.findElement(By.xpath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b")).getText()
				.equals("**Successful Login**");
		
		if(path == true) {
			System.out.println("login successful");
		}
		
		Thread.sleep(1000);
		
		
	}
	
	
	
	
}
