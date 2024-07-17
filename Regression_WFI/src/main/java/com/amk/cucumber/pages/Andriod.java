package com.amk.cucumber.pages;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;

public class Andriod {

//  private AndroidDriver driver;
  
  private AppiumDriver driver;

  @Before
  public void setUp() throws MalformedURLException {
    DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
    desiredCapabilities.setCapability("platformName", "Android");
    desiredCapabilities.setCapability("appium:deviceName", "Google Pixel 3");
    desiredCapabilities.setCapability("appium:os_version", "9.0");
    desiredCapabilities.setCapability("appium:app", "bs://925fe0eb505097eafa4e5d0275625c88ce60e4a9");
    desiredCapabilities.setCapability("appium:ensureWebviewsHavePages", true);
    desiredCapabilities.setCapability("appium:nativeWebScreenshot", true);
 //   desiredCapabilities.setCapability("bstack:options", {"source":"appiumdesktop"});
    desiredCapabilities.setCapability("appium:newCommandTimeout", 3600);
    desiredCapabilities.setCapability("appium:connectHardwareKeyboard", true);

    URL remoteUrl = new URL("https://maheshkurnool_rtwOGI:smVsaDyJouwyA81pzneq@hub-cloud.browserstack.com:443/wd/hub");

//    driver = new AndroidDriver(remoteUrl, desiredCapabilities);
    
    driver = new AppiumDriver(remoteUrl, desiredCapabilities);
  }

  @Test
  public void sampleTest() {
	  WebElement ele1= driver.findElement(By.xpath("//android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View"));
	  boolean elemn= ele1.isDisplayed();
	  System.out.println(elemn);
	  WebElement ele2=  driver.findElement(By.xpath("//android.view.View/android.view.View[2]/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View/android.widget.Button[3]"));
	  ele2.click();
	  WebElement ele3=  driver.findElement(By.xpath("//android.view.View/android.view.View/android.view.View[1]/android.view.View[2]/android.view.View[2]/android.view.View/android.view.View[1]/android.widget.EditText[1]"));
	  ele3.sendKeys("sampleagent1");
	  WebElement ele4=  driver.findElement(By.xpath("//android.view.View/android.view.View/android.view.View[1]/android.view.View[2]/android.view.View[2]/android.view.View/android.view.View[1]/android.widget.EditText[2]"));
	  ele4.sendKeys("Test1234t");
	  WebElement ele5=  driver.findElement(By.xpath("//android.view.View/android.view.View/android.view.View[1]/android.view.View[2]/android.view.View[2]/android.view.View/android.view.View[1]/android.widget.Button"));
	  ele5.click();
  }

  @After
  public void tearDown() {
    driver.quit();
  }
}
