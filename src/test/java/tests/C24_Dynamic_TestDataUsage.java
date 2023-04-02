package tests;
import TestDatas.TestData_JsonPlaceHolder;
import baseUrl.BaseUrl_JsonPlaceHolder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C24_Dynamic_TestDataUsage extends BaseUrl_JsonPlaceHolder {

    @Test()
    public void test01(){

        /*


        When we send a GET request to the URL https://jsonplaceholder.typicode.com/posts/22,
        the expected response has a status code of 200 and the response body should be the same as the following JSON object:

                    {
                    "userId": 4,
                    "id": 40,
                    "title": "enim quo cumque",
                    "body": "ut voluptatum aliquid illo tenetur nemo sequi quo facilis\nipsum rem optio mollitia quas\nvoluptatem eum voluptas qui\nunde omnis voluptatem iure quasi maxime voluptas nam"
                    }
         */



        // 1- prepare the body and the end-point

        specJsonPlaceHolder.pathParams("pp1","posts","pp2",22);

        // 2- prepare the expected data or body

        JSONObject expectedData = TestData_JsonPlaceHolder.JsonBodyCreation(3,22,"dolor sint quo a velit explicabo quia nam","eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse");
        System.out.println(expectedData);


        // 3- send request and save the response

        Response response = given()
                            .when().spec(specJsonPlaceHolder)
                            .get("/{pp1}/{pp2}");

        response.prettyPrint();

        JsonPath responseJsonPath = response.jsonPath();


        // 4- Assertion
        assertEquals(TestData_JsonPlaceHolder.successfulStatusCode,response.statusCode());
        assertEquals(expectedData.getInt("userId"),responseJsonPath.getInt("userId"));
        assertEquals(expectedData.getInt("id"),responseJsonPath.getInt("id"));
        assertEquals(expectedData.getString("title"),responseJsonPath.getString("title"));
        assertEquals(expectedData.getString("body"),responseJsonPath.getString("body"));




    }

}
