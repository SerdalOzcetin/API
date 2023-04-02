package TestDatas;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class TestData_Herokuapp {



    static JSONObject resquestBody;
    static Map<String,Object> requestBodyMap;

    public static JSONObject creationJsonObject(String firstname,
                                                String lastname,
                                                int totalprice,
                                                boolean depositpaid,
                                                String checkin,
                                                String checkout,
                                                String additionalneeds){

        /*
         Request Body:

                    {
                    "firstname" : "Ahmet",
                    "lastname" : "Bulut",
                    "totalprice" : 500,
                    "depositpaid" : false,
                    "bookingdates" : {
                            "checkin" : "2021-06-01",
                            "checkout" : "2021-06-10"
                    },
                    "additionalneeds" : "wi-fi"
            }
         */

        resquestBody = new JSONObject();
        JSONObject bookingDates = new JSONObject();

            bookingDates.put("checkin",checkin);
            bookingDates.put("checkout",checkout);

        resquestBody.put("firstname",firstname);
        resquestBody.put("lastname",lastname);
        resquestBody.put("totalprice",totalprice);
        resquestBody.put("depositpaid",depositpaid);
        resquestBody.put("additionalneeds",additionalneeds);
        resquestBody.put("bookingdates",bookingDates);



        return resquestBody;

    }

    public static JSONObject responseBodyCreation(){

        JSONObject responseBody = new JSONObject();
        responseBody.put("booking",resquestBody);

        return responseBody;
    }

    public static Map<String, Object> creationRequestbodyMap(String firstname,
                                                             String lastname,
                                                             double totalprice,
                                                             boolean depositpaid,
                                                             String checkin,
                                                             String checkout,
                                                             String additionalneeds){

        requestBodyMap = new HashMap<>();
        Map<String,Object> bookingDatesBodyMap = new HashMap<>();

            bookingDatesBodyMap.put("checkin",checkin);
            bookingDatesBodyMap.put("checkout",checkout);

        requestBodyMap.put("firstname",firstname);
        requestBodyMap.put("lastname",lastname);
        requestBodyMap.put("totalprice",totalprice);
        requestBodyMap.put("depositpaid",depositpaid);
        requestBodyMap.put("additionalneeds",additionalneeds);
        requestBodyMap.put("bookingdates",bookingDatesBodyMap);

        return requestBodyMap;

    }

    public static Map<String,Object> responseBodyMap(){

        Map<String,Object> responseBodyMap =new HashMap<>();

        responseBodyMap.put("booking",requestBodyMap);

        return responseBodyMap;
    }

}
