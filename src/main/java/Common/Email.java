package Common;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.jayway.restassured.RestAssured.given;

/**
 * Created by Chetna on 7/6/2017.
 *
 */

public class Email {

    static String myEmail = "worldwide.sumit@aol.in";

    public static List<String> getMyEmail(){
        List<String> newEmail = new ArrayList<>();
        newEmail.add(myEmail);
        return newEmail;
    }

    public static void sendemail(List<String> elist,String body){
        String listString = String.join(", ", elist);
        RestAssured.baseURI = "https://api.mailgun.net/v3";
        Response res = RestAssured.given()
                .auth().preemptive().basic("api","key-9641868ec14fc6db528656a021989d88")
                .multiPart("from","APITestStatusL1BRE@mg.sumplusit.com")
                .multiPart("to", listString)
                .multiPart("subject","L1BRE Test Status -- "+ DateTime.now())
                .multiPart("text",body).log().all()
                .when().post("/mg.sumplusit.com/messages")
                .then().log().all().assertThat().statusCode(200).extract().response();
    }
}
