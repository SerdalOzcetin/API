package tests;
import TestDatas.TestData_JsonPlaceHolder;
import baseUrl.BaseUrl_JsonPlaceHolder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C25_Put_TestDataClassUsage extends BaseUrl_JsonPlaceHolder {

    @Test
    public void test01(){

        /*

        Send a PUT request to the URL https://jsonplaceholder.typicode.com/posts/70 with the body below,
        and test whether the response status code is 200, content type is "application/json; charset=utf-8",
        Connection header value is "keep-alive",
        and response body is the same as the expected data provided below.

                    Expected Data:

                    {
                    "title": "Jhon",
                    "body": "Doe",
                    "userId": 10,
                    "id": 70
                    }

                    Request Body:

                    {
                    "title": "Jhon",
                    "body": "Doe",
                    "userId": 10,
                    "id": 70
                    }
         */


        // 1- prepare the body and the end-point

        specJsonPlaceHolder.pathParams("pp1","posts","pp2","70");
        JSONObject requestBody = TestData_JsonPlaceHolder.JsonBodyCreation(10,70,"Jhon","Doe");

        // 2- prepare the expected data or body
        JSONObject expectedData=TestData_JsonPlaceHolder.JsonBodyCreation(10,70,"Jhon","Doe");


        // 3- send request and save the response

        Response response = given()
                .spec(specJsonPlaceHolder)
                .contentType(ContentType.JSON)
                .when()
                .body(requestBody.toString())
                .put("/{pp1}/{pp2}");

        JsonPath responseJsonPath = response.jsonPath();
        // 4- Assertion

        assertEquals(TestData_JsonPlaceHolder.successfulStatusCode,response.statusCode());
        assertEquals(TestData_JsonPlaceHolder.contentType,response.contentType());
        assertEquals(TestData_JsonPlaceHolder.connectionHeader,response.header("Connection"));
        assertEquals(TestData_JsonPlaceHolder.connectionHeader,response.header("Connection"));
        assertEquals(expectedData.getInt("userId"),responseJsonPath.getInt("userId"));
        assertEquals(expectedData.getInt("id"),responseJsonPath.getInt("id"));
        assertEquals(expectedData.getString("body"),responseJsonPath.getString("body"));
        assertEquals(expectedData.getString("title"),responseJsonPath.getString("title"));

    }

}
