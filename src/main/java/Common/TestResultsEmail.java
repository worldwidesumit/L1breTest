package Common;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import org.joda.time.DateTime;
import org.testng.TestRunner;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.jayway.restassured.RestAssured.given;

/**
 * Created by Chetna on 7/6/2017.
 *
 */

public class TestResultsEmail {

    static String myEmail = "worldwide.sumit@aol.in";



    public List<String> getEmail(){
        List<String> newEmail = new ArrayList<>();
        newEmail.add(myEmail);
        return newEmail;
    }
    @Test(priority = 1000)
    public void sendEmail(){
        String listString = String.join(", ", getEmail());
        RestAssured.baseURI = "https://api.mailgun.net/v3";
        Response res = RestAssured.given()
                .auth().preemptive().basic("api","key-9641868ec14fc6db528656a021989d88")
                .multiPart("from","APITestStatusL1BRE@mg.sumplusit.com")
                .multiPart("to", listString)
                .multiPart("subject","L1BRE Test Status -- "+ DateTime.now())
                .multiPart("text", Base.TestRunner.getSendBody()).log().all()
                .when().post("/mg.sumplusit.com/messages")
                .then().log().all().assertThat().statusCode(200).log().all().extract().response();
    }
}