package tests;

import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C02_GetRequest_Test_Manual_Data {

    @Test
    public void test01(){

        /*
                  A GET request to https://restful-booker.herokuapp.com/booking/10
            of the Response that came back when we sent it,
            status code 200,
            and the content type is application/json; charset=utf-8,
            and the value of the header named Server is Cowboy,
            and status Line's HTTP/1.1 200 OK
            and manually test that the response time is less than 5 seconds.
         */

        // 1- prepare the body and the end-point

        String url ="https://restful-booker.herokuapp.com/booking/10";

        // 2- prepare the expected data or body

        // 3- send request and save the response

        Response response = given().when().get(url);

        System.out.println(response.getBody().toString()); // doesn't work lke "prettyPrint"
        response.prettyPrint();

        System.out.println("status code : "+response.getStatusCode() +
                           "\n content type : " +response.getContentType() +
                           "\n Server Header : " + response.getHeader("Server") +
                           "\n Status Line : " + response.getStatusLine() +
                           "\n Response Time : " + response.getTime() );

        // 4- Assertion

    }

}
