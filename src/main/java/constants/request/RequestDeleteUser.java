package constants.request;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;


public class RequestDeleteUser extends Header {

    private static final String USER_URL = BASE_URL + "auth/";

    @Step("Delete user {userId}")
    public ValidatableResponse deleteUser(String userId) {
        return given()
                .spec(getRequestAuthSpec(userId))
                .delete(USER_URL + "user/").then();
    }
}
