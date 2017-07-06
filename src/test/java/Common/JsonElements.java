package Common;

import com.jayway.restassured.path.json.JsonPath;
import com.jayway.restassured.response.Response;

/**
 * Created by Chetna on 7/5/2017.
 */
public class JsonElements {

    static String AccessTokenPath = "result.loginToken.access_token";

    public static String getBearerToken(Response res){
        JsonPath js = new JsonPath(res.asString());
        return js.get(AccessTokenPath);
    }
}
