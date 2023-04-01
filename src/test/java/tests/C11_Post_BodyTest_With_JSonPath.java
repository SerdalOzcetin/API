package tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class C11_Post_BodyTest_With_JSonPath {

    @Test
    public void test01(){

        /*
        When we send a POST request to the URL "https://restful-booker.herokuapp.com/booking" with the following body:

                    {
                    "firstname" : "Jhon",
                    "lastname" : "Doe",
                    "totalprice" : 500,
                    "depositpaid" : false,
                    "bookingdates" : {
                    "checkin" : "2023-01-10",
                    "checkout" : "2023-01-20"
                    },
                    "additionalneeds" : "wi-fi"
                    }

        Verify that the returned response has a status code of 200,
        content type of application-json,
        and the following data in the response body:

                    "firstname" is "Jhon"
                    "lastname" is "Doe"
                    "totalprice" is 500
                    "depositpaid" is false
                    "checkin" date is "2023-01-10"
                    "checkout" date is "2023-01-20"
                    "additionalneeds" is "wi-fi"
         */
        // 1- prepare the body and the end-point

        String url = "https://restful-booker.herokuapp.com/booking";

        JSONObject requestBody = new JSONObject();
        JSONObject bookingDatesJson = new JSONObject();

            bookingDatesJson.put("checkin","2023-01-10");
            bookingDatesJson.put("checkout","2023-01-20");

        requestBody.put("firstname","Jhon");
        requestBody.put("lastname","Doe");
        requestBody.put("totalprice",500);
        requestBody.put("depositpaid",false);
        requestBody.put("bookingdates",bookingDatesJson);
        requestBody.put("additionalneeds","wi-fi");

        System.out.println(requestBody);

        // 2- prepare the expected data or body

        // 3- send request and save the response

        Response response = given().contentType(ContentType.JSON)
                .when().body(requestBody.toString())
                .post(url);

                response.prettyPrint();
        // 4- Assertion
        //"firstname" is "Jhon"
        //                    "lastname" is "Doe"
        //                    "totalprice" is 500
        //                    "depositpaid" is false
        //                    "checkin" date is "2023-01-10"
        //                    "checkout" date is "2023-01-20"
        //                    "additionalneeds" is "wi-fi"
        response.then().assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON).body("booking.firstname", equalTo("Jhon"),
                                                "booking.lastname",equalTo("Doe"),
                                                 "booking.totalprice",equalTo(500),
                                                  "booking.depositpaid",equalTo(false),
                                                  "booking.bookingdates.checkin",equalTo("2023-01-10"),
                                                 "booking.bookingdates.checkout",equalTo("2023-01-20"),
                                                 "booking.additionalneeds",equalTo("wi-fi"));
    }

}
