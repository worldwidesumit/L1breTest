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
public class GeoSupplyTests extends BaseTestSuite{

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
    public static void geoAdminGodView() throws IOException {
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = RestAssured.given()
                .header(Headers.getHeaderKeyContentType(),Headers.getHeaderValueApplicationJson()).and()
                .header(Headers.getHeaderAuthorization(),Headers.getHeaderAuthorizationValue(bearerToken))
                .queryParam("lat1",BaseTestSuite.getData().getProperty("GODVIEW_LAT1")).and()
                .queryParam("lng1",BaseTestSuite.getData().getProperty("GODVIEW_LNG1")).and()
                .queryParam("lat2",BaseTestSuite.getData().getProperty("GODVIEW_LAT2")).and()
                .queryParam("lng2",BaseTestSuite.getData().getProperty("GODVIEW_LNG2")).and()
                .log().all()
                .when().get(BaseTestSuite.getData().getProperty("URL_GEO_GODVIEW"))
                .then().log().all().and().assertThat().statusCode(200).extract().response()
                ;
    }

    @Test(priority = 3)
    public static void geoGetDifferentStatusTaxiNumbersInArea() throws IOException {
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = RestAssured.given()
                .header(Headers.getHeaderKeyContentType(),Headers.getHeaderValueApplicationJson()).and()
                .header(Headers.getHeaderAuthorization(),Headers.getHeaderAuthorizationValue(bearerToken))
                .queryParam("lat1",BaseTestSuite.getData().getProperty("GODVIEW_LAT1")).and()
                .queryParam("lng1",BaseTestSuite.getData().getProperty("GODVIEW_LNG1")).and()
                .queryParam("lat2",BaseTestSuite.getData().getProperty("GODVIEW_LAT2")).and()
                .queryParam("lng2",BaseTestSuite.getData().getProperty("GODVIEW_LNG2")).and()
                .log().all()
                .when().get(BaseTestSuite.getData().getProperty("URL_GEO_GODVIEW_COUNT"))
                .then().log().all().and().assertThat().statusCode(200).extract().response()
                ;

    }

    @Test(priority = 4)
    public static void geoGetTotalTaxisAtGpsPoint() throws IOException {
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = RestAssured.given()
                .header(Headers.getHeaderKeyContentType(),Headers.getHeaderValueApplicationJson()).and()
                .header(Headers.getHeaderAuthorization(),Headers.getHeaderAuthorizationValue(bearerToken))
                .queryParam("lat",BaseTestSuite.getData().getProperty("GEO_LAT")).and()
                .queryParam("lng",BaseTestSuite.getData().getProperty("GEO_LNG")).and()
                .log().all()
                .when().get(BaseTestSuite.getData().getProperty("URL_GEO_TAXIS"))
                .then().log().all().and().assertThat().statusCode(200).extract().response()
                ;
    }

    @Test(priority = 5)
    public static void geoCheckTaxisInGeoCircle() throws IOException {
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = RestAssured.given()
                .header(Headers.getHeaderKeyContentType(),Headers.getHeaderValueApplicationJson()).and()
                .header(Headers.getHeaderAuthorization(),Headers.getHeaderAuthorizationValue(bearerToken))
                .queryParam("lat",BaseTestSuite.getData().getProperty("GEO_LAT")).and()
                .queryParam("lng",BaseTestSuite.getData().getProperty("GEO_LNG")).and()
                .queryParam("dist",BaseTestSuite.getData().getProperty("GEO_DIST")).and()
                .log().all()
                .when().get(BaseTestSuite.getData().getProperty("URL_GEO_TAXIS_IN_GEO_CIRCLE"))
                .then().log().all().and().assertThat().statusCode(200).extract().response()
                ;
    }

