package Pages;

import com.shaft.gui.browser.BrowserActions;
import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver;
    private By Email_textBox= By.id("email");
    private By Password_textBox=By.id("pass");
    private By Login_button=By.name("login");
    private By CreateNewAccount_button=By.xpath("//a[text()='Create New Account']");

    public By getErrorMessage_text() {
        return ErrorMessage_text;
    }

    private By ErrorMessage_text =By.xpath("//div[@class='_9ay7']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    public LoginPage openFacebookLandingPage(){
        BrowserActions.navigateToURL(driver,System.getProperty("baseURL"));
        return this;
    }

    public Dashboard ValidLogin(String email, String password){
        new ElementActions(driver).type(Email_textBox,email)
                .type(Password_textBox,password)
                .click(Login_button);
        return new Dashboard(driver);
    }

    public LoginPage InvalidLogin(String email,String password){
        new ElementActions(driver).type(Email_textBox,email)
                .type(Password_textBox,password)
                .click(Login_button);
        return this;
    }
    public Registration openRegisterPage(){
        new ElementActions(driver).click(CreateNewAccount_button);
        return new Registration(driver);
    }


}
