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
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;

/**
 * Created by Chetna on 7/12/2017.
 */
public class TripManagerTests extends BaseTestSuite{

    static String bearerToken;
    static String driverToken;
    static String SHIFTID;
    static String TRIPID;
    static String suc = "SUCCESSFUL TESTS"+"\n";
    static String fail = "FAILED TESTS"+"\n";
    static String PASSENGER1_TOKEN;
    static String PASSENGER1_PASSENGER_ID;

    public static String getTRIPID(){
        return TRIPID;
    }

    public static String getSHIFTID(){
        return SHIFTID;
    }


    @Test(priority = 1)
    public void tripDriver1Login() throws IOException {
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = RestAssured.given()
                .header(Headers.getHeaderKeyContentType(), Headers.getHeaderValueApplicationJson()).and()
                .body(PayLoad.getDriver1LoginBody()).log().all()
                .when().post(BaseTestSuite.getData().getProperty("URL_DRIVER_LOGIN"))
                .then().log().all().and().assertThat().statusCode(200).extract().response();
        driverToken = JsonElements.getToken(res);
    }

    @Test(priority = 1)
    public static void webUserLogin() throws IOException {
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = RestAssured.given()
                .header(Headers.getHeaderKeyContentType(),Headers.getHeaderValueApplicationJson()).and()
                .body(PayLoad.getWebUserLoginBody()).log().all()
                .when().post(BaseTestSuite.getData().getProperty("URL_WEBUSER_LOGIN"))
                .then().log().all().and().assertThat().statusCode(200).extract().response()
                ;
        bearerToken = JsonElements.getToken(res);
        System.out.println(bearerToken);
    }

    @Test(priority = 2)
    public void tripDriver1ShiftsTaxi1() throws IOException {
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = RestAssured.given()
                .header(Headers.getHeaderKeyContentType(), Headers.getHeaderValueApplicationJson()).and()
                .header(Headers.getHeaderAuthorization(), Headers.getHeaderAuthorizationValue(driverToken))
                .body(PayLoad.getDriverShiftsTaxi1Body()).log().all()
                .when().post(BaseTestSuite.getData().getProperty("URL_DRIVER_SHIFT"))
                .then().log().all().and().assertThat().statusCode(200).extract().response();
        SHIFTID = JsonElements.getShiftId(res);
    }

    @Test(priority = 3)
    public void tripDriver1BooksTrip1Shift1() throws IOException {
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = RestAssured.given()
                .header(Headers.getHeaderKeyContentType(), Headers.getHeaderValueApplicationJson()).and()
                .header(Headers.getHeaderAuthorization(), Headers.getHeaderAuthorizationValue(driverToken))
                .body(PayLoad.getTripDriver1BookTaxi1Body()).log().all()
                .when().post(BaseTestSuite.getData().getProperty("URL_TRIP_MANAGER_TRIP"))
                .then().log().all().and().assertThat().statusCode(200).extract().response();
        TRIPID = JsonElements.getTripId(res);
    }


    @Test(priority = 4)
    public void tripDriver1CancelsTrip1() throws IOException {
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = RestAssured.given()
                .header(Headers.getHeaderKeyContentType(), Headers.getHeaderValueApplicationJson()).and()
                .header(Headers.getHeaderAuthorization(), Headers.getHeaderAuthorizationValue(driverToken))
                .body(PayLoad.getTripCancelTripBody()).log().all()
                .when().put(BaseTestSuite.getData().getProperty("URL_TRIP_MANAGER_TRIP")+"/"
                + TRIPID
                +BaseTestSuite.getData().getProperty("URL_TRIP_MANAGER_TRIP_CANCEL"))
                .then().log().all().and().assertThat().statusCode(200).extract().response();
    }

    @Test(priority = 5)
    public void tripDriver1BooksTrip2Shift1() throws IOException {
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = RestAssured.given()
                .header(Headers.getHeaderKeyContentType(), Headers.getHeaderValueApplicationJson()).and()
                .header(Headers.getHeaderAuthorization(), Headers.getHeaderAuthorizationValue(driverToken))
                .body(PayLoad.getTripDriver1BookTaxi1Body()).log().all()
                .when().post(BaseTestSuite.getData().getProperty("URL_TRIP_MANAGER_TRIP"))
                .then().log().all().and().assertThat().statusCode(200).extract().response();
        TRIPID = JsonElements.getTripId(res);
    }

    @Test(priority = 6)
    public void tripDriver1StartTrip2() throws IOException {
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = RestAssured.given()
                .header(Headers.getHeaderKeyContentType(), Headers.getHeaderValueApplicationJson()).and()
                .header(Headers.getHeaderAuthorization(), Headers.getHeaderAuthorizationValue(driverToken))
                .log().all()
                .when().put(BaseTestSuite.getData().getProperty("URL_TRIP_MANAGER_TRIP")+"/"
                        + TRIPID
                        +BaseTestSuite.getData().getProperty("URL_TRIP_MANAGER_TRIP_START"))
                .then().log().all().and().assertThat().statusCode(200).extract().response();
    }

