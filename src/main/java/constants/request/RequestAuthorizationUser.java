package constants.request;

import constants.user.UserAuthorizationFields;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RequestAuthorizationUser extends Header {

    private static final String USER_URL = BASE_URL + "auth/";

    @Step("Authorization User {userAuthorizationFields}")
    public Response authorizationUser(UserAuthorizationFields userAuthorizationFields) {
        return given()
                .spec(getRequestSpec())
                .body(userAuthorizationFields)
                .post(USER_URL + "login/");
    }
}
