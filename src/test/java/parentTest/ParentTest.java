package parentTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.LandingPage;
import pages.LoginPage;
import parentPages.ParentPage;

import java.util.concurrent.TimeUnit;


public class ParentTest {
    protected WebDriver webDriver;
    protected LandingPage landingPage;
    protected LoginPage loginPage;
    protected ParentPage parentPage;

    @Before
    public void setUp() throws Exception {
        webDriver = driverInit();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        landingPage = new LandingPage(webDriver);
        loginPage = new LoginPage(webDriver);


    }

    private WebDriver driverInit() throws Exception {
        String browser = System.getProperty("browser");
        if ((browser == null) || ("chrome".equalsIgnoreCase(browser))){
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        } else if("firefox".equalsIgnoreCase(browser)){
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        } else {
            throw new Exception ("Check browser");
        }

    }

    @After
    public void closeBrowser(){
        webDriver.quit();
    }

    protected void checkExpectedResult(String message, boolean actualResult) {
        Assert.assertEquals(message, true, actualResult);  //сообщение, ожидаемый, актуальный
    }

}
