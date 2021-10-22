package RegisterSuite;

import Pages.LoginPage;
import com.shaft.gui.browser.BrowserFactory;
import com.shaft.tools.io.JSONFileManager;
import com.shaft.validation.Assertions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TC01_CheckSignUpWithValidData {
    private WebDriver driver;
    private JSONFileManager users;

    @BeforeClass
    public void beforeClass() {
        driver = BrowserFactory.getBrowser();
        users = new JSONFileManager(System.getProperty("testDataFolderPath") + "Users.json");
    }

    @Test
    public void CheckFillingSignUpFormWithValidData() {
        var signupBtn = new LoginPage(driver).openFacebookLandingPage()
                .openRegisterPage()
                .FillSignUpForm(users.getTestData("ValidRegisterUser.firstName"),
                        users.getTestData("ValidRegisterUser.surname"),
                        users.getTestData("ValidRegisterUser.email"),
                        users.getTestData("ValidRegisterUser.password"),
                        users.getTestData("ValidRegisterUser.day"),
                        users.getTestData("ValidRegisterUser.month"),
                        users.getTestData("ValidRegisterUser.year"),
                        users.getTestData("ValidRegisterUser.pronounce"),
                        users.getTestData("ValidRegisterUser.optionalGender"))
                .getSignUp_button();
        Assertions.assertElementExists(driver, signupBtn);
        //Here we can assert on any elements in the next page
        //but cause of test data the page will not redirect to any other page so i assert on sign up button
    }


}
