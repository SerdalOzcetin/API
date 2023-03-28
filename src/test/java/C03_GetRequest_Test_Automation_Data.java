import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C03_GetRequest_Test_Automation_Data {

    @Test
    public void test01(){

        /*
        A GET request to https://restful-booker.herokuapp.com/booking/10
            of the Response that came back when we sent it,
            status code 200,
            and the content type is application/json; charset=utf-8,
            and the value of the header named Server is Cowboy,
            and status Line's HTTP/1.1 200 OK
            test that there is.
         */

        // 1- prepare the body and the end-point

        String url = "https://restful-booker.herokuapp.com/booking/10";

        // 2- prepare the expected data or body

        // 3- send request and save the response

        Response response = given().when().get(url);

        // 4- Assertion

        response.then()
                .assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .header("Server","Cowboy")
                .statusLine("HTTP/1.1 200 OK");



    }

}
