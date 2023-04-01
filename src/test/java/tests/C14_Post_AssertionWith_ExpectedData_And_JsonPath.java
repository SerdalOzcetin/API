package tests;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C14_Post_AssertionWith_ExpectedData_And_JsonPath {

    @Test
    public void test01(){

        /*


        Test the response of a POST request with the body below to the URL 'https://restful-booker.herokuapp.com/booking'
        and ensure that the response, except for the ID, is as follows:

                        Response Body:

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

                        Request Body:

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

        // 1- prepare the body and the end-point

        String url = "https://restful-booker.herokuapp.com/booking";

        JSONObject requestBodyJson = new JSONObject();

        JSONObject bookingdatesJson = new JSONObject();
            bookingdatesJson.put("checkin","2021-06-01");
            bookingdatesJson.put("checkout","2021-06-10");

        requestBodyJson.put("firstname","Jhon");
        requestBodyJson.put("lastname","Doe");
        requestBodyJson.put("totalprice",500);
        requestBodyJson.put("depositpaid",false);
        requestBodyJson.put("bookingdates",bookingdatesJson);
        requestBodyJson.put("additionalneeds","wi-fi");


        // 2- prepare the expected data or body

        JSONObject expectedDataJson = new JSONObject();
        expectedDataJson.put("booking",requestBodyJson);

        //System.out.println(expectedDataJson);


        // 3- send request and save the response
        Response response = given()
                            .contentType(ContentType.JSON)
                            .when()
                            .body(requestBodyJson.toString())
                            .post(url);

        //response.prettyPrint();


        // 4- Assertion

        JsonPath responseJsonPath = response.jsonPath();

        assertEquals(expectedDataJson.getJSONObject("booking").get("firstname"),
                responseJsonPath.get("booking.firstname"));

        assertEquals(expectedDataJson.getJSONObject("booking").get("lastname"),
                responseJsonPath.get("booking.lastname"));

        assertEquals(expectedDataJson.getJSONObject("booking").get("totalprice"),
                responseJsonPath.get("booking.totalprice"));

        assertEquals(expectedDataJson.getJSONObject("booking").get("depositpaid"),
                responseJsonPath.get("booking.depositpaid"));

        assertEquals(expectedDataJson.getJSONObject("booking").getJSONObject("bookingdates").get("checkin"),
                responseJsonPath.get("booking.bookingdates.checkin"));

        assertEquals(expectedDataJson.getJSONObject("booking").getJSONObject("bookingdates").get("checkout"),
                responseJsonPath.get("booking.bookingdates.checkout"));

        assertEquals(expectedDataJson.getJSONObject("booking").get("additionalneeds"),
                responseJsonPath.get("booking.additionalneeds"));




    }

}
