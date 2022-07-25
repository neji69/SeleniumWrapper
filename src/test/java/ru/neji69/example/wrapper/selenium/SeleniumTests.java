package ru.neji69.example.wrapper.selenium;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import ru.neji69.example.wrapper.selenium.pageobjects.*;

import static org.junit.jupiter.api.parallel.ExecutionMode.CONCURRENT;
import static ru.neji69.example.wrapper.selenium.utils.SeleniumWebDriverWrapperImpl.*;

@Execution(CONCURRENT)
public class SeleniumTests {

    @Test
    @DisplayName("Услуги и продукты -> " +
            "Тестирование сайта (перейти), " +
            "проверить что кнопка \"Узнать цены\" раскрашена синим цветом")
    void performanceLabRu_checkColorButtonTest() {

        String rgbaExpected = "rgba(79, 173, 255, 1)";
        String rgbaActual;

        open("https://www.google.com/");
        new GoogleSearch()
                .search("performance lab")
                .clickToPerformanceLabLink();


        new MainPage().closePopUp()
                .navigateToServicesAndProductsMenu()
                .navigateToSiteTestingSubMenu();

        switchTo().window(getWindows().get(1)); //переключаемся на новую открытую вкладку.

        rgbaActual = new SiteTestingPage().getBackgroundColorElement();

        Assertions.assertThat(rgbaActual).isEqualTo(rgbaExpected); //Проверяем что цвет совпадает с "rgba(79, 173, 255, 1)"
    }

    @Test
    @DisplayName("найти вкладку Услуги и продукты -> " +
            "Автоматизация тестирования (перейти), " +
            "отмотать страницу до \"Примеры выполненных проектов\", " +
            "нажать на картинку под темой и проверить, " +
            "что открылась форма для заполнения контактов.")
    void performanceLabRu_checkOpenFormToContactsTest() {

        open("https://www.google.com/");
        new GoogleSearch()
                .search("performance lab")
                .clickToPerformanceLabLink();

        new MainPage()
                .closePopUp()
                .navigateToServicesAndProductsMenu()
                .navigateToAutomationTestingSubMenu();

        new AutomationTestingPage()
                .clickToImage()
                .checkFormContact();
    }
}