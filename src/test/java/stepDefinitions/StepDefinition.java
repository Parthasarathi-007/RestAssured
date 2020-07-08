package stepDefinitions;
import pojo.location;
import resources.APIResources;
import resources.Utils;
import resources.responseBuid;
import pojo.Serialize;
import pojo.Deserialize;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class StepDefinition extends Utils{

	RequestSpecification input;
	ResponseSpecification Res;
	pojo.Deserialize P = new pojo.Deserialize();
	static Response R;
	static String resource;
	//static String outPutValidation;
	
	//static RequestSpecification getPlaceid;
	
	Utils requestSpecification = new Utils();
	
	
	responseBuid responseB = new responseBuid();

	//Serialize  s = responseB.addPlacePayload();
	
	@Given("the AddPlace Payload with {string},{string},{string}")
	public void the_add_place_payload_with(String name, String language, String address)
	{
			
			 Res = new ResponseSpecBuilder().expectStatusCode(200)
					.expectContentType(ContentType.JSON).build();
			
			
			try {
				input =  given().spec(requestSpecificationBuilder()).body(responseB.addPlacePayload(name,language,address));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
					
		    //throw new io.cucumber.java.PendingException();
		}


	
	@When("user calls {string} with {string} http request")
	public void user_calls_with_http_request(String resource, String method) {
			
		APIResources resourceAPI = APIResources.valueOf(resource);
		String resourcename = resourceAPI.getResource();
		System.out.println(resourcename);
	
		if (method.equalsIgnoreCase("POST"))
			 R = input.when().post(resourceAPI.getResource())
			.then().spec(Res).log().all().extract().response();	
		else if (method.equalsIgnoreCase("GET"))
		
		R = input.when().post(resourceAPI.getResource())
		.then().spec(Res).log().all().extract().response();
			
			System.out.println(resourcename);
		}

	    @Then("^API call is success with status code 200$")
	    public void api_call_is_success_with_status_code_200()  {
	      
	    	int statusCode =R.getStatusCode();
			
	    	//System.out.println(statusCode);
	    	if (statusCode== 200)
	    			
	    	{
	    		System.out.println("Place successfully added");
	    	}
	    	else
	    		
	    		System.out.println("Place NOT successfully added");
		
		//assertEquals(R.getStatusCode(),200);
				
	        //throw new PendingException();
		}
	   /* @Then("^validate that \"([^\"]*)\" is \"([^\"]*)\"$")
	    public void validate_that_something_is_something(String Key, String Value)  {
	    	
	    //outPutValidation = R.asString();
	   
	  // JsonPath j = new JsonPath(outPutValidation);
	   
	   assertEquals(getJsonPath( R, Key),Value);
	   //j.get(Key);
	   
	   
	    }
	    
	   /* @And("^validate that  place _id  matches with \"([^\"]*)\" in response from \"([^\"]*)\"$")
	    public void validate_that_place_id_matches_with_something_in_response_from_something(String name, String getplaceapi) throws IOException 
	    {
	      
		  
		   String placeID = getJsonPath(R,"place_id");
		
		   input  =    given().spec(requestSpecificationBuilder()).queryParam("place_id", placeID);
		   
		 
		   user_calls_with_http_request( resource,"GET");
		   
		   String extractedName = getJsonPath(R,"name");
		   
		   System.out.println("the name is"+extractedName);*/
	    }
		









