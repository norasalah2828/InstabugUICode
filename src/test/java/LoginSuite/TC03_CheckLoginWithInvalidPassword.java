package LoginSuite;

import Pages.LoginPage;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Assertions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC03_CheckLoginWithInvalidPassword {
    private WebDriver driver;
    private JSONFileManager users;

    @BeforeClass
    public void beforeClass(){
        driver= BrowserFactory.getBrowser();
        users= new JSONFileManager(System.getProperty("testDataFolderPath")+ "Users.json");
    }

    @Test
    public void CheckLoginWithInvalidPassword(){
        var invalidMsg=    new LoginPage(driver)
                .openFacebookLandingPage()
                .InvalidLogin(users.getTestData("invalidUser.email")
                        ,users.getTestData("invalidUser.password"))
                .getErrorMessage_text();
        Assertions.assertElementAttribute(driver,
                invalidMsg,
                "text",
                "The password that you've entered is incorrect.",
                Assertions.AssertionComparisonType.CONTAINS,
                Assertions.AssertionType.POSITIVE);
    }
}
