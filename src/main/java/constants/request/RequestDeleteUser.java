package constants.request;

import io.qameta.allure.Step;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;


public class RequestDeleteUser extends Header {

    private static final String USER_URL = BASE_URL + "auth/";

    @Step("Delete user {idUser}")
    public ValidatableResponse deleteUser(String idUser) {
        return given()
                .spec(getRequestAuthSpec(idUser))
                .delete(USER_URL + "user/").then();
    }
}
