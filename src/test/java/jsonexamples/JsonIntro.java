package jsonexamples;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

public class JsonIntro {

    @Test
    public void parseJson(){
        String json = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        JsonPath jsonPath = new JsonPath(json);
        System.out.println(jsonPath.getString("password"));
        System.out.println((Object) jsonPath.get("$"));

    }

    @Test
    public void createBooking(){
        String response = RestAssured
                .given()
                .get("https://restful-booker.herokuapp.com/booking/6")
                .then()
                .log().all()
                .extract()
                .asPrettyString();

        JsonPath jsonPath = new JsonPath(response);
        System.out.println((Object) jsonPath.get("$"));
        System.out.println(jsonPath.getString("$"));
        System.out.println((Object) jsonPath.get());
    }
    @Test
    public void parseObject(){
        String str = "{" +
                "\"firstName\" : \"Rabie\","+
                "\"lastName\" : \"El ouargua\"," +
                "\"age\" : 42," +
                "\"address\" : {" +
                     "\"flatNo\" : 44," +
                     "\"buidingName\" : \"ABC\"," +
                    "\"street\" : \"XYZ\"" +
                     "}," +
                "\"salary\" : 1234.44," +
                "\"married\" : true" +
                   "}";
        System.out.println("str = " + str);
        JsonPath jsonPath = new JsonPath(str);

       System.out.println(jsonPath.getString("firstName"));
       System.out.println(jsonPath.getInt("address.flatNo"));
       System.out.println(jsonPath.getString("address.buidingName"));
        System.out.println(jsonPath.getDouble("salary"));
        System.out.println(jsonPath.getBoolean("married"));
    }
}
