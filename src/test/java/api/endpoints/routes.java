package api.endpoints;

public class routes {

	public static String base_url="https://petstore.swagger.io/v2";
	
	public static String post_url= base_url + "/user/createWithList";
	public static String get_url= base_url+ "/user/{username}";
	///user/{username}>> path param added/required
	public static String update_url= base_url+ "/user/{username}";
	public static String delete_url= base_url+ "/user/{username}";
	
	
}

