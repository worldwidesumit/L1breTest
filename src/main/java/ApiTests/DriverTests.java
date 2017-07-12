package ApiTests;

import Base.BaseTestSuite;
import Common.Email;
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
import java.sql.Timestamp;

/**
 * Created by Chetna on 7/6/2017.
 */
public class DriverTests {

    static String bearerToken;
    static String driverToken;
    static String suc = "SUCCESSFUL TESTS"+"\n";
    static String fail = "FAILED TESTS"+"\n";



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
    public void driverValidateExistingEmail() throws IOException {
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = RestAssured.given()
                .header(Headers.getHeaderKeyContentType(), Headers.getHeaderValueApplicationJson()).and()
                .header(Headers.getHeaderAuthorization(),Headers.getHeaderAuthorizationValue(bearerToken))
                .body(PayLoad.getDriverEmailbody()).log().all()
                .when().post(BaseTestSuite.getData().getProperty("URL_DRIVER_VALIDATE"))
                .then().log().all().and().assertThat().statusCode(200).extract().response();

    }

    @Test(priority = 3)
    public void driverValidateNewPhoneEmail() throws IOException {
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = RestAssured.given()
                .header(Headers.getHeaderKeyContentType(), Headers.getHeaderValueApplicationJson()).and()
                .header(Headers.getHeaderAuthorization(),Headers.getHeaderAuthorizationValue(bearerToken))
                .body(PayLoad.getDriverNewPhoneEmail()).log().all()
                .when().post(BaseTestSuite.getData().getProperty("URL_DRIVER_VALIDATE"))
                .then().log().all().and().assertThat().statusCode(200).extract().response();

    }

    @Test(priority = 4)
    public void driverValidateDriverNotExists() throws IOException {
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = RestAssured.given()
                .header(Headers.getHeaderKeyContentType(), Headers.getHeaderValueApplicationJson()).and()
                .header(Headers.getHeaderAuthorization(),Headers.getHeaderAuthorizationValue(bearerToken))
                .queryParam("folio",BaseTestSuite.getData().getProperty("DRIVER_UNIGUE_LICENSE_ID")).log().all()
                .when().get(BaseTestSuite.getData().getProperty("URL_DRIVER_SEMOVI"))
                .then().log().all().and().assertThat().statusCode(200).extract().response();

    }

    @Test(priority = 5)
    public void driverValidateDriverAlreadyExists() throws IOException {
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = RestAssured.given()
                .header(Headers.getHeaderKeyContentType(), Headers.getHeaderValueApplicationJson()).and()
                .header(Headers.getHeaderAuthorization(),Headers.getHeaderAuthorizationValue(bearerToken))
                .queryParam("folio",BaseTestSuite.getData().getProperty("DRIVER1_LICENSEID")).log().all()
                .when().get(BaseTestSuite.getData().getProperty("URL_DRIVER_SEMOVI"))
                .then().log().all().and().assertThat().statusCode(200).extract().response();

    }

    @Test(priority = 6)
    public void driverValidateDriverNotFound() throws IOException {
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = RestAssured.given()
                .header(Headers.getHeaderKeyContentType(), Headers.getHeaderValueApplicationJson()).and()
                .header(Headers.getHeaderAuthorization(),Headers.getHeaderAuthorizationValue(bearerToken))
                .queryParam("folio",BaseTestSuite.getData().getProperty("TEMP_FIRST_NAME")).log().all()
                .when().get(BaseTestSuite.getData().getProperty("URL_DRIVER_SEMOVI"))
                .then().log().all().and().assertThat().statusCode(404).extract().response();

    }

    @Test(priority = 7)
    public void driverValidateDriverNameExactMatch() throws IOException {
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = RestAssured.given()
                .header(Headers.getHeaderKeyContentType(), Headers.getHeaderValueApplicationJson()).and()
                .header(Headers.getHeaderAuthorization(),Headers.getHeaderAuthorizationValue(bearerToken))
                .queryParam("term",BaseTestSuite.getData().getProperty("DRIVER1_USERNAME")).log().all()
                .when().get(BaseTestSuite.getData().getProperty("URL_DRIVER_FREESEARCH"))
                .then().log().all().and().assertThat().statusCode(200).extract().response();

    }

    @Test(priority = 8)
    public void driverValidateDriverEmailExactMatch() throws IOException {
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = RestAssured.given()
                .header(Headers.getHeaderKeyContentType(), Headers.getHeaderValueApplicationJson()).and()
                .header(Headers.getHeaderAuthorization(),Headers.getHeaderAuthorizationValue(bearerToken))
                .queryParam("term",BaseTestSuite.getData().getProperty("DRIVER1_EMAIL")).log().all()
                .when().get(BaseTestSuite.getData().getProperty("URL_DRIVER_FREESEARCH"))
                .then().log().all().and().assertThat().statusCode(200).extract().response();

    }

