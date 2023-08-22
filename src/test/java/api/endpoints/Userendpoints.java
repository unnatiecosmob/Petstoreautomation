package api.endpoints;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

//Create for CRUD - Create, Update, Read, Delete.
public class Userendpoints {
	 
	public static Response createuser(User payload)
	{
		Response response =given().contentType(ContentType.JSON)
		.accept(ContentType.JSON).body(payload)
		.when().post(Routes.post_url);
		
		return response;
	}
	
	public static Response getuser(String Username)
	{
		Response response =given()
				.pathParam("Username", Username)
		.when().get(Routes.get_url);
		
		return response;
	}
	
	public static Response updateuser(String Username, User payload)
	{
		Response response =given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON).pathParam("Username", Username).body(payload)
		.when().put(Routes.put_url);
		
		return response;
	}
	
	public static Response deleteuser(String Username)
	{
		Response response =given()
				.pathParam("Username", Username)
		.when().delete(Routes.delete_url);
		
		return response;
	}
	
	
	
	
	
	
	
	
	
	
}
