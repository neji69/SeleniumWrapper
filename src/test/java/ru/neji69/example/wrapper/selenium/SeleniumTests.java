package ru.neji69.example.wrapper.selenium;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import ru.neji69.example.wrapper.selenium.pageobjects.MainPage;
import ru.neji69.example.wrapper.selenium.utils.DriverExtensions;

import static ru.neji69.example.wrapper.selenium.utils.Utils.*;

@ExtendWith(DriverExtensions.class)
public class SeleniumTests {

    @Test
    void mailRuTest(WebDriver driver) {

        MainPage mainPageMailRu = new MainPage(driver);

        int randomNews = (int) (Math.random() * 16);

        mainPageMailRu.getNewsContent().isDisplayed();
        String selectedNewsItemFromList = mainPageMailRu.choiceNewsItemFromList(randomNews).getText();
        mainPageMailRu.choiceNewsItemFromList(randomNews).click();

        System.out.println();
        $text(selectedNewsItemFromList).isDisplayed();
    }
}