    @Test(priority = 7)
    public void tripDriver1PauseTrip2() throws IOException {
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = RestAssured.given()
                .header(Headers.getHeaderKeyContentType(), Headers.getHeaderValueApplicationJson()).and()
                .header(Headers.getHeaderAuthorization(), Headers.getHeaderAuthorizationValue(driverToken))
                .log().all()
                .when().put(BaseTestSuite.getData().getProperty("URL_TRIP_MANAGER_TRIP")+"/"
                        + TRIPID
                        +BaseTestSuite.getData().getProperty("URL_TRIP_MANAGER_TRIP_PAUSE"))
                .then().log().all().and().assertThat().statusCode(200).extract().response();
    }

    @Test(priority = 8)
    public void tripDriver1UnPauseTrip2() throws IOException {
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = RestAssured.given()
                .header(Headers.getHeaderKeyContentType(), Headers.getHeaderValueApplicationJson()).and()
                .header(Headers.getHeaderAuthorization(), Headers.getHeaderAuthorizationValue(driverToken))
                .log().all()
                .when().put(BaseTestSuite.getData().getProperty("URL_TRIP_MANAGER_TRIP")+"/"
                        + TRIPID
                        +BaseTestSuite.getData().getProperty("URL_TRIP_MANAGER_TRIP_UNPAUSE"))
                .then().log().all().and().assertThat().statusCode(200).extract().response();
    }

    @Test(priority = 9)
    public void tripDriver1EndTrip2() throws IOException {
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = RestAssured.given()
                .header(Headers.getHeaderKeyContentType(), Headers.getHeaderValueApplicationJson()).and()
                .header(Headers.getHeaderAuthorization(), Headers.getHeaderAuthorizationValue(driverToken))
                .body(PayLoad.getTripTrip2EndBody()).log().all()
                .when().put(BaseTestSuite.getData().getProperty("URL_TRIP_MANAGER_TRIP")+"/"
                        + TRIPID
                        +BaseTestSuite.getData().getProperty("URL_TRIP_MANAGER_TRIP_DESTINATION_REACHED"))
                .then().log().all().and().assertThat().statusCode(200).extract().response();
    }

    @Test(priority = 10)
    public void tripDriver1RatesTrip2() throws IOException {
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = RestAssured.given()
                .header(Headers.getHeaderKeyContentType(), Headers.getHeaderValueApplicationJson()).and()
                .header(Headers.getHeaderAuthorization(), Headers.getHeaderAuthorizationValue(driverToken))
                .body(PayLoad.getTripDriver1RateTrip2Body()).log().all()
                .when().put(BaseTestSuite.getData().getProperty("URL_TRIP_MANAGER_TRIP")+"/"
                        + TRIPID
                        +BaseTestSuite.getData().getProperty("URL_TRIP_MANAGER_TRIP_RATE"))
                .then().log().all().and().assertThat().statusCode(200).extract().response();
    }

    @Test(priority = 11)
    public void tripPassengerRatesTrip2() throws IOException {
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = RestAssured.given()
                .header(Headers.getHeaderKeyContentType(), Headers.getHeaderValueApplicationJson()).and()
                .header(Headers.getHeaderAuthorization(), Headers.getHeaderAuthorizationValue(driverToken))
                .body(PayLoad.getTripPassengerRatingBody()).log().all()
                .when().put(BaseTestSuite.getData().getProperty("URL_TRIP_MANAGER_TRIP")+"/"
                        + TRIPID
                        +BaseTestSuite.getData().getProperty("URL_TRIP_MANAGER_TRIP_RATE"))
                .then().log().all().and().assertThat().statusCode(200).extract().response();
    }

    @Test(priority = 12)
    public void tripDriver1CompleteTrip2() throws IOException {
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = RestAssured.given()
                .header(Headers.getHeaderKeyContentType(), Headers.getHeaderValueApplicationJson()).and()
                .header(Headers.getHeaderAuthorization(), Headers.getHeaderAuthorizationValue(driverToken))
                .log().all()
                .when().put(BaseTestSuite.getData().getProperty("URL_TRIP_MANAGER_TRIP")+"/"
                        + TRIPID
                        +BaseTestSuite.getData().getProperty("URL_TRIP_MANAGER_TRIP_COMPLETE"))
                .then().log().all().and().assertThat().statusCode(200).extract().response();
    }

    @Test(priority = 13)
    public void tripDriverViewHistory() throws IOException {
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = RestAssured.given()
                .header(Headers.getHeaderKeyContentType(), Headers.getHeaderValueApplicationJson()).and()
                .header(Headers.getHeaderAuthorization(), Headers.getHeaderAuthorizationValue(driverToken))
                .log().all()
                .when().get(BaseTestSuite.getData().getProperty("URL_TRIP_MANAGER_HISTORY_DRIVER")                        )
                .then().log().all().and().assertThat().statusCode(200).extract().response();
    }

