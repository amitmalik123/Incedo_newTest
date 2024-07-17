package com.amk.cucumber.steps;

import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.junit.Assert;

import com.amk.cucumber.constants.Constants;
import com.amk.cucumber.utility.RestApiUtility;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
//import jdk.internal.org.jline.utils.Log;

public class APIStep extends GenericStepMethods {

	String url = "";
	String accessToken;
	String externalReferenceId;
	RequestSpecification request;
	Response deactivateResponse;
	Map<String, Object> headerMap;
	JSONObject body;
	List<String> valueFromDB;

	
	 @When ("User should generate bearer token")
	 public void generateAccessToken() {
		 emptyLogger(" \n ");
		 accessToken = restApiUtilityPage.getBearerToken();
		 emptyLogger(" \n ");
	 }	 
	 
	 @When ("User should add request header parameters for {string}")
	 public void addHeaders(String option) {
		 emptyLogger(" \n ");
		 request = RestAssured.given();
		 restApiUtilityPage.addingHeaderParameters(request, accessToken, option);		
		 emptyLogger(" \n ");
	 }	
	 
	 @When ("User should design request body for {string}")
	 public void addRequestBody(String option) {
		 emptyLogger(" \n ");
		 String jsonString;
		 switch (option) {
		case "delete residual":
			jsonString = "{\"requestHeader\":{\"externalReferenceId\":\"9daabc98-c969-43ad-94c1-0169d9370134\",\"applicationId\":\"amksvc02\",\"custodialId\":\"WWS\",\"requestor\":{\"identity\":\"2352683\",\"identityType\":\"SubId\"},\"requestAction\":\"SubmitOrQueue\"},\"deletePeriodicWithdrawalInstructionsRequest\":{\"processingInstruction\":\"Submit\",\"accountNumber\":"+clientData.get(Constants.ACCOUNT_NUMBER)+",\"socialSecurityNumber\":\"000009999\"}}";
			logger.info("the body is -"+jsonString);
			restApiUtilityPage.addingBodyToRequest(request,jsonString);
			customLogger("Added Body to request", "");
			break;
			
		case "delete distribution":
			jsonString = "{\"requestHeader\":{\"externalReferenceId\":\"9daabc98-c969-43ad-94c1-0169d9370134\",\"applicationId\":\"amksvc02\",\"custodialId\":\"WWS\",\"requestor\":{\"identity\":\"2352683\",\"identityType\":\"SubId\"},\"requestAction\":\"SubmitOrQueue\"},\"deletePeriodicWithdrawalInstructionsRequest\":{\"processingInstruction\":\"Submit\",\"accountNumber\":"+clientData.get(Constants.ACCOUNT_NUMBER)+",\"socialSecurityNumber\":\"000008888\"}}";
			logger.info("the body is -"+jsonString);
			restApiUtilityPage.addingBodyToRequest(request,jsonString);
			customLogger("Added Body to request", "");
			break;
			
		case "CreateJournalEntry":
			jsonString = "{\"requestHeader\":{\"externalReferenceId\":\"fe0a8693-003b-4f76-8a55-7cc6463c10eb\",\"applicationId\":\"amksvc02\",\"requestor\":{\"identity\":\"2426399\",\"identityType\":\"SubId\"},\"custodialId\":\"WWS\",\"requestAction\":\"Submit\"},\"createJournalEntryRequest\":{\"currencyCode\":\"USD\",\"journalEntries\":[{\"accountNumber\":\"12299100\",\"accountIndicator\":\"G\",\"amount\":10000,\"movementInstruction\":\"Debit\",\"correlationId\":\"1\",\"descriptionLine1\":\"Fund\"},{\"accountNumber\":\""+fundingAccountNumber+"\",\"accountType\":\"Cash\",\"accountIndicator\":\"C\",\"amount\":10000,\"movementInstruction\":\"Credit\",\"correlationId\":\"2\",\"descriptionLine1\":\"Fund\",\"sourceCode\":\"JNL\"}]}}";
			logger.info("the body is -"+jsonString);
			restApiUtilityPage.addingBodyToRequest(request,jsonString);
			customLogger("Added Body to request", "");
			break;
			
		case "CreateShareEntry":
			jsonString = "{\"requestHeader\":{\"externalReferenceId\":\"9daabc98-c969-43ad-94c1-0169d9370134\",\"applicationId\":\"amksvc02\",\"custodialId\":\"WWS\",\"requestor\":{\"identity\":\"2352683\",\"identityType\":\"SubId\"},\"requestAction\":\"Submit\",\"pagingInfo\":{\"pageSize\":10}},\"createShareEntryRequest\":{\"processingMethod\":\"Submit\",\"groupEntries\":true,\"shareEntries\":[{\"correlationId\":\"1\",\"accountInformation\":{\"accountNumber\":"+fundingAccountNumber+",\"accountType\":\"Cash\"},\"shareEntryInformation\":{\"quantity\":100,\"movementInstruction\":\"Long\",\"securityIdentifier\":{\"symbol\":\"AAPL\"}},\"sourceCode\":\"JNL\",\"typeOfBeneficiary\":\"SameNameAndAddress\"}]}}";
			logger.info("the body is -"+jsonString);
			restApiUtilityPage.addingBodyToRequest(request,jsonString);
			customLogger("Added Body to request", "");
			break;
			
		case "CreateMultipleShareEntry":
			jsonString = "{\"requestHeader\":{\"externalReferenceId\":\"9daabc98-c969-43ad-94c1-0169d9370134\",\"applicationId\":\"amksvc02\",\"custodialId\":\"WWS\",\"requestor\":{\"identity\":\"2352683\",\"identityType\":\"SubId\"},\"requestAction\":\"Submit\",\"pagingInfo\":{\"pageSize\":10}},\"createShareEntryRequest\":{\"processingMethod\":\"Submit\",\"groupEntries\":true,\"shareEntries\":[{\"correlationId\":\"1\",\"accountInformation\":{\"accountNumber\":"+fundingAccountNumber+",\"accountType\":\"Cash\"},\"shareEntryInformation\":{\"quantity\":1,\"movementInstruction\":\"Long\",\"securityIdentifier\":{\"symbol\":\"AAPL\"}},\"sourceCode\":\"JNL\",\"typeOfBeneficiary\":\"SameNameAndAddress\"},{\"correlationId\":\"2\",\"accountInformation\":{\"accountNumber\":"+fundingAccountNumber+",\"accountType\":\"Cash\"},\"shareEntryInformation\":{\"quantity\":1,\"movementInstruction\":\"Long\",\"securityIdentifier\":{\"symbol\":\"AMZN\"}},\"sourceCode\":\"JNL\",\"typeOfBeneficiary\":\"SameNameAndAddress\"}]}}";
			logger.info("the body is -"+jsonString);
			restApiUtilityPage.addingBodyToRequest(request,jsonString);
			customLogger("Added Body to request", "");
			break;
			
		case "CloseAccountTransferRequest":
			jsonString = "{\"requestHeader\":{\"externalReferenceId\":\"9daabc98-c969-43ad-94c1-0169d9370134\",\"applicationId\":\"amk-svc02\",\"custodialId\":\"WWS\",\"requestor\":{\"identity\":\"2352683\",\"identityType\":\"SubId\"},\"requestAction\":\"Submit\"},\"closeAccountTransferRequestRequest\":{\"subFirmNumber\":1,\"accountTransferId\":\""+accountTransferId+"\"}}";
			logger.info("the body is -"+jsonString);
			restApiUtilityPage.addingBodyToRequest(request,jsonString);
			customLogger("Added Body to request", "");
			break;
			
		case "GetAccountTransferRequests":
			jsonString = "{\"requestHeader\":{\"externalReferenceId\":\"9daabc98-c969-43ad-94c1-0169d9370134\",\"applicationId\":\"amk-svc02\",\"custodialId\":\"WWS\",\"requestor\":{\"identity\":\"2352683\",\"identityType\":\"SubId\"},\"requestAction\":\"Submit\",\"pagingInfo\":{\"pageSize\":100}},\"getAccountTransferRequestsRequest\":{\"filterOption\":{\"accountNumber\":"+fundingAccountNumber+"},\"accountTransferInstruction\":\"Receive\",\"includeTransferAssets\":false}}";
			logger.info("the body is -"+jsonString);
			restApiUtilityPage.addingBodyToRequest(request,jsonString);
			customLogger("Added Body to request", "");
			break;
			
		case "GetPeriodicWithdrawalInstructionsByAccount":
			jsonString = "{\"requestHeader\":{\"externalReferenceId\":\"9daabc98-c969-43ad-94c1-0169d9370134\",\"applicationId\":\"amk-svc02\",\"custodialId\":\"WWS\",\"requestAction\":\"SubmitOrQueue\"},\"getPeriodicWithdrawalInstructionsByAccountRequest\":{\"accountNumber\":"+fundingAccountNumber+"}}";
			logger.info("the body is -"+jsonString);
			restApiUtilityPage.addingBodyToRequest(request,jsonString);
			customLogger("Added Body to request", "");
			break;
		
		case "GetPeriodicWithdrawalInstructionsByAccountTranferOut":
			jsonString = "{\"requestHeader\":{\"externalReferenceId\":\"9daabc98-c969-43ad-94c1-0169d9370134\",\"applicationId\":\"amk-svc02\",\"custodialId\":\"WWS\",\"requestAction\":\"SubmitOrQueue\"},\"getPeriodicWithdrawalInstructionsByAccountRequest\":{\"accountNumber\":"+clientData.get(Constants.ACCOUNT_NUMBER)+"}}";
			logger.info("the body is -"+jsonString);
			restApiUtilityPage.addingBodyToRequest(request,jsonString);
			customLogger("Added Body to request", "");
			break;
			
		case "GetAccountDetail":
			jsonString = "{\"requestHeader\":{\"externalReferenceId\":\"9daabc98-c969-43ad-94c1-0169d9370134\",\"applicationId\":\"amksvc02\",\"custodialId\":\"WWS\",\"requestor\":{\"identity\":\"2352683\",\"identityType\":\"SubId\"},\"requestAction\":\"Submit\",\"pagingInfo\":{\"pageSize\":10}},\"getAccountDetailRequest\":{\"accountNumber\":"+fundingAccountNumber+"}}";
			logger.info("the body is -"+jsonString);
			restApiUtilityPage.addingBodyToRequest(request,jsonString);
			customLogger("Added Body to request", "");
			break;
		
		case "GetAccountDetailTransferOut":
			jsonString = "{\"requestHeader\":{\"externalReferenceId\":\"9daabc98-c969-43ad-94c1-0169d9370134\",\"applicationId\":\"amksvc02\",\"custodialId\":\"WWS\",\"requestor\":{\"identity\":\"2352683\",\"identityType\":\"SubId\"},\"requestAction\":\"Submit\",\"pagingInfo\":{\"pageSize\":10}},\"getAccountDetailRequest\":{\"accountNumber\":"+clientData.get(Constants.ACCOUNT_NUMBER)+"}}";
			logger.info("the body is -"+jsonString);
			restApiUtilityPage.addingBodyToRequest(request,jsonString);
			customLogger("Added Body to request", "");
			break;
			
		case "openAccount":
			jsonString = "{\"requestHeader\":{\"externalReferenceId\":\"9daabc98-c969-43ad-94c1-0169d9370134\",\"applicationId\":\"amksvc02\",\"custodialId\":\"WWS\",\"requestor\":{\"identity\":\"2352683\",\"identityType\":\"SubId\"},\"requestAction\":\"SubmitOrQueue\"},\"updateAccountRequest\":{\"processingInstruction\":\"Submit\",\"accountNumber\":"+clientData.get(Constants.ACCOUNT_NUMBER)+",\"accountStatus\":{\"status\":\"Open\"}}}";
			logger.info("the body is -"+jsonString);
			restApiUtilityPage.addingBodyToRequest(request,jsonString);
			customLogger("Added Body to request", "");
			break;	

		default:
			break;
		}
		 emptyLogger(" \n ");
	 }
	 
