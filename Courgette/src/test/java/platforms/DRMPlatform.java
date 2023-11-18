package platforms;

import com.codeborne.selenide.WebDriverRunner;
import pageObjects.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import static com.codeborne.selenide.Condition.*;

public class DRMPlatform {
    private WebDriver driver;
    private LoginPage loginPage;

    public void setUp() {
        ChromeOptions options = new ChromeOptions().setHeadless(false);
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.google.com/chrome/");

        loginPage = new LoginPage(driver);
        WebDriverRunner.setWebDriver(driver);
    }

    public void tearDown() {
        driver.quit();
    }

    public void verifyDRMLoginPage() throws Exception {
        try {
            loginPage.getDeerholdLogo().shouldBe(visible, Duration.ofSeconds(3));
        } catch (Exception e) {
            throw new Exception("Failed to verify DRM login page", e);
        }
    }

    public void verifyGoogleChromePagePage() throws Exception {
        try {
            loginPage.getGoogleChromeImage().shouldBe(visible, Duration.ofSeconds(3));
        } catch (Exception e) {
            throw new Exception("Failed to verify google chrome page", e);
        }
    }

}
