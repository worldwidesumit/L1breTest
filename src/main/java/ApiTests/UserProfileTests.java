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
public class UserProfileTests {

    static String USERPROFILE_TEMP_USER_ID;
    static String suc = "SUCCESSFUL TESTS"+"\n";
    static String fail = "FAILED TESTS"+"\n";

    @Test(priority = 1)
    public void userProfileAddUser() throws IOException {
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = RestAssured.given()
                .header(Headers.getHeaderKeyContentType(), Headers.getHeaderValueApplicationJson()).and()
                .header(Headers.getHeaderAuthorization(), Headers.getHeaderAuthorizationValue(BaseTestSuite.getData()
                .getProperty("USERPROFILE_TOKEN")))
                .body(PayLoad.getUserProfileAddUserBody()).log().all()
                .when().post(BaseTestSuite.getData().getProperty("URL_USERPROFILE_USERS"))
                .then().log().all().and().assertThat().statusCode(200).extract().response();
        USERPROFILE_TEMP_USER_ID = JsonElements.getUserprofileTempUserId(res);
    }

    @Test(priority = 2,enabled = true)
    public void userProfileAddSameUser() throws IOException {
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = RestAssured.given()
                .header(Headers.getHeaderKeyContentType(), Headers.getHeaderValueApplicationJson()).and()
                .header(Headers.getHeaderAuthorization(), Headers.getHeaderAuthorizationValue(BaseTestSuite.getData()
                        .getProperty("USERPROFILE_TOKEN")))
                .body(PayLoad.getUserProfileAddUserBody()).log().all()
                .when().post(BaseTestSuite.getData().getProperty("URL_USERPROFILE_USERS"))
                .then().log().all().and().assertThat().statusCode(200).extract().response();
    }

    @Test(priority = 3)
    public void userProfileGetExistingUser() throws IOException {
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = RestAssured.given()
                .header(Headers.getHeaderKeyContentType(), Headers.getHeaderValueApplicationJson()).and()
                .header(Headers.getHeaderAuthorization(), Headers.getHeaderAuthorizationValue(BaseTestSuite.getData()
                        .getProperty("USERPROFILE_TOKEN"))).log().all()
                .when().get(BaseTestSuite.getData().getProperty("URL_USERPROFILE_USERS")+"/"
                + USERPROFILE_TEMP_USER_ID)
                .then().log().all().and().assertThat().statusCode(200).extract().response();
    }

    @Test(priority = 4)
    public void userProfileFilterUserByUserName() throws IOException {
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = RestAssured.given()
                .header(Headers.getHeaderKeyContentType(), Headers.getHeaderValueApplicationJson()).and()
                .header(Headers.getHeaderAuthorization(), Headers.getHeaderAuthorizationValue(BaseTestSuite.getData()
                        .getProperty("USERPROFILE_TOKEN")))
                .queryParam("filter","userName").and()
                .queryParam("value",BaseTestSuite.getData().getProperty("USERPROFILE_USERNAME"))
                .when().get(BaseTestSuite.getData().getProperty("URL_USERPROFILE_USERS"))
                .then().log().all().and().assertThat().statusCode(200).extract().response();
    }

    @Test(priority = 5)
    public void userProfileChangePassword() throws IOException {
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = RestAssured.given()
                .header(Headers.getHeaderKeyContentType(), Headers.getHeaderValueApplicationJson()).and()
                .header(Headers.getHeaderAuthorization(), Headers.getHeaderAuthorizationValue(BaseTestSuite.getData()
                        .getProperty("USERPROFILE_TOKEN")))
                .body(PayLoad.getUserProfileChangePassword()).log().all()
                .when().put(BaseTestSuite.getData().getProperty("URL_USERPROFILE_USERS")+"/"
                        + USERPROFILE_TEMP_USER_ID)
                .then().log().all().and().assertThat().statusCode(200).extract().response();
    }
    @Test(priority = 6)
    public void userProfileDeleteUser() throws IOException {
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = RestAssured.given()
                .header(Headers.getHeaderKeyContentType(), Headers.getHeaderValueApplicationJson()).and()
                .header(Headers.getHeaderAuthorization(), Headers.getHeaderAuthorizationValue(BaseTestSuite.getData()
                        .getProperty("USERPROFILE_TOKEN")))
                .log().all()
                .when().delete(BaseTestSuite.getData().getProperty("URL_USERPROFILE_USERS")+"/"
                        + USERPROFILE_TEMP_USER_ID)
                .then().log().all().and().assertThat().statusCode(200).extract().response();
    }

    @Test(priority = 7)
    public void userProfileUserDoesNotExist() throws IOException {
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = RestAssured.given()
                .header(Headers.getHeaderKeyContentType(), Headers.getHeaderValueApplicationJson()).and()
                .header(Headers.getHeaderAuthorization(), Headers.getHeaderAuthorizationValue(BaseTestSuite.getData()
                        .getProperty("USERPROFILE_TOKEN"))).log().all()
                .when().get(BaseTestSuite.getData().getProperty("URL_USERPROFILE_USERS")+"/"
                        + USERPROFILE_TEMP_USER_ID)
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