	 @When ("User should hit the request and get the response for {string}")
		public void postResponse(String endpointName) {
			emptyLogger(" \n ");
			request.relaxedHTTPSValidation();
			switch (endpointName) {
			case "delete residual":
			case "delete distribution":				
				logger.info("the API url is ::  " +Constants.deleteResidual);
				response = request.post(Constants.deleteResidual);
				break;		
			case "CreateJournalEntry":				
				logger.info("the API url is ::  " +Constants.CreateJournalEntry);
				response = request.post(Constants.CreateJournalEntry);
				break;	
			case "CreateShareEntry":				
				logger.info("the API url is ::  " +Constants.CreateShareEntry);
				response = request.post(Constants.CreateShareEntry);
				break;	
			case "CloseAccountTransferRequest":				
				logger.info("the API url is ::  " +Constants.CloseAccountTransferRequest);
				response = request.post(Constants.CloseAccountTransferRequest);
				break;	
			case "GetAccountTransferRequests":				
				logger.info("the API url is ::  " +Constants.GetAccountTransferRequests);
				response = request.post(Constants.GetAccountTransferRequests);
				break;	
			case "GetPeriodicWithdrawalInstructionsByAccount":				
				logger.info("the API url is ::  " +Constants.GetPeriodicWithdrawalInstructionsByAccount);
				response = request.post(Constants.GetPeriodicWithdrawalInstructionsByAccount);
				break;	
			case "GetAccountDetail":				
				logger.info("the API url is ::  " +Constants.GetAccountDetail);
				response = request.post(Constants.GetAccountDetail);
				break;	
			case "openAccount":				
				logger.info("the API url is ::  " +Constants.openAccount);
				response = request.post(Constants.openAccount);
				break;		
			}
			customLogger("Response", response.asPrettyString());
			logger.info("Response for "+endpointName +"is -->  "+ response.asPrettyString());
			emptyLogger(" \n ");
		}
	 
