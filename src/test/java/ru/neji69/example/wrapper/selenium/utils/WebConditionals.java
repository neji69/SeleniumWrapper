package ru.neji69.example.wrapper.selenium.utils;

/**
 * Enum для передачи состояния ожидания WebElement'а.
 * Используются в методе shouldBe() из класса SeleniumWebElementWrapperImpl.
 */
public enum WebConditionals {

    VISIBLE("visible"),

    PRESENT("present");

    private final String webConditionalName;

    WebConditionals(String webConditionalName) {
        this.webConditionalName = webConditionalName;
    }

    public String getWebConditionalName() {
        return webConditionalName;
    }
}
