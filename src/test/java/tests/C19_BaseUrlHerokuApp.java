package tests;

import baseUrl.BaseUrlHerokuapp;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C19_BaseUrlHerokuApp extends BaseUrlHerokuapp {

    @Test
    public void test01(){

        /*

        "When we send a GET request to the https://restful-booker.herokuapp.com/booking endpoint,
        test that the response has a status code of 200 and contains 12 bookings in the response."

         */



        // 1- prepare the body and the end-point


        specHerokuapp.pathParams("pp1","booking");


        // 2- prepare the expected data or body


        // 3- send request and save the response

        Response response = given()
                            .when().spec(specHerokuapp)
                            .get("/{pp1}");


        // 4- Assertion

        JsonPath responseJsonPath = response.jsonPath();

        System.out.println(responseJsonPath.getList("booking").size());

        response.then().assertThat().statusCode(200).body("booking",Matchers.hasSize(7000));


    }


}
