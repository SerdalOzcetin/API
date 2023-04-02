package tests;
import baseUrl.BaseUrlHerokuapp;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C21_BaseUrlHerokuapp_QueryParams extends BaseUrlHerokuapp {

    @Test
    public void test01(){

        /*
                Send a GET request to the "https://restful-booker.herokuapp.com/booking" endpoint with the necessary query parameters
                to test for a reservation with a "firstname" value of "Mary".
                Test that the status code of the returned response is 200 and that there is at least one booking with the name "Mary".
         */




        // 1- prepare the body and the end-point

        specHerokuapp.pathParam("pp1","booking").queryParam("firstname","Mary");

        // 2- prepare the expected data or body

        // 3- send request and save the response

        Response response  = given()
                            .when().spec(specHerokuapp)
                            .get("/{pp1}");

        response.prettyPrint();

        // 4- Assertion

        response.then().assertThat()
                .statusCode(200)
                .body("bookingid", Matchers.hasSize(1));

    }

}
