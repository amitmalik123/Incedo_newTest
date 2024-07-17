package com.amk.cucumber.driver;

import java.net.MalformedURLException;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.Proxy;

import com.amk.cucumber.utility.ConfigReader;
//import com.epam.healenium.SelfHealingDriver;

public class ChromeDriverManager extends DriverManager {

	public ChromeDriverManager(ConfigReader configReader) {
		super(configReader);
		this.driverLocation = configReader.get_DriverLocation(DriverManagerFactory.DriverType.CHROME);
	}

	@Override
	protected void createWebDriver() {
		ChromeOptions chromeOptions = new ChromeOptions();

		Map<String, Object> chromePref = new HashMap<>();
		chromePref.put("credentials_enable_service", false);
		chromePref.put("profile.password_manager_enabled", false);
		chromePref.put("profile.default_content_settings.popups", 0);
		chromePref.put("download.default_directory", downloadsFolderPath);
		chromePref.put("download.prompt_for_download", false);
		chromePref.put("profile.default_content_settings.popups", 0);
		chromePref.put("profile.default_content_setting_values.plugins", 1);
		chromePref.put("profile.content_settings.plugin_whitelist.adobe-flash-player", 1);
		chromePref.put("safebrowsing.enabled", true);
		chromePref.put("plugins.always_open_pdf_externally", false);
		chromePref.put("plugins.plugins_disabled", "Chrome PDF Viewer");
		Map<String, Object> contentSettings = new HashMap<String, Object>();

		// 0 - Default, 1 - Allow, 2 - Block
		contentSettings.put("geolocation", 2);
		contentSettings.put("notifications", 2);
		chromePref.put("managed_default_content_settings", contentSettings);

		chromeOptions.setExperimentalOption("prefs", chromePref);
		chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		chromeOptions.addArguments("disable-infobars");
		chromeOptions.addArguments("start_maximized");
		chromeOptions.addArguments("enable_automation");
		chromeOptions.addArguments("--no-sandbox");
		chromeOptions.addArguments("enable_automation");
		chromeOptions.addArguments("disable-infobars");
		chromeOptions.addArguments("--disable-dev-shm-usage");
		chromeOptions.addArguments("--disable-browser-side-navigation");
		chromeOptions.setExperimentalOption("detach", true);
		chromeOptions.addArguments("--password-store=basic");
		chromeOptions.addArguments("--log-level=1");
		chromeOptions.addArguments("--remote-allow-origins=*");
		// chromeOptions.addArguments("--auto-open-devtools-for-tabs");
		// chromeOptions.addArguments("--incognito");
//		chromeOptions.addArguments("--headless=new");

		DesiredCapabilities cap = new DesiredCapabilities();
		HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
		cap.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		cap.setCapability("applicationCacheEnabled", false);
		
		// next three lines of code is for grid execution
		/*
		 * Proxy proxy = new Proxy(); proxy.setHttpProxy("http://172.29.33.5:4444");
		 * cap.setCapability("proxy", proxy);
		 */

		switch (executionType) {

		case "REMOTE_DESKTOP":
			LOG.info("Execution type : REMOTE DESKTOP");
			cap.setCapability("browserName", "Chrome");
			browserstackOptions.put("os", "Windows");
			browserstackOptions.put("osVersion", "10");
			browserstackOptions.put("browserVersion", "latest");
			browserstackOptions.put("projectName", "BAW");
			browserstackOptions.put("consoleLogs", "verbose");
			browserstackOptions.put("networkLogs", "true");
			browserstackOptions.put("seleniumVersion", "4.6.0");
			browserstackOptions.put("local", "true");
			browserstackOptions.put("debug", "true");
			cap.setCapability("bstack:options", browserstackOptions);
			try {
				driver = new RemoteWebDriver(new URL(remoteMachineURL), cap);
			} catch (MalformedURLException e) {
				LOG.error("Malformed URL Exception", e.getMessage());
			}
			break;
		case "REMOTE_MOBILE":
			LOG.info("Execution type : REMOTE MOBILE");
			browserstackOptions.put("browserName", "chrome");
//			browserstackOptions.put("deviceName", "Google Pixel 6 Pro");
//			browserstackOptions.put("osVersion", "13");
//			browserstackOptions.put("deviceName", "Samsung Galaxy S20");
//			browserstackOptions.put("osVersion", "10.0");
			browserstackOptions.put("osVersion", "16");
			browserstackOptions.put("deviceName", "iPhone 14");
			browserstackOptions.put("projectName", "BAW");
			browserstackOptions.put("realMobile", "true");
			browserstackOptions.put("networkLogs", "true");
			browserstackOptions.put("deviceOrientation", "portrait");
			browserstackOptions.put("local", "true");
			browserstackOptions.put("debug", "true");
			LOG.info("the capability list is :" + browserstackOptions);
			cap.setCapability("bstack:options", browserstackOptions);
			try {
				driver = new RemoteWebDriver(new URL(remoteMachineURL), cap);
			} catch (MalformedURLException e) {
				LOG.error("Malformed URL Exception", e.getMessage());
			}
			break;
		case "LOCAL_MOBILE":
		case "LOCAL_DESKTOP":
			// WebDriverManager.chromedriver().setup();

			chromeOptions.merge(cap);
			// System.setProperty("webdriver.chrome.driver", driverLocation);
			driver = new ChromeDriver(chromeOptions);

			// SelfHealingDriver driver = SelfHealingDriver.create(delegate);
			// devTools();
			break;
		default:
			break;
		}
		driver.manage().window().maximize();
	}

	/*
	 * public void devTools() {
	 * 
	 * DevTools d1= ((ChromeDriver)driver).getDevTools();
	 * 
	 * d1.createSession();
	 * 
	 * if (executionType.equalsIgnoreCase("LOCAL_MOBILE")) {
	 * 
	 * d1.send(Emulation.setDeviceMetricsOverride(390, 844, 50, true,
	 * Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(),
	 * Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(),
	 * Optional.empty())); } d1.send(Network.enable( Optional.empty(),
	 * Optional.empty(), Optional.empty()));
	 * 
	 * 
	 * d1.addListener(Network.requestWillBeSent(), request -> {
	 * System.out.println(request.getRequest().getUrl());
	 * System.out.println(request.getRequest().getMethod());
	 * System.out.println(request.getRedirectResponse()); });
	 * 
	 * 
	 * 
	 * d1.addListener(Network.responseReceived(), response ->{ Response res=
	 * response.getResponse();
	 * 
	 * // if(res.getUrl().contains("ewealthmanager.com") &&
	 * (!res.getStatus().toString().startsWith("2")) ) {
	 * System.err.println("reponse url is "+res.getUrl() +" & status is " +
	 * res.getStatus()); // } }); }
	 */

}
