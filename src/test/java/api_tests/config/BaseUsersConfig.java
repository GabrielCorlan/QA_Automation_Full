package api_tests.config;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import org.testng.annotations.BeforeClass;

public class BaseUsersConfig {

    @BeforeClass
    public void setupRequest() {
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setBaseUri("https://demoqa.com")
                .setBasePath("/Account/v1")
                .setContentType("application/json")
                .build();
    }

    @BeforeClass
    public void setupResponse() {
        RestAssured.responseSpecification = new ResponseSpecBuilder()
                .expectStatusCode(201)
                .build();
    }
}
