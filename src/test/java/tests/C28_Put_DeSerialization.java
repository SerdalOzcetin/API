package tests;
import TestDatas.TestData_JsonPlaceHolder;
import baseUrl.BaseUrl_JsonPlaceHolder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;


public class C28_Put_DeSerialization extends BaseUrl_JsonPlaceHolder {


    @Test
    public void test01() {

        /*

        "When we send a PUT request with the body below to the URL https://jsonplaceholder.typicode.com/posts/70,
        test that the response body returned is the same as the one given below:

                    Expected Data:

                    {
                    "title": "Jhon",
                    "body": "Doe",
                    "userId": 10,
                    "id": 70
                    }

                    Request Body

                    {
                    "title": "Jhon",
                    "body": "Doe",
                    "userId": 10,
                    "id": 70
                    }"

         */



        // 1- prepare the body and the end-point

        specJsonPlaceHolder.pathParams("pp1","posts","pp2",70);
        Map<String,Object> requestBodyMap = TestData_JsonPlaceHolder.MapBodyCreation();

        // 2- prepare the expected data or body

        Map<String,Object> expectedDataMap = TestData_JsonPlaceHolder.MapBodyCreation();

        // 3- send request and save the response
        Response response = given()
                .spec(specJsonPlaceHolder)
                .contentType(ContentType.JSON)
                .when()
                .body(requestBodyMap)
                .put("/{pp1}/{pp2}");

        response.prettyPrint();

        // 4- Assertion

        Map<String,Object> responseMap = response.as(HashMap.class);
        System.out.println(responseMap);

        assertEquals(expectedDataMap.get("title"),requestBodyMap.get("title"));
        assertEquals(expectedDataMap.get("body"),requestBodyMap.get("body"));
        assertEquals(expectedDataMap.get("userId"),requestBodyMap.get("userId"));
        assertEquals(expectedDataMap.get("id"),requestBodyMap.get("id"));

    }
}
