package tests;

import TestDatas.TestData_Dummy;
import TestDatas.TestData_Herokuapp;
import baseUrl.BaseUrlHerokuapp;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C30_Post_Deserialization extends BaseUrlHerokuapp {


    /*


                            Send a POST request to the https://restful-booker.herokuapp.com/booking url with the body below and
                            test that the response returned is as shown below except for the bookingid.

                            Response Body // expected data

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

                            Request body

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

     */

    @Test
    public void test01() {





        // 1- prepare the body and the end-point
        specHerokuapp.pathParams("pp1","booking");

        Map<String,Object> requestBody = TestData_Herokuapp.creationRequestbodyMap("Jhon",
                                                                                    "Doe",
                                                                                    500,
                                                                                    false,
                                                                                    "2021-06-01",
                                                                                    "2021-06-10",
                                                                                    "wi-fi");

        // 2- prepare the expected data or body

        Map<String,Object> expectedDataMap = TestData_Herokuapp.responseBodyMap();



        // 3- send request and save the response

        Response response = given().spec(specHerokuapp).contentType(ContentType.JSON).when().body(requestBody).post("/{pp1}");

        Map<String,Object> responseMap = response.as(HashMap.class);



        // 4- Assertion

        assertEquals(((Map)expectedDataMap.get("booking")).get("firstname"),
                ((Map)responseMap.get("booking")).get("firstname"));

        assertEquals(((Map)expectedDataMap.get("booking")).get("lastname"),
                ((Map)responseMap.get("booking")).get("lastname"));

        assertEquals(((Map)expectedDataMap.get("booking")).get("totalprice"),
                ((Map)responseMap.get("booking")).get("totalprice"));

        assertEquals(((Map)expectedDataMap.get("booking")).get("depositpaid"),
                ((Map)responseMap.get("booking")).get("depositpaid"));

        assertEquals(((Map)expectedDataMap.get("booking")).get("additionalneeds"),
                ((Map)responseMap.get("booking")).get("additionalneeds"));

        assertEquals(((Map)((Map) expectedDataMap.get("booking")).get("bookingdates")).get("checkin"),
                ((Map)((Map<?, ?>) responseMap.get("booking")).get("bookingdates")).get("checkin"));

        assertEquals(((Map)((Map) expectedDataMap.get("booking")).get("bookingdates")).get("checkout"),
                ((Map)((Map) responseMap.get("booking")).get("bookingdates")).get("checkout"));

    }
}
