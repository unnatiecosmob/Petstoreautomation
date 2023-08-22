package api.test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.Userendpoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class Datadriventesting {
	
	
	@Test(priority = 1, dataProvider = "data", dataProviderClass = DataProviders.class)
	
	public void TestPostUser(String UserID, String Username, String FirstName, String LastName, String Email, String Password, String Phone) 
	
	{
		User userPayload = new User();
		userPayload.setId(Integer.parseInt(UserID));
		userPayload.setUsername(Username);
		userPayload.setFirstName(FirstName);
		userPayload.setLastName(LastName);
		userPayload.setEmail(Email);
		userPayload.setPassword(Password);
		userPayload.setPhone(Phone);
		
		Response response = Userendpoints.createuser(userPayload);
		response.then().log().all();
		AssertJUnit.assertEquals(response.getStatusCode(), 200);
		
	}
	
	@Test(priority = 1, dataProvider = "Username", dataProviderClass = DataProviders.class)
	
	public void deleteuserbyusername(String Username) {
		Response response = Userendpoints.deleteuser(Username);
		AssertJUnit.assertEquals(response.getStatusCode(), 200);
	}
}



