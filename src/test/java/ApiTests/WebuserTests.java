package ApiTests;
import Base.BaseTestSuite;
import Common.*;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.RestAssured.port;

/**
 * Created by Chetna on 7/5/2017.
 */
public class WebuserTests extends BaseTestSuite{

    static String bearerToken;
    static String suc = "SUCCESSFUL TESTS"+"\n";
    static String fail = "FAILED TESTS"+"\n";

    @Test(priority = 1)
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

    @Test(priority = 2)
    public void webUserForgotPasswordEmail() throws IOException {
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = given()
                .header(Headers.getHeaderKeyContentType(),Headers.getHeaderValueApplicationJson()).and()
                .body(PayLoad.getWebUserForgotPasswordEmailBody()).log().all()
                .when().post(BaseTestSuite.getData().getProperty("URL_WEBUSER_FORGOT_PASSWORD"))
                .then().log().all().and().assertThat().statusCode(200).extract().response();

    }
    @Test(priority = 3)
    public void webUserForgotPasswordUName() throws IOException {
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = given()
                .header(Headers.getHeaderKeyContentType(),Headers.getHeaderValueApplicationJson()).and()
                .body(PayLoad.getWebUserForgotPasswordUnameBody()).log().all()
                .when().post(BaseTestSuite.getData().getProperty("URL_WEBUSER_FORGOT_PASSWORD"))
                .then().log().all().and().assertThat().statusCode(200).extract().response();

    }

    @Test(priority = 4)
    public void webUserForgotPasswordFake() throws IOException {
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = given()
                .header(Headers.getHeaderKeyContentType(),Headers.getHeaderValueApplicationJson()).and()
                .body(PayLoad.getWebUserForgotPasswordFakeBody()).log().all()
                .when().post(BaseTestSuite.getData().getProperty("URL_WEBUSER_FORGOT_PASSWORD"))
                .then().log().all().and().assertThat().statusCode(200).extract().response();

    }

    @Test(priority = 5)
    public void webUserSearchAdminEmail() throws IOException {
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = given()
                .header(Headers.getHeaderKeyContentType(),Headers.getHeaderValueApplicationJson()).and()
                .header(Headers.getHeaderAuthorization(),Headers.getHeaderAuthorizationValue(bearerToken))
                .queryParam("term",BaseTestSuite.getData().getProperty("ADMIN_EMAIL")).log().all()
                .when().get(BaseTestSuite.getData().getProperty("URL_WEBUSER_GLOBAL_SEARCH"))
                .then().log().all().and().assertThat().statusCode(200).extract().response();

    }

    @Test(priority = 6)
    public void webUserGetOverview() throws IOException {
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = given()
                .header(Headers.getHeaderKeyContentType(),Headers.getHeaderValueApplicationJson()).and()
                .header(Headers.getHeaderAuthorization(),Headers.getHeaderAuthorizationValue(bearerToken))
                .log().all()
                .when().get(BaseTestSuite.getData().getProperty("URL_WEBUSER_ADMIN_OVERVIEW"))
                .then().log().all().and().assertThat().statusCode(200).extract().response();
    }

    @Test(priority = 6)
    public void webUserListRolesAdmin() throws IOException {
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = given()
                .header(Headers.getHeaderKeyContentType(),Headers.getHeaderValueApplicationJson()).and()
                .header(Headers.getHeaderAuthorization(),Headers.getHeaderAuthorizationValue(bearerToken)).and()
                .queryParam("rows",10).and()
                .queryParam("start",0).and()
                .queryParam("filter","roles:admin").and()
                .queryParam("sort","name asc")
                .log().all()
                .when().get(BaseTestSuite.getData().getProperty("URL_WEBUSER_LIST"))
                .then().log().all().and().assertThat().statusCode(200).extract().response();
    }

    @Test(priority = 7)
    public void webUserListRolesDispatcher() throws IOException {
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = given()
                .header(Headers.getHeaderKeyContentType(),Headers.getHeaderValueApplicationJson()).and()
                .header(Headers.getHeaderAuthorization(),Headers.getHeaderAuthorizationValue(bearerToken)).and()
                .queryParam("rows",10).and()
                .queryParam("start",0).and()
                .queryParam("filter","roles:dispatcher").and()
                .queryParam("sort","email desc")
                .log().all()
                .when().get(BaseTestSuite.getData().getProperty("URL_WEBUSER_LIST"))
                .then().log().all().and().assertThat().statusCode(200).extract().response();
    }

