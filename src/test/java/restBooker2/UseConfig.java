package restBooker2;

import io.restassured.RestAssured;
import io.restassured.config.HeaderConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class UseConfig {

    @Test
    public void useConfig(){
        RequestSpecification req1 = RestAssured.given().header("h1", "v1");
        RequestSpecification req2 = RestAssured.given()
                                    .header("h1", "v2")
                                    .header("h4", "v4") ;

        RestAssured
                .given()
                .config(RestAssuredConfig.config()
                        .headerConfig(HeaderConfig.headerConfig()
                        .overwriteHeadersWithName("h1")))
                .spec(req1)
                .spec(req2)
                .log().all()
                .get();
    }
}
