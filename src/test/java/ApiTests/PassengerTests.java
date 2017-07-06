package ApiTests;

import Base.BaseTestSuite;
import Common.Headers;
import Common.JsonElements;
import Common.PayLoad;
import Common.Resources;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.jayway.restassured.RestAssured.given;

/**
 * Created by Chetna on 7/6/2017.
 */
public class PassengerTests {

    static String bearerToken;


    @Test(priority = 1)
    public void passenger2Login() throws IOException {
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = given()
                .header(Headers.getHeaderKeyContentType(),Headers.getHeaderValueApplicationJson()).and()
                .body(PayLoad.getPassenger2LoginBody())
                .when().post(Resources.getPassengerLogin())
                .then().log().all().and().assertThat().statusCode(200).extract().response();
        bearerToken = JsonElements.getBearerToken(res);

    }
    @Test(priority = 2)
    public void passenger2ChangePassword() throws IOException {
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = given()
                .header("Authorization","Bearer "+bearerToken).and()
                .header(Headers.getHeaderKeyContentType(),Headers.getHeaderValueApplicationJson()).and()
                .body(PayLoad.getPassenger2ChangePassword()).log().all()
                .when().post(Resources.getPassengerChangePassword())
                .then().log().all().and().assertThat().statusCode(200).extract().response();

    }
}
