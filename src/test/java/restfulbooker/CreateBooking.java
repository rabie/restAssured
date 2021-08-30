package restfulbooker;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class CreateBooking {
    public static void main(String[] args) {
   /*     //Build the request
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification = requestSpecification.log().all();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body("{\n" +
                "    \"firstname\" : \"Rabie\",\n" +
                "    \"lastname\" : \"EL ouargua\",\n" +
                "    \"totalprice\" : 222,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2022-01-01\",\n" +
                "        \"checkout\" : \"2023-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}");

        //Hit the request and get Response
        Response response = requestSpecification.post();
        //Validate Response
        ValidatableResponse validatableResponse = response.then();
        validatableResponse.statusCode(200);*/

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

        String response =
        RestAssured
            .given()
                .baseUri("https://restful-booker.herokuapp.com/")
                .basePath("booking")
                .contentType(ContentType.JSON)
                .body(body)
            .when()
                .post()
            .then()
                .extract()
                .body()
                .asPrettyString();
        System.out.println(response);

    }
}
