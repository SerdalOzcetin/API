package tests;

import baseUrl.BaseUrlDummy;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.Pojo_Herokuap_Response;
import pojos.Pojo_Herokuapp_BookingDates;
import pojos.Pojo_Herokuapp_requestBody;

import static io.restassured.RestAssured.given;

public class C33_Get_Pojo extends BaseUrlDummy {

    /*

     Test the response returned when we send a GET request to the URL http://dummy.restapiexample.com/api/v1/employee/3
     and verify that the response body is as follows:

                Response Body
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
        specDummy.pathParams("pp1","employee","pp2","3");

        // 2- prepare the expected data or body


        // 3- send request and save the response


        // 4- Assertion

    }
}
