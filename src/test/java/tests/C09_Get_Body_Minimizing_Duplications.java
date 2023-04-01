package tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C09_Get_Body_Minimizing_Duplications {

    @Test
    public void test01(){

        /*
        Test that when we send a GET request to the URL "https://restful-booker.herokuapp.com/booking/10",
         the returned Response has a status code of 200,
         a content type of "application-json",
         and the following fields in the response body:

            "firstname" is "Sally"
            "lastname" is "Jackson"
            "totalprice" is 569
            "depositpaid" is false
            "additionalneeds" is "Breakfast".
         */

        // 1- prepare the body and the end-point

        String url = "https://restful-booker.herokuapp.com/booking/10";

        // 2- prepare the expected data or body

        // 3- send request and save the response

        Response response = given().when().get(url);

        // 4- Assertion
        response.prettyPrint();
        /*
        response.then().assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("firstname", Matchers.equalTo("Mary"))
                .body("lastname",Matchers.equalTo("Wilson"))
                .body("totalprice",Matchers.equalTo(762))
                .body("depositpaid",Matchers.equalTo(true))
                .body("additionalneeds",Matchers.notNullValue());

         */

        response.then().assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("firstname",equalTo("Jim"),
                        "lastname",equalTo("Smith"),
                        "totalprice",lessThan(1000),
                        "depositpaid",equalTo(false),
                        "additionaşneeds",notNullValue());




    }

}
