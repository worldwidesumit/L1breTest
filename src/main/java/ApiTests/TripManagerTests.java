package ApiTests;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

/**
 * Created by Chetna on 7/12/2017.
 */
public class TripManagerTests {

    static String bearerToken;
    static String driverToken;
    static String suc = "SUCCESSFUL TESTS"+"\n";
    static String fail = "FAILED TESTS"+"\n";
















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
    public void sendEmail(){

        Base.TestRunner.setSendBodyBody(this.getClass().getSimpleName()+suc+fail);
    }
}
