package api.endpoints;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.ResourceBundle;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

//Create for CRUD - Create, Update, Read, Delete.
public class Userendpoints2 {
	
	 //Method for getting all the URL from the properties file
	
	static ResourceBundle getURL()
	{
		ResourceBundle routes = ResourceBundle.getBundle("routes");//load all the URL
		return routes;
	}
	 
	public static Response createuser(User payload)
	{
		String post_url = getURL().getString("post_url");
		
		Response response =given().contentType(ContentType.JSON)
		.accept(ContentType.JSON).body(payload)
		.when().post(post_url);
		
		return response;
	}
	
	public static Response getuser(String Username)
	{
		
		String get_url = getURL().getString("get_url");
		
		Response response =given()
				.pathParam("Username", Username)
		.when().get(get_url);
		
		return response;
	}
	
	public static Response updateuser(String Username, User payload)
	{
		
		String put_url = getURL().getString("put_url");
		
		Response response =given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON).pathParam("Username", Username).body(payload)
		.when().put(put_url);
		
		return response;
	}
	
	public static Response deleteuser(String Username)
	{
		String delete_url = getURL().getString("delete_url");
		Response response =given()
				.pathParam("Username", Username)
		.when().delete(Routes.delete_url);
		
		return response;
	}
	
	
	
	
	
	
	
	
	
	
}
