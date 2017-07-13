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
public class NotificationTests extends BaseTestSuite {

    static String driverId;
    static String driverToken;
    static String bearerToken;
    static String suc = "SUCCESSFUL TESTS"+"\n";
    static String fail = "FAILED TESTS"+"\n";
    static String PASSENGER_TOKEN;
    static String PASSENGER_ID;
    static String driverShiftId;

    public static String getDriverId(){
        return driverId;
    }

    public static String getDriverToken(){
        return driverToken;
    }

    public static String getPassengerToken(){
        return PASSENGER_TOKEN;
    }

    public static String getPassengerId(){
        return PASSENGER_ID;
    }

    public static String getDriverShiftId(){
        return driverShiftId;
    }



    @Test(priority = 1)
    public static void notificationAdminLogin() throws IOException {
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
    public void notificationDriverLogin() throws IOException {
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = RestAssured.given()
                .header(Headers.getHeaderKeyContentType(), Headers.getHeaderValueApplicationJson()).and()
                .body(PayLoad.getDriver1LoginBody()).log().all()
                .when().post(BaseTestSuite.getData().getProperty("URL_DRIVER_LOGIN"))
                .then().log().all().and().assertThat().statusCode(200).extract().response();
        driverToken = JsonElements.getToken(res);
        driverId = JsonElements.getDriverId(res);
    }

    @Test(priority = 3)
    public void notificationPassengerLogin() throws IOException {
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = RestAssured.given()
                .header(Headers.getHeaderKeyContentType(), Headers.getHeaderValueApplicationJson()).and()
                .body(PayLoad.getPassenger1LoginBody())
                .when().post(BaseTestSuite.getData().getProperty("URL_PASSENGER_LOGIN"))
                .then().log().all().and().assertThat().statusCode(200).extract().response();
        PASSENGER_TOKEN = JsonElements.getToken(res);
        PASSENGER_ID = JsonElements.getPassengerId(res);
    }

    @Test(priority = 4)
    public void notificationAdminDriverNotification() throws IOException {
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = RestAssured.given()
                .header(Headers.getHeaderKeyContentType(), Headers.getHeaderValueApplicationJson()).and()
                .header(Headers.getHeaderAuthorization(),Headers.getHeaderAuthorizationValue(bearerToken))
                .body(PayLoad.getNotifAdminDriverBody()).log().all()
                .when().post(BaseTestSuite.getData().getProperty("URL_NOTIFICATION_WEBUSER")
                        +BaseTestSuite.getData().getProperty("URL_NOTIFICATION_WEBUSER_SEND_MESSAGE"))
                .then().log().all().and().assertThat().statusCode(200).extract().response();
    }

    @Test(priority = 5)
    public void notificationAdminBroadCastDrivers() throws IOException {
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = RestAssured.given()
                .header(Headers.getHeaderKeyContentType(), Headers.getHeaderValueApplicationJson()).and()
                .header(Headers.getHeaderAuthorization(),Headers.getHeaderAuthorizationValue(bearerToken))
                .body(PayLoad.getNotifAdminBroadCastDriverBody()).log().all()
                .when().post(BaseTestSuite.getData().getProperty("URL_NOTIFICATION_WEBUSER")
                        +BaseTestSuite.getData().getProperty("URL_NOTIFICATION_WEBUSER_BROAD_CAST_MESSAGE"))
                .then().log().all().and().assertThat().statusCode(200).extract().response();
    }

    @Test(priority = 6)
    public void notificationDriverGetsToken() throws IOException {
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = RestAssured.given()
                .header(Headers.getHeaderKeyContentType(), Headers.getHeaderValueApplicationJson()).and()
                .header(Headers.getHeaderAuthorization(),Headers.getHeaderAuthorizationValue(driverToken))
                .log().all()
                .when().get(BaseTestSuite.getData().getProperty("URL_NOTIFICATION_DRIVER")
                        +"/"+driverId+"/"+"token")
                .then().log().all().and().assertThat().statusCode(200).extract().response();
    }

    @Test(priority = 7)
    public void notificationPassengerGetsToken() throws IOException {
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = RestAssured.given()
                .header(Headers.getHeaderKeyContentType(), Headers.getHeaderValueApplicationJson()).and()
                .header(Headers.getHeaderAuthorization(),Headers.getHeaderAuthorizationValue(PASSENGER_TOKEN))
                .log().all()
                .when().get(BaseTestSuite.getData().getProperty("URL_NOTIFICATION_PASSENGER")
                        +"/"+PASSENGER_ID+"/"+"token")
                .then().log().all().and().assertThat().statusCode(200).extract().response();
    }

    @Test(priority = 8)
    public void notificationDriverShitsInTaxi() throws IOException {
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = RestAssured.given()
                .header(Headers.getHeaderKeyContentType(), Headers.getHeaderValueApplicationJson()).and()
                .header(Headers.getHeaderAuthorization(),Headers.getHeaderAuthorizationValue(driverToken))
                .body(PayLoad.getNotifDriverShiftBody()).log().all()
                .when().post(BaseTestSuite.getData().getProperty("URL_DRIVER_SHIFT"))
                .then().log().all().and().assertThat().statusCode(200).extract().response();
        driverShiftId = JsonElements.getShiftId(res);
    }

    //@Test(priority = 9)  //"/driver/1.0.0/shift/notification/1.0.0/driver/forceShiftOut does not exist"
    public void notificationAdminForcesDriverShiftOut() throws IOException {
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = RestAssured.given()
                .header(Headers.getHeaderKeyContentType(), Headers.getHeaderValueApplicationJson()).and()
                .header(Headers.getHeaderAuthorization(),Headers.getHeaderAuthorizationValue(bearerToken))
                .body(PayLoad.getNotifAdminForceShiftOutBody()).log().all()
                .when().post(BaseTestSuite.getData().getProperty("URL_DRIVER_SHIFT")
                +BaseTestSuite.getData().getProperty("URL_NOTIFICATION_DRIVER")
                +BaseTestSuite.getData().getProperty("URL_NOTIFICATION_DRIVER_FORCESHIFTOUT"))
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
            suc = suc+ result.getName()+":"+result.isSuccess()+"\n";
        }else {
            fail = fail+ result.getName()+":"+result.isSuccess()+"\n";
        }

    }

    @AfterClass
    public void sendEmail(){

        Base.TestRunner.setSendBodyBody("\n"+"\n"+this.getClass().getSimpleName()+"\n"+suc+fail);
    }
}
