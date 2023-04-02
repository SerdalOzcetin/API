package TestDatas;

import org.json.JSONObject;

public class TestData_JsonPlaceHolder {

    public static int successfulStatusCode =200;
    public static String contentType = "application/json; charset=utf-8";
    public static String connectionHeader = "keep-alive";

    public static JSONObject responseBodyCreation22(){

        JSONObject expectedData = new JSONObject();
        expectedData.put("userId",3);
        expectedData.put("id",22);
        expectedData.put("title","dolor sint quo a velit explicabo quia nam");
        expectedData.put("body","eos qui et ipsum ipsam suscipit aut\n" +
                "sed omnis non odio\n" +
                "expedita earum mollitia molestiae aut atque rem suscipit\n" +
                "nam impedit esse");

            return expectedData;

    }

    public static JSONObject JsonBodyCreation(int userId, int id, String title, String body){


        JSONObject expectedData = new JSONObject();
        expectedData.put("userId",userId);
        expectedData.put("id",id);
        expectedData.put("title",title);
        expectedData.put("body",body);


        return expectedData;

    }


}
