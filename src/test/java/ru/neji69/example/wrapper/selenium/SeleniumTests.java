package ru.neji69.example.wrapper.selenium;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.neji69.example.wrapper.selenium.pageobjects.*;

import java.time.Duration;

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

        GoogleSearch googleSearch = new GoogleSearch();
        googleSearch.search("performance lab");
        googleSearch.clickToPerformanceLabLink();

        MainPagePerformanceLab mainPage = new MainPagePerformanceLab();
        mainPage.closePopUp();
        mainPage.moveToElementsFromMenu(HeaderMenuComponent.SERVICES_AND_PRODUCTS_MENU);
        mainPage.clickFromSubMenu(HeaderSubMenuComponent.SITE_TESTING);

        switchTo().window(getWindows().get(1));

        SiteTestingPagePerformanceLab siteTestingPage = new SiteTestingPagePerformanceLab();
        rgbaActual = siteTestingPage.getBackgroundColorElement(siteTestingPage.getCheckPricesButton());

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

        MainPagePerformanceLab mainPage = new MainPagePerformanceLab();
        mainPage.closePopUp();
        mainPage.moveToElementsFromMenu(HeaderMenuComponent.SERVICES_AND_PRODUCTS_MENU);
        mainPage.clickFromSubMenu(HeaderSubMenuComponent.AUTOMATION_TESTING);

        AutomationTestingPagePerformanceLab automationTestingPage = new AutomationTestingPagePerformanceLab();
        automationTestingPage.clickToImageAndCheckFormContact();

    }

}