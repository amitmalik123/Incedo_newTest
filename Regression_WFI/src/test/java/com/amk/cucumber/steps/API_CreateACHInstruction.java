package com.amk.cucumber.steps;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.junit.Assert;

import com.amk.cucumber.utility.RestApiUtility;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;



public class API_CreateACHInstruction extends RestApiUtility {

	String url = "";
	String access_token;
	String externalReferenceId;
	RequestSpecification request;
	Response response;
	Map<String, Object> headerMap;
	JSONObject body;
	
	List<String> valueFromDB;

	String AplNavID;
	GenericStepMethods genericStepMethods= new GenericStepMethods();
	private String excelPath = System.getProperty("user.dir") + File.separator
			+ "Data/Test11_data.xlsx";

	@Given("setup the url for Create ACH Instruction service with given {string}")
	public void The_url_setup_for_the_post_request(String TokenURL) {
		emptyLogger(" \n ");
		Log.info("-----------------    " + TokenURL);
		url = getSpecificURL_number_GetAPI(TokenURL);
		Log.info("the URI is  \t  :" + url);
		customLogger("the URI is ", url);
		request = setupURL(url);
		emptyLogger(" \n ");
	}

	@When("user authenticate the auth url using token {string}")
	public void addingAuthandHeaderForHittingRequest(String token) {
		emptyLogger(" \n ");
		addingAuthorization_AccessToken(request, getSpecificURL_number_GetAPI(token));
		headerMap = consolidatedHeaders_AccessToken();
		addingHeaderFields(request, headerMap);
		customLogger(" Basic authorization and headers has been added to request URI ", "");
		emptyLogger(" \n ");
	}
	
	@When("user adds account number,routing number, bank account number & customer names in request body via fetching data from sheetname {string} and rownumber {int}")
	public void addingBodyForHittingRequest(String sheetName, int rownum) {
		emptyLogger(" \n ");
		//call generic method
		genericStepMethods.setup(excelPath, sheetName, rownum);
		String accountNumber=genericStepMethods.readData("AccountNumber");
		String bankAccountNumber=genericStepMethods.readData("BankAccountNumber");
		String abaRoutingNumber=genericStepMethods.readData("ABARoutingNumber");
		String customerName1=genericStepMethods.readData("customerName1");
		String customerName2=genericStepMethods.readData("customerName2");		
		body = designRequestBody(accountNumber,bankAccountNumber,abaRoutingNumber,customerName1,customerName2, request);

		addingBodyToRequest(request, body);
		customLogger("added account number  ", accountNumber);
		customLogger("added bank account number  ", bankAccountNumber);
		customLogger("added routing number  ", abaRoutingNumber);
		customLogger("added customer name1 ", customerName1);
		customLogger("added customer name2 ", customerName2);
		customLogger(" Body contents has been added to request URL ", "");
		emptyLogger(" \n ");
	}
	
	@When("user hit the request and check the response")
	public void hitPostrequest() {
		emptyLogger(" \n ");
		response = gettingResponse_Post(request, url);

		String responsebody = response.getBody().asString();

		Log.info("the response body recieved is    ---:" + responsebody);
		customLogger(" Response Body received ", "");

		emptyLogger(" \n ");
	}

	@Then("validate the resposne status")
	public void retive_the_key_value_from_result() {
		emptyLogger(" \n ");

		verifyStatusCode(response,200);
		Long responseTime = response.time();
		Log.info("Response time is \t " + responseTime);
		customLogger(" Response time is ::" + responseTime, "");
		verifyStatusline(response);	
		Assert.assertEquals("SUCCESS", retrivingValueFromResponse(response, "responseHeader.status"));
		String bodyContent=getBodyFromResponse1(response);
		Assert.assertTrue(bodyContent.contains("ACHInstructionNumber"));
		Log.info("Response has been verified  ");
		customLogger("Response has been verified  ", "");
		
		emptyLogger(" \n ");
	}

	
    
     

}
