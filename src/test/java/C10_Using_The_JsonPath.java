import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Test;

public class C10_Using_The_JsonPath {

    @Test
    public void test01(){

        JSONObject personalDatasJsonObj = new JSONObject();





        JSONObject addressJsonObj = new JSONObject();

        addressJsonObj.put("streetAddress","naist Street");
        addressJsonObj.put("city", "Nara");
        addressJsonObj.put("postalCode","630-0192");

        JSONArray phoneDatasArr = new JSONArray();

                JSONObject mobilePhoneDatasJsonObj = new JSONObject();

                    mobilePhoneDatasJsonObj.put("type","iPhone");
                    mobilePhoneDatasJsonObj.put("number", "0123-4567-8888");

                JSONObject phoneDatasJsonObj = new JSONObject();

                    phoneDatasJsonObj.put("type","home");
                    phoneDatasJsonObj.put("number","0123-4567-8910");

            phoneDatasArr.put(mobilePhoneDatasJsonObj);
            phoneDatasArr.put(phoneDatasJsonObj);



        personalDatasJsonObj.put("firstname","Jhon");
        personalDatasJsonObj.put("lastname","doe");
        personalDatasJsonObj.put("age",26);
        personalDatasJsonObj.put("address",addressJsonObj);
        personalDatasJsonObj.put("phoneNumbers",phoneDatasArr);

        System.out.println(personalDatasJsonObj);

        System.out.println("firstname : "+personalDatasJsonObj.get("firstname"));
        System.out.println("lastname : "+personalDatasJsonObj.get("lastname"));

        System.out.println("streetAddress : "+personalDatasJsonObj.getJSONObject("address").get("streetAddress"));
        System.out.println("city : " + personalDatasJsonObj.getJSONObject("address").get("city"));

        System.out.println("MobilePhoneNumber : " + personalDatasJsonObj.getJSONArray("phoneNumbers").getJSONObject(0).get("number"));
    }

}