	 @Then ("User should verify status code {int}")
	 public static void verifyStatusCode(int code) {
		 emptyLogger(" \n ");
		 restApiUtilityPage.verifyStatusCode(response, code);
//		 GenericStepMethods.response = response;
		 emptyLogger(" \n ");
	 } 
	 
	 @Then ("User should verify {string} as {string} for {string}")
	 public void verifyResponseParameter(String parameter, String expectedValue, String apiType) {
		 emptyLogger(" \n ");
		 Object status;
		 switch(apiType){
		 case "GetAccountTransferRequests":
			 status =RestApiUtility.retrivingValueObjectFromResponse(response, "getAccountTransferRequestsResponse.accountTransfers[0].accountTransferStatusDescription");
			 Assert.assertEquals(parameter+" value is not --> "+expectedValue, expectedValue, String.valueOf(status));
			 customLogger(parameter+" value is ", String.valueOf(status));
			 logger.info(parameter+" value is "+ String.valueOf(status));
			break; 
		 case "GetPeriodicWithdrawalInstructionsByAccount":
			 status =RestApiUtility.retrivingValueObjectFromResponse(response, "getPeriodicWithdrawalInstructionsByAccountResponse.accountWithdrawals[0].periodicWithdrawalInformation.distributionStatus");
			 Assert.assertEquals(parameter+" value is not --> "+expectedValue, expectedValue, String.valueOf(status));
			 customLogger(parameter+" value is ", String.valueOf(status));
			 logger.info(parameter+" value is "+ String.valueOf(status));
			break;	
		 case "GetAccountDetail":
			 status =RestApiUtility.retrivingValueObjectFromResponse(response, "getAccountDetailResponse.accountStatus.status");
			 Assert.assertEquals(parameter+" value is not --> "+expectedValue, expectedValue, String.valueOf(status));
			 customLogger(parameter+" value is ", String.valueOf(status));
			 logger.info(parameter+" value is "+ String.valueOf(status));
			break;	
		 } 		
		 emptyLogger(" \n ");
	 }
	 
