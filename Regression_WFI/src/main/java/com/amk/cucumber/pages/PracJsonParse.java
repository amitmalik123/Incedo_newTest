package com.amk.cucumber.pages;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class PracJsonParse {
	static List<String> lst = new ArrayList<String>();
	
	public static void main(String[] args) {	
		parameters();
	}
	
	public static void stringReq() {
		String s= "{\r\n"
				+ "    \"responseHeader\": {\r\n"
				+ "        \"externalReferenceId\": \"9daabc98-c969-43ad-94c1-0169d9370134\",\r\n"
				+ "        \"internalReferenceId\": \"03ee54cf-bdea-44ef-8170-371bf5487681\",\r\n"
				+ "        \"pagingInfo\": {\r\n"
				+ "            \"isLastPage\": true,\r\n"
				+ "            \"rowsInCurrentPage\": 1\r\n"
				+ "        },\r\n"
				+ "        \"status\": \"SUCCESS\",\r\n"
				+ "        \"messages\": []\r\n"
				+ "    },\r\n"
				+ "    \"getPeriodicWithdrawalInstructionsByAccountResponse\": {\r\n"
				+ "        \"accountWithdrawals\": [\r\n"
				+ "            {\r\n"
				+ "                \"trailerDescription\": \"DISBURSEMENT\",\r\n"
				+ "                \"recipientInformation\": {\r\n"
				+ "                    \"socialSecurityNumber\": \"000008888\",\r\n"
				+ "                    \"payeeInstructionNumber\": 2,\r\n"
				+ "                    \"typeOfPayee\": \"SameNameAndAddress\",\r\n"
				+ "                    \"alternateNameAndAddressLines\": {\r\n"
				+ "                        \"alternateNameAndAddressLine1\": \"HENRY\",\r\n"
				+ "                        \"alternateNameAndAddressLine2\": \"6948 SHEPHERD\",\r\n"
				+ "                        \"alternateNameAndAddressLine3\": \"RUSSELVILLE AR  72801\",\r\n"
				+ "                        \"state\": \"CO\"\r\n"
				+ "                    }\r\n"
				+ "                },\r\n"
				+ "                \"periodicWithdrawalInformation\": {\r\n"
				+ "                    \"frequency\": \"OneTime\",\r\n"
				+ "                    \"beginningDate\": \"2024-07-01\",\r\n"
				+ "                    \"nextPayableDate\": \"2024-07-01\",\r\n"
				+ "                    \"distributionStatus\": \"Active\",\r\n"
				+ "                    \"alternativeRequiredMinimumDistribution\": \"NotAutomaticallyAdjusted\",\r\n"
				+ "                    \"federalWithholding\": {\r\n"
				+ "                        \"taxWithheld\": false\r\n"
				+ "                    },\r\n"
				+ "                    \"stateWithholding\": {\r\n"
				+ "                        \"taxWithheld\": false\r\n"
				+ "                    },\r\n"
				+ "                    \"ACHWithdrawalInstruction\": {\r\n"
				+ "                        \"transactionSource\": \"PaperSignatureOnFile\",\r\n"
				+ "                        \"ACHAuthorizationType\": \"PrearrangedPaymentAndDeposit\",\r\n"
				+ "                        \"mailAdviceSent\": false\r\n"
				+ "                    },\r\n"
				+ "                    \"checkWithdrawalInstruction\": {\r\n"
				+ "                        \"sourceCode\": \"CCHK\",\r\n"
				+ "                        \"checkType\": \"R\",\r\n"
				+ "                        \"creditInterest\": false,\r\n"
				+ "                        \"moneyMarket\": false,\r\n"
				+ "                        \"otherIncome\": false,\r\n"
				+ "                        \"freeCredit\": false,\r\n"
				+ "                        \"moneyMarketBalance\": true\r\n"
				+ "                    }\r\n"
				+ "                },\r\n"
				+ "                \"auditTrail\": {\r\n"
				+ "                    \"created\": {\r\n"
				+ "                        \"date\": \"2024-06-26\",\r\n"
				+ "                        \"userInitials\": \"BAM\",\r\n"
				+ "                        \"moneyMarket\": true\r\n"
				+ "                    },\r\n"
				+ "                    \"modified\": {\r\n"
				+ "                        \"userId\": \"BAM\",\r\n"
				+ "                        \"source\": \"BLServer\"\r\n"
				+ "                    }\r\n"
				+ "                }\r\n"
				+ "            }\r\n"
				+ "        ]\r\n"
				+ "    }\r\n"
				+ "}";
		JSONObject jsonObject = new JSONObject(s);		
		getKey(jsonObject, "moneyMarket");		
	}
	
	public static void getKey(JSONObject json, String key) {
		boolean exists= json.has(key);
		Iterator<?> keys;
		String nextKeys;
		
		if(!exists) {
			keys= json.keys();
			while(keys.hasNext()) {
				nextKeys =(String)keys.next();
				try {
					if(json.get(nextKeys) instanceof JSONObject) {
						if(exists == false) {
							getKey(json.getJSONObject(nextKeys), key);
						}
					}else if(json.get(nextKeys) instanceof JSONArray) {
						JSONArray jsonArray= json.getJSONArray(nextKeys);						
						for(int i=0;i<jsonArray.length();i++) {
							String jsonArrayString = jsonArray.get(i).toString();
							JSONObject innerJsonObject = new JSONObject(jsonArrayString);
							if(exists == false) {
								getKey(innerJsonObject, key);
							}							
						}
					}
				}catch(Exception e) {
					
				}
			}
		}else {
			parseObject(json, key);
		}
	}
	
	
	public static void parseObject(JSONObject json, String key) throws JSONException {
		lst.add(json.get(key).toString());
		System.out.println(json.get(key));
	}	
	
	public static void rerSpec() {
		RequestSpecification reqSpec = new RequestSpecBuilder()
				.setBaseUri("")
				.setBody("")
				.build();
		
		RestAssured.given().log().all().spec(reqSpec).when().get().then().statusCode(200).log().all();		
	}
	
	public static void resSpec() {
		ResponseSpecification responseSpec = new ResponseSpecBuilder()
				.expectStatusCode(200)
				.expectContentType(ContentType.JSON)
				.build();
		
		RestAssured.given().when().get().then().spec(responseSpec);
	}

	public static void fileUpload() {
		RestAssured.given().multiPart(new File("user.dir"+"/pathToFile"))
		.when().post().then().statusCode(200);		
	}
	
	public static void extractResponse() {
		Response response= RestAssured.given().when().get().then().extract().response();
		System.out.println("response: "+ response.asString());
	}
	
	public static void parameters() {
		String URL= "http://api.example.com/users/{userId}/orders/{orderId}?status={status}&sort={sort}";
		RestAssured.baseURI= "http://api.example.com";
			
		Response response= RestAssured.given().relaxedHTTPSValidation()
		.pathParam("userId", 1)
		.pathParam("orderId", 1)
		.queryParam("status", 200)
		.queryParam("sort", "ascending")
		.when().get("/users/{userId}/orders/{ordersId}")
		.then().log().all().extract().response();
		
		System.out.println("url: "+ URL);
		System.out.println("response: "+ response.asString());
	}
	
	public static void schemaValidation() {
		RestAssured.baseURI= "http://api.example.com";
		RestAssured.given()
		.when().get().then().assertThat().body(matchesJsonSchemaInClasspath("./Data/schemaValidation.json"));
	}
	
	public static void designReq() {
		JSONArray emp1 = new JSONArray();
		JSONArray emp2 = new JSONArray();
		JSONObject emp3 = new JSONObject();
		JSONObject emp4 = new JSONObject();		
		JSONObject fi = new JSONObject();		
		emp3.put("firstname", "tom");
		emp3.put("salary", 72000);
		emp3.put("age", 59);
		emp3.put("firstname", "Mathew");		
		emp1.put(emp3);		
		emp4.put("firstname", "Perry");
		emp4.put("salary", 36000);
		emp4.put("age", 32);
		emp4.put("firstname", "David");		
		emp2.put(emp4);		
		fi.put("employee1", emp1);
		fi.put("employee2", emp2);		
		System.out.println(fi.toString(4));	
		
		System.out.println(JsonPath.read(fi.toString(), "$.*").toString());	
		System.out.println(JsonPath.read(fi.toString(), "$.employee1").toString());	
		System.out.println(JsonPath.read(fi.toString(), "$.employee1[*].firstname").toString());	
		System.out.println(JsonPath.read(fi.toString(), "$..firstname[?(@.age==59)]").toString());
	}
	
	public static void om() {
		ObjectMapper om= new ObjectMapper();
		
	}

	
	//.book[?(@.price in ['',''])]
}
