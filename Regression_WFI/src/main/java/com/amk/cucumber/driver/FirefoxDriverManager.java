package com.amk.cucumber.driver;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.amk.cucumber.utility.ConfigReader;

public class FirefoxDriverManager extends DriverManager {

    public FirefoxDriverManager(ConfigReader configReader) {
        super(configReader);
        this.driverLocation = configReader.get_DriverLocation(DriverManagerFactory.DriverType.FIREFOX);
    }

    @Override
    protected void createWebDriver() {
        FirefoxOptions options = new FirefoxOptions();

        options.addArguments("--disable-infobars");
        options.addArguments("--start_maximized");
        options.addArguments("--enable_automation");
        options.addArguments("--no-sandbox");
        options.addArguments("--enable_automation");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-browser-side-navigation");
        options.addArguments("--disable-gpu");

        options.addPreference("browser.download.folderList", 2);
        options.addPreference("browser.helperApps.alwaysAsk.force", false);
        options.addPreference("browser.download.dir", downloadsFolderPath);
        options.addPreference("browser.download.defaultFolder", downloadsFolderPath);
        options.addPreference("browser.download.manager.showWhenStarting", false);
        options.addPreference("browser.helperApps.neverAsk.saveToDisk", "multipart/x-zip,application/zip,application/x-zip-compressed,application/x-compressed,application/msword,application/csv,text/csv,image/png ,image/jpeg, application/pdf, text/html,text/plain,  application/excel, application/vnd.ms-excel, application/x-excel, application/x-msexcel, application/octet-stream");

        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
     //   cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
   //     cap.setCapability("moz:firefoxOptions", options);
        options.merge(cap);
        if (executionType.equalsIgnoreCase("REMOTE")) {
            cap.setCapability("os", "Windows");
            cap.setCapability("os_version", "11");
            cap.setCapability("browser", "Firefox");
            cap.setCapability("browser_version", "latest");
    //        cap.setCapability("name", Reporter.getCurrentTestResult().getTestContext().getAttribute("Test_Name"));
            cap.setCapability("browserstack.local", "true");
            cap.setCapability("browserstack.selenium_version", "3.141.59");
            cap.setCapability("browserstack.debug", "true");
            cap.setCapability("applicationCacheEnabled", false);
            cap.setCapability("resolution", "1920x1080");

            try {
                this.driver=new RemoteWebDriver(new URL(remoteMachineURL), cap);
            } catch (MalformedURLException e) {
                LOG.error("Malformed URL Exception", e.getMessage());
            }
        } else if (executionType.equalsIgnoreCase("LOCAL")) {
            System.setProperty("webdriver.gecko.driver", driverLocation);
            this.driver=new FirefoxDriver(options);
        }
        cap.setBrowserName("FIREFOX");
        this.driver.manage().window().maximize();
    }
}
