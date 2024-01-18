package api_tests.user_tests;

import api_tests.config.BaseUsersConfig;
import constants.Constants;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PostUserApiTest extends BaseUsersConfig {

    @Test
    public void postNewUserTest() {
        given().log().all()
                .body(
                        " {\n" +
                                "\"userName\": \"" + Constants.RANDOM_USERNAME + "\"," +
                                """
                                "password": "Qwerty123*"
                                }
                           """
                )
        .when().post("/User")
        .then().log().all();
    }
}