    @Test(priority = 6)
    public static void geoGetEntireTaxisForStatus() throws IOException {
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = RestAssured.given()
                .header(Headers.getHeaderKeyContentType(),Headers.getHeaderValueApplicationJson()).and()
                .header(Headers.getHeaderAuthorization(),Headers.getHeaderAuthorizationValue(bearerToken))
                .log().all()
                .when().get(BaseTestSuite.getData().getProperty("URL_GEO_GODVIEW_COUNT"))
                .then().log().all().and().assertThat().statusCode(200).extract().response()
                ;
    }

    @Test(priority = 7)
    public static void geoGetNoOfFreeTaxis() throws IOException {
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = RestAssured.given()
                .header(Headers.getHeaderKeyContentType(),Headers.getHeaderValueApplicationJson()).and()
                .header(Headers.getHeaderAuthorization(),Headers.getHeaderAuthorizationValue(bearerToken))
                .queryParam("status",0).and()
                .log().all()
                .when().get(BaseTestSuite.getData().getProperty("URL_GEO_TAXIS_GET_BY_STATUS"))
                .then().log().all().and().assertThat().statusCode(200).extract().response()
                ;
    }

    @Test(priority = 8)
    public static void geoGetNoOfOccupiedTaxis() throws IOException {
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = RestAssured.given()
                .header(Headers.getHeaderKeyContentType(),Headers.getHeaderValueApplicationJson()).and()
                .header(Headers.getHeaderAuthorization(),Headers.getHeaderAuthorizationValue(bearerToken))
                .queryParam("status",1).and()
                .log().all()
                .when().get(BaseTestSuite.getData().getProperty("URL_GEO_TAXIS_GET_BY_STATUS"))
                .then().log().all().and().assertThat().statusCode(200).extract().response()
                ;
    }

    @Test(priority = 9)
    public static void geoGetNoOfEnrouteTaxis() throws IOException {
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = RestAssured.given()
                .header(Headers.getHeaderKeyContentType(),Headers.getHeaderValueApplicationJson()).and()
                .header(Headers.getHeaderAuthorization(),Headers.getHeaderAuthorizationValue(bearerToken))
                .queryParam("status",2).and()
                .log().all()
                .when().get(BaseTestSuite.getData().getProperty("URL_GEO_TAXIS_GET_BY_STATUS"))
                .then().log().all().and().assertThat().statusCode(200).extract().response()
                ;
    }

    @Test(priority = 10)
    public static void geoGetNoOfDistressedTaxis() throws IOException {
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = RestAssured.given()
                .header(Headers.getHeaderKeyContentType(),Headers.getHeaderValueApplicationJson()).and()
                .header(Headers.getHeaderAuthorization(),Headers.getHeaderAuthorizationValue(bearerToken))
                .queryParam("status",3).and()
                .log().all()
                .when().get(BaseTestSuite.getData().getProperty("URL_GEO_TAXIS_GET_BY_STATUS"))
                .then().log().all().and().assertThat().statusCode(200).extract().response()
                ;
    }

    @Test(priority = 11)
    public static void geoGetNoOfBreakTaxis() throws IOException {
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = RestAssured.given()
                .header(Headers.getHeaderKeyContentType(),Headers.getHeaderValueApplicationJson()).and()
                .header(Headers.getHeaderAuthorization(),Headers.getHeaderAuthorizationValue(bearerToken))
                .queryParam("status",4).and()
                .log().all()
                .when().get(BaseTestSuite.getData().getProperty("URL_GEO_TAXIS_GET_BY_STATUS"))
                .then().log().all().and().assertThat().statusCode(200).extract().response()
                ;
    }

    @Test(priority = 11)
    public static void geoGetNoOfOffDutyTaxis() throws IOException {
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = RestAssured.given()
                .header(Headers.getHeaderKeyContentType(),Headers.getHeaderValueApplicationJson()).and()
                .header(Headers.getHeaderAuthorization(),Headers.getHeaderAuthorizationValue(bearerToken))
                .queryParam("status",5).and()
                .log().all()
                .when().get(BaseTestSuite.getData().getProperty("URL_GEO_TAXIS_GET_BY_STATUS"))
                .then().log().all().and().assertThat().statusCode(200).extract().response()
                ;
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
