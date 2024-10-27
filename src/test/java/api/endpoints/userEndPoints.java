package api.endpoints;

import static io.restassured.RestAssured.given;

import api.payload.userpayload;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class userEndPoints {

	//here we are accesing the url form routes class
	//also we are performing crud operations
	public static Response createuser(userpayload payload) {
		//String payload is coming from user class/payload package
		Response res= given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
				.when()
			//	.post("https://petstore.swagger.io/v2/user/createWithList")
				.post(routes.post_url);
		return res;
	}
	public static Response getuser(String username) {
		Response res= given()
				.pathParam("username", username)
				.when()
				.get(routes.get_url);
		return res;
	}
	public static Response updateuser(String string, userpayload payload) {
		Response res= given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
				.when()
				.put(routes.update_url);
		return res;
	}
	public static Response deleteuser(String username) {
		Response res= given()
				.pathParam("username", username)
				.when()
				.delete(routes.delete_url);
		return res;
	}


}
