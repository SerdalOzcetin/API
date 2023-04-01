package tests;

import netscape.javascript.JSObject;
import org.json.JSONObject;
import org.junit.Test;

public class C05_Creation_JSON_Object {

    @Test
    public void test01(){

        JSONObject obj01 = new JSONObject();
        JSONObject obj02 = new JSONObject();
        /*
                "firstname":"Jim",
                "additionalneeds":"Breakfast",
                "bookingdates":{
                "checkin":"2018-01-01",
                "checkout":"2019-01-01"
                },
                "totalprice":111,
                "depositpaid":true,
                "lastname":"Brown"
         */

       /*

       1. way

        obj01.put("firstname","Jim");
        obj01.put("additionalneeds","Breakfast");
        obj01.put("Bookingdates",obj02.put("checkin","2018-01-01"));
        obj01.put("Bookingdates",obj02.put("checkout","2019-01-01"));
        obj01.put("totalprice",111);
        obj01.put("depositpaid",true);
        obj01.put("lastname","Brown");


        {
        "firstname":"Jim",
        "additionalneeds":"Breakfast",
        "totalprice":111,
        "depositpaid":true,
        "Bookingdates":{"checkin":"2018-01-01",
                        "checkout":"2019-01-01"},
        "lastname":"Brown"
        }

         */


        // 2. Way

        // Firstly create the inner object.

        obj02.put("checkin","2018-01-01");
        obj02.put("checkout","2019-01-01");

        //Secondly create the outer object.

        System.out.println(obj01);
        obj01.put("firstname","Jim");
        obj01.put("additionalneeds","Breakfast");
        obj01.put("Bookingdates",obj02);
        obj01.put("totalprice",111);
        obj01.put("depositpaid",true);
        obj01.put("lastname","Brown");


        System.out.println(obj01);

        /*

        {
        "firstname":"Jim",
        "additionalneeds":"Breakfast",
        "totalprice":111,
        "depositpaid":true,
        "Bookingdates":{"checkin":"2018-01-01",
                        "checkout":"2019-01-01"},
        "lastname":"Brown"
        }

         */






    }

}