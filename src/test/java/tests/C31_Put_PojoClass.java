package tests;

import TestDatas.TestData_Herokuapp;
import TestDatas.TestData_JsonPlaceHolder;
import baseUrl.BaseUrl_JsonPlaceHolder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojos.Pojo_JhsonPlaceHolder;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C31_Put_PojoClass extends BaseUrl_JsonPlaceHolder {

    /*

    Test if the response body returned after sending a PUT request to the URL "https://jsonplaceholder.typicode.com/posts/70"
    with the body given below is the same as the expected data provided:

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

    @Test
    public void test01() {


        // 1- prepare the body and the end-point

        specJsonPlaceHolder.pathParams("pp1","posts","pp2","70");
        Pojo_JhsonPlaceHolder requestBodyPojo = new Pojo_JhsonPlaceHolder("Jhon","Doe",10,70);


        // 2- prepare the expected data or body

        Pojo_JhsonPlaceHolder expectedBodyPojo = new Pojo_JhsonPlaceHolder("Jhon","Doe",10,70);

        // 3- send request and save the response

        Response response = given()
                .spec(specJsonPlaceHolder)
                .contentType(ContentType.JSON)
                .when()
                .body(requestBodyPojo)
                .put("/{pp1}/{pp2}");

        Pojo_JhsonPlaceHolder responsePojo = response.as(Pojo_JhsonPlaceHolder.class);

        // 4- Assertion

        assertEquals(TestData_JsonPlaceHolder.successfulStatusCode,response.statusCode());
        assertEquals(TestData_JsonPlaceHolder.connectionHeader,response.header("Connection"));
        assertEquals(TestData_JsonPlaceHolder.contentType,response.contentType());

        assertEquals(expectedBodyPojo.getTitle(),responsePojo.getTitle());
        assertEquals(expectedBodyPojo.getBody(),responsePojo.getBody());
        assertEquals(expectedBodyPojo.getUserId(),responsePojo.getUserId());
        assertEquals(expectedBodyPojo.getId(),responsePojo.getId());


    }
}
