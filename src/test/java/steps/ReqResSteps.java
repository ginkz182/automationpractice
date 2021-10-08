package steps;

import api.ReqRes;
import com.thoughtworks.gauge.Step;

public class ReqResSteps {

    ReqRes api = new ReqRes();

    @Step("Call Get User by id <id> and verify response")
    public void callGetUserAndVerify(Integer id) {
        api.verifyGetUser(id);
    }

    @Step("Call Post Create User name <name> job <job> and verify response")
    public void callPostCreateUserAndVerify(String name, String job) {
        api.verifyPostCreateUser(name, job);
    }

    @Step("Call Get Users and assert response time not exceed <ms> ms")
    public void callGetUserAndVerifyResponseTime(long ms) {
        api.callGetUserAndVerifyResponseTime(ms);
    }

    @Step("Call Login with username <user> password <pwd> and verify cookies set correctly")
    public void callLoginAndVerifyCookies(String user, String pwd) {
        api.callLoginAndVerifyCookies(user, pwd);
    }
}
