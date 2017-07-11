package Base;

import ApiTests.DocumentTests;
import ApiTests.DriverTests;
import ApiTests.PassengerTests;
import ApiTests.WebuserTests;
import org.testng.TestListenerAdapter;
import org.testng.TestNG;

/**
 * Created by Chetna on 7/10/2017.
 */
public class TestRunner {

    public static void main(String[] args) {
        TestListenerAdapter tla = new TestListenerAdapter();
        TestNG testng = new TestNG();
        testng.setTestClasses(new Class[] { DocumentTests.class, DriverTests.class
        , PassengerTests.class, WebuserTests.class});
        testng.addListener(tla);
        testng.run();
    }


}
