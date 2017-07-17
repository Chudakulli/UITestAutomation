package tools;

import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import pages.StartPage;
import java.util.concurrent.TimeUnit;


public class BasicTestConditions {

    private static final String BASEURL = PropertiesProvider.getProperty("base.url");
    private static final int TIMEOUT = Integer.parseInt(PropertiesProvider.getProperty("time.out"));

    protected static WebDriver driver;
    protected static StartPage startPage;


    private static String webdriverName = PropertiesProvider.getProperty("webdriver.name");
    /** This methods will be executed before every test class*/

    @BeforeClass (alwaysRun = true)
    public void beforeClassSetUp() throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        driver = (WebDriver) Class.forName(webdriverName).newInstance();
        driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);
        driver.get(BASEURL);
        startPage = new StartPage(driver);
    }


    /** This methods will be executed after every test class*/
    @AfterClass (alwaysRun = true)
    public static void afterClassTearDown() {
        driver.quit();
    }


}
