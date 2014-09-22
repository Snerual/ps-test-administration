package com.ps.automatedTests.psAppAdministration.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestSetupUtil {

	public static void ExecuteUserLogin(WebDriver driver) throws Exception {
	    String baseUrl = "http://staging.ps-app-administration.apps.outfittery.de";

	    driver.get(baseUrl + "/login/auth");
	    driver.findElement(By.name("j_username")).clear();
	    driver.findElement(By.name("j_username")).sendKeys("3paul@outfittery.de");
	    driver.findElement(By.name("j_password")).clear();
	    driver.findElement(By.name("j_password")).sendKeys("a");
	    driver.findElement(By.id("submit")).click();
	  }
	public static WebDriver InitializeWebDriver(WebDriver driver) throws Exception {
		System.setProperty("webdriver.chrome.driver", "/home/laurens/workspace/OutfitterySelenium/selenium-2.43.1/chromedriver");
		driver = new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}

}

