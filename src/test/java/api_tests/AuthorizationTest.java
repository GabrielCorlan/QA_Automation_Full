package api_tests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class AuthorizationTest extends BaseApiTest {

    @Test
    public void generateTokenTest() {
        given().log().all()
                .body("""
                            {
                              "userName": "Romeo12",
                              "password": "TestPass123*"
                            }
                        """)
                .when().post("Account/v1/GenerateToken")
                .then().statusCode(200).log().all();
    }
}
