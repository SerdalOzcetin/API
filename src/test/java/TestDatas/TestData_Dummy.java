package TestDatas;

import org.json.JSONObject;

public class TestData_Dummy {

    public static int successfulStatusCode =200;
    public static String contentType = "application/json";

    public static JSONObject JsonBodyCreation(int employee_age,
                                              int id,
                                              int employee_salary,
                                              String employee_name,
                                              String profile_image){


        JSONObject expectedData = new JSONObject();
        JSONObject innerExpectedData = new JSONObject();
/*
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

        innerExpectedData.put("id",id);
        innerExpectedData.put("employee_name",employee_name);
        innerExpectedData.put("employee_age",employee_age);
        innerExpectedData.put("employee_salary",employee_salary);
        innerExpectedData.put("profile_image",profile_image);

        expectedData.put("status","success");
        expectedData.put("message","Successfully! Record has been fetched.");
        expectedData.put("data",innerExpectedData);





        return expectedData;

    }

}
