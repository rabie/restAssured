package restfulbooker;

import io.restassured.RestAssured;

public class PathParameterExample2 {
    public static void main(String[] args) {
        RestAssured
                .given()
                    .log().all()
                    .baseUri("https://restful-booker.herokuapp.com/")
                    .pathParam("basePath", "booking")
                .when()
                    .get("{basePath}/{bookingId}", 8)
                .then()
                    .log().all();
    }
}