    @Test(priority = 14)
    public void tripAdminViewDriver1History() throws IOException {
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = RestAssured.given()
                .header(Headers.getHeaderKeyContentType(), Headers.getHeaderValueApplicationJson()).and()
                .header(Headers.getHeaderAuthorization(), Headers.getHeaderAuthorizationValue(bearerToken))
                .queryParam("driverId",BaseTestSuite.getData().getProperty("DRIVER1_DRIVERID"))
                .log().all()
                .when().get(BaseTestSuite.getData().getProperty("URL_TRIP_MANAGER_HISTORY_DRIVER"))
                .then().log().all().and().assertThat().statusCode(200).extract().response();
    }

    @Test(priority = 15)
    public void tripAdminViewTrip2() throws IOException {
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = RestAssured.given()
                .header(Headers.getHeaderKeyContentType(), Headers.getHeaderValueApplicationJson()).and()
                .header(Headers.getHeaderAuthorization(), Headers.getHeaderAuthorizationValue(bearerToken))
                .log().all()
                .when().get(BaseTestSuite.getData().getProperty("URL_TRIP_MANAGER_TRIP")+"/"
                        + TRIPID)
                .then().log().all().and().assertThat().statusCode(200).extract().response();
    }

    @Test(priority = 16)
    public void tripDriver1ShiftsOut() throws IOException {
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = RestAssured.given()
                .header(Headers.getHeaderKeyContentType(), Headers.getHeaderValueApplicationJson()).and()
                .header(Headers.getHeaderAuthorization(), Headers.getHeaderAuthorizationValue(driverToken))
                .log().all()
                .when().post(BaseTestSuite.getData().getProperty("URL_DRIVER_SHIFT_OUT"))
                .then().log().all().and().assertThat().statusCode(200).extract().response();
    }

    @Test(priority = 17)
    public void tripDriver1LogsOut() throws IOException {
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = RestAssured.given()
                .header(Headers.getHeaderKeyContentType(), Headers.getHeaderValueApplicationJson()).and()
                .header(Headers.getHeaderAuthorization(), Headers.getHeaderAuthorizationValue(driverToken))
                .log().all()
                .when().post(BaseTestSuite.getData().getProperty("URL_DRIVER_LOGOUT"))
                .then().log().all().and().assertThat().statusCode(200).extract().response();
    }

    @Test(priority = 18)
    public void tripPassenger1Login() throws IOException {
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = RestAssured.given()
                .header(Headers.getHeaderKeyContentType(), Headers.getHeaderValueApplicationJson()).and()
                .body(PayLoad.getPassenger1LoginBody())
                .when().post(BaseTestSuite.getData().getProperty("URL_PASSENGER_LOGIN"))
                .then().log().all().and().assertThat().statusCode(200).extract().response();
        PASSENGER1_TOKEN = JsonElements.getToken(res);
        PASSENGER1_PASSENGER_ID = JsonElements.getPassengerId(res);
    }

    @Test(priority = 19)
    public void tripPassengerViewHistory() throws IOException {
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = RestAssured.given()
                .header(Headers.getHeaderKeyContentType(), Headers.getHeaderValueApplicationJson()).and()
                .header(Headers.getHeaderAuthorization(), Headers.getHeaderAuthorizationValue(PASSENGER1_TOKEN))
                .queryParam("passengerId",PASSENGER1_PASSENGER_ID)
                .log().all()
                .when().get(BaseTestSuite.getData().getProperty("URL_TRIP_MANAGER_HISTORY_PASSENGER"))
                .then().log().all().and().assertThat().statusCode(200).extract().response();
    }

    @Test(priority = 20)
    public void tripAdminViewPassenger11History() throws IOException {
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = RestAssured.given()
                .header(Headers.getHeaderKeyContentType(), Headers.getHeaderValueApplicationJson()).and()
                .header(Headers.getHeaderAuthorization(), Headers.getHeaderAuthorizationValue(bearerToken))
                .queryParam("passengerId",PASSENGER1_PASSENGER_ID)
                .log().all()
                .when().get(BaseTestSuite.getData().getProperty("URL_TRIP_MANAGER_HISTORY_PASSENGER"))
                .then().log().all().and().assertThat().statusCode(200).extract().response();
    }

    @Test(priority = 21)
    public void tripPassenger1LogsOut() throws IOException {
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = RestAssured.given()
                .header(Headers.getHeaderKeyContentType(), Headers.getHeaderValueApplicationJson()).and()
                .header(Headers.getHeaderAuthorization(), Headers.getHeaderAuthorizationValue(PASSENGER1_TOKEN))
                .log().all()
                .when().post(BaseTestSuite.getData().getProperty("URL_PASSENGER_LOGOUT"))
                .then().log().all().and().assertThat().statusCode(200).extract().response();
    }



    @BeforeMethod
    protected void startSession(Method method) throws Exception {
        long id = Thread.currentThread().getId();
        String testName = method.getName();
        System.out.println(testName);
    }


    @AfterMethod
    public void getResult(ITestResult result){
        if(result.getStatus() == ITestResult.SUCCESS){
            suc = suc+ result.getName()+"\n";
        }else {
            fail = fail+ result.getName()+":"+result.isSuccess()+"\n";
        }

    }

    @AfterClass
    public void sendEmail(){

        Base.TestRunner.setSendBodyBody("\n"+"\n"+this.getClass().getSimpleName()+"\n"+suc+fail);
    }
}
