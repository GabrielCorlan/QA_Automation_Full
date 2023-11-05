package api_tests;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import org.testng.annotations.BeforeClass;

public class BaseApiTest {

    protected static final String CONTENT_TYPE_HEADER_NAME = "Content-Type";
    protected static final String CONTENT_TYPE_HEADER_VALUE = "application/json";

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "https://demoqa.com/";

        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setContentType(CONTENT_TYPE_HEADER_VALUE)
                .build();
    }


}
