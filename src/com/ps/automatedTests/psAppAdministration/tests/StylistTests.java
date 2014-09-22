package com.ps.automatedTests.psAppAdministration.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import com.ps.automatedTests.psAppAdministration.utils.TestSetupUtil;

public class StylistTests {
  private static WebDriver driver;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = TestSetupUtil.InitializeWebDriver(driver);
    TestSetupUtil.ExecuteUserLogin(driver);
  }

  @Test
  public void testStylistMakeCallable() throws Exception {
    driver.findElement(By.xpath("(//a[contains(text(),'StylelistController')])[3]")).click();
    driver.findElement(By.linkText("1535582")).click();
    driver.findElement(By.linkText("Edit Stylelist")).click();
    driver.findElement(By.id("balancerEnabled")).click();
    driver.findElement(By.id("callable")).click();
    driver.findElement(By.name("_action_update")).click();
    driver.findElement(By.className("alert-info")).getText().equals("Stylelist 1,535,582 updated");
  }
  
  /**@Test
  public void testMakeNewStylist() throws Exception {
	    /**driver.findElement(By.xpath("(//a[contains(text(),'StylelistController')])[3]")).click();
	    driver.findElement(By.linkText("1535582")).click();
	    driver.findElement(By.linkText("Edit Stylelist")).click();
	    driver.findElement(By.id("balancerEnabled")).click();
	    driver.findElement(By.id("callable")).click();
	    driver.findElement(By.name("_action_update")).click();
	  }**/

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
