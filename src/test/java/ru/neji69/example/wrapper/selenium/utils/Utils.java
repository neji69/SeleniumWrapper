package ru.neji69.example.wrapper.selenium.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Utils {

    static WebDriver webDriver;

    public static void open(WebDriver driver, String relativeOrAbsoluteUrl) {
        webDriver = driver;
        driver.get(relativeOrAbsoluteUrl);
    }

    public static WebElement $x(String xpathExpression) {
        return webDriver.findElement(
                By.xpath(xpathExpression));
    }

    public static WebElement $(String cssSelector) {
        return webDriver.findElement(
                By.cssSelector(cssSelector));
    }
    public static WebElement $text(String linkText) {
        return webDriver.findElement(
                By.linkText(linkText));
    }

}
