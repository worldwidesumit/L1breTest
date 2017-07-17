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
 * Created by Sumit on 7/17/2017.
 */
public class PdfGenerateTests {

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
        System.out.println(bearerToken);

    }

    @Test(priority = 2)
    public static void generatePdfFile() throws IOException {
        webUserLogin();
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = RestAssured.given()
                .header(Headers.getHeaderKeyContentType(),Headers.getHeaderValueApplicationJson()).and()
                .header(Headers.getHeaderAuthorization(),Headers.getHeaderAuthorizationValue(bearerToken))
                .body(PayLoad.getPdfGeneratePdf()).log().all()
                .when().post(BaseTestSuite.getData().getProperty("URL_PDF_GENERATE"))
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
