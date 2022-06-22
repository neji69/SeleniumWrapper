package ru.neji69.example.wrapper.selenium;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.neji69.example.wrapper.selenium.pageobjects.*;

import static ru.neji69.example.wrapper.selenium.utils.WebDriverLocalWrapper.*;

public class SeleniumTests {

    @Test
    @DisplayName("Услуги и продукты -> " +
            "Тестирование сайта (перейти), " +
            "проверить что кнопка \"Узнать цены\" раскрашена синим цветом")
    void performanceLabRu_checkColorButtonTest() {

        String rgbaExpected = "rgba(79, 173, 255, 1)";
        String rgbaActual;

        open("https://www.google.com/");
        new GoogleSearch().search("performance lab").clickToPerformanceLabLink();


        MainPage mainPage = new MainPage();
        String headerMenu = mainPage.getHeaderMenu().BLOG_MENU;
        String subMenu = mainPage.getHeaderMenu().getSubMenu().SITE_TESTING;


        mainPage.closePopUp()
                .moveToElementsFromMenu(headerMenu)
                .clickToSubMenu(subMenu);
//        mainPage.moveToElementsFromMenu(SERVICES_AND_PRODUCTS_MENU);
//        mainPage.clickToSubMenu(HeaderSubMenuComponent.SITE_TESTING);
//        mainPage.moveToElementsFromMenu(headerMenu).clickToSubMenu(subMenu);

        switchTo().window(getWindows().get(1));

        SiteTestingPage siteTestingPage = new SiteTestingPage();
        String button = siteTestingPage.getCheckPricesButton();
        rgbaActual = siteTestingPage.getBackgroundColorElement(button);

        Assertions.assertThat(rgbaActual).isEqualTo(rgbaExpected);
    }

    @Test
    @DisplayName("найти вкладку Услуги и продукты -> " +
            "Автоматизация тестирования (перейти), " +
            "отмотать страницу до \"Примеры выполненных проектов\", " +
            "нажать на картинку под темой и проверить, " +
            "что открылась форма для заполнения контактов.")
    void performanceLabRu_checkOpenFormToContactsTest() {

        open("https://www.google.com/");

        GoogleSearch googleSearch = new GoogleSearch();
        googleSearch.search("performance lab");
        googleSearch.clickToPerformanceLabLink();

        MainPage mainPage = new MainPage();
        String menu = mainPage.getHeaderMenu().SERVICES_AND_PRODUCTS_MENU;
        String subMenu = mainPage.getHeaderMenu().getSubMenu().AUTOMATION_TESTING;
        mainPage.closePopUp().moveToElementsFromMenu(menu).clickToSubMenu(subMenu);

        AutomationTestingPage automationTestingPage = new AutomationTestingPage();
        automationTestingPage.clickToImage().checkFormContact();

    }

}