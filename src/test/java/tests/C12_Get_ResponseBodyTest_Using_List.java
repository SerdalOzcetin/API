package tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C12_Get_ResponseBodyTest_Using_List {

    @Test
    public void test01(){

        /*

        When we send a GET request to the URL "http://dummy.restapiexample.com/api/v1/employees",
        test the following assertions about the returned response:

            The status code should be 200.
            The content type should be "Application/JSON".
            The number of employees in the response body should be 24.
            One of the employees in the response body should be "Ashton Cox".
            The ages 61, 21, and 35 should be present among the entered ages.

         */

        // 1- prepare the body and the end-point

        String url = "http://dummy.restapiexample.com/api/v1/employees";

        // 2- prepare the expected data or body

        // 3- send request and save the response

        Response response = given().when().get(url);

        // 4- Assertion

        response.then()
                .assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("data.id",hasSize(24))
                .body("data.employee_name",hasItem("Ashton Cox"),
                        "data.employee_age",hasItems(61,21,35));
    }

}
