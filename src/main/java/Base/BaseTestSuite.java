package Base;

import org.testng.annotations.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by Chetna on 7/6/2017.
 */
public class BaseTestSuite  {

    static  Properties prop = new Properties();

    @BeforeSuite(alwaysRun = true)
    @Parameters("Environment")
    public static void setUp(@Optional String Environment){

        System.out.println(Environment);

    }

    @AfterSuite(alwaysRun = true)
    public static void tearDown(){

        System.out.println("Base TearDown");

    }

    public static Properties getData() throws IOException {
        FileInputStream fis = new FileInputStream("env.properties");
        prop.load(fis);
        String env = prop.getProperty("Environment");
        if (env.equals("TEST")){
            FileInputStream nfis = new FileInputStream("testenv.properties");
            prop.load(nfis);
        }else
        {
            FileInputStream nfis = new FileInputStream("prodenv.properties");
            prop.load(nfis);
        }
        return prop;
    }
}
