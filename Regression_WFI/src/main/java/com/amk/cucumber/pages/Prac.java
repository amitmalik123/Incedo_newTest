package com.amk.cucumber.pages;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.Spliterator;
import java.util.stream.Collectors;

import javax.swing.filechooser.FileSystemView;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.jayway.jsonpath.JsonPath;




public class Prac implements Prac1 {


	public static void main(String[] args) throws IOException {
		/*
		 * SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		 * System.out.println(sdf.format(new Date()));
		 */
		/*
		 * String s= """ Amit Sumit vipin """;
		 	System.out.println(s);
		 	*/	
		/*
		 * String s= "inverstment minimium: $25,000.00";
		 * System.out.println(s.replaceAll("[,():$]", "")); String []
		 * s1=s.replaceAll("[,():$]", "").split("[.]"); for(String s2: s1) {
		 * System.out.println(s2); }
		 */
		
	//	Class.forName("Prac").getd
		
	//	Prac.class.getDeclaredConstructors().getClass().
	//	pdfR();
		ttr();
	//	dateCreation(0, "MMddyy");
	}
	
	public static void ttr() {
		ArrayList<Integer> iu= new ArrayList<Integer>(Arrays.asList(2,4,7));
		ArrayList<Integer> ip= new ArrayList<Integer>(Arrays.asList(5,8,1));
		
		Collections.reverse(iu); 
		Collections.reverse(ip);
		
		if(iu.size() == ip.size()   &&  iu.size()!=0   &&   ip.size()!=0) {
		for(int i=0;i<iu.size();i++) {
			int a= iu.get(i) + ip.get(i);
		}
		}
			System.out.println(iu);
		
	}
	
	public static void dateCreation(int days, String pattern) {
		LocalDate currentDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
	//	return currentDate.plusDays(days).format(formatter);
		System.out.println(currentDate.plusDays(days).format(formatter));
	}
	
	public static void dupl() {
		String s="my name is my amit name";
		String[] al= s.split(" ");
		Map<String,Integer> ss= new HashMap<String, Integer>();
		
		List<String> as= Arrays.asList(al);
		for(int i=0;i<as.size();i++) {
			int counter=1;
			for(int j=i+1;j<as.size()-1;j++) {
				if(as.get(i).equals(as.get(j))) {
					counter= counter+1;
				}
			}
			ss.put(as.get(i), counter);
		}
		Set<Map.Entry<String, Integer>> it= ss.entrySet();
		for(Map.Entry<String, Integer> is : it) {
			System.out.println("key is "+is.getKey() +" and occurance count is "+ is.getValue());
		}
	}
	public static void minMax() {
		int [] arr= {10,5,30,20};
		Set<String> j= new HashSet<>();
		HashMap<String, String> map = new HashMap<String, String>(); 
		map.put("A", "amit");
		map.put("B", "Sumit");
		j= map.keySet();
		Collection<String> cs= map.values();
		Set<Map.Entry<String, String>> se= map.entrySet();
		for(Map.Entry<String, String> enO : se) {
			
		}
		Iterator it= j.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		Map<Integer,String> lk= new LinkedHashMap<Integer, String>();
		for(int i=0;i<arr.length;i++) {
			
		}
	}
	
	//pending
	public static void sortString() {		
		char c1;
		String s= "GeeksForGeeks";		
		char [] c= s.toLowerCase().toCharArray();
		for(int i=0;i<c.length-1;i++) {	
			if(String.valueOf(c[i]).compareTo(String.valueOf(c[i+1]))<0) {				
				c1= c[i];
				c[i]=c[i+1];
				c[i+1]= c1;				
			}
		}
		for(int i=0;i<c.length;i++) {
			System.out.print(c[i]);
		}
	}
	
	public static void e2o() {		
		char c1;
		String s= "GeeksForGeeks";
		char [] c= s.toCharArray();
		for(int i=0;i<c.length-1;i=i+2) {
			if(i%2==0) {
				c1= c[i];
				c[i]=c[i+1];
				c[i+1]= c1;				
			}
		}
		for(int i=0;i<c.length;i++) {
			System.out.print(c[i]);
		}
	}
	
	public static void d2b() {
		int a=17,i=0;
		int [] b= new int[10];
		while(a>=1) {
			b[i]=a%2;
			a/=2;
			i++;
		}
		for(int j=i-1;j>=0;j--) {
			System.out.print(b[j]);
		}		
	}
	
	public static void fact() {
		int a= 9,b=1;
		while(a>=1) {
			b=b*a;
			a=a-1;
		}
		System.out.println(b);
	}
	public static void arm() {
		int a= 153;	
		int b=0,c=1;
		while(a>0) {
			c=a%10;
			b= b + c*c*c;
			a=a/10;
		}
		System.out.println(b);
	}
	
	public static void vow() {
		String s= "my name is";
		String s1= "aeiou";
		s=s.replaceAll("\\s", "");
		for(int i=0;i<s.length()-1;i++) {
			String sd = s1.indexOf(s.charAt(i))== -1 ? "constant" : "vowels";			
			System.out.println(s.charAt(i)+ " is " + sd);		
		}
	}
	
	public static void pal() {
		int a= 16461;	
		int b=0;
		while(a%10>0) {
			b= (b*10) + a%10;
			a=a/10;
		}
		System.out.println(b);
	}
	
	public static void fab() {
		int a=0,b=1;
		while(a+b<=50) {
			b=a+b;
			a=b-a;
			System.out.print(a);
		}
	}
	
