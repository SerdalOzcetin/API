package TestDatas;

import org.json.JSONObject;

public class TestData_Herokuapp {



    static JSONObject resquestBody;

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

}
