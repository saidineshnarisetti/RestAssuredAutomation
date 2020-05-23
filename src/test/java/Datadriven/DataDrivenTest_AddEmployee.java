package Datadriven;

import org.apache.http.HttpRequest;
import org.apache.http.protocol.HTTP;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DataDrivenTest_AddEmployee {
	@Test
	void postnewEmployee() {
		
			//specify asee url 
				RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
				RequestSpecification httpRequest =RestAssured.given();
				//Request object
				JSONObject requestParams = new JSONObject();
				requestParams.put("name", "Dinesh");
				requestParams.put("salary", "10000");
				requestParams.put("age", "28");
				httpRequest.header("content-Type", "application/json");
				
				
				httpRequest.body(requestParams.toJSONString());
				
				//Response
				Response response = httpRequest.request(Method.POST,"/create");
				String responseBody= response.getBody().asString();
				Assert.assertEquals(responseBody.contains("Dinesh"), true);
				Assert.assertEquals(responseBody.contains("10000"), true);
				Assert.assertEquals(responseBody.contains("28"), true);
				
				//status
				int statuscode = response.getStatusCode();
				Assert.assertEquals(statuscode, 200);
				
				
	}

}
