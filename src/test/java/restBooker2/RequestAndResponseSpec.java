package restBooker2;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class RequestAndResponseSpec extends BaseClass {

    @Test
    public void getBooking(){
        RestAssured
                .given(requestSpecification,responseSpecification)
                .get("booking/1")
                .then()
                .log().all();
    }
}
