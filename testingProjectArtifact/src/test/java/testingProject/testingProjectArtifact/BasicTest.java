package testingProject.testingProjectArtifact;

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicTest {
	
	WebDriver webdriver;
	
	@Before
	public void before() {
		webdriver = new ChromeDriver();
	}
	
	@Test
	public void method() {
		webdriver.get("http://demoqa.com/");
	}
	
	@After
	public void after() {
		webdriver.quit();
	}
	
	
}
