package tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C08_Post_Test_Responsebody {


    @Test
    public void test01(){

        /*
        "When we send a POST request to the URL https://jsonplaceholder.typicode.com/posts with the following body:

            {
            "title":"API",
            "body":"Learning API is great",
            "userId":10
            }

        Test that the returned response has a status code of 201,
        a content type of application/json, and in the response body,
        the "title" is "API",
        the "userId" value is less than 100,
        and the "body" contains the word "API"."

         */

        // 1- prepare the body and the end-point

        String url = "https://jsonplaceholder.typicode.com/posts";

        JSONObject requestBody = new JSONObject();
        requestBody.put("title","API");
        requestBody.put("body","Learning API is great");
        requestBody.put("userID",10);

        // 2- prepare the expected data or body

        // 3- send request and save the response

        Response response = given().contentType(ContentType.JSON)
                            .when().body(requestBody.toString())
                            .post(url);

        response.prettyPrint();

        // 4- Assertion

        response.then().assertThat()
                .statusCode(201)
                .contentType(ContentType.JSON)
                .body("title", Matchers.equalTo("API"))
                .body("userID",Matchers.lessThan(100))
                .body("body",Matchers.containsString("API"));
    }
}
