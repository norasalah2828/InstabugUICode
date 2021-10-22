package RegisterSuite;

import Pages.LoginPage;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Assertions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC02_CheckSignUpWithInvalidData {
    private WebDriver driver;
    private JSONFileManager users;

    @BeforeClass
    public void beforeClass() {
        driver = BrowserFactory.getBrowser();
        users = new JSONFileManager(System.getProperty("testDataFolderPath") + "Users.json");

    }

    @Test
    public void CheckFillingSignUpFormWithInvalidData() {
        var errorMessageText = new LoginPage(driver).openFacebookLandingPage()
                .openRegisterPage()
                .FillSignUpForm(users.getTestData("invalidRegisterUser.firstName"),
                        users.getTestData("invalidRegisterUser.surname"),
                        users.getTestData("invalidRegisterUser.email"),
                        users.getTestData("invalidRegisterUser.password"),
                        users.getTestData("invalidRegisterUser.day"),
                        users.getTestData("invalidRegisterUser.month"),
                        users.getTestData("invalidRegisterUser.year"),
                        users.getTestData("invalidRegisterUser.gender"))
                .getErrorMessage_text();
        Assertions.assertElementExists(driver, errorMessageText);
    }
}
