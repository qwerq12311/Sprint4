package locators;

import org.openqa.selenium.By;

public class ScooterOrderPageLocators {


    // Локаторы элементов страницы заказа самоката
    public static final By DATE_PICKER_INPUT = By.cssSelector(".Order_MixedDatePicker__3qiay input[type='text']"); // Поле ввода для выбора даты




    public static final By ORDER_BUTTON_HEADER = By.xpath("//button[contains(text(), 'Заказать')]"); // Кнопка "Заказать" в заголовке страницы

    public static final By ORDER_BUTTON_FORM = By.xpath("//div[contains(@class, 'Order_Buttons__1xGrp')]/button[contains(text(), 'Заказать')]"); // Кнопка "Заказать" в форме заказа



    // Локаторы в попапе подтверждения создания заказа

    public static final By POPUP_YES_BUTTON = By.xpath("//button[text()='Да']"); // Кнопка "Да" в попапе заказа



    // Локаторы для кнопки в попапе успешного экрана
    public static final By VIEW_STATUS_BUTTON = By.cssSelector(".Order_NextButton__1_rCA button"); // Кнопка "Посмотреть статус"




    // Локатор для элемента "Заказ оформлен"

    public static final By orderNumber = By.xpath("//div[@class='Order_Text__2broi']/text()[1]");
    public static final By locatorOfferToConfirmed = By.xpath("//div[contains(@class, 'Order_ModalHeader__3FDaJ') and contains(text(), 'Заказ оформлен')]");


    // Локатор для элемента "Номер заказа"
    public static final By FOR_WHOM_SCOOTER_DIV = By.cssSelector("div.Order_Header__BZXOb");



    // Локаторы для выбора срока аренды
    public static final By dropdownContainer = By.className("Dropdown-root"); // Локатор для внешнего контейнера выпадающего списка

    public static final By dropdownOption = By.className("Dropdown-option"); // Локаторы для опций в выпадающем списке

}
