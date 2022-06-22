package ru.neji69.example.wrapper.selenium.pageobjects;

import ru.neji69.example.wrapper.selenium.utils.WebConditionals;

import static ru.neji69.example.wrapper.selenium.utils.WebDriverLocalWrapper.*;

public class MainPage extends BasePage<MainPage> {

    public MainPage closePopUp() {

//        shouldBe(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@data-gr='popup-container']")));
        $x("//div[@data-gr='popup-container']").shouldBe(WebConditionals.PRESENT);
        executeJavaScript("arguments[0].remove()", $x("//div[@data-gr='popup-container']"));
        return this;
    }
}

