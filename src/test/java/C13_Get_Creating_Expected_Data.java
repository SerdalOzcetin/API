import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class C13_Get_Creating_Expected_Data {

    @Test
    public void test01(){


        /*

            When we send a GET request to the URL "https://jsonplaceholder.typicode.com/posts/22",
            test that the returned response body is the same as the following:

                Response body:
                "userId": 3,
                "id": 22,
                "title": "dolor sint quo a velit explicabo quia nam",
                "body": "eos qui et ipsum ipsam suscipit aut sed omnis non odioexpedita earum mollitia molestiae aut atque rem suscipitnam impedit esse"


         */


        // 1- prepare the body and the end-point

        String url = "https://jsonplaceholder.typicode.com/posts/22";

        // 2- prepare the expected data or body

        JSONObject expectedData = new JSONObject();
        expectedData.put("userId",3);
        expectedData.put("id",22);
        expectedData.put("title","dolor sint quo a velit explicabo quia nam");
        expectedData.put("body","eos qui et ipsum ipsam suscipit aut\n" +
                "sed omnis non odio\n" +
                "expedita earum mollitia molestiae aut atque rem suscipit\n" +
                "nam impedit esse");

        System.out.println(expectedData.toString());

        // 3- send request and save the response
        Response response = given().when().get(url);
        response.prettyPrint();

        // 4- Assertion

       /* response.then()
                .assertThat()
                .body("userId",equalTo(3),
                        "id",equalTo(22),
                        "title",equalTo("dolor sint quo a velit explicabo quia nam"),
                        "body",equalTo("eos qui et ipsum ipsam suscipit aut\nsed omnis non odio\nexpedita earum mollitia molestiae aut atque rem suscipit\nnam impedit esse"));


        */

        JsonPath responseJsonPath = response.jsonPath();
        Assert.assertEquals(expectedData.get("id"),responseJsonPath.get("id"));
        Assert.assertEquals(expectedData.get("title"),responseJsonPath.get("title"));
        Assert.assertEquals(expectedData.get("body"),responseJsonPath.get("body"));
        Assert.assertEquals(expectedData.get("userId"),responseJsonPath.get("userId"));

    }

}
