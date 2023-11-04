package api_tests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class FirstTest {

    @Test
    public void firstTest() {
        // Scenario setup: config, headers, params
        given().
                log().all().
                // action: GET, POST, PUT, DELETE
                        when()
                .get("https://demoqa.com/BookStore/v1/Books").
                // assertions: check response code, extract data
                        then()
                .log().all();
    }
}
