package restBooker2;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;

public class BaseClass {


    protected RequestSpecification requestSpecification = null;
    protected ResponseSpecification responseSpecification = null;
    @BeforeClass
    public void setUp(){
        requestSpecification = RestAssured
                                .given()
                                .baseUri("https://restful-booker.herokuapp.com/");
        responseSpecification = RestAssured.expect()
                                        .statusCode(200)
                                        .contentType(ContentType.JSON)
                                        .time(Matchers.lessThan(4000L));

    }
}
