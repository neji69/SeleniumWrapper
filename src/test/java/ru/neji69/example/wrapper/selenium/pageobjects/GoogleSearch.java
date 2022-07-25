package ru.neji69.example.wrapper.selenium.pageobjects;

import org.openqa.selenium.Keys;

import static ru.neji69.example.wrapper.selenium.utils.SeleniumWebDriverWrapperImpl.$x;

public class GoogleSearch {

    //Ищем в поисковой строке переданный аргумент.
    public GoogleSearch search(String search) {
        $x("//input[@name='q']").sendKeys(search, Keys.ENTER);
        return this;
    }

    //Ищем кликаем по ссылке https://www.performance-lab.ru/
    public void clickToPerformanceLabLink() {
        $x("//a[@href='https://www.performance-lab.ru/']").click();
    }
}
