package pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;


import java.time.Duration;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class HomePageAccordionDropdownTestFirefox {
    private WebDriver firefoxDriver;
    private WebDriverWait firefoxWait;
    private HomePage homePage;

    private int itemIndex;

    public HomePageAccordionDropdownTestFirefox(int itemIndex) {
        this.itemIndex = itemIndex;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {0}, {1}, {2}, {3}, {4}, {5}, {6}, {7}
        });
    }

    @Before
    public void setUp() {
        WebDriverManager.firefoxdriver().setup();
        firefoxDriver = new FirefoxDriver();
        firefoxWait = new WebDriverWait(firefoxDriver, Duration.ofSeconds(10));
        homePage = new HomePage(firefoxDriver, firefoxWait);
        firefoxDriver.manage().window().maximize();


        homePage.open();
        homePage.acceptCookie();
    }

    @Test
    public void testAccordionDropdownItem() {
        homePage.clickAccordionButton();
        List<WebElement> accordionItems = homePage.getAccordionItems();
        assertTrue("Список вопросов пуст", !accordionItems.isEmpty());

        homePage.clickAccordionItem(itemIndex);
        String expectedText = homePage.getAccordionItemText(accordionItems.get(itemIndex));
        String actualText = homePage.getAccordionItemText(accordionItems.get(itemIndex));
        assertEquals("Неверный текст элемента аккордеона", expectedText, actualText);
    }

    @After
    public void tearDown() {
        if (firefoxDriver != null) {
            firefoxDriver.quit();
        }
    }
}
