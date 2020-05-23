package Datadriven;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DataDrivenTest_AddEmployees {
	@Test(dataProvider= "empdataprovider")
	void postnewEmployees(String ename,String eage, String esal) {
		//specify asee url 
		RestAssured.baseURI="http://dummy.restapiexample.com/api/v1";
		RequestSpecification httpRequest =RestAssured.given();
		//Request object
		JSONObject requestParams = new JSONObject();
		requestParams.put("name", ename);
		requestParams.put("salary", eage);
		requestParams.put("age", esal);
		httpRequest.header("content-Type", "application/json");
		
		
		httpRequest.body(requestParams.toJSONString());
		
		//Response
		Response response = httpRequest.request(Method.POST,"/create");
		String responseBody= response.getBody().asString();
		System.out.println("Eresponse body is :"+ responseBody);
		Assert.assertEquals(responseBody.contains(ename), true);
		Assert.assertEquals(responseBody.contains(eage), true);
		Assert.assertEquals(responseBody.contains(esal), true);
		
		//status
		int statuscode = response.getStatusCode();
		Assert.assertEquals(statuscode, 200);
		
	}
	@DataProvider(name="empdataprovider")
	String [][] getEmpdata(){
		String empdata[][]= {{"AC123","10000","20"},{"AC1234","20000","25"},{"AC12345","30000","30"}};
		return (empdata);
	}

}
