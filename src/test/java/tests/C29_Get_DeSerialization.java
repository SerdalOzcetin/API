package tests;

import TestDatas.TestData_Dummy;
import baseUrl.BaseUrlDummy;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class C29_Get_DeSerialization extends BaseUrlDummy {

    /*
        When we send a GET request to the URL "http://dummy.restapiexample.com/api/v1/employee/3",
        we should test that the response's status code is 200, the content type is "application/json",
        and the body is as follows:

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

    @Test
    public void test01() {


        // 1- prepare the body and the end-point
        specDummy.pathParams("pp1","employee","pp2",3);

        // 2- prepare the expected data or body
        Map<String, Object> expectedDataMap = TestData_Dummy.creationBodyMap(3.0,"Ashton Cox",66.0,86000.0,"");

        // 3- send request and save the response

            Response response = given()
                    .spec(specDummy)
                    .when()
                    .get("/{pp1}/{pp2}");

            Map<String,Object> responseBodyMap = response.as(HashMap.class);
            System.out.println(responseBodyMap);

        // 4- Assertion

        assertEquals(TestData_Dummy.successfulStatusCode,response.statusCode());
        assertEquals(TestData_Dummy.contentType,response.contentType());

        assertEquals(expectedDataMap.get("message"),responseBodyMap.get("message"));
        assertEquals(expectedDataMap.get("status"),responseBodyMap.get("status"));

        assertEquals(((Map)expectedDataMap.get("data")).get("employee_name"),
                ((Map)responseBodyMap.get("data")).get("employee_name"));

        assertEquals(((Map)expectedDataMap.get("data")).get("employee_salary"),
                ((Map)responseBodyMap.get("data")).get("employee_salary"));

        assertEquals(((Map)expectedDataMap.get("data")).get("employee_age"),
                ((Map)responseBodyMap.get("data")).get("employee_age"));

        assertEquals(((Map)expectedDataMap.get("data")).get("profile_image"),
                ((Map)responseBodyMap.get("data")).get("profile_image"));
    }
}
