package ru.neji69.example.wrapper.selenium;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.neji69.example.wrapper.selenium.pageobjects.*;

import static ru.neji69.example.wrapper.selenium.utils.WebDriverLocalWrapper.*;

public class SeleniumTests {

    @Test
    @DisplayName(" Услуги и продукты -> " +
            "Тестирование сайта (перейти), " +
            "проверить что кнопка \"Узнать цены\" раскрашена синим цветом")
    void performanceLabRuTest() {

        String rgbaExpected = "rgba(79, 173, 255, 1)";
        String rgbaActual;

        open("https://www.google.com/");
//        open("https://www.performance-lab.ru/");

        GoogleSearch googleSearch = new GoogleSearch();
        googleSearch.search("performance lab");
        googleSearch.clickToPerformanceLabSite();

        MainPage mainPage = new MainPage();
        mainPage.closePopUp();
        mainPage.moveToElementsFromMenu(HeaderMenuComponent.SERVICES_AND_PRODUCTS_MENU);
        mainPage.clickFromSubMenu(HeaderSubMenuComponent.SITE_TESTING);

        switchTo().window(getWindows().get(1));

        SiteTestingPage siteTestingPage = new SiteTestingPage();
        rgbaActual = siteTestingPage.getBackgroundColorElement(siteTestingPage.getCheckPricesButton());

        Assertions.assertThat(rgbaActual).isEqualTo(rgbaExpected);
    }

}