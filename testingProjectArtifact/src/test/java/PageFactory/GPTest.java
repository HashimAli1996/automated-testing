package PageFactory;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class GPTest {
	
	WebDriver webdriver;
	
	@Before
	public void before() {
		webdriver = new ChromeDriver();
	}
	
	@Test
	public void method() {
		webdriver.get("http://google.com/");
		
		GooglePage page = PageFactory.initElements(webdriver, GooglePage.class);
		page.searchFor("Bradford University Switchboard");
		
	}
	
	@After
	public void after() {
		webdriver.quit();
	}
	
	
}
