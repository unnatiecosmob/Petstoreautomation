package api.endpoints;


/* Create user(POST): https://petstore.swagger.io/v2/user
 * Get user(GET): https://petstore.swagger.io/v2/user/{Username}
 * Update user(PUT): https://petstore.swagger.io/v2/user/{Username}
 * Delete user(DELETE): https://petstore.swagger.io/v2/user/{Username}
 */
public class Routes {

	public static String base_url = "https://petstore.swagger.io/v2";
	
	//User Module
	
	public static String post_url = base_url+"/user";
	public static String get_url = base_url+"/user/{Username}";
	public static String put_url = base_url+"/user/{Username}";
	public static String delete_url = base_url+"/user/{Username}";
	
	//Store Module
	
	//We can put all store module url here.
	
	
	
}