	 @Then ("User should verify the response body to confirm creation of instruction")
	 public void verifyCreationOfInstruction() {
		 emptyLogger(" \n ");
//		 String responseBody = response.body().prettyPrint();
		 Object status =RestApiUtility.retrivingValueObjectFromResponse(response, "responseHeader.status");
//		 Object description =RestApiUtility.retrivingValueObjectFromResponse(response, "responseHeader.messages[0].description");
		 if(status.equals("SUCCESS")) {
			 Assert.assertTrue("The status is --> "+status,status.equals("SUCCESS")); 
		 }
		 else {
			 Assert.assertTrue("The status is --> "+status,status.equals("FAILURE"));  
		 }
		 customLogger("The status is ", String.valueOf(status));
//		 Assert.assertTrue("The values of the description is --> "+description,description.equals());
		 emptyLogger(" \n ");
	 }	 
	 
	 @Then ("User should check status code {int} for Cancel SWP Workflow")
	 public void verifyStatusCodeForCancelSWPWorkflow(int code) {
		 emptyLogger(" \n ");
		 restApiUtilityPage.checkStatusCode(response, code);
		 customLogger("Check the Status code Recieved", "Checked");
	 }
	 
	 @Then ("User should verify the response body to confirm success")
	 public void validateResponseStatus() {
		 emptyLogger(" \n ");
//		 String responseBody = response.body().prettyPrint();
		 Object status =RestApiUtility.retrivingValueObjectFromResponse(response, "responseHeader.status");
//		 Object description =RestApiUtility.retrivingValueObjectFromResponse(response, "responseHeader.messages[0].description");
		 if(status.equals("SUCCESS")) {
			 Assert.assertTrue("The status is --> "+status,status.equals("SUCCESS")); 
		 }
		 else {
			 Assert.assertTrue("The status is --> "+status,status.equals("FAILURE"));  
		 }
		 customLogger("The status is ", String.valueOf(status));
//		 Assert.assertTrue("The values of the description is --> "+description,description.equals());
		 emptyLogger(" \n ");
	 }
	 
