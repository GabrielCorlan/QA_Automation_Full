package ui_tests;

import constants.Constants;
import constants.WDWait;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BaseTest {

    protected WebDriver driver;
    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
    }

    @Test
    public void goToWebsite() {
        driver.get(Constants.BASE_URL);
        driver.manage().window().maximize();
        WDWait.waitForSeconds(3);
        driver.quit();
    }
}
