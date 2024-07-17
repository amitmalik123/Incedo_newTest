package com.amk.cucumber.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import com.amk.cucumber.driver.DriverManagerFactory;

import lombok.Getter;
import lombok.Setter;

public class ConfigReader {

    @Getter
    @Setter
    private Integer _Max_Wait_Time = null;

    @Getter
    @Setter
    private Integer _Min_Wait_Time = null;

    @Getter
    @Setter
    private Integer _Poll_Time = null;

    @Getter
    @Setter
    private String _ExecutionType = null;

    @Getter
    @Setter
    private String _Remote_Machine_URL = null;

    @Getter
    @Setter
    private String _Report_Folder_Path = null;

    @Getter
    @Setter
    private static String configFilePath = System.getProperty("user.dir") + File.separator
	+ "src/test/resources/propertiesFiles/" + "config.properties";

    @Setter
    private String _DriverLocation = null;

    @Getter
    @Setter
    private String _DownloadLocation = null;

    @Getter
    @Setter
    private String _Application_URL = null;

    @Getter
    @Setter
    private String _Application_Username = null;

    @Getter
    @Setter
    private String _Application_Password = null;

    @Getter
    @Setter
    private String _DB_EWM_HostName = null;  

    @Getter
    @Setter
    private String _DB_EWM_UserName = null;
    
    @Getter
    @Setter
    private String _DB_EWM_Password = null;
    
    @Getter
    @Setter
    private String _DB_BPM_HostName = null;
    
    @Getter
    @Setter
    private String _DB_BPM_UserName = null;
    
    @Getter
    @Setter
    private String _DB_BPM_Password = null;

    @Getter
    @Setter
    private String _BawApplication_Username = null;

    @Getter
    @Setter
    private String _BawApplication_Password = null;

    @Getter
    @Setter
    private String _BawApplication_URL = null;
    
    @Getter
    @Setter
    private String _REMOTE_USER_NAME = null;
    
    @Getter
    @Setter
    private String _REMOTE_ACCESS_KEY = null;

    @Getter
    private Properties reader;
    
    @Getter
    @Setter
    private String _OcwApplication_URL = null;
    
    @Getter
    @Setter
    private String _Browser = null;

    /**
     * To read the framework config.json file from the given path
     *
     * @param filePath
     */
    public ConfigReader(String filePath) {
    	try {
			reader = new Properties();
			FileInputStream input = new FileInputStream(filePath);
			reader.load(input);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        this._Max_Wait_Time = Integer.parseInt(reader.getProperty("MAX_WAIT_TIME"));
		this._Min_Wait_Time = Integer.parseInt(reader.getProperty("MIN_WAIT_TIME"));
		this._Poll_Time = Integer.parseInt(reader.getProperty("POLL_TIME"));
        this._ExecutionType = reader.getProperty("EXECUTIONTYPE");
        this._Remote_Machine_URL = reader.getProperty("REMOTE_MACHINE_URL");
        this._Report_Folder_Path = reader.getProperty("REPORT_FOLDER_PATH");
        this._Application_URL = reader.getProperty("ENVIRONMENT_DETAILS.URL");
        this._Application_Username = reader.getProperty("ENVIRONMENT_DETAILS.USERNAME");
        this._Application_Password = reader.getProperty("ENVIRONMENT_DETAILS.PASSWORD");
        this._DownloadLocation = System.getProperty("user.dir") + File.separator
                + reader.getProperty("DOWNLOAD_FOLDER");

        this._BawApplication_URL = reader.getProperty("BAW_ENVIRONMENT_URL");
        this._BawApplication_Username = reader.getProperty("BAW_ENVIRONMENT_DETAILS.USERNAME");
        this._BawApplication_Password = reader.getProperty("BAW_ENVIRONMENT_DETAILS.PASSWORD");
        this._DB_EWM_HostName = reader.getProperty("ENVIRONMENT_DETAILS.DBEWM_HOSTNAME");
        this._DB_EWM_UserName = reader.getProperty("ENVIRONMENT_DETAILS.DBEWM_USERNAME");
        this._DB_EWM_Password = reader.getProperty("ENVIRONMENT_DETAILS.DBEWM_PASSWORD");
        this._DB_BPM_HostName = reader.getProperty("ENVIRONMENT_DETAILS.DBBPM_HOSTNAME");
        this._DB_BPM_UserName = reader.getProperty("ENVIRONMENT_DETAILS.DBBPM_USERNAME");
        this._DB_BPM_Password = reader.getProperty("ENVIRONMENT_DETAILS.DBBPM_PASSWORD");
        
        this._REMOTE_USER_NAME = reader.getProperty("REMOTE_USER_NAME");
        this._REMOTE_ACCESS_KEY = reader.getProperty("REMOTE_ACCESS_KEY");
        this._OcwApplication_URL = reader.getProperty("OCW_ENVIRONMENT_URL");
        this._Browser = reader.getProperty("BROWSER");
    }

    /**
     * To read the framework config.json file from project folder
     */
    public ConfigReader() {
        this(configFilePath);
    }

    public String get_DriverLocation(DriverManagerFactory.DriverType driverType) {
        this._DriverLocation = System.getProperty("user.dir") + File.separator
                + reader.getProperty(driverType.toString().toUpperCase());
        return _DriverLocation;
    }
}
