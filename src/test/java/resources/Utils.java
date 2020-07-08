package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class Utils {
	public static RequestSpecification Req;
	
	public RequestSpecification requestSpecificationBuilder() throws IOException {
		
		if (Req==null)
		{
		
		PrintStream requestLog = new PrintStream(new FileOutputStream("logging.txt"));
		
		Req= new RequestSpecBuilder().setBaseUri(getGlobalVariables("baseURI"))
				.addQueryParam("key", "qaclick123").setContentType(ContentType.JSON)
				.addFilter(RequestLoggingFilter.logRequestTo(requestLog))
				.addFilter(ResponseLoggingFilter.logResponseTo(requestLog)).build();
		return Req;
		}
		return Req;
	}
	
	public static String  getGlobalVariables(String Key) throws IOException {
		
		Properties Prop = new Properties();
		
		FileInputStream fis = new FileInputStream("src\\test\\java\\resources\\global.properties");
	
		Prop.load(fis);
		
		return Prop.getProperty(Key);
		
		
	}
	
	
	public String getJsonPath(Response R,String element)
	{
		
		
		String  outputValidation = R.toString();
		
		JsonPath j = new JsonPath(outputValidation);
		
		return   j.getString(element).toString();
	}
	

}
