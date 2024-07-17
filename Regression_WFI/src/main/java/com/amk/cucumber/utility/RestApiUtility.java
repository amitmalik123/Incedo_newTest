package com.amk.cucumber.utility;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.junit.Assert;

import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * Test Code
 */
public class RestApiUtility {
	public static Properties allLoadedProperties;
	protected static Logger Log = Logger.getLogger(RestApiUtility.class);

	/**
	 * Test Code
	 */
	public static String getApiKey(String endpoint) {
		String key = "";
		RestAssured.baseURI = endpoint;
		RequestSpecification request = RestAssured.given();
		Response response = request.get(RestAssured.baseURI);
		int statusCode = response.getStatusCode();
		System.out.println("Status code for resquest : :" + statusCode + "");		
		key = response.jsonPath().get("");
		System.out.println("Access Token : " + key);
		return key;

	}

	/**
	 * Test Code
	 */
	public static String getSpecificURL(String keyword) {
		allLoadedProperties = PropertyHandler.loadpropertyFile("config");
		String url = allLoadedProperties.getProperty(keyword);
		return url;
	}

	/**
	 * Test Code
	 */
	public static Response hitGetEndpoint(String url) {

		Map<String, Object> headerMap = new HashMap<String, Object>();

		headerMap.put("authorization", getSpecificURL("tokenValue"));
		headerMap.put("accountNumber", getSpecificURL("accountNumber"));
		headerMap.put("accountType", getSpecificURL("accountType"));

		RestAssured.baseURI = url;
		RequestSpecification httpsRequest = RestAssured.given().headers(headerMap);
		Response response = httpsRequest.get(url);
		return response;
	}

	public static RequestSpecification setupURL(String url) {
		RestAssured.baseURI = url;
		RequestSpecification request = RestAssured.given();
		return request;
	}

	public static void addingAuthorization(RequestSpecification request, String token) {
		request.given().auth().oauth2(token);
	}

	public static void addingAuthorization_AccessToken(RequestSpecification request, String uname, String pass) {
		request.auth().basic(uname, pass);
	}
	
	public static void addingAuthorization_AccessToken(RequestSpecification request, String token) {
		request.auth().oauth2(token);    
	}

	public String formatingURLencodedtoString(String key, String value) {
		String body = String.format(key + "=%s", value); // "grant_type= "client_credentials"
		Log.info("the Request body recieved is    ---    :" + body);

		return body;
	}

	public void addingBodyToRequest(RequestSpecification request, String body) {
		request.body(body);
	}

	public static Map<String, Object> consolidatedHeaders(String token) {
		Map<String, Object> headerMap = new HashMap<String, Object>();
		headerMap.put(getSpecificURL("headerkey3"), "Bearer " + token); // "Authorization"
		headerMap.put(getSpecificURL("headerkey4"), getSpecificURL_number("Ocp-Apim-Subscription-Key")); // "Ocp-Apim-Subscription-Key"
		return headerMap;
	}

	public static Map<String, Object> consolidatedHeaders_AccessToken() {
		Map<String, Object> headerMap = new HashMap<String, Object>();
		headerMap.put(getSpecificURL("headerkey1"), getSpecificURL("Content-Type")); // "Content-Type"
		headerMap.put(getSpecificURL("headerkey2"), getSpecificURL("Accept")); // "Accept"
		headerMap.put(getSpecificURL("headerkey3"), getSpecificURL("Authorization")); // (getSpecificURL("headerkey3")
																						// "Authorization"

		return headerMap;
	}
	
