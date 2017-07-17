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
import static org.hamcrest.Matchers.equalTo;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * Created by Sumit on 7/17/2017.
 */
public class Eta {

    static String bearerToken;
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

    }


    @Test(priority = 2)
    public static void etaFalseEta() throws IOException {
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = RestAssured.given()
                .header(Headers.getHeaderKeyContentType(),Headers.getHeaderValueApplicationJson()).and()
                .header(Headers.getHeaderAuthorization(),Headers.getHeaderAuthorizationValue(bearerToken))
                .queryParam("lat",BaseTestSuite.getData().getProperty("TEMP_LAT_YES")).and()
                .queryParam("lng",BaseTestSuite.getData().getProperty("TEMP_LNG_YES")).and()
                .queryParam("status",0).and()
                .queryParam("type",BaseTestSuite.getData().getProperty("TAXI_TYPE")).and()
                .queryParam("eta",false).log().all()
                .when().get(BaseTestSuite.getData().getProperty("URL_GEO_TAXIS"))
                .then().log().all().and().assertThat().statusCode(200).extract().response()
                ;
    }

    @Test(priority = 3)
    public static void etaTrueEtaHaveTaxis() throws IOException {
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = RestAssured.given()
                .header(Headers.getHeaderKeyContentType(),Headers.getHeaderValueApplicationJson()).and()
                .header(Headers.getHeaderAuthorization(),Headers.getHeaderAuthorizationValue(bearerToken))
                .queryParam("lat",BaseTestSuite.getData().getProperty("TEMP_LAT_YES")).and()
                .queryParam("lng",BaseTestSuite.getData().getProperty("TEMP_LNG_YES")).and()
                .queryParam("status",0).and()
                .queryParam("type",BaseTestSuite.getData().getProperty("TAXI_TYPE")).and()
                .queryParam("eta",true).log().all()
                .when().get(BaseTestSuite.getData().getProperty("URL_GEO_TAXIS"))
                .then().log().all().and().assertThat().statusCode(200).extract().response()
                ;

    }

    @Test(priority = 4)
    public static void etaTrueEtaNoTaxis() throws IOException {
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = RestAssured.given()
                .header(Headers.getHeaderKeyContentType(),Headers.getHeaderValueApplicationJson()).and()
                .header(Headers.getHeaderAuthorization(),Headers.getHeaderAuthorizationValue(bearerToken))
                .queryParam("lat",BaseTestSuite.getData().getProperty("TEMP_LAT_NO")).and()
                .queryParam("lng",BaseTestSuite.getData().getProperty("TEMP_LNG_NO")).and()
                .queryParam("status",0).and()
                .queryParam("type",BaseTestSuite.getData().getProperty("TAXI_TYPE")).and()
                .queryParam("eta",true).log().all()
                .when().get(BaseTestSuite.getData().getProperty("URL_GEO_TAXIS"))
                .then().log().all().and().assertThat().statusCode(200).and()
                .body(JsonElements.getETANumFound(),equalTo(0))
                .extract().response()
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
