package Base;

import Common.TestResultsEmail;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;

/**
 * Created by Chetna on 7/10/2017.
 */
public class TestRunner {

    static String sendBody = "TEST RESULTS"+"\n";

    public static void setSendBodyBody(String body){
        sendBody = sendBody + body;
    }

    public static String getSendBody(){
        return sendBody;
    }



    public static void main(String[] args) {
        TestListenerAdapter tla = new TestListenerAdapter();
        TestNG testng = new TestNG();
        testng.setTestClasses(new Class[] { ApiTests.DocumentTests.class, ApiTests.DriverTests.class
                , ApiTests.PassengerTests.class, ApiTests.WebuserTests.class, ApiTests.GeoSupplyTests.class
                ,ApiTests.TripManagerTests.class, TestResultsEmail.class});
        testng.addListener(tla);
        testng.run();
    }


}