	public static void prime() {
		int l=50, m=100;
		
		for(int i=l;i<=m;i++) {
			boolean b=true;
			for(int j=3;j<=i/2;j++) {
				if(i%j==0) {
					b= false;
					break;
				}
			}
			if(b) {
				System.out.println(i+" is not prime");
			}else {
				System.out.println(i+" is prime");
		}
		}
	}
	
	public static void star() {
		int l=4;
		for(int i=1;i<=l;i++) {
			for(int k=1;k<=l-i;k++) {
				System.out.print(" ");
			}
			for(int j=1;j<=i;j++) {
				System.out.print("* ");
			}
			System.out.print("\n");
		}
	}
	
	public static void prog3() {
		String s="my name is amit";
		String b="";
		String [] a= s.split(" ");
		for(int i=0;i<a.length;i++) {
			if(i%2!=0) {
				for(int j=a[i].length()-1;j>=0;j--) {
				b= b+ String.valueOf(a[i].charAt(j));
				}
				b+=" ";
			}else {
			b= b+ a[i]+" ";
			}
		}
		System.out.println(b);
		}
	public static void js() {
		
		        String json = "{\n" +
		                "    \"id\": \"C80517\",\n" +
		                "    \"fullHouseholdName\": \"BRUSZER, DON & MARIANNE\",\n" +
		                "    \"latestAccountNumber\": \"13806034\",\n" +
		                "    \"highestNameCounter\": 3,\n" +
		                "    \"accounts\": [\n" +
		                "        {\n" +
		                "            \"accountId\": \"AC0UD2\",\n" +
		                "            \"accountName\": \"Don & Marianne Bruszer, Joint Tenants with Rights of Survivorship\",\n" +
		                "            \"accountStrategy\": \"JPMorgan Absolute Return - Profile 1\",\n" +
		                "            \"accountStatus\": \"Funded\",\n" +
		                "            \"accountNumber\": \"11697600\",\n" +
		                "            \"modelId\": \"JFIAR2\",\n" +
		                "            \"modelName\": \"JPMorgan Absolute Return - Profile 1\",\n" +
		                "            \"shouldDisplay\": false,\n" +
		                "            \"legalAddress\": {\n" +
		                "                \"nameCounter\": 3,\n" +
		                "                \"hasAlternateMailingAddress\": true,\n" +
		                "                \"nameAndAddressLine1\": \"AUGUST EVAN &\",\n" +
		                "                \"nameAndAddressLine2\": \"NELL EVAN\",\n" +
		                "                \"nameAndAddressLine3\": \"JTWROS\",\n" +
		                "                \"nameAndAddressLine4\": \"4231 MEMORIAL DR\",\n" +
		                "                \"nameAndAddressLine5\": \"AVON MA                  ZIPCD\",\n" +
		                "                \"nameAndAddressLine6\": null,\n" +
		                "                \"city\": \"AVON\",\n" +
		                "                \"state\": \"MA\",\n" +
		                "                \"postalCode\": \"02322\",\n" +
		                "                \"postalCodeExtension\": \"1919\",\n" +
		                "                \"irsNameLines\": [\n" +
		                "                    \"1\"\n" +
		                "                ]\n" +
		                "            },\n" +
		                "            \"mailingAddress\": {\n" +
		                "                \"addressLine1\": \"1217 MEMORIAL DR\",\n" +
		                "                \"addressLine2\": null,\n" +
		                "                \"addressLine3\": null,\n" +
		                "                \"addressLine4\": null,\n" +
		                "                \"city\": \"AVON\",\n" +
		                "                \"state\": \"MA\",\n" +
		                "                \"postalCode\": \"02322\"\n" +
		                "            },\n" +
		                "            \"pledgedIndicator\": null,\n" +
		                "            \"typeofAccount\": null,\n" +
		                "            \"programId\": \"MF\",\n" +
		                "            \"retirementPlan\": null,\n" +
		                "            \"isIRAQualified\": false,\n" +
		                "            \"isDAF\": false,\n" +
		                "            \"isDeceased\": false,\n" +
		                "            \"isFraud\": false,\n" +
		                "            \"isFrozen\": false,\n" +
		                "            \"isNotFunded\": false,\n" +
		                "            \"isPledged\": false,\n" +
		                "            \"ageGroupOptions\": null,\n" +
		                "            \"stateRule\": null,\n" +
		                "            \"accountRMDInformation\": null,\n" +
		                "            \"isClosed\": true\n" +
		                "        },\n" +
		                "        {\n" +
		                "            \"accountId\": \"AC6HW5\",\n" +
		                "            \"accountName\": \"Don and Marianne Bruszer, Joint Tenants with Rights of Survivorship\",\n" +
		                "            \"accountStrategy\": \"GPS Accumulation, Profile 3, Moderate\",\n" +
		                "            \"accountStatus\": \"Funded\",\n" +
		                "            \"accountNumber\": \"10153511\",\n" +
		                "            \"modelId\": \"GPANS3\",\n" +
		                "            \"modelName\": \"GPS Accumulation, Profile 3, Moderate\",\n" +
		                "            \"shouldDisplay\": false,\n" +
		                "            \"legalAddress\": {\n" +
		                "                \"nameCounter\": 3,\n" +
		                "                \"hasAlternateMailingAddress\": true,\n" +
		                "                \"nameAndAddressLine1\": \"AUGUST EVAN &\",\n" +
		                "                \"nameAndAddressLine2\": \"NELL EVAN\",\n" +
		                "                \"nameAndAddressLine3\": \"JTWROS\",\n" +
		                "                \"nameAndAddressLine4\": \"4231 MEMORIAL DR\",\n" +
		                "                \"nameAndAddressLine5\": \"AVON MA                  ZIPCD\",\n" +
		                "                \"nameAndAddressLine6\": null,\n" +
		                "                \"city\": \"AVON\",\n" +
		                "                \"state\": \"MA\",\n" +
		                "                \"postalCode\": \"02322\",\n" +
		                "                \"postalCodeExtension\": \"1919\",\n" +
		                "                \"irsNameLines\": [\n" +
		                "                    \"1\"\n" +
		                "                ]\n" +
		                "            },\n" +
		                "            \"mailingAddress\": {\n" +
		                "                \"addressLine1\": \"1217 MEMORIAL DR\",\n" +
		                "                \"addressLine2\": null,\n" +
		                "                \"addressLine3\": null,\n" +
		                "                \"addressLine4\": null,\n" +
		                "                \"city\": \"AVON\",\n" +
		                "                \"state\": \"MA\",\n" +
		                "                \"postalCode\": \"02322\"\n" +
		                "            },\n" +
		                "            \"pledgedIndicator\": null,\n" +
		                "            \"typeofAccount\": null,\n" +
		                "            \"programId\": \"GPF\",\n" +
		                "            \"retirementPlan\": null,\n" +
		                "            \"isIRAQualified\": false,\n" +
		                "            \"isDAF\": false,\n" +
		                "            \"isDeceased\": false,\n" +
		                "            \"isFraud\": false,\n" +
		                "            \"isFrozen\": false,\n" +
		                "            \"isNotFunded\": false,\n" +
		                "            \"isPledged\": false,\n" +
		                "            \"ageGroupOptions\": null,\n" +
		                "            \"stateRule\": null,\n" +
		                "            \"accountRMDInformation\": null,\n" +
		                "            \"isClosed\": true\n" +
		                "        }\n" +
		                "    ],\n" +
		                "    \"hasDeceasedAccount\": false,\n" +
		                "    \"hasFraudAccount\": false,\n" +
		                "    \"hasDAFAccount\": false\n" +
		                "}";

		        // Extract movies where "Eva Green" is starring
	//	        Object result = JsonPath.read(json, "$[?(@.accounts[*] contains 'isClosed':true)]");
		        
		//        JsonPath jsonPath = new JsonPath(json.toString());
		        List<Map<String, Object>> result =  JsonPath.read(json, "$..accounts[?(@.isClosed == true)]");
		        if(result instanceof List) {
		        	System.out.println("instance is jsonObject");
		        }else if(result instanceof Map) {
		        	System.out.println("instance is jsonArray");
		        }else {
		        	System.out.println("instance is something different");
		        }
	}
	
