package LoginSuite;

import com.shaft.gui.browser.BrowserFactory;
import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Assertions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Pages.*;

public class TC01_CheckLoginWithValidEmailAndPassword {
    private WebDriver driver;
    private JSONFileManager users;

    @BeforeClass
    public void beforeClass() {
        driver = BrowserFactory.getBrowser();
        users = new JSONFileManager(System.getProperty("testDataFolderPath") + "Users.json");
    }

    @Test
    public void CheckLoginWithValidCredentials() {
        var crateStory = new LoginPage(driver)
                .openFacebookLandingPage()
                .ValidLogin(users.getTestData("validUser.email")
                        , users.getTestData("validUser.password")).getWelcomeToFB_label();
        Assertions.assertElementAttribute(driver,
                crateStory,
                "text",
                "Welcome to Facebook",
                Assertions.AssertionComparisonType.CONTAINS,
                Assertions.AssertionType.POSITIVE);
    }

}


