package tests;

import TestDatas.TestData_JsonPlaceHolder;
import baseUrl.BaseUrl_JsonPlaceHolder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C23_Get_UsingTestData extends BaseUrl_JsonPlaceHolder {

    @Test
    public void test01(){

        /*

                Send a GET request to the "https://jsonplaceholder.typicode.com/posts/22" URL
                and test that the status code of the returned response is 200
                and that the response body is the same as the one given below:

                {
                      "userId": 3,
                      "id": 22,
                      "title": "dolor sint quo a velit explicabo quia nam",
                      "body": "eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse"
                }

         */


        // 1- prepare the body and the end-point

        specJsonPlaceHolder.pathParams("pp1","posts","pp2","22");

        // 2- prepare the expected data or body

        JSONObject expectedData = TestData_JsonPlaceHolder.responseBodyCreation22();
        System.out.println(expectedData);

        // 3- send request and save the response
        Response response = given()
        .when()
        .spec(specJsonPlaceHolder)
        .get("/{pp1}/{pp2}");

        response.prettyPrint();

        JsonPath responseJsonPath = response.jsonPath();

        // 4- Assertion

        Assert.assertEquals(TestData_JsonPlaceHolder.successfulStatusCode,response.statusCode());
        Assert.assertEquals(expectedData.getInt("userId"),responseJsonPath.getInt("userId"));
        Assert.assertEquals(expectedData.getInt("id"),responseJsonPath.getInt("id"));
        Assert.assertEquals(expectedData.getString("title"),responseJsonPath.getString("title"));
        Assert.assertEquals(expectedData.getString("body"),responseJsonPath.getString("body"));

    }


}