	public String getBearerToken() {
		Map<String,String> headers = new HashMap<String,String>();
		headers.put("Accept", "application/json");
		headers.put("Content-Type", "application/x-www-form-urlencoded");
		headers.put("Cache-Control", "no-cache");
		headers.put("Authorization", "Basic MG9hdWx6bnZhZ0VITmJJZk0waDc6RU1BZWNfUmdrdHpobGw3Vk5EWkJ1ZGNUSEJUNGNDZU5YQ2VsMDJEYQ==");
	//	headers.put("Cookie", "JSESSIONID=320178982A98C6F361D7AE1642754152");
		RequestSpecification tokenRequest = RestAssured.given();
		tokenRequest.auth().basic("0oaulznvagEHNbIfM0h7", "EMAec_Rgktzhll7VNDZBudcTHBT4cCeNXCel02Da")
		.headers(headers).body(formatingURLencodedtoString("grant_type","client_credentials"));
		Log.info("request body : " + tokenRequest.toString());
		Response response = tokenRequest.post("https://assetmark.oktapreview.com/oauth2/default/v1/token");
		Log.info("response code : " + response.statusCode());
		Log.info("response body : " + response.prettyPrint());
		JsonPath jsonPath = new JsonPath(response.asString());
		String token = jsonPath.get("access_token");
		Log.info("Access Token : " + token);
		customLogger("Access Token", token);
		return token;
	}
	
	public RequestSpecification addingHeaderParameters(RequestSpecification request, String token, String option) {
		Map<String, Object> header = new HashMap<String, Object>();		
		switch(option) {
			case "delete residual":
			case "delete distribution":
			case "CloseAccountTransferRequest":
			case "GetAccountTransferRequests":
			case "GetPeriodicWithdrawalInstructionsByAccount":
				header.put("Ocp-Apim-Subscription-Key", "db28dc8a774f4e25a9d553067a7ac977");
				header.put("Api-Version", "v1");
				header.put("Ocp-Apim-Trace", true);
				header.put("Authorization", "Bearer " + token);
	//			header.put("Content-Type", "application/json-patch+json");
				header.put("Content-Type", "application/json");
			break;
			case "CreateJournalEntry":
				header.put("Ocp-Apim-Subscription-Key", "db28dc8a774f4e25a9d553067a7ac977");
				header.put("Api-Version", "v2");
				header.put("Ocp-Apim-Trace", true);
				header.put("Authorization", "Bearer " + token);
				header.put("Content-Type", "application/json");
			break;
			case "CreateShareEntry":
			case "GetAccountDetail":
			case "openAccount":
				header.put("Ocp-Apim-Subscription-Key", "db28dc8a774f4e25a9d553067a7ac977");
				header.put("Api-Version", "v3");
				header.put("Ocp-Apim-Trace", true);
				header.put("Authorization", "Bearer " + token);
				header.put("Content-Type", "application/json");
			default:
				Log.info("end point is not correct ");
		}		
		request.headers(header);
		Log.info("Header Parameters : " + header);		
		customLogger("Header Parameters", header.toString());
		return request;
	}
	
	@SuppressWarnings("unchecked")
	public JSONObject designRequestBody(String accountNumber, String bankAccountNumber, String abaRoutingNumber,String customerName1,String customerName2, RequestSpecification request) {
		JSONObject requestParams = new JSONObject();	    		
	
		JSONObject requestHeader= new JSONObject();
	    requestHeader.put("externalReferenceId", "9daabc98-c969-43ad-94c1-0169d9370134");
	    requestHeader.put("applicationId", "amk-svc-02");     	
	    JSONObject requestor= new JSONObject();
	    requestor.put("identity", "2352683");
	    requestor.put("identityType", "SubId");
	    requestHeader.put("requestor", requestor); 
	    requestHeader.put("custodialId", "WWS");
	    requestHeader.put("requestAction", "Submit");	  
	    JSONObject createACHInstructionRequest= new JSONObject();
	    createACHInstructionRequest.put("processingInstruction", "Submit");
	    int accNumber=Integer.parseInt(accountNumber);
	    createACHInstructionRequest.put("accountNumber", accNumber);  
	    JSONObject ACHInformation= new JSONObject();
	    JSONObject bankInformation= new JSONObject();
	    bankInformation.put("bankAccountNumber", bankAccountNumber);
	    bankInformation.put("bankAccountType", "Checking");
	    bankInformation.put("ABARoutingNumber", abaRoutingNumber);
	    bankInformation.put("customerName1", customerName1);
	    bankInformation.put("customerName2", customerName2);
	    ACHInformation.put("bankInformation", bankInformation); 
	    ACHInformation.put("typeOfBeneficiary", "ThirdPartyDomesticIndividual"); 	
	    JSONObject clearingInstructions= new JSONObject();
	    clearingInstructions.put("manualDeposit", true);
	    clearingInstructions.put("manualWithdrawal", true);
	    ACHInformation.put("clearingInstructions", clearingInstructions); 
	    ACHInformation.put("originId", "BPM"); 
	    ACHInformation.put("letterOfAuthorization", "Withdrawals"); 
	    createACHInstructionRequest.put("ACHInformation", ACHInformation);	    
	    requestParams.put("requestHeader", requestHeader);
	    requestParams.put("createACHInstructionRequest", createACHInstructionRequest);
	    
	 //   request.body(requestParams.toString());
		Log.info("the Request body recieved is  -------:" + requestParams);

		return requestParams;
	}
	