    @Test(priority = 9)
    public void driverValidateDriverNamePartialMatch() throws IOException {
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = RestAssured.given()
                .header(Headers.getHeaderKeyContentType(), Headers.getHeaderValueApplicationJson()).and()
                .header(Headers.getHeaderAuthorization(),Headers.getHeaderAuthorizationValue(bearerToken))
                .queryParam("term","Test").log().all()
                .when().get(BaseTestSuite.getData().getProperty("URL_DRIVER_FREESEARCH"))
                .then().log().all().and().assertThat().statusCode(200).extract().response();

    }

    @Test(priority = 10)
    public void driverValidateListAllDrivers() throws IOException {
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = RestAssured.given()
                .header(Headers.getHeaderKeyContentType(), Headers.getHeaderValueApplicationJson()).and()
                .header(Headers.getHeaderAuthorization(),Headers.getHeaderAuthorizationValue(bearerToken))
                .queryParam("rows",10).and()
                .queryParam("start",0).log().all()
                .when().get(BaseTestSuite.getData().getProperty("URL_DRIVER_LIST"))
                .then().log().all().and().assertThat().statusCode(200).extract().response();

    }

    @Test(priority = 11)
    public void driverValidateDriver2Suspend() throws IOException {
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = RestAssured.given()
                .header(Headers.getHeaderKeyContentType(), Headers.getHeaderValueApplicationJson()).and()
                .header(Headers.getHeaderAuthorization(), Headers.getHeaderAuthorizationValue(bearerToken))
                .body(PayLoad.getDriver2SuspendBody()).log().all()
                .when().put(BaseTestSuite.getData().getProperty("URL_DRIVER")+"/"
                +BaseTestSuite.getData().getProperty("DRIVER2_DRIVERID")
                +BaseTestSuite.getData().getProperty("URL_SUSPEND"))
                .then().log().all().and().assertThat().statusCode(200).extract().response();

    }

    @Test(priority = 12)
    public void driverValidateDriver2SuspendedLogin() throws IOException {
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = RestAssured.given()
                .header(Headers.getHeaderKeyContentType(), Headers.getHeaderValueApplicationJson()).and()
                .body(PayLoad.getDriver2LoginBody()).log().all()
                .when().post(BaseTestSuite.getData().getProperty("URL_DRIVER_LOGIN"))
                .then().log().all().and().assertThat().statusCode(200).extract().response();
    }

    @Test(priority = 13)
    public void driverValidateDriver2UnSuspend() throws IOException {
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = RestAssured.given()
                .header(Headers.getHeaderKeyContentType(), Headers.getHeaderValueApplicationJson()).and()
                .header(Headers.getHeaderAuthorization(), Headers.getHeaderAuthorizationValue(bearerToken))
                .body(PayLoad.getDriver2UnSuspendBody()).log().all()
                .when().put(BaseTestSuite.getData().getProperty("URL_DRIVER") + "/"
                        + BaseTestSuite.getData().getProperty("DRIVER2_DRIVERID")
                        + BaseTestSuite.getData().getProperty("URL_UNSUSPEND"))
                .then().log().all().and().assertThat().statusCode(200).extract().response();
    }

    @Test(priority = 14)
    public void driverValidateDriver2Login() throws IOException {
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = RestAssured.given()
                .header(Headers.getHeaderKeyContentType(), Headers.getHeaderValueApplicationJson()).and()
                .body(PayLoad.getDriver2LoginBody()).log().all()
                .when().post(BaseTestSuite.getData().getProperty("URL_DRIVER_LOGIN"))
                .then().log().all().and().assertThat().statusCode(200).extract().response();
        driverToken = JsonElements.getToken(res);
    }

    @Test(priority = 15)
    public void driverValidateDriverZipCode() throws IOException {
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = RestAssured.given()
                .header(Headers.getHeaderKeyContentType(), Headers.getHeaderValueApplicationJson()).and()
                .header(Headers.getHeaderAuthorization(), Headers.getHeaderAuthorizationValue(bearerToken))
                .when().get(BaseTestSuite.getData().getProperty("URL_DRIVER")+ "/"
                + BaseTestSuite.getData().getProperty("DRIVER2_DRIVERID"))
                .then().log().all().and().assertThat().statusCode(200).extract().response();
    }

    @Test(priority = 16)
    public void driverValidateDriverChangeZipCode() throws IOException {
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = RestAssured.given()
                .header(Headers.getHeaderKeyContentType(), Headers.getHeaderValueApplicationJson()).and()
                .header(Headers.getHeaderAuthorization(), Headers.getHeaderAuthorizationValue(bearerToken))
                .body(PayLoad.getDriverZipCodeBody()).log().all()
                .when().put(BaseTestSuite.getData().getProperty("URL_DRIVER")+ "/"
                        + BaseTestSuite.getData().getProperty("DRIVER2_DRIVERID"))
                .then().log().all().and().assertThat().statusCode(200).extract().response();
    }
    @Test(priority = 17)
    public void driverValidateDriver2Logout() throws IOException {
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = RestAssured.given()
                .header(Headers.getHeaderKeyContentType(), Headers.getHeaderValueApplicationJson()).and()
                .header(Headers.getHeaderAuthorization(), Headers.getHeaderAuthorizationValue(driverToken))
                .log().all()
                .when().post(BaseTestSuite.getData().getProperty("URL_DRIVER_LOGOUT"))
                .then().log().all().and().assertThat().statusCode(200).extract().response();
    }

