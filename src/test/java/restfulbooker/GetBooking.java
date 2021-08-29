package restfulbooker;

import io.restassured.RestAssured;

public class GetBooking {

    public static void main(String[] args) {
        RestAssured
                .given()
                    .baseUri("https://restful-booker.herokuapp.com/")
                    .basePath("booking/{id}")
                    .pathParam("id", 5)
                .when()
                    .get()
                .then()
                    .statusCode(200);

    }
}
