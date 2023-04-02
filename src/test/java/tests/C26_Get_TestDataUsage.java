package tests;

import TestDatas.TestData_Dummy;
import TestDatas.TestData_JsonPlaceHolder;
import baseUrl.BaseUrlDummy;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C26_Get_TestDataUsage extends BaseUrlDummy {

    @Test
    public void test01(){

        /*

        Send a GET request to the URL http://dummy.restapiexample.com/api/v1/employee/3 and
        test whether the response status code is 200,
        content type is "application/json",
        and response body is as follows:

                            Response Body:

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
            specDummy.pathParams("pp1","employee","pp2",3);

        // 2- prepare the expected data or body
        JSONObject expectedData = TestData_Dummy.JsonBodyCreation(66,3,86000,"Ashton Cox","");

        // 3- send request and save the response

        Response response = given()
                .spec(specDummy)
                .when()
                .get("/{pp1}/{pp2}");

        response.prettyPrint();

        JsonPath responseJsonPath = response.jsonPath();

        // 4- Assertion

        assertEquals(TestData_Dummy.successfulStatusCode,response.statusCode());
        assertEquals(TestData_Dummy.contentType,response.contentType());

        assertEquals(expectedData.getString("status"),responseJsonPath.getString("status"));
        assertEquals(expectedData.getString("message"),responseJsonPath.getString("message"));

        assertEquals(expectedData.getJSONObject("data").getInt("id"),responseJsonPath.getInt("data.id"));
        assertEquals(expectedData.getJSONObject("data").getString("employee_name"),responseJsonPath.getString("data.employee_name"));
        assertEquals(expectedData.getJSONObject("data").getInt("employee_salary"),responseJsonPath.getInt("data.employee_salary"));
        assertEquals(expectedData.getJSONObject("data").getInt("employee_age"),responseJsonPath.getInt("data.employee_age"));
        assertEquals(expectedData.getJSONObject("data").getString("profile_image"),responseJsonPath.getString("data.profile_image"));

    }

}