	public static void sdr() {
		String jsonArrayString = "[{\"name\":\"John\",\"age\":30},{\"name\":\"Alice\",\"age\":25}]";

        // Convert JSONArray string to JSONArray
        JSONArray jsonArray = new JSONArray(jsonArrayString);
        
        JSONObject firstJsonObject= jsonArray.getJSONObject(0);

        // Convert JSONArray to JSONObject
		/*
		 * JSONObject jsonObject = new JSONObject(); jsonObject.put("data", jsonArray);
		 * // Assuming you want to store the JSONArray under a key "data"
		 */
        // Print the JSONObject
        System.out.println(firstJsonObject.toString());
	}
	
	public static void str(String ss) {
		String s1= "";
		String s="my name is" +ss;
		s1 = s1+s;
	}
	
	public static void jsonP() {
		
		
		 String jsonResponse = "[\r\n    {\r\n        \"accountId\": \"AI0WQ8\",\r\n        \"accountNumber\": 13351108,\r\n        \"accountName\": \"Walter D. Ackerman, III, Rollover IRA \",\r\n        \"bankInformation\": [\r\n            {\r\n                \"instructionNumber\": 2,\r\n                \"bankName\": \"KIKU #$BUKS20230913\",\r\n                \"bankAccountNumber\": \"******8318\",\r\n                \"customerName\": \"KIKS BANK#$ CUSTOMER NAME#$ 2\",\r\n                \"accountType\": \"Checking\",\r\n                \"abaRoutingNumber\": \"021000021\",\r\n                \"isFirstParty\": false,\r\n                \"isSLOA\": false,\r\n                \"shouldDisplay\": false,\r\n                \"isSelected\": false,\r\n                \"typeOfBeneficiary\": \"ThirdPartyDomesticIndividual\",\r\n                \"investmentAccounts\": [\r\n                    {\r\n                        \"accountName\": \"Walter D. Ackerman, III, Rollover IRA \",\r\n                        \"accountNumber\": 13351108,\r\n                        \"isFirstParty\": false\r\n                    }\r\n                ]\r\n            },\r\n            {\r\n                \"instructionNumber\": 3,\r\n                \"bankName\": \"KIKU #$BUKS20230913_1\",\r\n                \"bankAccountNumber\": \"******8318\",\r\n                \"customerName\": \"KIKS BANK#$ CUSTOMER NAME#$ 2\",\r\n                \"accountType\": \"Checking\",\r\n                \"abaRoutingNumber\": \"021000021\",\r\n                \"isFirstParty\": true,\r\n                \"isSLOA\": false,\r\n                \"shouldDisplay\": true,\r\n                \"isSelected\": false,\r\n                \"typeOfBeneficiary\": \"SameNameAndAddress\",\r\n                \"investmentAccounts\": [\r\n                    {\r\n                        \"accountName\": \"Walter D. Ackerman, III, Rollover IRA \",\r\n                        \"accountNumber\": 13351108,\r\n                        \"isFirstParty\": true\r\n                    },\r\n                    {\r\n                        \"accountName\": \"Walter D. Ackerman, III, Rollover IRA \",\r\n                        \"accountNumber\": 13351108,\r\n                        \"isFirstParty\": true\r\n                    },\r\n                    {\r\n                        \"accountName\": \"Walter D. Ackerman, III, Rollover IRA \",\r\n                        \"accountNumber\": 13351108,\r\n                        \"isFirstParty\": true\r\n                    },\r\n                    {\r\n                        \"accountName\": \"Walter D. Ackerman, III, Rollover IRA \",\r\n                        \"accountNumber\": 13351108,\r\n                        \"isFirstParty\": true\r\n                    },\r\n                    {\r\n                        \"accountName\": \"Walter D. Ackerman, III, Rollover IRA \",\r\n                        \"accountNumber\": 13351108,\r\n                        \"isFirstParty\": true\r\n                    },\r\n                    {\r\n                        \"accountName\": \"Walter D. Ackerman, III, Rollover IRA \",\r\n                        \"accountNumber\": 13351108,\r\n                        \"isFirstParty\": true\r\n                    }\r\n                ]\r\n            },\r\n            {\r\n                \"instructionNumber\": 4,\r\n                \"bankName\": \"KIKU #$BUKS20230913_1\",\r\n                \"bankAccountNumber\": \"******8318\",\r\n                \"customerName\": \"KIKS BANK#$ CUSTOMER NAME#$ 2\",\r\n                \"accountType\": \"Checking\",\r\n                \"abaRoutingNumber\": \"021000021\",\r\n                \"isFirstParty\": true,\r\n                \"isSLOA\": true,\r\n                \"shouldDisplay\": true,\r\n                \"isSelected\": false,\r\n                \"typeOfBeneficiary\": \"SameNameAndAddress\",\r\n                \"investmentAccounts\": [\r\n                    {\r\n                        \"accountName\": \"Walter D. Ackerman, III, Rollover IRA \",\r\n                        \"accountNumber\": 13351108,\r\n                        \"isFirstParty\": true\r\n                    },\r\n                    {\r\n                        \"accountName\": \"Walter D. Ackerman, III, Rollover IRA \",\r\n                        \"accountNumber\": 13351108,\r\n                        \"isFirstParty\": true\r\n                    },\r\n                    {\r\n                        \"accountName\": \"Walter D. Ackerman, III, Rollover IRA \",\r\n                        \"accountNumber\": 13351108,\r\n                        \"isFirstParty\": true\r\n                    },\r\n                    {\r\n                        \"accountName\": \"Walter D. Ackerman, III, Rollover IRA \",\r\n                        \"accountNumber\": 13351108,\r\n                        \"isFirstParty\": true\r\n                    },\r\n                    {\r\n                        \"accountName\": \"Walter D. Ackerman, III, Rollover IRA \",\r\n                        \"accountNumber\": 13351108,\r\n                        \"isFirstParty\": true\r\n                    },\r\n                    {\r\n                        \"accountName\": \"Walter D. Ackerman, III, Rollover IRA \",\r\n                        \"accountNumber\": 13351108,\r\n                        \"isFirstParty\": true\r\n                    }\r\n                ]\r\n            },\r\n            {\r\n                \"instructionNumber\": 5,\r\n                \"bankName\": \"KIKU #$BUKS20230913_1\",\r\n                \"bankAccountNumber\": \"******8318\",\r\n                \"customerName\": \"KIKS BANK#$ CUSTOMER NAME#$ 2\",\r\n                \"accountType\": \"Checking\",\r\n                \"abaRoutingNumber\": \"021000021\",\r\n                \"isFirstParty\": true,\r\n                \"isSLOA\": true,\r\n                \"shouldDisplay\": true,\r\n                \"isSelected\": false,\r\n                \"typeOfBeneficiary\": \"SameNameAndAddress\",\r\n                \"investmentAccounts\": [\r\n                    {\r\n                        \"accountName\": \"Walter D. Ackerman, III, Rollover IRA \",\r\n                        \"accountNumber\": 13351108,\r\n                        \"isFirstParty\": true\r\n                    },\r\n                    {\r\n                        \"accountName\": \"Walter D. Ackerman, III, Rollover IRA \",\r\n                        \"accountNumber\": 13351108,\r\n                        \"isFirstParty\": true\r\n                    },\r\n                    {\r\n                        \"accountName\": \"Walter D. Ackerman, III, Rollover IRA \",\r\n                        \"accountNumber\": 13351108,\r\n                        \"isFirstParty\": true\r\n                    },\r\n                    {\r\n                        \"accountName\": \"Walter D. Ackerman, III, Rollover IRA \",\r\n                        \"accountNumber\": 13351108,\r\n                        \"isFirstParty\": true\r\n                    },\r\n                    {\r\n                        \"accountName\": \"Walter D. Ackerman, III, Rollover IRA \",\r\n                        \"accountNumber\": 13351108,\r\n                        \"isFirstParty\": true\r\n                    },\r\n                    {\r\n                        \"accountName\": \"Walter D. Ackerman, III, Rollover IRA \",\r\n                        \"accountNumber\": 13351108,\r\n                        \"isFirstParty\": true\r\n                    }\r\n                ]\r\n            },\r\n            {\r\n                \"instructionNumber\": 6,\r\n                \"bankName\": \"KIKU #$BUKS20230913_1\",\r\n                \"bankAccountNumber\": \"******8318\",\r\n                \"customerName\": \"KIKS BANK#$ CUSTOMER NAME#$ 2\",\r\n                \"accountType\": \"Checking\",\r\n                \"abaRoutingNumber\": \"021000021\",\r\n                \"isFirstParty\": true,\r\n                \"isSLOA\": true,\r\n                \"shouldDisplay\": true,\r\n                \"isSelected\": false,\r\n                \"typeOfBeneficiary\": \"SameNameAndAddress\",\r\n                \"investmentAccounts\": [\r\n                    {\r\n                        \"accountName\": \"Walter D. Ackerman, III, Rollover IRA \",\r\n                        \"accountNumber\": 13351108,\r\n                        \"isFirstParty\": true\r\n                    },\r\n                    {\r\n                        \"accountName\": \"Walter D. Ackerman, III, Rollover IRA \",\r\n                        \"accountNumber\": 13351108,\r\n                        \"isFirstParty\": true\r\n                    },\r\n                    {\r\n                        \"accountName\": \"Walter D. Ackerman, III, Rollover IRA \",\r\n                        \"accountNumber\": 13351108,\r\n                        \"isFirstParty\": true\r\n                    },\r\n                    {\r\n                        \"accountName\": \"Walter D. Ackerman, III, Rollover IRA \",\r\n                        \"accountNumber\": 13351108,\r\n                        \"isFirstParty\": true\r\n                    },\r\n                    {\r\n                        \"accountName\": \"Walter D. Ackerman, III, Rollover IRA \",\r\n                        \"accountNumber\": 13351108,\r\n                        \"isFirstParty\": true\r\n                    },\r\n                    {\r\n                        \"accountName\": \"Walter D. Ackerman, III, Rollover IRA \",\r\n                        \"accountNumber\": 13351108,\r\n                        \"isFirstParty\": true\r\n                    }\r\n                ]\r\n            },\r\n            {\r\n                \"instructionNumber\": 7,\r\n                \"bankName\": \"KIKU #$BUKS20230913_1\",\r\n                \"bankAccountNumber\": \"******8318\",\r\n                \"customerName\": \"KIKS BANK#$ CUSTOMER NAME#$ 2\",\r\n                \"accountType\": \"Checking\",\r\n                \"abaRoutingNumber\": \"021000021\",\r\n                \"isFirstParty\": true,\r\n                \"isSLOA\": true,\r\n                \"shouldDisplay\": true,\r\n                \"isSelected\": false,\r\n                \"typeOfBeneficiary\": \"SameNameAndAddress\",\r\n                \"investmentAccounts\": [\r\n                    {\r\n                        \"accountName\": \"Walter D. Ackerman, III, Rollover IRA \",\r\n                        \"accountNumber\": 13351108,\r\n                        \"isFirstParty\": true\r\n                    },\r\n                    {\r\n                        \"accountName\": \"Walter D. Ackerman, III, Rollover IRA \",\r\n                        \"accountNumber\": 13351108,\r\n                        \"isFirstParty\": true\r\n                    },\r\n                    {\r\n                        \"accountName\": \"Walter D. Ackerman, III, Rollover IRA \",\r\n                        \"accountNumber\": 13351108,\r\n                        \"isFirstParty\": true\r\n                    },\r\n                    {\r\n                        \"accountName\": \"Walter D. Ackerman, III, Rollover IRA \",\r\n                        \"accountNumber\": 13351108,\r\n                        \"isFirstParty\": true\r\n                    },\r\n                    {\r\n                        \"accountName\": \"Walter D. Ackerman, III, Rollover IRA \",\r\n                        \"accountNumber\": 13351108,\r\n                        \"isFirstParty\": true\r\n                    },\r\n                    {\r\n                        \"accountName\": \"Walter D. Ackerman, III, Rollover IRA \",\r\n                        \"accountNumber\": 13351108,\r\n                        \"isFirstParty\": true\r\n                    }\r\n                ]\r\n            },\r\n            {\r\n                \"instructionNumber\": 8,\r\n                \"bankName\": \"KIKU #$BUKS20230913_1\",\r\n                \"bankAccountNumber\": \"******8318\",\r\n                \"customerName\": \"KIKS BANK#$ CUSTOMER NAME#$ 2\",\r\n                \"accountType\": \"Checking\",\r\n                \"abaRoutingNumber\": \"021000021\",\r\n                \"isFirstParty\": true,\r\n                \"isSLOA\": true,\r\n                \"shouldDisplay\": true,\r\n                \"isSelected\": false,\r\n                \"typeOfBeneficiary\": \"SameNameAndAddress\",\r\n                \"investmentAccounts\": [\r\n                    {\r\n                        \"accountName\": \"Walter D. Ackerman, III, Rollover IRA \",\r\n                        \"accountNumber\": 13351108,\r\n                        \"isFirstParty\": true\r\n                    },\r\n                    {\r\n                        \"accountName\": \"Walter D. Ackerman, III, Rollover IRA \",\r\n                        \"accountNumber\": 13351108,\r\n                        \"isFirstParty\": true\r\n                    },\r\n                    {\r\n                        \"accountName\": \"Walter D. Ackerman, III, Rollover IRA \",\r\n                        \"accountNumber\": 13351108,\r\n                        \"isFirstParty\": true\r\n                    },\r\n                    {\r\n                        \"accountName\": \"Walter D. Ackerman, III, Rollover IRA \",\r\n                        \"accountNumber\": 13351108,\r\n                        \"isFirstParty\": true\r\n                    },\r\n                    {\r\n                        \"accountName\": \"Walter D. Ackerman, III, Rollover IRA \",\r\n                        \"accountNumber\": 13351108,\r\n                        \"isFirstParty\": true\r\n                    },\r\n                    {\r\n                        \"accountName\": \"Walter D. Ackerman, III, Rollover IRA \",\r\n                        \"accountNumber\": 13351108,\r\n                        \"isFirstParty\": true\r\n                    }\r\n                ]\r\n            },\r\n            {\r\n                \"instructionNumber\": 9,\r\n                \"bankName\": \"TEST BANK\",\r\n                \"bankAccountNumber\": \"******3331\",\r\n                \"customerName\": \"TEST\",\r\n                \"accountType\": \"Checking\",\r\n                \"abaRoutingNumber\": \"122100024\",\r\n                \"isFirstParty\": true,\r\n                \"isSLOA\": false,\r\n                \"shouldDisplay\": true,\r\n                \"isSelected\": false,\r\n                \"typeOfBeneficiary\": \"SameNameAndAddress\",\r\n                \"investmentAccounts\": [\r\n                    {\r\n                        \"accountName\": \"Walter D. Ackerman, III, Rollover IRA \",\r\n                        \"accountNumber\": 13351108,\r\n                        \"isFirstParty\": true\r\n                    }\r\n                ]\r\n            },\r\n            {\r\n                \"instructionNumber\": 10,\r\n                \"bankName\": \"TEST BANK\",\r\n                \"bankAccountNumber\": \"******3332\",\r\n                \"customerName\": \"TEST ACCT\",\r\n                \"accountType\": \"Checking\",\r\n                \"abaRoutingNumber\": \"122100024\",\r\n                \"isFirstParty\": false,\r\n                \"isSLOA\": false,\r\n                \"shouldDisplay\": false,\r\n                \"isSelected\": false,\r\n                \"typeOfBeneficiary\": \"ThirdPartyDomesticIndividual\",\r\n                \"investmentAccounts\": [\r\n                    {\r\n                        \"accountName\": \"Walter D. Ackerman, III, Rollover IRA \",\r\n                        \"accountNumber\": 13351108,\r\n                        \"isFirstParty\": false\r\n                    }\r\n                ]\r\n            },\r\n            {\r\n                \"instructionNumber\": 11,\r\n                \"bankName\": \"TEST 3\",\r\n                \"bankAccountNumber\": \"******3333\",\r\n                \"customerName\": \"TEST\",\r\n                \"accountType\": \"Checking\",\r\n                \"abaRoutingNumber\": \"122100024\",\r\n                \"isFirstParty\": true,\r\n                \"isSLOA\": false,\r\n                \"shouldDisplay\": false,\r\n                \"isSelected\": false,\r\n                \"typeOfBeneficiary\": \"DifferentAddress\",\r\n                \"investmentAccounts\": [\r\n                    {\r\n                        \"accountName\": \"Walter D. Ackerman, III, Rollover IRA \",\r\n                        \"accountNumber\": 13351108,\r\n                        \"isFirstParty\": true\r\n                    }\r\n                ]\r\n            },\r\n            {\r\n                \"instructionNumber\": 12,\r\n                \"bankName\": \"KIKU #$BUKS20230913 1\",\r\n                \"bankAccountNumber\": \"******8318\",\r\n                \"customerName\": \"KIKS BANK#$ CUSTOMER NAME#$2\",\r\n                \"accountType\": \"Checking\",\r\n                \"abaRoutingNumber\": \"021000021\",\r\n                \"isFirstParty\": true,\r\n                \"isSLOA\": false,\r\n                \"shouldDisplay\": true,\r\n                \"isSelected\": false,\r\n                \"typeOfBeneficiary\": \"SameNameAndAddress\",\r\n                \"investmentAccounts\": [\r\n                    {\r\n                        \"accountName\": \"Walter D. Ackerman, III, Rollover IRA \",\r\n                        \"accountNumber\": 13351108,\r\n                        \"isFirstParty\": true\r\n                    }\r\n                ]\r\n            }\r\n        ]\r\n    }\r\n]\r\n";

	        // Parse the JSON string	
		 
	        JsonArray jsonArray = JsonParser.parseString(jsonResponse).getAsJsonArray();
	        int counter=0;
	        // Iterate over the JSON array and extract account names
	        for (JsonElement element : jsonArray) {
	            JsonObject jsonObject = element.getAsJsonObject();
	            JsonArray bankInformationArray = jsonObject.getAsJsonArray("bankInformation");

	            // Iterate over the bankInformation array
	            for (JsonElement infoElement : bankInformationArray) {
	                JsonObject bankInfoObject = infoElement.getAsJsonObject();	                
	                	JsonArray investInfo =	bankInfoObject.getAsJsonArray("investmentAccounts");
	                	
	                		for(JsonElement accName : investInfo) {	                		
	                             String accountName = accName.getAsJsonObject().get("accountName").getAsString();
	                             counter++;
	                // Print the account name
	                             System.out.println("Account Name: " + accountName);
	                		}
	            }
	        }
	        System.out.println("Count is : " + counter);
	}
	
