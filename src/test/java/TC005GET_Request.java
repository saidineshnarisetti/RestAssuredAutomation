import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC005GET_Request {
	
	@Test
	void getweatherdetails() {
		//specify asee url 
		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
		//Request object
		  RequestSpecification httpRequest=RestAssured.given();
		//Response object
		  Response response=httpRequest.request(Method.GET,"/Delhi");
		  
		  String ResBody =response.getBody().asString();
		  
		  System.out.println("Response body is:"+ ResBody);
		  
		  //status code validation
		
		  Assert.assertEquals(response.getStatusCode(), 200);
		  
		  //status validationn
		  Assert.assertEquals(response.getStatusLine(),"HTTP/1.1 200 OK");
		  //Response Body
		  Assert.assertEquals(ResBody.contains("Delhi"),true);
		  
		  JsonPath jsonpath= response.jsonPath();
		  System.out.println(jsonpath.get("City"));
		  System.out.println(jsonpath.get("Temperature"));
		  System.out.println(jsonpath.get("Humidity"));
	}

}
