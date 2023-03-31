import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import static io.restassured.RestAssured.given;

public class C15_Get_ExpectedDataTest_With_SoftAssert {


    @Test
    public void test01(){

        /*
        Test the response that is returned when sending a GET request to the URL http://dummy.restapiexample.com/api/v1/employee/3
         and ensure that it matches the following response body:

                    {
                    "status": "success",
                    "data": {
                        "id": 3,
                        "employee_name": "Ashton Cox",
                        "employee_salary": 86000,
                        "employee_age": 66,
                        "profile_image": ""
                        },
                    "message": "Successfully! Record has been fetched."
                    }
         */


        // 1- prepare the body and the end-point

        String url = "http://dummy.restapiexample.com/api/v1/employee/3";

        // 2- prepare the expected data or body

        JSONObject expectedDataJson = new JSONObject();
        JSONObject dataInfo = new JSONObject();
            dataInfo.put("id",3);
            dataInfo.put("employee_name","Ashton Cox");
            dataInfo.put("employee_salary",86000);
            dataInfo.put("employee_age",66);
            dataInfo.put("profile_image","");

        expectedDataJson.put("status","success");
        expectedDataJson.put("data",dataInfo);
        expectedDataJson.put("message","Successfully! Record has been fetched.");

        System.out.println(expectedDataJson);

        // 3- send request and save the response

        Response response = given().when().get(url);

        JsonPath responseJsonPath = response.jsonPath();


        // 4- Assertion

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(responseJsonPath.get("status"),expectedDataJson.get("status"));
        softAssert.assertEquals(responseJsonPath.get("message"),expectedDataJson.get("message"));
        softAssert.assertEquals(responseJsonPath.get("data.id"),expectedDataJson.getJSONObject("data").get("id"));
        softAssert.assertEquals(responseJsonPath.get("data.employee_name"),expectedDataJson.getJSONObject("data").get("employee_name"));
        softAssert.assertEquals(responseJsonPath.get("data.employee_salary"),expectedDataJson.getJSONObject("data").get("employee_salary"));
        softAssert.assertEquals(responseJsonPath.get("data.employee_age"),expectedDataJson.getJSONObject("data").get("employee_age"));
        softAssert.assertEquals(responseJsonPath.get("data.profile_image"),expectedDataJson.getJSONObject("data").get("profile_image"));


        softAssert.assertAll();

    }

}
