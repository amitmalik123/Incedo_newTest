package com.amk.cucumber.driver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.amk.cucumber.utility.ConfigReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EdgeDriverManager extends DriverManager {

    public EdgeDriverManager(ConfigReader configReader) {
        super(configReader);
        this.driverLocation = configReader.get_DriverLocation(DriverManagerFactory.DriverType.EDGE);
    }

    @Override
    protected void createWebDriver() {      

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_settings.popups", 0);
        prefs.put("download.default_directory", downloadsFolderPath);
        prefs.put("download.prompt_for_download", false);
//        prefs.put("profile.default_content_setting_values.cookies", 2);
        
        EdgeOptions options = new EdgeOptions();	
        options.addArguments("enable-automation");
        options.setExperimentalOption("prefs", prefs); 
        options.setExperimentalOption("useAutomationExtension", false);
        options.addArguments("--remote-allow-origins=*");
        DesiredCapabilities cap = new DesiredCapabilities();

        cap.setCapability("ms:edgeChrominum", true);
   //     cap.setCapability("ms:edgeOptions", edgeOptions);
        cap.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        options.merge(cap);

        if (executionType.equalsIgnoreCase("REMOTE")) {
            cap.setCapability("os", "Windows");
            cap.setCapability("os_version", "10");
            cap.setCapability("browser", "Edge");
            cap.setCapability("browser_version", "latest");      
            cap.setCapability("browserstack.local", "true");
            cap.setCapability("browserstack.selenium_version", "3.141.59");
            cap.setCapability("browserstack.debug", "true");
            cap.setCapability("applicationCacheEnabled", false);
            cap.setCapability("resolution", "1920x1080");

            try {
                driver=new RemoteWebDriver(new URL(remoteMachineURL), cap);
            } catch (MalformedURLException e) {
                LOG.error("Malformed URL Exception", e.getMessage());
            }
        } else if (executionType.equalsIgnoreCase("LOCAL_DESKTOP")) {        
        	WebDriverManager.edgedriver().setup();  
            driver=new EdgeDriver(options);
        }
        cap.setBrowserName("EDGE");
        driver.manage().window().maximize();
    }
}