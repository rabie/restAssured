package restfulbooker;

import io.restassured.RestAssured;

import java.net.URI;
import java.net.URISyntaxException;

public class DeleteResource {
    public static void main(String[] args) throws URISyntaxException {
        RestAssured
                .given()
                    .log().all()
                    .header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=")
                .when()
                    .delete(new URI("https://restful-booker.herokuapp.com/booking/1"))
                .then()
                    .log().all()
                    .statusCode(201);
    }
}
