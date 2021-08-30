package restfulbooker;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import java.net.MalformedURLException;
import java.net.URL;

public class UpdateResource {

    public static void main(String[] args) throws MalformedURLException {
        String body = "{\n" +
                "    \"firstname\" : \"Rabie\",\n" +
                "    \"lastname\" : \"EL ouargua\",\n" +
                "    \"totalprice\" : 222,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2022-01-01\",\n" +
                "        \"checkout\" : \"2023-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";
        RestAssured
                .given()
                    .log().all()
                    .contentType(ContentType.JSON)
                    .header("Authorization","Basic YWRtaW46cGFzc3dvcmQxMjM=")
                    .body(body)
                .when()
                    .put(new URL("https://restful-booker.herokuapp.com/booking/1"))
                .then()
                    .log().all()
                    .statusCode(200);

    }
}
