package ApiTests;

import Base.BaseTestSuite;
import Common.Headers;
import Common.JsonElements;
import Common.PayLoad;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.jayway.restassured.RestAssured.given;

/**
 * Created by Chetna on 7/6/2017.
 */
public class PassengerTests extends BaseTestSuite {

    static String bearerToken;
    static String PASSENGER1_PASSENGER_ID;
    static String PASSENGER1_TOKEN;
    static String PASSENGER2_PASSENGER_ID;
    static String PASSENGER2_TOKEN;

    static String suc = "SUCCESSFUL TESTS"+"\n";
    static String fail = "FAILED TESTS"+"\n";


    @Test(priority = 1)
    public void passenger1Login() throws IOException {
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = RestAssured.given()
                .header(Headers.getHeaderKeyContentType(), Headers.getHeaderValueApplicationJson()).and()
                .body(PayLoad.getPassenger1LoginBody())
                .when().post(BaseTestSuite.getData().getProperty("URL_PASSENGER_LOGIN"))
                .then().log().all().and().assertThat().statusCode(200).extract().response();
        PASSENGER1_TOKEN = JsonElements.getToken(res);
        PASSENGER1_PASSENGER_ID = JsonElements.getPassengerId(res);
    }

    @Test(priority = 2)
    public void passenger1GetSelfInfoPassengerId() throws IOException {
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = RestAssured.given()
                .header(Headers.getHeaderKeyContentType(), Headers.getHeaderValueApplicationJson()).and()
                .header(Headers.getHeaderAuthorization(), Headers.getHeaderAuthorizationValue(PASSENGER1_TOKEN))
                .log().all()
                .when().get(BaseTestSuite.getData().getProperty("URL_PASSENGER") + "/" + PASSENGER1_PASSENGER_ID)
                .then().log().all().and().assertThat().statusCode(200).extract().response();

    }

    @Test(priority = 3)
    public void passenger1GetSelfInfoPassengerUname() throws IOException {
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = RestAssured.given()
                .header(Headers.getHeaderKeyContentType(), Headers.getHeaderValueApplicationJson()).and()
                .header(Headers.getHeaderAuthorization(), Headers.getHeaderAuthorizationValue(PASSENGER1_TOKEN))
                .log().all()
                .when().get(BaseTestSuite.getData().getProperty("URL_PASSENGER") + "/" +
                        BaseTestSuite.getData().getProperty("PASSENGER1_USERNAME"))
                .then().log().all().and().assertThat().statusCode(200).extract().response();
    }

    @Test(priority = 4)
    public void passenger1ChangeLocale() throws IOException {
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = RestAssured.given()
                .header(Headers.getHeaderKeyContentType(), Headers.getHeaderValueApplicationJson()).and()
                .header(Headers.getHeaderAuthorization(), Headers.getHeaderAuthorizationValue(PASSENGER1_TOKEN))
                .and().body(PayLoad.getPassengerChangeLocale())
                .log().all()
                .when().put(BaseTestSuite.getData().getProperty("URL_PASSENGER") + "/" + PASSENGER1_PASSENGER_ID)

                .then().log().all().and().assertThat().statusCode(200).extract().response();
    }

    @Test(priority = 5)
    public void passenger1LogsOut() throws IOException {
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = RestAssured.given()
                .header(Headers.getHeaderKeyContentType(), Headers.getHeaderValueApplicationJson()).and()
                .header(Headers.getHeaderAuthorization(), Headers.getHeaderAuthorizationValue(PASSENGER1_TOKEN))
                .log().all()
                .when().post(BaseTestSuite.getData().getProperty("URL_PASSENGER_LOGOUT"))
                .then().log().all().and().assertThat().statusCode(200).extract().response();
    }

    @Test(priority = 6)
    public void passenger2Login() throws IOException {
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = RestAssured.given()
                .header(Headers.getHeaderKeyContentType(), Headers.getHeaderValueApplicationJson()).and()
                .body(PayLoad.getPassenger2LoginBody())
                .when().post(BaseTestSuite.getData().getProperty("URL_PASSENGER_LOGIN"))
                .then().log().all().and().assertThat().statusCode(200).extract().response();
        PASSENGER2_TOKEN = JsonElements.getToken(res);
        PASSENGER2_PASSENGER_ID = JsonElements.getPassengerId(res);
    }

