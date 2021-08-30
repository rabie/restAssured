package restBooker2;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class WithResponseSpecification extends BaseClass{

    @Test
    public void createBooking() {
        RestAssured
                .given()
                    .spec(requestSpecification)
                    .basePath("booking")
                    .contentType(ContentType.JSON)
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
                .when()
                    .post()
                .then()
                    .log().all()
                    .spec(responseSpecification);
    }
}
