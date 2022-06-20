package ru.neji69.example.wrapper.selenium.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

public class WebDriverLocalWrapper extends RemoteWebElement {

    private WebDriverLocalWrapper() {
    }

    // Создаем тред локал синглтон
    private static final ThreadLocal<WebDriver> THREAD_LOCAL = ThreadLocal.withInitial(() ->
            WebDriverManager.chromedriver().create());

    // Через метод будем получать инстанс хромдрайвера и использовать его везде, где нам нужно.
    public static WebDriver getInstanceWebDriver() {
        return THREAD_LOCAL.get();
    }

    public static void open(String relativeOrAbsoluteUrl) {
        getInstanceWebDriver().get(relativeOrAbsoluteUrl);
    }

    // Вызов поиска элемента, по xpath
    public static WebElement $x(String xpathExpression) {
        return getInstanceWebDriver().findElement(By.xpath(xpathExpression));
    }

    // Вызов поиска элемента, по cssSelector
    public static WebElement $(String cssSelector) {
        return getInstanceWebDriver().findElement(
                By.cssSelector(cssSelector));
    }

    // Вызов поиска элемента, по тексту
    public static WebElement $text(String linkText) {
        return getInstanceWebDriver().findElement(
                By.linkText(linkText));
    }

    // Исполнить джава-скрипт
    public static void executeJavaScript(String script, WebElement webElement) {
        JavascriptExecutor js = (JavascriptExecutor) getInstanceWebDriver();
        js.executeScript(script, webElement);
    }

    // Переместить мышку к элементу
    public static Actions moveToElement(WebElement webElement) {
        Actions actions = new Actions(getInstanceWebDriver());
        return actions.moveToElement(webElement);
    }

    // перключиться на...
    public static WebDriver.TargetLocator switchTo() {
        return getInstanceWebDriver().switchTo();
    }

    // Получить список окон
    public static ArrayList<String> getWindows() {
        return new ArrayList<>(getInstanceWebDriver().getWindowHandles());
    }

    public static WebElement shouldBe(ExpectedCondition<WebElement> webElementExpectedCondition) {
        WebDriverWait wait = new WebDriverWait(getInstanceWebDriver(), Duration.ofSeconds(60));
        return wait.until(webElementExpectedCondition);
    }

}


