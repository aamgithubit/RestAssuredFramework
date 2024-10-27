package api.endpoints;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.payload.userpayload;
import io.restassured.http.ContentType;

public class routes {

	public static String base_url="https://petstore.swagger.io/v2";
	
	public static String post_url= base_url + "/user/createWithList";
	public static String get_url= base_url+ "/user/{username}";
	///user/{username}>> path param added/required
	public static String update_url= base_url+ "/user/{username}";
	public static String delete_url= base_url+ "/user/{username}";
	Faker faker;
	
	@Test
	public void test() {
		userpayload userpayload= new userpayload();
	userpayload.setId2(faker.idNumber().hashCode());
	userpayload.setUsername(faker.name().username());
	userpayload.setFirstName(faker.name().firstName());
	
	given().contentType(ContentType.JSON)
	.accept(ContentType.JSON)
	.body(userpayload)
	.when().post(post_url).then().log().all();
	
}}

