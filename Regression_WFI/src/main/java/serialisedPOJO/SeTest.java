package serialisedPOJO;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class SeTest {

	public static void main(String[] args) {
		 
		PostAPIPojo poReq = PostAPIPojo.builder()
		.name("morpheus")
		.job("leader")
		.build();
		
		RestAssured.baseURI = "https://reqres.in/api/users";
		
		Response response= RestAssured.given().contentType(ContentType.JSON).body(poReq).when().post();
		System.out.println(response.asPrettyString());	
	}

}
