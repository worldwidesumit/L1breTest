package ApiTests;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;

/**
 * Created by Chetna on 7/12/2017.
 */
public class DispatchTests {

    static String ADMINTOKEN;
    static String DOCUMENTID;
    static String suc = "SUCCESSFUL TESTS"+"\n";
    static String fail = "FAILED TESTS"+"\n";









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
