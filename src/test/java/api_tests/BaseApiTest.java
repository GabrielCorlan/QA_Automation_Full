package api_tests;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class BaseApiTest {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://demoqa.com/";

    }
}
