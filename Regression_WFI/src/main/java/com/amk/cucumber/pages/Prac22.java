package com.amk.cucumber.pages;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Prac22 {	
	
	static String a= "https://test12.ewealthmanager.com/Documents/View/DownloadCombinedDocuments?documentsList.HistoryReportId=6646926&documentsList.ClientId=W1J6VY&documentsList.IncludeAED=True&documentsList.IncludeLGL=True.pdf";
	
	public Prac22() {
		System.out.println("prac22 cons");
	}
	
	String b="Prac22";
	
	public static void main(String[] args) throws IOException {
		DesiredCapabilities cap = new DesiredCapabilities();		
		cap.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
		cap.setCapability("applicationCacheEnabled", false);
		ChromeOptions chromeoptions= new ChromeOptions();
		chromeoptions.merge(cap);
		WebDriver driver = new ChromeDriver(chromeoptions);
		driver.get(a);
		
		URL pdfurl= new URL(a);
		URLConnection urlconnection=  pdfurl.openConnection();
		urlconnection.addRequestProperty("User-Agent", "Mozilla");
		
	//	InputStream st= pdfurl.openStream();
		
		InputStream st= urlconnection.getInputStream();
		BufferedInputStream bts= new BufferedInputStream(st);
		PDDocument pdDoc= PDDocument.load(bts);
		
		pdDoc.getCurrentAccessPermission();
		
		int pageCount =pdDoc.getNumberOfPages();
		System.out.println(pageCount);
		
		PDFTextStripper textStripper= new PDFTextStripper();
		String pdfdata= textStripper.getText(pdDoc);	
		
		System.out.println(pdfdata);
	}
	
	protected void mm() {
		System.out.println("this is prac22 class");		
	}

	public Object abc(String a) {
		System.out.println("method abc of Prac22 class");
		return null;
	}
}
