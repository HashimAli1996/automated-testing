package PageFactory;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class DQTest {
	
	WebDriver webdriver;
	
	@Before
	public void before() {
		webdriver = new ChromeDriver();
	}
	
	@Test
	public void method() {
		
		DemoQaHomePage homePage = PageFactory.initElements(webdriver, DemoQaHomePage.class);
		DemoQaRegisterPage registerPage = PageFactory.initElements(webdriver, DemoQaRegisterPage.class);
		
		
		//homePage.goTo(webdriver);
		//
		//homePage.clickAPic(webdriver, "Unique and Clean");
		//homePage.clickAPic(webdriver, "Customer Support");
		
		registerPage.goTo(webdriver);
		registerPage.country(webdriver, "Finland");
		
		
		
	}
	
	@After
	public void after() {
		//webdriver.quit();
	}
	
	
}
