package tests;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C06_Put_Assert_The_Response_Datas {

    @Test
    public void test01(){

        /*
      Add the following Json format body to the url https://jsonplaceholder.typicode.com/posts/70
            When we send PUT request

            {

            "title": "Ahmed",
            "body": "Hello",
            "userId": 10,
            "id": 70

            }

            returning Response's status code is 200,
            and the content type is application/json; charset=utf-8,
            and the value of the Header named Server is cloudflare,
            and status Line's HTTP/1.1 200 OK

            test that
         */

        // 1- prepare the body and the end-point

        String url = "https://jsonplaceholder.typicode.com/posts/70";

        JSONObject obj01 = new JSONObject();

        obj01.put("title","Jhon");
        obj01.put("body","Hello");
        obj01.put("userID",10);
        obj01.put("id",70);

        // 2- prepare the expected data or body

        // 3- send request and save the response

        Response response = given()
                            .contentType(ContentType.JSON)
                            .when().body(obj01
                            .toString())
                            .put(url);

        response.prettyPrint();

        // 4- Assertion

        response.then().assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8")
                .header("Server","cloudflare")
                .statusLine("HTTP/1.1 200 OK");

    }

}
