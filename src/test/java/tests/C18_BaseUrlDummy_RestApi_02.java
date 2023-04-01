package tests;
import baseUrl.BaseUrl_JsonPlaceHolder;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.*;


public class C18_BaseUrlDummy_RestApi_02 extends BaseUrl_JsonPlaceHolder {


    @Test
    public void test01(){

        /*
           Test that when we send a DELETE request to the https://jsonplaceholder.typicode.com/posts/50 endpoint,
           the returned response has a status code of 200 and the response body is null.
         */




        // 1- prepare the body and the end-point

            specJsonPlaceHolder.pathParams("pp1","posts","pp2",50);

        // 2- prepare the expected data or body


        // 3- send request and save the response

        Response response = given().spec(specJsonPlaceHolder)
                            .when()
                            .delete("/{pp1}/{pp2}");

        response.prettyPrint();


        // 4- Assertion

            response.then()
                    .assertThat()
                    .statusCode(200)
                    .body("title", Matchers.nullValue());

    }


}
