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
    static String TripIdPath = "result.tripId";
    static String ShiftIdPath = "result.shiftId";
    static String driverId = "result.userInfo.driverId";

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

    public static String getTripId(Response res){
        JsonPath js = new JsonPath(res.asString());
        return js.get(TripIdPath);
    }

    public static String getShiftId(Response res){
        JsonPath js = new JsonPath(res.asString());
        return js.get(ShiftIdPath);
    }

    public static String getDriverId(Response res){
        JsonPath js = new JsonPath(res.asString());
        return js.get(driverId);
    }




}
