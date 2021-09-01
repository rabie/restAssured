package restBooker2;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeTest;

public class BaseClass2 {

    @BeforeTest
    public void setUp(){
        RestAssured.baseURI = "https://restful-booker.herokuapp.com/";
        RestAssured.basePath = "booking";
        
    }
}
