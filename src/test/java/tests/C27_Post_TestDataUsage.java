package tests;

import TestDatas.TestData_Herokuapp;
import baseUrl.BaseUrlHerokuapp;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C27_Post_TestDataUsage extends BaseUrlHerokuapp {

    @Test
    public void test01() {

        /*

                Send a POST request with the body below to the URL https://restful-booker.herokuapp.com/booking
                and test whether the response body, except for the bookingid, is as follows:

                    Response Body:

                    {
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
                    },
                    "bookingid": 24
                    }

                    Request Body:

                    {
                    "firstname" : "Jhon",
                    "lastname" : "Doe",
                    "totalprice" : 500,
                    "depositpaid" : false,
                    "bookingdates" : {
                            "checkin" : "2021-06-01",
                            "checkout" : "2021-06-10"
                    },
                    "additionalneeds" : "wi-fi"
            }

         */



        // 1- prepare the body and the end-point
        specHerokuapp.pathParam("pp1","booking");

        JSONObject requestBody = TestData_Herokuapp.creationJsonObject("Jhon",
                                                                   "Doe",
                                                                   500,
                                                                  false,
                                                                     "2021-06-01",
                                                                    "2021-06-10",
                                                                "wi-fi");


        // 2- prepare the expected data or body

        JSONObject expectedBody = TestData_Herokuapp.responseBodyCreation();
        System.out.println(expectedBody);

        // 3- send request and save the response

        Response response =given().contentType(ContentType.JSON)
                            .when().spec(specHerokuapp).body(requestBody.toString())
                            .post("/{pp1}");

        JsonPath responseJsonPath = response.jsonPath();

        // 4- Assertion
        assertEquals(expectedBody.getJSONObject("booking").getString("firstname"),responseJsonPath.getString("booking.firstname"));
        assertEquals(expectedBody.getJSONObject("booking").getString("lastname"),responseJsonPath.getString("booking.lastname"));
        assertEquals(expectedBody.getJSONObject("booking").getInt("totalprice"),responseJsonPath.getInt("booking.totalprice"));
        assertEquals(expectedBody.getJSONObject("booking").getBoolean("depositpaid"),responseJsonPath.getBoolean("booking.depositpaid"));
        assertEquals(expectedBody.getJSONObject("booking").getJSONObject("bookingdates").getString("checkin"),responseJsonPath.getString("booking.bookingdates.checkin"));
        assertEquals(expectedBody.getJSONObject("booking").getJSONObject("bookingdates").getString("checkout"),responseJsonPath.getString("booking.bookingdates.checkout"));
        assertEquals(expectedBody.getJSONObject("booking").getString("additionalneeds"),responseJsonPath.getString("booking.additionalneeds"));
    }
}
