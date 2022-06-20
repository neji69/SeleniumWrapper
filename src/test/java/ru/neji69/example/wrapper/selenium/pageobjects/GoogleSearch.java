package ru.neji69.example.wrapper.selenium.pageobjects;

import org.openqa.selenium.Keys;

import static ru.neji69.example.wrapper.selenium.utils.WebDriverLocalWrapper.$x;

public class GoogleSearch {

    public void search(String search){
        $x("//input[@name='q']").sendKeys(search + Keys.ENTER);
    }

    public void clickToPerformanceLabLink() {
        $x("//a[@href='https://www.performance-lab.ru/']").click();
    }
}
