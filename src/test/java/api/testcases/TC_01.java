package api.testcases;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.userEndPoints;
import api.payload.userpayload;
import io.restassured.response.Response;
public class TC_01 {

	Faker faker;
	userpayload userpayload;


	@Test(priority=0)
	public void setupdata() {
		faker=new Faker();
		userpayload= new userpayload();
		userpayload.setId2(faker.idNumber().hashCode());
		userpayload.setUsername(faker.name().username());
		userpayload.setFirstName(faker.name().firstName());
		userpayload.setLastName(faker.name().lastName());
		userpayload.setPhone(faker.phoneNumber().cellPhone());
		userpayload.setPassword(faker.internet().password(2, 8));
		userpayload.setEmail(faker.internet().emailAddress());
		System.out.println(userpayload.getEmail());
		System.out.println(userpayload.getFirstName());
		System.out.println(userpayload.getLastName());
		System.out.println(userpayload.getPhone());
		System.out.println(userpayload.getPassword());
		System.out.println(userpayload.getUsername());

	}
/*
	@Test(priority=2)
	public void testpostuser() {
		System.out.println("<<<<<<<<<,create user body is>>>>>>");

		Response res=userEndPoints.createuser(userpayload);
		res.then().log().all();
		System.out.println(res.getStatusCode());

	}
	*/
	
	@Test(priority=1)
	public void getuser() {
		System.out.println("<<<<<<<<<,get body is>>>>>>");

		Response res= userEndPoints.getuser(this.userpayload.getUsername());
		System.out.println(res.getStatusCode());
		Assert.assertEquals(res.getStatusCode(),200);
	}
	/*
	@Test(priority=3)
	public void updateuser() {
		System.out.println("<<<<<<<<<,after update body is>>>>>>");

		//below valuse of same username we want to change
		userpayload.setFirstName(faker.name().firstName());
		userpayload.setLastName(faker.name().lastName());
		userpayload.setPhone(faker.phoneNumber().cellPhone());

		Response res= userEndPoints.updateuser(this.userpayload.getUsername(), userpayload);
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(), 200);
	}
	@Test(priority=4)
	public void deleteuser() {
		Response res= userEndPoints.deleteuser(this.userpayload.getUsername());
		System.out.println("<<<<<<<<<,after delete body is>>>>>>");
		res.getBody();
		
	}
*/
	}
