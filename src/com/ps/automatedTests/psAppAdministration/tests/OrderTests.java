package com.ps.automatedTests.psAppAdministration.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import com.ps.automatedTests.psAppAdministration.utils.TestSetupUtil;

public class OrderTests {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
	  driver = TestSetupUtil.InitializeWebDriver(driver);
	  TestSetupUtil.ExecuteUserLogin(driver);
  }

  @Test
  public void testFindOrderAndSetMailsHaltTo() throws Exception {
    driver.findElement(By.xpath("(//a[contains(text(),'OrderController')])[5]")).click();
    driver.findElement(By.linkText("Filter")).click();
    new Select(driver.findElement(By.id("filter.op.state"))).selectByVisibleText("Equal To");
    new Select(driver.findElement(By.id("state"))).selectByVisibleText("128");
    driver.findElement(By.name("_action_filter")).click();
    driver.findElement(By.linkText("166517149")).click();
    driver.findElement(By.linkText("Kundenprofil")).click();
    driver.findElement(By.linkText("Transaktionen")).click();
    driver.findElement(By.linkText("Folgebestellungen")).click();
    driver.findElement(By.linkText("bearbeiten")).click();
    new Select(driver.findElement(By.id("customer.mailsHaltTo_day"))).selectByVisibleText("11");
    new Select(driver.findElement(By.id("customer.mailsHaltTo_month"))).selectByVisibleText("August");
    new Select(driver.findElement(By.id("customer.mailsHaltTo_year"))).selectByVisibleText("2015");
    driver.findElement(By.name("_action_update")).click();
    driver.findElement(By.linkText("Bestelldetails")).click();
    driver.findElement(By.linkText("Changelog")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