    @Test(priority = 18)
    public void driverValidateDriver1Login() throws IOException {
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = RestAssured.given()
                .header(Headers.getHeaderKeyContentType(), Headers.getHeaderValueApplicationJson()).and()
                .body(PayLoad.getDriver1LoginBody()).log().all()
                .when().post(BaseTestSuite.getData().getProperty("URL_DRIVER_LOGIN"))
                .then().log().all().and().assertThat().statusCode(200).extract().response();
        driverToken = JsonElements.getToken(res);
    }

    //@Test(priority = 19) //Needs Fixing
    public void driverValidateDriver1DeleteEmergencyContacts() throws IOException {
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = RestAssured.given()
                .header(Headers.getHeaderKeyContentType(), Headers.getHeaderValueApplicationJson()).and()
                .header(Headers.getHeaderAuthorization(), Headers.getHeaderAuthorizationValue(driverToken))
                .body(PayLoad.getDriverReplaceEmerContactsBody()).log().all()
                .when().put(BaseTestSuite.getData().getProperty("URL_DRIVER")+ "/"
                +BaseTestSuite.getData().getProperty("DRIVER1_DRIVERID")
                +BaseTestSuite.getData().getProperty("URL_ADD_EM_CONTACTS"))
                .then().log().all().and().assertThat().statusCode(200).extract().response();
    }

    @Test(priority = 20)
    public void driverValidateDriver1ShiftsTaxi1() throws IOException {
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = RestAssured.given()
                .header(Headers.getHeaderKeyContentType(), Headers.getHeaderValueApplicationJson()).and()
                .header(Headers.getHeaderAuthorization(), Headers.getHeaderAuthorizationValue(driverToken))
                .body(PayLoad.getDriverShiftsTaxi1Body()).log().all()
                .when().post(BaseTestSuite.getData().getProperty("URL_DRIVER_SHIFT"))
                .then().log().all().and().assertThat().statusCode(200).extract().response();
    }

    @Test(priority = 21)
    public void driverValidateDriverByTaxiId() throws IOException {
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = RestAssured.given()
                .header(Headers.getHeaderKeyContentType(), Headers.getHeaderValueApplicationJson()).and()
                .header(Headers.getHeaderAuthorization(), Headers.getHeaderAuthorizationValue(bearerToken))
                .queryParam("taxiId",BaseTestSuite.getData().getProperty("TAXI1_TAXIID")).log().all()
                .when().get(BaseTestSuite.getData().getProperty("URL_DRIVER_FIND_BY_TAXI_ID"))
                .then().log().all().and().assertThat().statusCode(200).extract().response();
    }

    @Test(priority = 22)
    public void driverValidateDriver1ShiftsOut() throws IOException {
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = RestAssured.given()
                .header(Headers.getHeaderKeyContentType(), Headers.getHeaderValueApplicationJson()).and()
                .header(Headers.getHeaderAuthorization(), Headers.getHeaderAuthorizationValue(driverToken))
                .log().all()
                .when().post(BaseTestSuite.getData().getProperty("URL_DRIVER_SHIFT_OUT"))
                .then().log().all().and().assertThat().statusCode(200).extract().response();
    }

    @Test(priority = 23)
    public void driverValidateDriver1LogOut() throws IOException {
        driverValidateDriver1Login();
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = RestAssured.given()
                .header(Headers.getHeaderKeyContentType(), Headers.getHeaderValueApplicationJson()).and()
                .header(Headers.getHeaderAuthorization(), Headers.getHeaderAuthorizationValue(driverToken))
                .log().all()
                .when().post(BaseTestSuite.getData().getProperty("URL_DRIVER_LOGOUT"))
                .then().log().all().and().assertThat().statusCode(200).extract().response();
    }

    @Test(priority = 24)
    public void driverValidateDriver3Login() throws IOException {
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = RestAssured.given()
                .header(Headers.getHeaderKeyContentType(), Headers.getHeaderValueApplicationJson()).and()
                .body(PayLoad.getDriver3LoginBody()).log().all()
                .when().post(BaseTestSuite.getData().getProperty("URL_DRIVER_LOGIN"))
                .then().log().all().and().assertThat().statusCode(200).extract().response();
        driverToken = JsonElements.getToken(res);
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
    public void sendemail(){
        Email.sendemail(Email.getMyEmail(),suc+fail);
    }

}
