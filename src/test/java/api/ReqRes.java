package api;

import org.json.JSONObject;
import org.openqa.selenium.json.Json;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.*;

public class ReqRes {

    String HOST_URL = "https://reqres.in";
    String GET_USER_API = "/api/users/";
    String POST_CREATE_API = "/api/users";
    String LOGIN_API = "/api/login";

    public void verifyGetUser(Integer userId) {
        when().
            get(HOST_URL + GET_USER_API + userId).
        then().
            assertThat().statusCode(200).
            assertThat().body("data.id", equalTo(userId));
    }

    public void verifyPostCreateUser(String name, String job) {
        JSONObject  jsonBody = new JSONObject();
        jsonBody.put("name", name);
        jsonBody.put("job", job);

        given().
            contentType("application/json").
            body(jsonBody.toString()).
        when().
            post(HOST_URL + POST_CREATE_API).
        then().
            assertThat().statusCode(201).
            assertThat().body("$", hasKey("id")).
            assertThat().body("$" , hasKey("createdAt"));
    }

    public void callGetUserAndVerifyResponseTime(long ms) {
        when().
            get(HOST_URL + GET_USER_API + "?delay=3").
        then().
            assertThat().time(lessThan(ms));
    }

    public void callLoginAndVerifyCookies(String user, String pwd) {
        JSONObject jsonBody = new JSONObject();
        jsonBody.put("email", user);
        jsonBody.put("password", pwd);

        given().
            contentType("application/json").
            body(jsonBody.toString()).
        when().
            post(HOST_URL + LOGIN_API).
        then().
            assertThat().statusCode(200).
            //this is dummy only. expected to fail
            assertThat().cookie("sessionid", "some_expected_value");
    }
}
