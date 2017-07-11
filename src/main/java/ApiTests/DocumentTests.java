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

    static String ADMINTOKEN;
    static String DOCUMENTID;
    static String suc = "SUCCESSFUL TESTS"+"\n";
    static String fail = "FAILED TESTS"+"\n";

    public static String getDocumentId(){
        String s = DOCUMENTID;
        return  s;
    }



    @Test(priority = 1,groups = "Document")
    public void documentWebUserLogin() throws IOException {
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = RestAssured.given()
                .header(Headers.getHeaderKeyContentType(),Headers.getHeaderValueApplicationJson()).and()
                .body(PayLoad.getWebUserLoginBody()).log().all()
                .when().post(BaseTestSuite.getData().getProperty("URL_WEBUSER_LOGIN"))
                .then().log().all().and().assertThat().statusCode(200).extract().response()
                ;
        ADMINTOKEN = JsonElements.getToken(res);

    }

    @Test(priority = 2,groups = "Document")
    public void documentUploadDocument() throws IOException {
        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = RestAssured.given()
                .multiPart("document",new File(BaseTestSuite.getData().getProperty("UPLOAD_FILEPATH")))
                .and().header(Headers.getHeaderAuthorization(), Headers.getHeaderAuthorizationValue(ADMINTOKEN))
                .and().param("ownerId",BaseTestSuite.getData().getProperty("OWNERID"))
                .and().param("documentType",BaseTestSuite.getData().getProperty("DOCUMENTTYPE"))
                .and().log().all()
                .when().post(BaseTestSuite.getData().getProperty("URL_DOCUMENT_DOCUMENT")).then()
                .log().all().and().assertThat().statusCode(200).extract().response();
        DOCUMENTID = JsonElements.getDocumentId(res);

    }

    @Test(priority = 3)
    public void documentListDocuments() throws IOException {

        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = RestAssured.given()
                .header(Headers.getHeaderAuthorization(), Headers.getHeaderAuthorizationValue(ADMINTOKEN))
                .and().param("ownerId",BaseTestSuite.getData().getProperty("OWNERID"))
                .and().log().all()
                .when().get(BaseTestSuite.getData().getProperty("URL_DOCUMENT_LIST")).then()
                .log().all().assertThat().statusCode(200).extract().response();
    }

    @Test(priority = 4)
    public void documentRenameDocuments() throws IOException {

        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = RestAssured.given()
                .header(Headers.getHeaderKeyContentType(),Headers.getHeaderValueApplicationJson()).and()
                .header(Headers.getHeaderAuthorization(), Headers.getHeaderAuthorizationValue(ADMINTOKEN))
                .body(PayLoad.getDocumentRenameBody())
                .and().log().all()
                .when().put(BaseTestSuite.getData().getProperty("URL_DOCUMENT_DOCUMENT")
                +"/"+DOCUMENTID+BaseTestSuite.getData().getProperty("URL_DOCUMENT_RENAME"))
                .then().log().all().assertThat().statusCode(200).extract().response();
    }

    @Test(priority = 5)
    public void documentDownloadDocuments() throws IOException {

        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = RestAssured.given()
                .header(Headers.getHeaderKeyContentType(),Headers.getHeaderValueApplicationJson()).and()
                .header(Headers.getHeaderAuthorization(), Headers.getHeaderAuthorizationValue(ADMINTOKEN))
                .and().log().all()
                .when().get(BaseTestSuite.getData().getProperty("URL_DOCUMENT_DOCUMENT")
                        +"/"+DOCUMENTID+BaseTestSuite.getData().getProperty("URL_DOCUMENT_DOWNLOAD"))
                .then().log().all().assertThat().statusCode(200).extract().response();
    }
    @Test(priority = 6)
    public void documentListTaxiDocumentsForUploadedDoc() throws IOException {

        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = RestAssured.given()
                .header(Headers.getHeaderKeyContentType(),Headers.getHeaderValueApplicationJson()).and()
                .header(Headers.getHeaderAuthorization(), Headers.getHeaderAuthorizationValue(ADMINTOKEN))
                .and().queryParam("ownerId",BaseTestSuite.getData().getProperty("TAXI_OWNER_ID"))
                .and().log().all()
                .when().get(BaseTestSuite.getData().getProperty("URL_DOCUMENT_LIST"))
                .then().log().all().assertThat().statusCode(200).extract().response();
    }
    @Test(priority = 8)
    public void documentDeleteAlreadyDeletedDocument() throws IOException {

        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = RestAssured.given()
                .header(Headers.getHeaderKeyContentType(),Headers.getHeaderValueApplicationJson()).and()
                .header(Headers.getHeaderAuthorization(), Headers.getHeaderAuthorizationValue(ADMINTOKEN))
                .and().body(PayLoad.getDocumentAlreadyDeletedBody())
                .and().log().all()
                .when().delete(BaseTestSuite.getData().getProperty("URL_DOCUMENT_DOCUMENT") + "/"
                +BaseTestSuite.getData().getProperty("ALREAD_DELETED_FILE_ID"))
                .then().log().all().assertThat().statusCode(404).extract().response();
    }

    @Test(priority = 9)
    public void documentListTaxiDocumentsForNoUploadedDoc() throws IOException {

        RestAssured.baseURI = BaseTestSuite.getData().getProperty("Host");
        Response res = RestAssured.given()
                .header(Headers.getHeaderKeyContentType(),Headers.getHeaderValueApplicationJson()).and()
                .header(Headers.getHeaderAuthorization(), Headers.getHeaderAuthorizationValue(ADMINTOKEN))
                .and().queryParam("ownerId",BaseTestSuite.getData().getProperty("TAXI_OWNER_ID_NO_DOCUMENT"))
                .and().log().all()
                .when().get(BaseTestSuite.getData().getProperty("URL_DOCUMENT_LIST"))
                .then().log().all().assertThat().statusCode(200).extract().response();
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
