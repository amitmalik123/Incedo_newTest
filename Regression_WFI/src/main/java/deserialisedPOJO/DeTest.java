package deserialisedPOJO;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class DeTest {

	public static void main(String[] args) {
		
		RestAssured.baseURI= "https://reqres.in/api/users?page=2";
		
		RequestSpecification request=  RestAssured.given();
		
		ListUsersPOJO po = request.when().get().as(ListUsersPOJO.class);
		
		System.out.println(po.toString());
	}

}
