package constants.request;

import constants.user.UserRegistrationFields;
import io.qameta.allure.Step;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class RequestRegistrationUser extends Header {
    private static final String USER_URL = BASE_URL + "auth/";

    @Step("Create user {userRegistrationFields}")
    public Response registerUser(UserRegistrationFields userRegistrationFields) {
        return given()
                .spec(getRequestSpec())
                .body(userRegistrationFields)
                .post(USER_URL + "register/");
    }
}
