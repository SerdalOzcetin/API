package tests;

import baseUrl.BaseUrlHerokuapp;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.Pojo_Herokuap_Response;
import pojos.Pojo_Herokuapp_BookingDates;
import pojos.Pojo_Herokuapp_requestBody;
import pojos.Pojo_JhsonPlaceHolder;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C32_Post_Pojo extends BaseUrlHerokuapp {

    /*

    Send a POST request to the URL https://restful-booker.herokuapp.com/booking with the following body, and test that the response (excluding the id) is as shown below:

                        Request body:

                        {
                        "firstname": "Jhon",
                        "lastname": "Doe",
                        "totalprice": 500,
                        "depositpaid": false,
                        "bookingdates": {
                            "checkin": "2021-06-01",
                            "checkout": "2021-06-10"
                             },
                        "additionalneeds": "wi-fi"
                        }

                        Expected response body:

                        {
                        "bookingid": 24,
                        "booking": {
                            "firstname": "Jhon",
                            "lastname": "Doe",
                            "totalprice": 500,
                            "depositpaid": false,
                            "bookingdates": {
                                "checkin": "2021-06-01",
                                "checkout": "2021-06-10"
                                 },
                        "additionalneeds": "wi-fi"
                           }
                        }

     */

    @Test
    public void test01() {


        // 1- prepare the body and the end-point

        specHerokuapp.pathParam("pp1","booking");
        Pojo_Herokuapp_BookingDates bookingDatesPojo = new Pojo_Herokuapp_BookingDates("2021-06-01","2021-06-10");

        Pojo_Herokuapp_requestBody requestBodyPojo = new Pojo_Herokuapp_requestBody("Jhon","Doe",500,false,bookingDatesPojo,"wi-fi");

        // 2- prepare the expected data or body

        bookingDatesPojo = new Pojo_Herokuapp_BookingDates("2021-06-01","2021-06-10");

        Pojo_Herokuapp_requestBody bookingPojo = new Pojo_Herokuapp_requestBody("Jhon","Doe",500,false,bookingDatesPojo,"wi-fi");

        Pojo_Herokuap_Response expectedResponseBodyPojo = new Pojo_Herokuap_Response(25,bookingPojo);



        // 3- send request and save the response

        Response response = given().spec(specHerokuapp).contentType(ContentType.JSON)
                            .when().body(requestBodyPojo)
                            .post("/{pp1}");


        Pojo_Herokuap_Response responsePojo = response.as(Pojo_Herokuap_Response.class);




        // 4- Assertion

        assertEquals(expectedResponseBodyPojo.getBooking().getFirstname(),responsePojo.getBooking().getFirstname());
        assertEquals(expectedResponseBodyPojo.getBooking().getLastname(),responsePojo.getBooking().getLastname());
        assertEquals(expectedResponseBodyPojo.getBooking().getTotalprice(),responsePojo.getBooking().getTotalprice());
        assertEquals(expectedResponseBodyPojo.getBooking().isDepositpaid(),responsePojo.getBooking().isDepositpaid());
        assertEquals(expectedResponseBodyPojo.getBooking().getTotalprice(),responsePojo.getBooking().getTotalprice());
        assertEquals(expectedResponseBodyPojo.getBooking().getBookingdates().getCheckin(),responsePojo.getBooking().getBookingdates().getCheckin());
        assertEquals(expectedResponseBodyPojo.getBooking().getBookingdates().getCheckout(),responsePojo.getBooking().getBookingdates().getCheckout());
        assertEquals(expectedResponseBodyPojo.getBooking().getAdditionalneeds(),responsePojo.getBooking().getAdditionalneeds());

    }
}
