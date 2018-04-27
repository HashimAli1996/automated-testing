package testingProject.testingProjectArtifact;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class HashCookie {

	String url;
	WebDriver driver;
	ExtentReports report;
	ExtentTest test;

	@Before
	public void setup() {

		report = new ExtentReports("C:\\Users\\Administrator\\Desktop\\EclipseWorkspace\\testingProjectArtifact\\cookie_test.html"
				, true);

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		url = "https://github.com/";

	}

	@After
	public void teardown() throws InterruptedException {
		//Thread.sleep(3000);
		//driver.quit();
	}

	@Test
	public void cookieTest() {
		
		login();
		createCookie();
		logout();

		driver.get("https://www.google.co.uk/");
		
		loadCookie();
	}

	public void login() {
		
		test = report.startTest("Verify login");

		driver.get(url);

		WebElement signinbtn = driver.findElement(By.xpath("/html/body/div[1]/header/div/div[2]/div/span/div/a[1]"));
		
		Actions actionthingy = new Actions(driver);
		actionthingy.moveToElement(signinbtn).click().perform();

		
		WebElement lgnfield = driver.findElement(By.xpath("//*[@id=\"login_field\"]"));
		WebElement pwfield = driver.findElement(By.xpath("//*[@id=\"password\"]"));
		WebElement seyebtn = driver.findElement(By.xpath("//*[@id=\"login\"]/form/div[3]/input[3]"));
		
		lgnfield.sendKeys("HashimAli1996");
		pwfield.sendKeys("Batman65523");
		actionthingy.moveToElement(seyebtn).click().perform();

		test.log(LogStatus.INFO, "Attempted to login");

		checkLogin();

		report.endTest(test);
		report.flush();
	}

	public void createCookie() {

		File f;
		BufferedWriter buf = null;

		try {
			f = new File("browser.data");
			f.delete();
			f.createNewFile();
			buf = new BufferedWriter(new FileWriter(f));

			for (Cookie ck : driver.manage().getCookies()) {
				buf.write(ck.getName() + ";" + ck.getValue() + ";" + ck.getDomain() + ";" + ck.getPath() + ";"
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

	public void logout() {
		test = report.startTest("Verify logout");
		Actions actionthingy = new Actions(driver);

		WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"user-links\"]/li[3]/details/summary/span"));
		WebElement signout = driver.findElement(By.xpath("//*[@id=\"user-links\"]/li[3]/details/ul/li[9]/form/button"));
		actionthingy.moveToElement(dropdown).click().perform();
		actionthingy.moveToElement(signout).click().perform();

		test.log(LogStatus.INFO, "Attempted to logout");

		checkLogout();

		report.endTest(test);
		report.flush();
	}

	public void loadCookie() {

		test = report.startTest("Cookie login");

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
					driver.manage().addCookie(ck);
				}
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}

		test.log(LogStatus.INFO, "Attempted to login with cookie");

		driver.get(url);
		checkLogin();

		report.endTest(test);
		report.flush();
	}

	public void checkLogin() {

		driver.findElement(By.xpath("//*[@id=\"user-links\"]/li[3]/details/summary/span")).click();

		String bodyText = driver.findElement(By.xpath("//*[@id=\"user-links\"]/li[3]/details/ul/li[1]")).getText();

		if (bodyText.contains("HashimAli1996")) {
			test.log(LogStatus.PASS, "Login valid");
		} else {
			test.log(LogStatus.FAIL, "Login failed");
		}
	}

	public void checkLogout() {
		
		WebElement bfd = driver.findElement(By.xpath("/html/body/div[4]/div[1]/div/div/div[1]/h1"));

		if(bfd.getText().equals("Built for developers")) {
			test.log(LogStatus.PASS, "Logout valid");
		} else {
			test.log(LogStatus.FAIL, "Logout failed");
		}
	}

}