    @Test(priority = 8)
    public void webUserListRolesCommissioner() throws IOException {
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = given()
                .header(Headers.getHeaderKeyContentType(),Headers.getHeaderValueApplicationJson()).and()
                .header(Headers.getHeaderAuthorization(),Headers.getHeaderAuthorizationValue(bearerToken)).and()
                .queryParam("rows",10).and()
                .queryParam("start",0).and()
                .queryParam("filter","roles:commissioner").and()
                .queryParam("sort","username desc")
                .log().all()
                .when().get(BaseTestSuite.getData().getProperty("URL_WEBUSER_LIST"))
                .then().log().all().and().assertThat().statusCode(200).extract().response();
    }

    @Test(priority = 9)
    public void webUserListRolesEmergency() throws IOException {
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = given()
                .header(Headers.getHeaderKeyContentType(),Headers.getHeaderValueApplicationJson()).and()
                .header(Headers.getHeaderAuthorization(),Headers.getHeaderAuthorizationValue(bearerToken)).and()
                .queryParam("rows",10).and()
                .queryParam("start",0).and()
                .queryParam("filter","roles:emergency").and()
                .queryParam("sort","username desc")
                .log().all()
                .when().get(BaseTestSuite.getData().getProperty("URL_WEBUSER_LIST"))
                .then().log().all().and().assertThat().statusCode(200).extract().response();
    }

    @Test(priority = 10)
    public void webUserGetUserById() throws IOException {
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = given()
                .header(Headers.getHeaderKeyContentType(),Headers.getHeaderValueApplicationJson()).and()
                .header(Headers.getHeaderAuthorization(),Headers.getHeaderAuthorizationValue(bearerToken)).and()
                .log().all()
                .when().get(BaseTestSuite.getData().getProperty("URL_WEBUSER")+"/"+
                        BaseTestSuite.getData().getProperty("ADMIN_WEBUSERID"))
                .then().log().all().and().assertThat().statusCode(200).extract().response();
    }

    @Test(priority = 10)
    public void webUserUpdateWebuser() throws IOException {
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = given()
                .header(Headers.getHeaderKeyContentType(),Headers.getHeaderValueApplicationJson()).and()
                .header(Headers.getHeaderAuthorization(),Headers.getHeaderAuthorizationValue(bearerToken)).and()
                .body(PayLoad.getWebuserUpdateBody())
                .log().all()
                .when().put(BaseTestSuite.getData().getProperty("URL_WEBUSER")+"/"+
                        BaseTestSuite.getData().getProperty("ADMIN2_WEBUSERID"))
                .then().log().all().and().assertThat().statusCode(200).extract().response();
    }

    @Test(priority = 11)
    public void webUserUpdateWebuserDuplicateEmail() throws IOException {
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = given()
                .header(Headers.getHeaderKeyContentType(),Headers.getHeaderValueApplicationJson()).and()
                .header(Headers.getHeaderAuthorization(),Headers.getHeaderAuthorizationValue(bearerToken)).and()
                .body(PayLoad.getWebUserUpdateDuplicateEmail())
                .log().all()
                .when().put(BaseTestSuite.getData().getProperty("URL_WEBUSER")+"/"+
                        BaseTestSuite.getData().getProperty("ADMIN2_WEBUSERID"))
                .then().log().all().and().assertThat().statusCode(200).extract().response();
    }
    @Test(priority = 12)
    public void webUserUpdateWebuserDuplicatePhone() throws IOException {
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = given()
                .header(Headers.getHeaderKeyContentType(),Headers.getHeaderValueApplicationJson()).and()
                .header(Headers.getHeaderAuthorization(),Headers.getHeaderAuthorizationValue(bearerToken)).and()
                .body(PayLoad.getWebuserUpdatePhoneBody())
                .log().all()
                .when().put(BaseTestSuite.getData().getProperty("URL_WEBUSER")+"/"+
                        BaseTestSuite.getData().getProperty("ADMIN2_WEBUSERID"))
                .then().log().all().and().assertThat().statusCode(200).extract().response();
    }

