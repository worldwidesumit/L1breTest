package Common;

import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;

/**
 * Created by Chetna on 7/5/2017.
 */
public class JsonElements {

    static String AccessTokenPath = "result.loginToken.access_token";
    static String PassengerIdPath = "result.userInfo.passengerId";
    static String DocumentIdPath = "result.documentId";

    public static String getToken(Response res){
        JsonPath js = new JsonPath(res.asString());
        return js.get(AccessTokenPath);
    }

    public static String getPassengerId(Response res){
        JsonPath js = new JsonPath(res.asString());
        return js.get(PassengerIdPath);
    }

    public static String getDocumentId(Response res){
        JsonPath js = new JsonPath(res.asString());
        return js.get(DocumentIdPath);
    }


}
