package ru.neji69.example.wrapper.selenium.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static ru.neji69.example.wrapper.selenium.utils.WebDriverLocalWrapper.*;

public class  MainPagePerformanceLab extends PerformanceLabAbstractPage {

    public MainPagePerformanceLab closePopUp() {
        shouldBe(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@data-gr='popup-container']")));
        executeJavaScript("arguments[0].remove()", $x("//div[@data-gr='popup-container']"));
        return this;
    }
}
