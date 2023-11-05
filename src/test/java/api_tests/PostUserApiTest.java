package api_tests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class PostUserApiTest extends BaseApiTest {

    @Test
    public void postNewUserTest() {
        given()
                .header("Content-Type", "application/json")
                .body(
                        """
                                {
                                "userName": "romy2234",
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
