package restfulbooker;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MultipleBooking {
        RequestSpecification requestSpecification = null;

        @BeforeClass
        public void setUp(){
                requestSpecification = RestAssured.given();
                requestSpecification
                        .baseUri("https://restful-booker.herokuapp.com/")
                        .basePath("booking")
                        .contentType(ContentType.JSON);

        }
        @Test
        public void createBooking(){
                RestAssured
                        .given()
                                .spec(requestSpecification)
                                .body("{\n" +
                                "    \"firstname\" : \"Rabie\",\n" +
                                "    \"lastname\" : \"EL ouargua\",\n" +
                                "    \"totalprice\" : 222,\n" +
                                "    \"depositpaid\" : true,\n" +
                                "    \"bookingdates\" : {\n" +
                                "        \"checkin\" : \"2022-01-01\",\n" +
                                "        \"checkout\" : \"2023-01-01\"\n" +
                                "    },\n" +
                                "    \"additionalneeds\" : \"Breakfast\"\n" +
                                "}")
                                .log()
                                .all()
                        .when()
                                .post()
                        .then()
                                .statusCode(200);
        }
}