	 @When ("User should design request body for {string} Beta Api Access")
	 public void addBodyForCreateBetaAPIAccess(String API) {
		 emptyLogger(" \n ");
		 switch(API) {
		 
		 case "GetAccountDetail":
			    String jsonString = "{\"requestHeader\":{\"externalReferenceId\":\"9daabc98-c969-43ad-94c1-0169d9370134\",\"applicationId\":\"amk-svc-02\",\"custodialId\":\"WWS\",\"requestor\":{\"identity\":\"2352683\",\"identityType\":\"SubId\"},\"requestAction\":\"Submit\"},\"getAccountDetailRequest\":{\"accountNumber\":"+clientData.get(Constants.ACCOUNT_NUMBER)+"}}";
			    logger.info("the body is -"+jsonString);
				restApiUtilityPage.addingBodyToRequest(request,jsonString);
				customLogger("Added Body to request", "Added");
				break;
				
		 case "getAccountCustomAttributesRequest":
			    String jsonString3 = "{\"requestHeader\":{\"externalReferenceId\":\"9daabc98-c969-43ad-94c1-0169d9370134\",\"applicationId\":\"amk-svc-02\",\"custodialId\":\"WWS\",\"requestor\":{\"identity\":\"2352683\",\"identityType\":\"SubId\"},\"requestAction\":\"Submit\"},\"getAccountCustomAttributesRequest\":{\"accountNumber\":"+clientData.get(Constants.ACCOUNT_NUMBER)+"}}";
			    logger.info("the body is -"+jsonString3);
				restApiUtilityPage.addingBodyToRequest(request,jsonString3);
				customLogger("Added Body to request", "Added");
				break;
				
		 case "UpdateAccountCustomAttributesForFraudAndHoldNO":
			    String jsonString4 = "{\"requestHeader\":{\"externalReferenceId\":\"9daabc98-c969-43ad-94c1-0169d9370134\",\"applicationId\":\"amk-svc-02\",\"custodialId\":\"WWS\",\"requestor\":{\"identity\":\"2352683\",\"identityType\":\"SubId\"},\"requestAction\":\"Submit\"},\"updateAccountCustomAttributesRequest\":{\"accountNumber\":"+clientData.get(Constants.ACCOUNT_NUMBER)+",\"fieldList\":[{\"name\":\"FRAUD ALERT\",\"value\":\"N\"},{\"name\":\"FROZEN COURT ORDERED\",\"value\":\"N\"}]}}";
			    logger.info("the body is -"+jsonString4);
				restApiUtilityPage.addingBodyToRequest(request,jsonString4);
				customLogger("Added Body to request", "Added");
				break;
				
		 case "UpdateAccountCustomAttributesForFraudAndHoldYes":
			    String jsonString5 = "{\"requestHeader\":{\"externalReferenceId\":\"9daabc98-c969-43ad-94c1-0169d9370134\",\"applicationId\":\"amk-svc-02\",\"custodialId\":\"WWS\",\"requestor\":{\"identity\":\"2352683\",\"identityType\":\"SubId\"},\"requestAction\":\"Submit\"},\"updateAccountCustomAttributesRequest\":{\"accountNumber\":"+clientData.get(Constants.ACCOUNT_NUMBER)+",\"fieldList\":[{\"name\":\"FRAUD ALERT\",\"value\":\"Y\"},{\"name\":\"FROZEN COURT ORDERED\",\"value\":\"Y\"}]}}";
			    logger.info("the body is -"+jsonString5);
				restApiUtilityPage.addingBodyToRequest(request,jsonString5);
				customLogger("Added Body to request", "Added");
				break;
				
		 case "UpdateAccountCustomAttributesForFraud":
			    String jsonString6 = "{\"requestHeader\":{\"externalReferenceId\":\"9daabc98-c969-43ad-94c1-0169d9370134\",\"applicationId\":\"amk-svc-02\",\"custodialId\":\"WWS\",\"requestor\":{\"identity\":\"2352683\",\"identityType\":\"SubId\"},\"requestAction\":\"Submit\"},\"updateAccountCustomAttributesRequest\":{\"accountNumber\":"+clientData.get(Constants.ACCOUNT_NUMBER)+",\"fieldList\":[{\"name\":\"FRAUD ALERT\",\"value\":\"Y\"},{\"name\":\"FROZEN COURT ORDERED\",\"value\":\"N\"}]}}";
			    logger.info("the body is -"+jsonString6);
				restApiUtilityPage.addingBodyToRequest(request,jsonString6);
				customLogger("Added Body to request", "Added");
				break;
				
		 case "UpdateAccountCustomAttributesForHold":
			    String jsonString7 = "{\"requestHeader\":{\"externalReferenceId\":\"9daabc98-c969-43ad-94c1-0169d9370134\",\"applicationId\":\"amk-svc-02\",\"custodialId\":\"WWS\",\"requestor\":{\"identity\":\"2352683\",\"identityType\":\"SubId\"},\"requestAction\":\"Submit\"},\"updateAccountCustomAttributesRequest\":{\"accountNumber\":"+clientData.get(Constants.ACCOUNT_NUMBER)+",\"fieldList\":[{\"name\":\"FRAUD ALERT\",\"value\":\"N\"},{\"name\":\"FROZEN COURT ORDERED\",\"value\":\"Y\"}]}}";
			    logger.info("the body is -"+jsonString7);
				restApiUtilityPage.addingBodyToRequest(request,jsonString7);
				customLogger("Added Body to request", "Added");
				break;
				
		 case "updateAccountForOpenStatus":
			    String jsonString1 = "{\"requestHeader\":{\"externalReferenceId\":\"9daabc98-c969-43ad-94c1-0169d9370134\",\"applicationId\":\"amk-svc-02\",\"custodialId\":\"WWS\",\"requestor\":{\"identity\":\"2352683\",\"identityType\":\"SubId\"},\"requestAction\":\"Submit\"},\"updateAccountRequest\":{\"processingInstruction\":\"Submit\",\"accountNumber\":"+clientData.get(Constants.ACCOUNT_NUMBER)+",\"accountStatus\":{\"status\":\"Open\"},\"decedentName\":\"SamSmith\"}}";
			    logger.info("the body is -"+jsonString1);
				restApiUtilityPage.addingBodyToRequest(request,jsonString1);
				customLogger("Added Body to request", "Added");
				break;
				
		 case "updateAccountForClosedStatus":
			    String jsonString2 = "{\"requestHeader\":{\"externalReferenceId\":\"9daabc98-c969-43ad-94c1-0169d9370134\",\"applicationId\":\"amk-svc-02\",\"custodialId\":\"WWS\",\"requestor\":{\"identity\":\"2352683\",\"identityType\":\"SubId\"},\"requestAction\":\"Submit\"},\"updateAccountRequest\":{\"processingInstruction\":\"Submit\",\"accountNumber\":"+clientData.get(Constants.ACCOUNT_NUMBER)+",\"accountStatus\":{\"status\":\"Closed\",\"secondaryStatus\":\"NoPositions\"},\"decedentName\":\"SamSmith\"}}";
			    logger.info("the body is -"+jsonString2);
				restApiUtilityPage.addingBodyToRequest(request,jsonString2);
				customLogger("Added Body to request", "Added");
				break;
				
		 case "GetACHInstructionsByAccount":
			    String jsonString8 = "{\"requestHeader\":{\"externalReferenceId\":\"9daabc98-c969-43ad-94c1-0169d9370134\",\"applicationId\":\"amk-svc-02\",\"custodialId\":\"WWS\",\"requestor\":{\"identity\":\"2426862\",\"identityType\":\"SubId\"},\"requestAction\":\"Submit\",\"pagingInfo\":{\"pageSize\":10}},\"getACHInstructionsByAccountRequest\":{\"accountNumber\":"+clientData.get(Constants.ACCOUNT_NUMBER)+",\"instructionStatus\":\"Active\"}}";
			    logger.info("the body is -"+jsonString8);
				restApiUtilityPage.addingBodyToRequest(request,jsonString8);
				customLogger("Added Body to request", "Added");
				break;
				
		 case "GetPayeeInstructions":
			    String jsonString9 ="{\"requestHeader\":{\"externalReferenceId\":\"9daabc98-c969-43ad-94c1-0169d9370134\",\"applicationId\":\"amk-svc-02\",\"custodialId\":\"WWS\",\"requestor\":{\"identity\":\"2352683\",\"identityType\":\"SubId\"},\"requestAction\":\"Submit\",\"pagingInfo\":{\"pageSize\":10}},\"getPayeeInstructionsRequest\":{\"accountNumber\":"+clientData.get(Constants.ACCOUNT_NUMBER)+",\"instructionStatus\":\"Active\"}}" ;
			    logger.info("the body is -"+jsonString9);
				restApiUtilityPage.addingBodyToRequest(request,jsonString9);
				customLogger("Added Body to request", "Added");
				break;
				
		 default:
				break;
		 }
		 
		 emptyLogger(" \n ");		 
	 }
	 
