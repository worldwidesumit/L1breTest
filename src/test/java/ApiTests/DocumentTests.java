package ApiTests;

import Base.BaseTestSuite;
import Common.*;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;

import static com.jayway.restassured.RestAssured.given;

/**
 * Created by Chetna on 7/5/2017.
 */
public class DocumentTests extends BaseTestSuite{

    static String bearerToken;
    static String suc = "SUCCESSFUL TESTS"+"\n";
    static String fail = "FAILED TESTS"+"\n";



    @Test(priority = 1,groups = "Document")
    public void webUserLogin() throws IOException {
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = given()
                .header(Headers.getHeaderKeyContentType(),Headers.getHeaderValueApplicationJson()).and()
                .body(PayLoad.getWebUserLoginBody()).log().all()
                .when().post(BaseTestSuite.getData().getProperty("URL_WEBUSER_LOGIN"))
                .then().log().all().and().assertThat().statusCode(200).extract().response()
                ;
        bearerToken = JsonElements.getToken(res);
        System.out.println(bearerToken);

    }

    @Test(priority = 2,groups = "Document")
    public void uploadDocument() throws IOException {

        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = given()
                .multiPart("document",new File("C:\\Dell\\Drivers\\J5PR2\\Version.txt"))
                .and().header("Authorization","Bearer "+bearerToken)
                .and().param("ownerId","017050f1-d4fc-4dc1-b709-fdc832fcc7b0")
                .and().log().all()
                .when().post(BaseTestSuite.getData().getProperty("URL_DOCUMENT_DOCUMENT")).then()
                .log().all().and().assertThat().statusCode(200).extract().response();

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
