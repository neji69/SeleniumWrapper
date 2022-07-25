package ru.neji69.example.wrapper.selenium.pageobjects;

import org.openqa.selenium.Keys;

import static ru.neji69.example.wrapper.selenium.utils.SeleniumWebDriverWrapperImpl.$x;

public class GoogleSearch {

    public GoogleSearch search(String search) {
        $x("//input[@name='q']").sendKeys(search, Keys.ENTER);
        return this;
    }

    public void clickToPerformanceLabLink() {
        $x("//a[@href='https://www.performance-lab.ru/']").click();
    }
}
