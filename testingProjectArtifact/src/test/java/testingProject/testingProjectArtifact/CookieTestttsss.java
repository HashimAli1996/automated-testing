package testingProject.testingProjectArtifact;

import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;
import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class CookieTestttsss {
	
	String url;
	WebDriver webdriver;
	
	@Before
	public void before() {
		webdriver = new ChromeDriver();
		url = "https://github.com/";
	}
	
	@After
	public void after() {
//		webdriver.quit();
	}
	
	@Test
	public void method() {
		
		String slapurdad = "ON T LOGEN PAGE";
		String idk = "stupid not workin";
		
		webdriver.get("https://github.com/");
		WebElement signinbtn = webdriver.findElement(By.xpath("/html/body/div[1]/header/div/div[2]/div/span/div/a[1]"));
		
		Actions actionthingy = new Actions(webdriver);
		actionthingy.moveToElement(signinbtn).click().perform();
		//System.out.println(webdriver.getCurrentUrl());
		if(webdriver.getCurrentUrl().equals("https://github.com/login")) {
			System.out.println(slapurdad);
		}
		
		WebElement lgnfield = webdriver.findElement(By.xpath("//*[@id=\"login_field\"]"));
		WebElement pwfield = webdriver.findElement(By.xpath("//*[@id=\"password\"]"));
		WebElement seyebtn = webdriver.findElement(By.xpath("//*[@id=\"login\"]/form/div[3]/input[3]"));
		
		lgnfield.sendKeys("HashimAli1996");
		pwfield.sendKeys("Batman65523");
		actionthingy.moveToElement(seyebtn).click().perform();
		createCookie();
		
		
		//click dropdown
		//click sign out
		WebElement dropdown = webdriver.findElement(By.xpath("//*[@id=\"user-links\"]/li[3]/details/summary/span"));
		WebElement signout = webdriver.findElement(By.xpath("//*[@id=\"user-links\"]/li[3]/details/ul/li[9]/form/button"));
		actionthingy.moveToElement(dropdown).click().perform();
		actionthingy.moveToElement(signout).click().perform();
		
		
		
		WebElement bfd = webdriver.findElement(By.xpath("/html/body/div[4]/div[1]/div/div/div[1]/h1"));
		
		if(bfd.getText().equals("Built for developers")) {
			System.out.println("Signed out successfuly and on home page");
		}
		
		assertTrue(bfd.getText().equals("Built for developers"));
		
		//go to google
		webdriver.get("https://google.com");
		//load cookie		
		loadCookie();
//		webdriver.navigate().refresh();
		
		webdriver.get(url);
		
		webdriver.navigate().refresh();
		
		//webdriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		//actionthingy.moveToElement(lgnfield).sendKeys("HashimAli1996").perform();
		
	}
	

	public void createCookie() {

		File f;
		BufferedWriter buf = null;

		try {
			f = new File("browser.data");
			
			f.delete();
			f.createNewFile();
			buf = new BufferedWriter(new FileWriter(f));

			for (Cookie ck : webdriver.manage().getCookies()) {
				buf.write(ck.getName() + ";" + ck.getValue() + ";" + ck.getDomain() + ";" + ck.getPath() + ";"
						+ ck.getExpiry() + ";" + ck.isSecure());
				
				System.out.println(ck.getName() + ";" + ck.getValue() + ";" + ck.getDomain() + ";" + ck.getPath() + ";"
						+ ck.getExpiry() + ";" + ck.isSecure());
				buf.newLine();
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (buf != null) {
					buf.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
	
	
	public void loadCookie() {

		try {
			File f = new File("browser.data");
			BufferedReader br = new BufferedReader(new FileReader(f));
			String line;

			while ((line = br.readLine()) != null) {
				StringTokenizer str = new StringTokenizer(line, ";");
				while (str.hasMoreTokens()) {
					String name = str.nextToken();
					String value = str.nextToken();
					String domain = str.nextToken();
					String path = str.nextToken();
					Date expiry = null;
					String dt;

					if (!(dt = str.nextToken()).equals("null")) {
						expiry = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy").parse(dt);
					}
					boolean isSecure = new Boolean(str.nextToken()).booleanValue();
					Cookie ck = new Cookie(name, value, domain, path, expiry, isSecure);
					//System.out.println(ck.toString());
					webdriver.manage().addCookie(ck);
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}



	}
}
