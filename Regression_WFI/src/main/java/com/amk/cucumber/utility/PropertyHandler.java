package com.amk.cucumber.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class PropertyHandler {
	
	private static Properties configProp;
	
	public static Properties loadpropertyFile(String fileName)
	{
		configProp = new Properties();
		try {
			
			configProp.load(new FileInputStream(new File(System.getProperty("user.dir")
					+ "/src/test/resources/propertiesFiles/config.properties")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return configProp;
		
	}
	
	public static String getproprty(String key)
	{
		return configProp.getProperty(key);
				
		
	}

}
