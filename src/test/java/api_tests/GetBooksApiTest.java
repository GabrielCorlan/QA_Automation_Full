package api_tests;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetBooksApiTest extends BaseApiTest{

    @Test
    public void firstTest() {
        // Scenario setup: config, headers, params
        given().
                log().all().
                // action: GET, POST, PUT, DELETE
                        when()
                .get("BookStore/v1/Books").
                // assertions: check response code, extract data
                        then()
                .log().all();
    }

    @Test
    public void getBooksTest() {
        Response response = get("BookStore/v1/Books");
        System.out.println("Response: " + response.asString());
        System.out.println("Status code: " + response.getStatusCode());
        System.out.println("Body: " + response.getBody().asString());
        System.out.println("Time taken: " + response.getTime());
        System.out.println("Header: " + response.getHeader("content-type"));

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }

    @Test
    public void getBooksGivenThenStyle() {
        given().log().all()
                .get("BookStore/v1/Books")
                .then()
                .statusCode(200)
                .body("books.isbn[0]", equalTo("9781449325862"))
                .log().all();
    }
}
