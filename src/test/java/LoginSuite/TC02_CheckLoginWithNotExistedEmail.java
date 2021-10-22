package LoginSuite;

import Pages.LoginPage;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Assertions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC02_CheckLoginWithNotExistedEmail {
    private WebDriver driver;
    private JSONFileManager users;

    @BeforeClass
    public void beforeClass() {
        driver = BrowserFactory.getBrowser();
        users = new JSONFileManager(System.getProperty("testDataFolderPath") + "Users.json");
    }

    @Test
    public void CheckLoginWithNotExistedEmail() {
        var invalidMsg = new LoginPage(driver)
                .openFacebookLandingPage()
                .InvalidLogin(users.getTestData("notExistedUser.email")
                        , users.getTestData("notExistedUser.password"))
                .getErrorMessage_text();
        Assertions.assertElementAttribute(driver,
                invalidMsg,
                "text",
                "The email address or mobile number you entered isn't connected to an account",
                Assertions.AssertionComparisonType.CONTAINS,
                Assertions.AssertionType.POSITIVE);
    }


}