	public void addingBodyToRequest(RequestSpecification request, JSONObject body) {
		request.body(body.toJSONString());
	}
	
	public static void verifyStatusline(Response response) {
		String statusLine= response.getStatusLine();
		Log.info("Response status line : :" + statusLine);
		customLogger(" Response status line : : " + statusLine, "");
		if(statusLine.toLowerCase().contains("ok")) {
			Assert.assertTrue("status line contains OK", true);
		}
		
	}

	public static void addingHeaderFields(RequestSpecification request, Map<String, Object> headerMap) {
		request.headers(headerMap);
	}
	
	public static String getBodyFromResponse1(Response response) {
		String responseBody = response.getBody().asString();
		return responseBody;
	}

	public static Response gettingResponse_GET(RequestSpecification request, String url) {
		customLogger("Hitting request with GET method", "");
		Response response = request.get(url);
		return response;
	}

	public static Response gettingResponse_Post(RequestSpecification request, String url) {
		customLogger("Hitting request with POST method", "");
		Response response = request.relaxedHTTPSValidation().post(url);
		return response;
	}

	public static String retrivingValueFromResponse(Response response, String key) {
		String value = response.jsonPath().get(key);
		Log.info("the value is :" + value);
		return value;
	}
	public static String retrivingJsonArrayFrmResp(Response response, String key,Map<Integer, Map<String, String>> map) {
		Map<String, String> valueamp ;		
		JsonPath j = new JsonPath(response.asString());
		
	      //get values of JSON array after getting array size
	      int s = j.getInt("accountHoldings.size()");
	      for(int i = 0; i < s; i++) {
	         String Cusip = j.getString("accountHoldings["+i+"].cusip");
	         for(int k=0;k<map.size();k++)
	 		{
	 			valueamp = map.get(k);
	 			System.out.println("valuamp from iteration ::::"+valueamp);
	 			String cusipfromMap =  valueamp.get("CusipID");
	 			if(Cusip.equals(cusipfromMap))
	 			{

		 			System.out.println("Cusip  :::"+Cusip);
			         String quantity = j.getString("accountHoldings["+i+"].quantity");
			         quantity =  String.valueOf(quantity);
			         
			         String value = String.valueOf(quantity);
						System.out.println("Before conv : : " + value);
						Double doubleValue =  Double.parseDouble(value); 
						BigDecimal bd = new BigDecimal(doubleValue.toString());
						long lonVal = bd.longValue();
						quantity = Long.toString(lonVal).trim();
						System.out.println("After conv : : " + quantity);
						
			         String quantityfromMap = valueamp.get("Quantity");
			         Assert.assertEquals(quantity, quantityfromMap);
			         
			         String holdingGainLossAmount = j.getString("accountHoldings["+i+"].holdingGainLossAmount");
			         String holdingGainLossAmountfromMap = valueamp.get("holdingGainLossAmount");
			         Assert.assertEquals(holdingGainLossAmount, holdingGainLossAmountfromMap);
			         
			         String holdingProceedsAmount = j.getString("accountHoldings["+i+"].holdingProceedsAmount");
			         
			         BigDecimal bd2= new BigDecimal(holdingProceedsAmount);
			         DecimalFormat df = new DecimalFormat("0.##");
			         holdingProceedsAmount = df.format(bd2);
			         System.out.println("bd1 value::"+ df.format(bd2));
						
			         String HoldingsAmountfromMap = valueamp.get("HoldingsAmount");
			         Assert.assertEquals(holdingProceedsAmount, HoldingsAmountfromMap);
			         
	 			}	 			
	 		}	         
	      }
		
			
		return "";
	}
	
