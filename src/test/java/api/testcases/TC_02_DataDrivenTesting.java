package api.testcases;

import org.testng.annotations.Test;

import api.endpoints.userEndPoints;
import api.payload.userpayload;
import io.restassured.response.Response;

public class TC_02_DataDrivenTesting {

    @Test(dataProvider = "testlogindata", dataProviderClass = dataprovider.class)
    public void testPostUser(String id, String username, String password) {
        userpayload userPayload = new userpayload();
        userPayload.setId(id);
        userPayload.setUsername(username);
        userPayload.setPassword(password);

        Response res = userEndPoints.createuser(userPayload); // Make sure to define this method in UserEndpoints
        res.then().log().all();
        System.out.println(res.getStatusCode());
    }
}

	

