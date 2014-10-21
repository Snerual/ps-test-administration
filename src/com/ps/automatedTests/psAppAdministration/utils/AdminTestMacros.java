package com.ps.automatedTests.psAppAdministration.utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AdminTestMacros {
	
	public static void ExecuteUserLogin(WebDriver driver) throws Exception {
	    String baseUrl = "http://staging.ps-app-administration.apps.outfittery.de";

	    driver.get(baseUrl + "/login/auth");
	    driver.findElement(By.name("j_username")).clear();
	    driver.findElement(By.name("j_username")).sendKeys("3paul@outfittery.de");
	    driver.findElement(By.name("j_password")).clear();
	    driver.findElement(By.name("j_password")).sendKeys("a");
	    driver.findElement(By.id("submit")).click();
	  }
	
	public static void FindOrderByState(WebDriver driver, String orderState) throws Exception {
		driver.findElement(By.linkText("Filter")).click();
	    new Select(driver.findElement(By.id("filter.op.state"))).selectByVisibleText("Equal To");
	    new Select(driver.findElement(By.id("state"))).selectByVisibleText(orderState);
	    driver.findElement(By.name("_action_filter")).click();
	    GetFirstLinkInResultList(driver).click();
	}
	
	public static WebElement GetFirstLinkInResultList(WebDriver driver){
		WebElement orderTable = driver.findElement(By.className("table-bordered"));
		List<WebElement> orderTableRows = orderTable.findElements(By.tagName("tr"));
		return orderTableRows.get(2).findElement(By.cssSelector("a[href*='/order/show/']"));
	}
}