	public static void pdfR() throws IOException {
		 File file = new File("C:/Users/Amit.Malik/Downloads/eSigPDFDownload.pdf");
		PDDocument pdfDocument = PDDocument.load(file);
		PDFTextStripper pdfTextStripper = new PDFTextStripper();
       String  pdfText = pdfTextStripper.getText(pdfDocument);
       System.out.println(pdfText);
	}
	
	public static void quat() {
		 LocalDate currentDate = LocalDate.now();
	        int year = currentDate.getYear();
	        int quarter = (currentDate.getMonthValue() - 1) / 3 + 1;

	        System.out.println("Current Year: " + year);
	        System.out.println("Current Quarter: " + quarter);      
	}
	
	public static void currentquat() {
		 LocalDate currentDate = LocalDate.now();
	        int year = currentDate.getYear();
	        int quarter = (currentDate.getMonthValue() - 1) / 3 + 1;

	        System.out.println("Current Year: " + year);
	        System.out.println("Current Quarter: " + quarter);
	        
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy"); 
	        
	     System.out.println(currentDate.plusDays(2).format(formatter));
	}
	
	public static void tm() {
		String s ="  amit  ";	
		System.out.println(s.trim());
	//	System.out.println("  jdkhf   ".strip());		
	}
	
	 public static void tim() {
	        // Get the current date and time in the default time zone
	        LocalDateTime currentDateTime = LocalDateTime.now();
	       

	        // Specify the PST time zone
	        ZoneId pstZone = ZoneId.of("America/Los_Angeles");

	        // Convert the date and time to the PST time zone
	        ZonedDateTime pstDateTime = currentDateTime.atZone(ZoneOffset.systemDefault()).withZoneSameInstant(pstZone);

	        // Format the PST date and time as a string
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm a");
	        String formattedDateTime = pstDateTime.format(formatter);

	        // Print the formatted PST date and time
	        System.out.println("PST Date and Time: " + formattedDateTime);
	    }
	
