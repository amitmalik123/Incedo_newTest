package com.amk.cucumber.driver;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amk.cucumber.utility.ConfigReader;

import lombok.Getter;
import lombok.Setter;

public abstract class DriverManager {

    protected static final Logger LOG = LoggerFactory.getLogger(DriverManager.class.getName());

    @Getter
    @Setter
    protected String executionType;

    @Getter
    @Setter
    protected String downloadsFolderPath;

    @Getter
    @Setter
    protected String remoteMachineURL;

    @Getter
    @Setter
    protected String driverLocation;

    protected WebDriver driver;

    protected abstract void createWebDriver();

    public DriverManager(ConfigReader configReader) {
        this.executionType = configReader.get_ExecutionType();
        this.remoteMachineURL = configReader.get_Remote_Machine_URL();
        this.downloadsFolderPath = configReader.get_DownloadLocation();
    }

    /**
     * To quite the WebDriver object
     */
    public synchronized void quitWebDriver() {
        if (driver != null) {
            driver.quit();         
        }
    }

    /**
     * To get the WebDriver object
     *
     * @return
     */
    public synchronized WebDriver getWebDriver() {
        if (driver == null) {
            createWebDriver();
        }
        return driver;
    }
}
