package com.amk.cucumber.driver;


import com.amk.cucumber.utility.ConfigReader;

public class DriverManagerFactory {

    public enum DriverType {
        CHROME,
        CHROME_HEADLESS,
        IE,
        FIREFOX,
        EDGE,
        OPERA,
        IPHONE,
        IPAD,
        SAFARI,
    }

    public static DriverManager getDriverManager(ConfigReader configReader) {
        DriverManager driverManager;

        String property = configReader.get_Browser(); 
        
        //    String property = System.getProperty("browser");
        if (property == null) {
            property = "CHROME";
        }
        property = property.toUpperCase();

        DriverType driverType = DriverType.valueOf(property);
        switch (driverType) {
            case CHROME:
                driverManager = new ChromeDriverManager(configReader);
                break;
            case FIREFOX:
                driverManager = new FirefoxDriverManager(configReader);
                break;
            case EDGE:
                driverManager = new EdgeDriverManager(configReader);
                break;            
            default:
                driverManager = new ChromeDriverManager(configReader);
                break;
        }
        return driverManager;
    }
}
