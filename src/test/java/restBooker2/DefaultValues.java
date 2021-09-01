package restBooker2;

import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.config.SSLConfig;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class DefaultValues extends BaseClass2{
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

    @Test
    public void createBooking(){
        RestAssured
                .given()
                    .log().all()
                    .contentType(ContentType.JSON)
                    .body(body)
                .when()
                    .post()
                .then()
                    .log().all()
                    .statusCode(200);

    }

    @Test void creatTooken(){
        String body = RestAssured
                .given()
                    .log().all()
                    .basePath("auth")
                    .body("{\n" +
                            "    \"username\" : \"admin\",\n" +
                            "    \"password\" : \"password123\"\n" +
                            "}")
                .when()
                    .post()
                .then()
                    .log().all()
                    .extract()
                    .body()
                    .asString();
        System.out.println("body = " + body);
    }

    @Test
    public void createHeader(){
        Header header = new Header("header1","value1" );
        Map<String, String> headers = new HashMap<>();
        headers.put("h1","v1");
        headers.put("f2", "F2");

       int code = RestAssured
                .given()
                    .log().all()
                    .headers(headers)
                .get()
                .then()
                .extract()
                .statusCode();
        System.out.println("code = " + code);
    }

    @Test
    public void overWriteHeaders(){
        RestAssured
                .given()
                .config(RestAssuredConfig.config().sslConfig(SSLConfig.sslConfig().allowAllHostnames()))
                ;
    }
}
