package tests;

import baseUrl.BaseUrl_JsonPlaceHolder;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class C17_BaseUrlDummy_RestApi extends BaseUrl_JsonPlaceHolder {


            /*

            Create 3 test methods within a class and perform the following tests:






             */


    @Test
    public void test01(){

        // Test that when we send a GET request to the https://jsonplaceholder.typicode.com/posts endpoint,
        // the returned response has a status code of 200 and contains 100 records.

        // 1- prepare the body and the end-point

        specJsonPlaceHolder.pathParam("pp1","posts");

        // 2- prepare the expected data or body


        // 3- send request and save the response

        Response response = given()
                            .when().spec(specJsonPlaceHolder)
                            .get("/{pp1}");

        response.prettyPrint();

        // 4- Assertion

        response.then().assertThat()
                .statusCode(200)
                .body("title", Matchers.hasSize(100));

        SoftAssert softAssert = new SoftAssert();

        // softAssert.assertEquals(response.statusCode(),200);
        //softAssert.assertEquals(response.body().);


    }

    @Test
    public  void test02(){

        // Test that when we send a GET request to the https://jsonplaceholder.typicode.com/posts/44 endpoint,
        // the returned response has a status code of 200 and the value of the "title" field is "optio dolor molestias sit".

        // 1- prepare the body and the end-point

        specJsonPlaceHolder.pathParams("pp1","posts","pp2",44);

        // 2- prepare the expected data or body


        // 3- send request and save the response

        Response response = given()
                .when().spec(specJsonPlaceHolder)
                .get("/{pp1}/{pp2}");

        response.prettyPrint();

        // 4- Assertion

        response.then().assertThat()
                .statusCode(200)
                .body("title",Matchers.equalTo("optio dolor molestias sit"));


    }


}
