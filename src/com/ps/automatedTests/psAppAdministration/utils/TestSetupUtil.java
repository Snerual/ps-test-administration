package com.ps.automatedTests.psAppAdministration.utils;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestSetupUtil {

	private static String BROWSERDRIVER = "CHROME"; 
	
	public static WebDriver InitializeWebDriver(WebDriver driver) throws Exception {
		if (BROWSERDRIVER == "CHROME") {
			System.setProperty("webdriver.chrome.driver", "/home/laurens/workspace/ps-test-administration/selenium-2.43.1/chromedriver");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			return driver;
		}
		else {
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			return driver;
		}
	}
	
	

}