    @Test(priority = 13)
    public void webUserSuspendById() throws IOException {
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = given()
                .header(Headers.getHeaderKeyContentType(),Headers.getHeaderValueApplicationJson()).and()
                .header(Headers.getHeaderAuthorization(),Headers.getHeaderAuthorizationValue(bearerToken)).and()
                .log().all()
                .when().put(BaseTestSuite.getData().getProperty("URL_WEBUSER")+"/"+
                        BaseTestSuite.getData().getProperty("ADMIN2_WEBUSERID")
                        +BaseTestSuite.getData().getProperty("URL_SUSPEND"))
                .then().log().all().and().assertThat().statusCode(200).extract().response();

            }
    @Test(priority = 14)
    public void webUserUnsuspend() throws IOException {
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = given()
                .header(Headers.getHeaderKeyContentType(),Headers.getHeaderValueApplicationJson()).and()
                .header(Headers.getHeaderAuthorization(),Headers.getHeaderAuthorizationValue(bearerToken)).and()
                .log().all()
                .when().put(BaseTestSuite.getData().getProperty("URL_WEBUSER")+"/"+
                        BaseTestSuite.getData().getProperty("ADMIN2_WEBUSERID")
                        +BaseTestSuite.getData().getProperty("URL_UNSUSPEND"))
                .then().log().all().and().assertThat().statusCode(200).extract().response();

    }

    @Test(priority = 15)
    public void webUserLoginAdmin2() throws IOException {
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = given()
                .header(Headers.getHeaderKeyContentType(),Headers.getHeaderValueApplicationJson()).and()
                .body(PayLoad.getWebUserAdmin2LoginBody()).log().all()
                .when().post(BaseTestSuite.getData().getProperty("URL_WEBUSER_LOGIN"))
                .then().log().all().and().assertThat().statusCode(200).extract().response()
                ;

    }


    @Test(priority = 16)
    public void webUserAdminChangePassword() throws IOException {
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = given()
                .header(Headers.getHeaderKeyContentType(),Headers.getHeaderValueApplicationJson()).and()
                .header(Headers.getHeaderAuthorization(),Headers.getHeaderAuthorizationValue(bearerToken)).and()
                .body(PayLoad.getWebusesrChangePasswordBody())
                .log().all()
                .when().post(BaseTestSuite.getData().getProperty("URL_WEBUSER_CHANGE_PASSWORD"))
                .then().log().all().and().assertThat().statusCode(200).extract().response();

    }

    @Test(priority = 17)
    public void webUserAdminLogout() throws IOException {
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = given()
                .header(Headers.getHeaderKeyContentType(),Headers.getHeaderValueApplicationJson()).and()
                .header(Headers.getHeaderAuthorization(),Headers.getHeaderAuthorizationValue(bearerToken)).and()
                .log().all()
                .when().post(BaseTestSuite.getData().getProperty("URL_WEBUSER_LOGOUT"))
                .then().log().all().and().assertThat().statusCode(200).extract().response();

    }

    @Test(priority = 18)
    public void webUserLoginOldPassword() throws IOException {
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = given()
                .header(Headers.getHeaderKeyContentType(),Headers.getHeaderValueApplicationJson()).and()
                .body(PayLoad.getWebUserLoginBody()).log().all()
                .when().post(BaseTestSuite.getData().getProperty("URL_WEBUSER_LOGIN"))
                .then().log().all().and().assertThat().statusCode(401).extract().response()
                ;

    }

    @Test(priority = 19)
    public void webUserLoginNewPassword() throws IOException {
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = given()
                .header(Headers.getHeaderKeyContentType(),Headers.getHeaderValueApplicationJson()).and()
                .body(PayLoad.getWebUserAdminLoginNewPasswordBody()).log().all()
                .when().post(BaseTestSuite.getData().getProperty("URL_WEBUSER_LOGIN"))
                .then().log().all().and().assertThat().statusCode(200).extract().response();
        bearerToken = JsonElements.getToken(res);
                ;

    }

    @Test(priority = 20)
    public void webUserAdminRevertPassword() throws IOException {
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = given()
                .header(Headers.getHeaderKeyContentType(),Headers.getHeaderValueApplicationJson()).and()
                .header(Headers.getHeaderAuthorization(),Headers.getHeaderAuthorizationValue(bearerToken)).and()
                .body(PayLoad.getWebusesrRevertPasswordBody())
                .log().all()
                .when().post(BaseTestSuite.getData().getProperty("URL_WEBUSER_CHANGE_PASSWORD"))
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
    public void sendemail(){
        Email.sendemail(Email.getMyEmail(),suc+fail);
    }




}