	 @When ("User should generate bearer token for Beta Access")
	 public void generateAccessToken_DM2_BetaAccess() {
		 emptyLogger(" \n ");
		 accessToken = restApiUtilityPage.getBearerToken_DM2BetaAccess();
		 emptyLogger(" \n ");
	 } 
	 
	 @When ("User should add request header parameters For {string}")
	 public void addHeaders1(String apiName) {
		 emptyLogger(" \n ");
		 switch(apiName) {		 
			 
		 case "GetAccountDetail":
			 request = RestAssured.given();
			 restApiUtilityPage.addingHeaderParameters_DM2BetaAccess(request, accessToken);
			 customLogger("Adding Header Parameters to the Request", "Added");
			 break;
			 
		 case "GetAccountCustomAttributes":
			 request = RestAssured.given();
			 restApiUtilityPage.addingHeaderParameters_CancelSWP_createInstruction(request, accessToken);
			 customLogger("Adding Header Parameters to the Request", "Added");
			 break;
			 
		 case "UpdateAccountCustomAttributes":
			 request = RestAssured.given();
			 restApiUtilityPage.addingHeaderParameters_CancelSWP_createInstruction(request, accessToken);
			 customLogger("Adding Header Parameters to the Request", "Added");
			 break;
			 
		 case "updateAccountForBeta":
			 request = RestAssured.given();
			 restApiUtilityPage.addingHeaderParameters_DM2BetaAccess(request, accessToken);
			 customLogger("Adding Header Parameters to the Request", "Added");
			 break;
		 
		 case "GetACHInstructionsByAccount":
			 request = RestAssured.given();
			 restApiUtilityPage.addingHeaderParameters_CancelSWP_createInstruction(request, accessToken);
			 customLogger("Adding Header Parameters to the Request", "Added");
			 break;
			 
		 case "GetPayeeInstructions":
			 request = RestAssured.given();
			 restApiUtilityPage.addingHeaderParameters_CancelSWP_createInstruction(request, accessToken);
			 customLogger("Adding Header Parameters to the Request", "Added");
			 break;
			 
				 }		
	 }	
	 
	 @When ("User should design request body for {string} API")
	 public void addBodyForGetWithdrawalInstructionByAccount(String accountAddress) {
		 emptyLogger(" \n ");
		 String jsonString = "{\"requestHeader\":{\"externalReferenceId\":\"9daabc98-c969-43ad-94c1-0169d9370134\",\"applicationId\":\"amk-svc-02\",\"custodialId\":\"WWS\",\"requestor\":{\"identity\":\"2426862\",\"identityType\":\"SubId\"},\"requestAction\":\"Submit\"},\"getPeriodicWithdrawalInstructionsByAccountRequest\":{\"accountNumber\":"+clientData.get(Constants.ACCOUNT_NUMBER)+",\"instructionStatus\":\"Active\"}}";
			logger.info("the body is -"+jsonString);
			restApiUtilityPage.addingBodyToRequest(request,jsonString);
			customLogger("Added Body to request", "");
		 emptyLogger(" \n ");
	 }
	
}