	public static void validationwithExcelData(Response response, String valuetofetch, Map<Integer, Map<String, String>> map)
	{
		String ValuetoCheck;
		 ValuetoCheck =  retrivingJsonArrayFrmResp(response, valuetofetch, map);
		Log.info("value of " + valuetofetch + " is   :" + ValuetoCheck);
		// verificationFromExcelAndResponse(response, sheetname, valuetofetch, 2);
	}	

	public static void customLogger(String log, String value) {
		if (value.isEmpty())
			ExtentCucumberAdapter.addTestStepLog(" . . . . " + log);
		else
			ExtentCucumberAdapter.addTestStepLog(" . . . . " + log + " : " + value);
	}

	public static void emptyLogger(String log) {
		ExtentCucumberAdapter.addTestStepLog(" ~ " + log);

	}

	public static Response getMethEndpointExecution(String token, RequestSpecification request, String url) {
		addingAuthorization(request, token);
		Map<String, Object> headerMap = consolidatedHeaders(token);
		addingHeaderFields(request, headerMap);
		customLogger(" OAuth2.0  with Bearer Token and Headers has been added to request URL ", "");
		Response response = gettingResponse_GET(request, url);
		customLogger(" Response Body received .", "");
		return response;
	}	

	
	/**
	 * Test Code
	 */
	public static void getBodyFromResponse(Response response) {
		String url = getSpecificURL("");
		response = hitGetEndpoint(url);
		String body = response.prettyPrint();

	}

	/**
	 * Test Code
	 */
	public static void setContentType(ContentType contentType) {
		RestAssured.given().contentType(contentType);
	}

	public static void jsonPathfinder(Response response, String key) {
		JsonPath jsonPathEvaluator = response.jsonPath();
		String value = jsonPathEvaluator.get(key);
	}

	/**
	 * Test Code
	 */
	public static JsonPath getJsonPath(Response response) {
		String json = response.asString();
		return new JsonPath(json);
	}

	/**
	 * Test Code
	 */
	public static void setBaseUri(String url) {
		RestAssured.baseURI = url;
	}

	/**
	 * Test Code
	 */
	public static void verifyStatusCode(Response response, int statuscode) {
		Log.info("Response status code : :" + response.getStatusCode());
		customLogger(" Response status code : : " + response.getStatusCode(), "");
		Assert.assertEquals(response.getStatusCode(), statuscode);
	}

