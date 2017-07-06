package Base;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Chetna on 7/6/2017.
 */
public class BaseTestSuite  {

    static  Properties prop = new Properties();

    @BeforeSuite
    public static void setUp(){

        System.out.println("Base Setup");

    }

    @AfterSuite
    public static void tearDown(){

        System.out.println("Base TearDown");

    }

    @BeforeTest
    public static Properties getData() throws IOException {
        FileInputStream fis = new FileInputStream("env.properties");
        prop.load(fis);
        return prop;
    }
}
