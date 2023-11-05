package api_tests;

import constants.Constants;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PostUserApiTest extends BaseApiTest {

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
                .when().post("Account/v1/User")
                .then()
                .statusCode(201)
                .log().all();
    }
}
