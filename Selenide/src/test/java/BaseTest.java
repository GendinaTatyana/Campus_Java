import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import static com.codeborne.selenide.Browsers.CHROME;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.hasWebDriverStarted;

public class BaseTest {
    public static final String STANDARD_USERNAME = "standard_user";
    public static final String PASSWORD = "secret_sauce";
    public static final String LOCKED_OUT_USERNAME = "locked_out_user";
    public static final String FIRST_NAME = "Леонид";
    public static final String LAST_NAME = "Утёсов";
    public static final String POST_CODE = "740-35-16";

    @BeforeAll
    public static void setUp(){
        Configuration.baseUrl = "https://www.saucedemo.com/";
        Configuration.browser = CHROME;
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 3000;
    }

    @BeforeEach
    public void beforeTest(){
        if(hasWebDriverStarted()){
            getWebDriver().manage().deleteAllCookies();
        }
        open("");
    }

    @AfterEach
    public void afterTest(){
        getWebDriver().manage().deleteAllCookies();
    }
}