	public static void zoneDateTime() {		
        LocalDateTime currentDateTime = LocalDateTime.now();
        System.out.println(ZoneId.getAvailableZoneIds());
        ZoneId pstZone = ZoneId.of("US/Pacific");
        ZonedDateTime pstDateTime = currentDateTime.atZone(pstZone);
        System.err.println(pstDateTime);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm a");
        String formattedDateTime = pstDateTime.format(formatter);
        System.out.println(formattedDateTime);
	}
	
		public static String dateFormatConversion(int days) {
			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
	    	Calendar c = Calendar.getInstance();
	    	c.setTime(new Date()); // Using today's date
	    	c.add(Calendar.DATE, days); // Adding 5 days
	    	String output = sdf.format(c.getTime());
	    	return output;
		}
		
		public static void aas() {
			String s= "Gray, H Willard & Barbara G";
			System.out.println(s.replaceAll("[,&/\\s]", ""));
		}
		
		public static void inst() {
			Instant instant = Instant.now();
			Instant instant1 = instant.plus(Duration.ofMillis(5000));
			Instant instant2 = instant.minus(Duration.ofMillis(5000));
			Instant instant3 = instant.minusSeconds(10);				
			
			System.out.println(instant+" 1 value is "+ instant1 +" 2 value is "+ instant2 +" 3 value is "+ instant3 );
		}

