import org.json.JSONObject;
import org.junit.Test;

public class C04_Creation_JSON_Object {

    @Test
    public void test01(){

        /*
        {

            "title":"Jhon",
            "body":"Hello",
            "userId":1

}
         */

        JSONObject obj01 = new JSONObject();

        obj01.put("title","Jhon");
        obj01.put("body","Hello");
        obj01.put("userID",1);


        System.out.println(obj01);

    }


}
