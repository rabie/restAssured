package restfulbooker;

import io.restassured.RestAssured;

public class PartialUpdateResource {
    public static void main(String[] args) {
        RestAssured
                .given()
                    .log().all()
                    .header("Authorization", "Basic YWRtaW46cGFzc3dvcmQxMjM=")
                    .baseUri("https://restful-booker.herokuapp.com/")
                    .basePath("booking/{id}")
                    .pathParam("id", 6)
                    .body("{\n" +
                            "    \"firstname\" : \"James\",\n" +
                            "    \"lastname\" : \"Brown\"\n" +
                            "}")
                .when()
                    .patch()
                .then()
                    .log().all()
                    .statusCode(200);
    }
}
