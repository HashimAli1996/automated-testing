package PageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DemoQaHomePage {

	@FindBy(how = How.NAME, using = "q")
	private WebElement searchbox;

	public void goTo(WebDriver driver) {
		driver.get("http://demoqa.com/");
	}

	public void goTo(WebDriver driver, String url) {
		driver.get(url);
	}

	public void clickAPic(WebDriver driver, String element) {

		if (element == "Unique and Clean") {
			driver.findElement(By.xpath("//*[@id=\"post-9\"]/div/div[1]/div/p[1]/a/img"));
		} else if (element == "Customer Support") {
			driver.findElement(By.xpath("//*[@id=\"post-9\"]/div/div[2]/div/p[1]/i/a/img"));
		} else {
			goTo(driver,
					"https://www.google.co.uk/search?biw=798&bih=1025&tbm=isch&sa=1&ei=I5"
							+ "nhWp_uJMrHgAb4zbCABg&q=are+you+stupid&oq=are+you+stupid&gs_l=psy-ab."
							+ "3..0i67k1j0l9.1537.2669.0.3017.8.6.0.0.0.0.128.377.5j1.6.0....0...1c.1.6"
							+ "4.psy-ab..4.3.232...0i8i30k1j0i10i24k1j0i24k1.0.aDA8SKo5SxQ");
		}
		driver.get("http://demoqa.com/");
	}

}
