package constants.request;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;


public class RequestDeleteUser extends Header {

    private static final String USER_URL = BASE_URL + "auth/";

    @Step("Create user {userRegistrationFields}")
    public ValidatableResponse deleteUser(String id_user) {
        return given()
                .spec(getRequestAuthSpec(id_user))
                .delete(USER_URL + "user/").then();
    }
}
