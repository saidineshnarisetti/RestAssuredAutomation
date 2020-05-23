import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC006_Get_Authrization {
	@Test
	void getauthrization() {
		//specify asee url 
		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
		//Request object
		  RequestSpecification httpRequest=RestAssured.given();
		//Response object
		  Response response=httpRequest.request(Method.GET,"/Bengaluru");
		  
		  System.out.println("Response body is:"+ response.getBody().asString());
		  
		  //status code validation
		
		  Assert.assertEquals(response.getStatusCode(), 200);
		  
		  //status validationn
		  Assert.assertEquals(response.getStatusLine(),"HTTP/1.1 200 OK");
	}
}