		public static void loca() {					
			LocalDateTime a= LocalDateTime.now();
			String dd= a.format(DateTimeFormatter.ofPattern("M/dd/yy"));
			System.out.println(dd);
			
	//		System.out.println(a.atZone(ZoneOffset.).format(DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm a ")));
	//		System.out.println(a.atZone(ZoneOffset.).format(DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm a ")));
		}
		
		public static void fori() {		
			ZoneId zoneid2 = ZoneId.of("Europe/London");
			LocalDate a= LocalDate.now(zoneid2);
			String dd= a.format(DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm"));
			System.out.println(dd);
		}

		public static void per() {	
			int ab=10;
			/*
			 * var ba= "10"; ba.chars().forEach(System.out::print);
			 */
			
			List<Integer> items = new ArrayList<>(); //Initialize the list
			for(int i=1;i<10;i++) {
				items.add(i);
			}
			String prefix = "str";
			 
			items.stream().filter(e-> (e%2==0)).collect(Collectors.toList()).forEach(System.out::print);
			
			items.stream().collect(Collectors.toSet());
			
			
			
			List<String> items1 = Arrays.asList("amit","sumit","ramit");
			
			String s= "amit";
			
			
	//		Map<Integer,items1>sb =items1.stream().filter(p -> "amit".equals(p)).map(String :: toUpperCase).collect(Collectors.toMap(1, items1:: get()));
			
						
		//	items.stream().filter(e-> (e%2==0)).f
			/*
			 * List<String> filteredList = items.stream() .filter(e ->
			 * (!e.startsWith(prefix))) .collect(Collectors.toList());
			 */			
		}
		
		public static void asdd() {			 
			  
			        // Initializing a list of type Linkedlist
			        List<Integer> l = new LinkedList<>();
			        l.add(10);
			        l.add(15);
			        l.add(20);
			        System.out.println(l);
			  
			        // Initializing another list
			        List<Integer> l2 = new ArrayList<Integer>();
			        l2.add(10);
			        l2.add(15);
			        l2.add(20);
			        System.out.println(l2);
			  
			        if (l.equals(l2))
			            System.out.println("Equal");
			        else
			            System.out.println("Not equal");
			    }

		public static void ppl() {
			List<String> names = new ArrayList<>();	         
			names.add("David");			         
			names.add("Johnson");			         
			names.add("Samontika");			         
			names.add("Brijesh");			         
			names.add("John");
			
			names.stream().skip(2).forEach(System.out:: println);
			System.out.println("--------------");
			names.stream().filter(e-> e.length() >=5).map(String::toUpperCase).skip(2).sorted().forEach(System.out:: println);
			
			Object [] arr= names.stream().filter(e-> e.length() >=5).skip(2).toArray();			
			System.out.println(Arrays.toString(arr));
			names.stream().filter(e-> e.length() >=5).skip(2);			
			
			LinkedList<String> ll= names.stream().collect(Collectors.toCollection(LinkedList::new));
			List aa= names.stream().collect(Collectors.toList());
			
			Optional<List<String>> oo= Optional.ofNullable(names);
			System.out.println(oo);
			System.out.println("---------");
			System.out.println(oo.get());
			
			Iterator<String> its= names.iterator();
			while(its.hasNext()) {
				System.out.println(its.next());
			}
			Spliterator<String> itr= names.stream().spliterator();			
		}	
	
		public void mp() {
			Map<String, Integer> ma= new HashMap<String, Integer>();
			ma.put("am", 1);
			ma.put("ami", 2);
			ma.put("amit", 3);			
			for(Map.Entry<String, Integer> e1 : ma.entrySet()) {
				System.out.println(e1.getKey()+ ""+ e1.getValue());
			}
			Iterator<Entry<String, Integer>> e3= ma.entrySet().iterator();			
		} 
		
		public static String opo() {
			System.out.println(Arrays.toString(Thread.State.values()));
	//		Thread.State.values();
	//		var i=10;		
			try {
				System.out.println("try block");
				System.out.println(10/0);				
				return "abc";
			}catch(Exception e) {
				System.out.println("catch block");
				return "error catch kr liya";
			}finally {
				System.out.println("final block");
			}			
		}
		
		public static void ty() {
			String s= "my name is amit malik";
			String [] s1= s.split(" ");			
			String s4="";
			for(int i=0;i<=s1.length-1;i++) {
				String s3="";
				String s2="";
				if(i%2!=0) {					
					for(int j=s1[i].length()-1;j>=0;j--) {
						s2= s2+s1[i].charAt(j);
					}
				}else {
					s3=s1[i];
				}
				s4=s4+" "+s3+s2;		
			}
			System.out.println(s4);
		}	
		//better to go with builder from memory and performance pov
		public static void oou() {		
			StringBuilder sb= new StringBuilder("");
			String ffg= new String("my name is amit malik");
			String [] t=ffg.split(" ");
			for(int k=0;k<=t.length-1;k++) {
				if(k%2!=0) {
					for(int i=t[k].length()-1;i>=0;i--) {
						sb=sb.append(t[k].charAt(i));
					}
				}else {
					sb=sb.append(t[k]);
				}				
				sb=sb.append(" ");
			}
			System.out.println(sb);
		}
				
		//array to list
		public static void ok() {
			Map<String, Integer> rr= new Hashtable<String, Integer>();			
			HashSet<String> q = new LinkedHashSet<String>();
			q.add("amit");
			String[] array = { "ANDROID", "JSP", "JAVA", "STRUTS", "HADOOP", "JSF" };
			ArrayList<String> list = new ArrayList<String>(Arrays.asList(array));			
			ArrayList<String> lis = new ArrayList<String>();
			lis.addAll(Arrays.asList(array));
			Collections.addAll(lis, array);			
		}
		
		//list to array
		public static void ko() {
			ArrayList<String> o= new ArrayList<String>();
			o.add("amit");
			o.add("sumit");
			o.add("amuj");
			o.set(2, null);			
			Object [] o1= o.toArray();
			System.out.println(Arrays.toString(o1));
			Iterator<String> po=o.listIterator();
			o.add("nitu");
			while(po.hasNext()) {
				System.out.println(po.next());
			}
		}
		
		public static void ooi() {
			FileSystemView fsv = FileSystemView.getFileSystemView();
	         
	        File[] drives = File.listRoots();
	          
	        if(drives.length > 0 && drives != null)
	        {
	            for (File drive : drives) 
	            {   
	                System.out.println("====================");
	                 
	                System.out.println("Drive Name : "+drive);
	                 
	                System.out.println("Type Of Drive : "+fsv.getSystemTypeDescription(drive));
	                 
	                System.out.println("Total Space : "+drive.getTotalSpace()/(1024*1024*1024)+" GB");
	                 
	                System.out.println("Free Space : "+drive.getFreeSpace()/(1024*1024*1024)+" GB");
	                 
	                System.out.println("Usable Space : "+drive.getUsableSpace()/(1024*1024*1024)+" GB");
	            }
	        }
		}
		
		@Override
		public void m() {
			
			m2();  //default
			Prac1.m3();
			
		}
		
		/*
		 * public static void cClass() { List<Object> oo= new ArrayList<Object>();
		 * oo.add(Map.of("name", "amit", "job", "dev")); oo.add("title");
		 * 
		 * System.out.println(oo.get(0)); }
		 */
		
		public static void streamProg() {
			
		}
}






