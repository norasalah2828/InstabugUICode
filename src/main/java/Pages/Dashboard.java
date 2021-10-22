package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Dashboard {
    public Dashboard(WebDriver driver) {
        this.driver = driver;
    }

    private WebDriver driver;

    public By getWelcomeToFB_label() {
        return WelcomeToFB_label;
    }

    private By WelcomeToFB_label=By.xpath("//div[@class='bcvklqu9 nzypyw8j']//span");

}