    @Test(priority = 7)
    public void passenger2ChangePassword() throws IOException {
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = RestAssured.given()
                .header(Headers.getHeaderKeyContentType(), Headers.getHeaderValueApplicationJson()).and()
                .header(Headers.getHeaderAuthorization(), Headers.getHeaderAuthorizationValue(PASSENGER2_TOKEN))
                .and().body(PayLoad.getPassengerChangePasswordBody())
                .when().post(BaseTestSuite.getData().getProperty("URL_PASSENGER_CHANGE_PASSWORD"))
                .then().log().all().and().assertThat().statusCode(200).extract().response();

    }

    @Test(priority = 8)
    public void passenger2LogsOut() throws IOException {
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = RestAssured.given()
                .header(Headers.getHeaderKeyContentType(), Headers.getHeaderValueApplicationJson()).and()
                .header(Headers.getHeaderAuthorization(), Headers.getHeaderAuthorizationValue(PASSENGER2_TOKEN))
                .log().all()
                .when().post(BaseTestSuite.getData().getProperty("URL_PASSENGER_LOGOUT"))
                .then().log().all().and().assertThat().statusCode(200).extract().response();
    }

    @Test(priority = 9)
    public void passenger2LoginOldPassword() throws IOException {
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = RestAssured.given()
                .header(Headers.getHeaderKeyContentType(), Headers.getHeaderValueApplicationJson()).and()
                .body(PayLoad.getPassenger2LoginBody())
                .when().post(BaseTestSuite.getData().getProperty("URL_PASSENGER_LOGIN"))
                .then().log().all().and().assertThat().statusCode(401).extract().response();
    }

    @Test(priority = 10)
    public void passenger2LoginNewPassword() throws IOException {
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = RestAssured.given()
                .header(Headers.getHeaderKeyContentType(), Headers.getHeaderValueApplicationJson()).and()
                .body(PayLoad.getPassenger2NewPassLoginBody())
                .when().post(BaseTestSuite.getData().getProperty("URL_PASSENGER_LOGIN"))
                .then().log().all().and().assertThat().statusCode(200).extract().response();
        PASSENGER2_TOKEN = JsonElements.getToken(res);
        PASSENGER2_PASSENGER_ID = JsonElements.getPassengerId(res);
    }

    @Test(priority = 11)
    public void passenger2RevertPassword() throws IOException {
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = RestAssured.given()
                .header(Headers.getHeaderKeyContentType(), Headers.getHeaderValueApplicationJson()).and()
                .header(Headers.getHeaderAuthorization(), Headers.getHeaderAuthorizationValue(PASSENGER2_TOKEN))
                .and().body(PayLoad.getPassengerRevertPasswordBody())
                .when().post(BaseTestSuite.getData().getProperty("URL_PASSENGER_CHANGE_PASSWORD"))
                .then().log().all().and().assertThat().statusCode(200).extract().response();
        passenger2LogsOut();

    }

    @Test(priority = 12)
    public void passenger2GenerateTempCode() throws IOException {
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = RestAssured.given()
                .header(Headers.getHeaderKeyContentType(), Headers.getHeaderValueApplicationJson()).and()
                .body(PayLoad.getPassengerGenerateTempDataBody())
                .when().post(BaseTestSuite.getData().getProperty("URL_PASSENGER_GENERATE_TEMP_CODE"))
                .then().log().all().and().assertThat().statusCode(200).extract().response();

    }

    //@Test(priority = 13)
    public void passengerRefreshToken() throws IOException {
        passenger2Login();
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = RestAssured.given()
                .header(Headers.getHeaderKeyContentType(), Headers.getHeaderValueApplicationJson()).and()
                .header(Headers.getHeaderAuthorization(), Headers.getHeaderAuthorizationValue(PASSENGER2_TOKEN)).and()
                .body(PayLoad.getPassengerRefreshToken())
                .when().post(BaseTestSuite.getData().getProperty("URL_PASSENGER_REFRESH_TOKEN"))
                .then().log().all().and().assertThat().statusCode(200).extract().response();

    }

    @AfterMethod
    public void getResult(ITestResult result){
        if(result.getStatus() == ITestResult.SUCCESS){
            suc = suc+ result.getName()+":"+result.isSuccess()+"\n";
            System.out.println(suc);
        }else {
            System.out.println("HoHai");
            fail = fail+ result.getName()+":"+result.isSuccess()+"\n";
        }

    }

    @AfterClass
    public void sendEmail(){

        Base.TestRunner.setSendBodyBody(this.getClass().getSimpleName()+"\n"+suc+fail);
    }

}



