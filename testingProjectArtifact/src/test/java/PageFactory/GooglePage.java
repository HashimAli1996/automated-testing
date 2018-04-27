package PageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class GooglePage {
	
	@FindBy(how = How.NAME, using = "q")
	private WebElement searchbox;
	
	public void searchFor(String text) {
		searchbox.sendKeys(text);
		searchbox.submit();
	}
	

}
