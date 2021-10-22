package Pages;

import com.shaft.gui.element.ElementActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Registration {
    public Registration(WebDriver driver) {
        this.driver = driver;
    }

    private WebDriver driver;
    private By FirstName_textBox = By.name("firstname");
    private By Surname_textBox = By.name("lastname");
    private By Email_textBox = By.name("reg_email__");
    private By EmailConfirmation_textBox = By.name("reg_email_confirmation__");
    private By Password_textBox=By.id("password_step_input");
    private By Days_dropDown = By.id("day");
    private By Months_dropDown = By.id("month");
    private By Years_dropDown = By.id("year");
    private By Female_radioButton = By.xpath("//label[text()='Female']");
    private By Male_radioButton = By.xpath("//label[text()='Male']");
    private By Custom_radioButton = By.xpath("//label[text()='Custom']");
    private By SelectYourPronoun_dropDown = By.name("preferred_pronoun");
    private By OptionalGender_textBox = By.name("custom_gender");

    public By getSignUp_button() {
        return SignUp_button;
    }
    private By SignUp_button=By.name("websubmit");

    public By getErrorMessage_text() {
        return ErrorMessage_text;
    }

    private By ErrorMessage_text=By.id("reg_error_inner");


    //The following are overloaded methods because of custom genders

    public Registration FillSignUpForm(String firstName, String surname, String email,String password,
                                       String day, String month, String year,
                                       String pronoun, String optionalGender) {
        new ElementActions(driver).type(FirstName_textBox, firstName)
                .type(Surname_textBox, surname)
                .type(Email_textBox, email)
                .type(EmailConfirmation_textBox, email)
                .type(Password_textBox,password)
                .select(Days_dropDown, day)
                .select(Months_dropDown, month)
                .select(Years_dropDown, year)
                .click(Custom_radioButton)
                .select(SelectYourPronoun_dropDown, pronoun)
                .type(OptionalGender_textBox, optionalGender)
                .click(SignUp_button);

        return this;
    }

    public Registration FillSignUpForm(String firstName, String surname, String email,String password,
                                       String day, String month, String year, String gender) {
        new ElementActions(driver).type(FirstName_textBox, firstName)
                .type(Surname_textBox, surname)
                .type(Email_textBox, email)
                .type(EmailConfirmation_textBox, email)
                .type(Password_textBox,password)
                .select(Days_dropDown, day)
                .select(Months_dropDown, month)
                .select(Years_dropDown, year);
        if (gender.equals("Male")) {
          new  ElementActions(driver)
                  .click(Male_radioButton)
                  .click(SignUp_button);
        } else if (gender.equals("Female")) {
          new  ElementActions(driver)
                  .click( Female_radioButton)
                  .click(SignUp_button);
        }
        return this;
    }

}
