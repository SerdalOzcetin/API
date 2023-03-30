import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class C07_Get_Test_ResponseBody {

    @Test
    public void test01(){

        /*
        "When we send a GET request to the URL https://jsonplaceholder.typicode.com/posts/44,
         test that the returned response has a status code of 200,
         a content type of Application.JSON,
         the userId in the response body is 5,
         and the title in the response body is "optio dolor molestias sit"."
         */

        // 1- prepare the body and the end-point

        String url = "https://jsonplaceholder.typicode.com/posts/44";

        // 2- prepare the expected data or body

        // 3- send request and save the response

        Response response = given().when().get(url);
        response.prettyPrint();
        // 4- Assertion

        response.then()
                .assertThat().statusCode(200)
                .contentType(ContentType.JSON)
                .body("userId", Matchers.equalTo(5))
                .body("title",Matchers.equalTo("optio dolor molestias sit"));
    }

}
