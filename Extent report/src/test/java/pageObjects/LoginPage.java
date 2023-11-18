package pageObjects;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public SelenideElement getDeerholdLogo() {
        return  $x("//img[contains(@src, 'deerhold-logo')]");
    }
    public SelenideElement getGoogleChromeImage() {
        return  $x("//img[contains(@src, 'chrome-logo-m100.svg')]");
    }
}
