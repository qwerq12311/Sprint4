package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.commons.lang3.StringUtils;

import java.time.Duration;
import java.util.Random;

import static org.junit.Assert.assertTrue;

public class ScooterOrderTestFirefox {
    private WebDriver driver;
    private WebDriverWait wait;
    private HomePage homePage;
    private ScooterOrderPage scooterOrderPage;

    @Before
    public void setUpBeforeClass() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        homePage = new HomePage(driver, wait);
        scooterOrderPage = new ScooterOrderPage(driver, wait);
        driver.manage().window().maximize();
    }

    @Test
    public void testScooterOrderButtonTop() {
        homePage.open();

        homePage.acceptCookie();
        homePage.clickTopOrderButton();

        scooterOrderPage.enterClientDetails("Тестирование", "Яндекс", "Практикум", "891812344321");
        scooterOrderPage.selectRandomMetroStation();
        scooterOrderPage.clickNextButtonInClientDetails();

        int randomRentalPeriodIndex = new Random().nextInt(3);
        scooterOrderPage.fillOrderForm("25-06-2023", randomRentalPeriodIndex);
        scooterOrderPage.clickNextButton();

        scooterOrderPage.clickPopupYesButton();

        String orderElementText = scooterOrderPage.getOrderElementText();
        String expectedOrderElementPhrase = "Заказ оформлен";
        assertTrue("Не получилось оформить заказ :( ", StringUtils.containsIgnoreCase(orderElementText, expectedOrderElementPhrase));
    }


    @Test
    public void testScooterOrderButtonBottom() {
        homePage.open();

        homePage.acceptCookie();
        homePage.clickBottomOrderButton();

        scooterOrderPage.enterClientDetails("Тестирование", "Яндекс", "Практикум", "891812344321");
        scooterOrderPage.selectRandomMetroStation();
        scooterOrderPage.clickNextButtonInClientDetails();

        int randomRentalPeriodIndex = new Random().nextInt(3);
        scooterOrderPage.fillOrderForm("26-06-2023", randomRentalPeriodIndex);
        scooterOrderPage.clickNextButton();

        scooterOrderPage.clickPopupYesButton();

        String orderElementText = scooterOrderPage.getOrderElementText();
        String expectedOrderElementPhrase = "Заказ оформлен";
        assertTrue("Не получилось оформить заказ :(", StringUtils.containsIgnoreCase(orderElementText, expectedOrderElementPhrase));
    }

    @After
    public void tearDownAfterClass() {
        if (driver != null) {
            driver.quit();
        }
    }
}
