package api_tests.user_tests;

import api_tests.config.BaseUsersConfig;
import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class AuthorizationTest extends BaseUsersConfig {

    @BeforeClass
    @Override
    public void setupResponse() {
        RestAssured.responseSpecification = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();
    }

    @Test
    public void generateTokenTest() {
        given().log().all()
                .body("""
                            {
                              "userName": "Romeo12",
                              "password": "TestPass123*"
                            }
                        """)
                .when().post("/GenerateToken")
                .then().log().all();
    }
}