	public static void verifyStatusCode(Response response) {
		Log.info("Response status code : :" + response.getStatusCode());
		customLogger(" Response status code : : " + response.getStatusCode(), "");
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	public static Object retrivingValueObjectFromResponse(Response response, String key) {
		Object value = response.jsonPath().get(key);
		Log.info("the value is :" + value);
		return value;
	}

	/**
	 * Test Code
	 */
	public static Object getSpecificURL_number(Object keyword) {
		allLoadedProperties = PropertyHandler.loadpropertyFile("config");
		Object url = allLoadedProperties.getProperty((String) keyword);
		return url;
	}

	public static String getSpecificURL_number_GetAPI(Object keyword) {
		allLoadedProperties = PropertyHandler.loadpropertyFile("config");
		String url = allLoadedProperties.getProperty((String) keyword);
		return url;
	}

	public static String getReportConfigPath() {
		allLoadedProperties = PropertyHandler.loadpropertyFile("config");
		String reportConfigPath = allLoadedProperties.getProperty("reportConfigPath");
		if (reportConfigPath != null)
			return reportConfigPath;
		else
			throw new RuntimeException(
					"Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");
	}

	public static void hitGetEndpoint1(String url) {
		setBaseUri(url);
		RequestSpecification httpsRequest = RestAssured.given();
		Response response = httpsRequest.get(url);
		getBodyFromResponse(response);
		verifyStatusCode(response);
	}

	public static RequestSpecification getRequestMethod(String accessToken) {
		RequestSpecification request = RestAssured.given();
		request.auth().oauth2(accessToken);
		Map<String, Object> headerMap = new HashMap<String, Object>();
		headerMap.put("Authorization", "Bearer " + accessToken);
		headerMap.put("Ocp-Apim-Subscription-Key", "ae6eec643dd94b21b64f3f492411ae8d");
		request.headers(headerMap);
		return request;
	}
	
	public  void checkStatusCode(Response response, int statuscode) {
		Log.info("Response status code : :" + response.getStatusCode());
		customLogger(" Response status code : : " + response.getStatusCode(), "");
		if(response.getStatusCode()==200) {
		     Log.info("Response code is :" + ""+statuscode+"");
		     customLogger("Response code is displayed as :", ""+statuscode+"");
		}
		else if(response.getStatusCode()==204) 
		{
			Log.info("No instructions found and status code is: " + ""+statuscode+"");
			customLogger("No instructions found and status code is: ", ""+statuscode+"");
		}
		else {
			Log.info("There is error in calling API and status code is: " + ""+statuscode+"");
			customLogger("There is error in calling API and status code is: ", ""+statuscode+"");
		}
		
	}
	
	public String getBearerToken_DM2BetaAccess() {
		Map<String,String> headers = new HashMap<String,String>();
		headers.put("Accept", "application/json");
		headers.put("Content-Type", "application/x-www-form-urlencoded");
		headers.put("Cache-Control", "no-cache");
		headers.put("Authorization", "Basic MG9hdWx6bnZhZ0VITmJJZk0waDc6RU1BZWNfUmdrdHpobGw3Vk5EWkJ1ZGNUSEJUNGNDZU5YQ2VsMDJEYQ==");
		headers.put("Cookie", "JSESSIONID=320178982A98C6F361D7AE1642754152");
		RequestSpecification tokenRequest = RestAssured.given();
		tokenRequest.auth().basic("0oaulznvagEHNbIfM0h7", "EMAec_Rgktzhll7VNDZBudcTHBT4cCeNXCel02Da").headers(headers).body(formatingURLencodedtoString("grant_type","client_credentials"));
		Log.info("request body : " + tokenRequest.toString());
		Response response = tokenRequest.post("https://assetmark.oktapreview.com/oauth2/default/v1/token");
		Log.info("response code : " + response.statusCode());
		Log.info("response body : " + response.prettyPrint());
		JsonPath jsonPath = new JsonPath(response.asString());
		String token = jsonPath.get("access_token");
		Log.info("Access Token : " + token);
		customLogger("Access Token", token);
		return token;
	}
	
	public RequestSpecification addingHeaderParameters_DM2BetaAccess(RequestSpecification request , String token) {
		Map<String, Object> header = new HashMap<String, Object>();
		header.put("Ocp-Apim-Subscription-Key", "db28dc8a774f4e25a9d553067a7ac977");
		header.put("Api-Version", "v3");
		header.put("Ocp-Apim-Trace", true);
		header.put("Authorization", "Bearer " + token);
		header.put("Content-Type", "application/json"); // -patch+json
		request.headers(header);
		Log.info("Header Parameters : " + header);
		customLogger("Header Parameters", header.toString());
		return request;
	}
	
	public RequestSpecification addingHeaderParameters_CancelSWP_createInstruction(RequestSpecification request, String token) {
		Map<String, Object> header = new HashMap<String, Object>();
		header.put("Ocp-Apim-Subscription-Key", "db28dc8a774f4e25a9d553067a7ac977");
		header.put("Api-Version", "v1");
		header.put("Ocp-Apim-Trace", true);
		header.put("Authorization", "Bearer " + token);
		header.put("Content-Type", "application/json"); // -patch+json
		request.headers(header);
		Log.info("Header Parameters : " + header);
		customLogger("Header Parameters", header.toString());
		return request;
	}

}
