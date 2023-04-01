package tests;
import baseUrl.BaseUrlHerokuapp;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C20_BaseUrlHerokuapp02 extends BaseUrlHerokuapp {


    @Test
    public void test01(){

        /*
        "When we send a POST request to the https://restful-booker.herokuapp.com/booking endpoint with the body shown below,
        test that the response has a status code of 200 and the value of the 'firstname' field is 'Ahmet'."

            {

            "firstname" : "Jhon",
            "lastname" : “Doe",
            "totalprice" : 500,
            "depositpaid" : false,
            "bookingdates" : {
                "checkin" : "2021-06-01"
                "checkout" : "2021-06-10
                },
            "additionalneeds" : "wi-fi"

            }

         */

        // 1- prepare the body and the end-point

        specHerokuapp.pathParam("pp1","booking");
        JSONObject requestBody = new JSONObject();
        JSONObject bookingdates = new JSONObject();
            bookingdates.put("checkin","2021-06-01");
            bookingdates.put("checkout","2021-06-10");

        requestBody.put("firstname","Jhon");
        requestBody.put("lastname","Doe");
        requestBody.put("totalprice",500);
        requestBody.put("depositpaid",false);
        requestBody.put("bookingdates",bookingdates);
        requestBody.put("additionalneeds","wi-fi");


        System.out.println(requestBody);

        // 2- prepare the expected data or body


        // 3- send request and save the response

        Response response = given().contentType(ContentType.JSON)
                            .when().spec(specHerokuapp).body(requestBody.toString())
                            .post("/{pp1}");

        response.prettyPrint();

        // 4- Assertion

        response.then().assertThat()
                .statusCode(200)
                .body("booking.firstname", Matchers.equalTo("Jhon"));

    }

}
