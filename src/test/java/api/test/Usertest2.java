package api.test;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.Userendpoints;
import api.endpoints.Userendpoints2;
import api.payload.User;
import io.restassured.response.Response;

public class Usertest2 {

	
	Faker faker;
	User userpayload;
	
	public Logger logger; //For log.
	
	@BeforeClass
	public void usersetdata()
	{
		faker = new Faker();
		userpayload = new User();
		
		userpayload.setId(faker.idNumber().hashCode());
		userpayload.setUsername(faker.name().username());
		userpayload.setFirstName(faker.name().firstName());
		userpayload.setLastName(faker.name().lastName());
		userpayload.setEmail(faker.internet().emailAddress());
		userpayload.setPassword(faker.internet().password());
		userpayload.setPhone(faker.phoneNumber().cellPhone());
		
		//logs
		
		logger = LogManager.getLogger(this.getClass());
		
		
	}
	
	@Test(priority = 1)
	public void TestPostUser()
	{
		logger.info("*************** User creating **************");
		
		Response response = Userendpoints2.createuser(userpayload);
		response.then().log().all();
		
		AssertJUnit.assertEquals(response.getStatusCode(), 200);
		
		logger.info("*************** User created **************");
	}
	
	@Test(priority = 2)
	public void TestGetUser()
	{
		logger.info("*************** Reading user **************");
		
		Response response = Userendpoints2.getuser(this.userpayload.getUsername());
		response.then().log().all();
		
		AssertJUnit.assertEquals(response.getStatusCode(), 200);
		
		logger.info("*************** User displayed **************");
		
	}
	
	@Test(priority = 3)
	
	public void TestUpdateUser()
	{
		//Updating data.
		
		logger.info("*************** Updating user **************");
		
		userpayload.setFirstName(faker.name().firstName());
		userpayload.setLastName(faker.name().lastName());
		userpayload.setEmail(faker.internet().emailAddress());
		
		Response response = Userendpoints2.updateuser(this.userpayload.getUsername(), userpayload);
		response.then().log().all();
		AssertJUnit.assertEquals(response.getStatusCode(), 200);
		
		logger.info("*************** User is updated **************");
		//Read Updated data
		Response responseafterupdate = Userendpoints.getuser(this.userpayload.getUsername());
		AssertJUnit.assertEquals(responseafterupdate.getStatusCode(), 200);
		
		
	}
	
	@Test(priority = 4)
	public void TestDeleteUser()
	{
		logger.info("*************** Deleteing user **************");
		
		Response response = Userendpoints2.deleteuser(this.userpayload.getUsername());
		AssertJUnit.assertEquals(response.getStatusCode(), 200);
	
		logger.info("*************** User is Deleted **************");
	}
	
}
