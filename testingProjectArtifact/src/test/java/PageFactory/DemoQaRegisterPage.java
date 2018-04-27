package PageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class DemoQaRegisterPage {

	@FindBy(how = How.NAME, using = "q")
	private WebElement searchbox;

	public void goTo(WebDriver driver) {
		driver.get("http://www.phptravels.net");
	}


	
	public void country(WebDriver driver, String country) {

	    new Select(driver.findElement(By.id("dropdown_7"))).selectByVisibleText("Fiji");
		
		//System.out.println(driver.findElement(By.cssSelector("#dropdown_7 > option:nth-child(60)")).getText());
		
		//driver.findElement(By.xpath("//*[@id=\\\"dropdown_7\\\"]")).findElement(By.linkText(country)).click();
		
		//driver.findElements(By.tagName("option"));
	}
}
