package ru.neji69.example.wrapper.selenium.pageobjects;

import ru.neji69.example.wrapper.selenium.utils.WebConditionals;

import static ru.neji69.example.wrapper.selenium.utils.SeleniumWebDriverWrapperImpl.$x;

public class MainPage extends BasePage<MainPage> {

    public MainPage closePopUp() {
        $x("//div[@data-gr='popup-container']").shouldBe(WebConditionals.PRESENT);
        $x("//div[@data-gr='popup-container']").executeJavaScript("arguments[0].remove()");
        return this;
    }
}

