package locators;

import org.openqa.selenium.By;

public class HomePageLocators {
    // Локаторы элементов главной страницы


    public static final By COOKIE_CONSENT_BUTTON = By.cssSelector(".App_CookieConsent__1yUIN .App_CookieButton__3cvqF");
    // Локатор кнопки согласия на использование куки

    public static final By HOME_ORDER_BUTTON_DOWN = By.cssSelector("div.Home_FinishButton__1_cWm button.Button_Button__ra12g.Button_Middle__1CSJM");
    // Локатор кнопки заказа внизу домашней страницы

    public static final By FAQ_QUESTIONS_LIST = By.className("accordion__item");
    // Список вопросов FAQ



    // Элементы аккордиона

    public static final By ACCORDION_ITEM_HEADING_DIV = By.cssSelector(".accordion__heading");
    public static final By ACCORDION_ITEM_BUTTON_DIV = By.cssSelector(".accordion__button");
    public static final By ACCORDION_ITEM_PANEL_DIV = By.cssSelector(".accordion__panel");


}
