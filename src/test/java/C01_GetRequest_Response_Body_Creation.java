import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C01_GetRequest_Response_Body_Creation {


    @Test
    public void get01 (){

        // When we send a GET request to https://restful-booker.herokuapp.com/booking/10 url
        //type the returning Response.

        // 1- prepare the body and the end-point

            String url = "https://restful-booker.herokuapp.com/booking/10";

        // 2- prepare the expected data

            // No Info here

        // 3- send request and save the response

        Response response = given().when().get(url);
        response.prettyPrint();

        // 4- Assertion

    }

}
