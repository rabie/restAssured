package restBooker2;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class MeasureResponseTime {

    @Test
    public void timeRequet() throws URISyntaxException, MalformedURLException {
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

        Response response = RestAssured
                .given()
                    .body(body)
                .when()
                    .post(new URL("https://restful-booker.herokuapp.com/booking"));

        Long timeInMS = response.time();
        System.out.println("timeInMS = " + timeInMS);
        Long timeInMS2 = response.getTime();
        System.out.println("timeInMS2 = " + timeInMS2);
        Long timeInS = response.timeIn(TimeUnit.SECONDS);
        System.out.println("timeInS = " + timeInS);
        Long timeInS2 = response.getTimeIn(TimeUnit.SECONDS);
        System.out.println("timeInS2 = " + timeInS2);
    }
}
