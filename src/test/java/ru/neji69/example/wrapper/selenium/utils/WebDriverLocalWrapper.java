package ru.neji69.example.wrapper.selenium.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

public class WebDriverLocalWrapper extends RemoteWebElement {

    private WebDriverLocalWrapper() {
    }

    // Создаем тред локал синглтон
    private static final ThreadLocal<WebDriver> THREAD_LOCAL = ThreadLocal.withInitial(() ->
            WebDriverManager.chromedriver().create());

    static String xpathOrCssLocator = null;
    static By byLocator = null;


    // Через метод будем получать инстанс хромдрайвера и использовать его везде, где нам нужно.
    public static WebDriver getInstanceWebDriver() {
        return THREAD_LOCAL.get();
    }

    public static void open(String relativeOrAbsoluteUrl) {
        getInstanceWebDriver().get(relativeOrAbsoluteUrl);
    }

    // Вызов поиска элемента, по xpath
    public static WebDriverLocalWrapper $x(String xpathExpression) {
        saveXpathOrCssLocator(xpathExpression);
        return (WebDriverLocalWrapper) getInstanceWebDriver().findElement(By.xpath(xpathExpression));
    }

    private static void saveXpathOrCssLocator(String xpathOrCssLocator) {
        WebDriverLocalWrapper.xpathOrCssLocator = xpathOrCssLocator;
    }

    private static void saveByLocator(By byLocator) {
        WebDriverLocalWrapper.byLocator = byLocator;
    }

    private static By stringLocatorToByLocator(String xpathOrCssLocator) {

        if (xpathOrCssLocator.contains("//")) {
            return By.xpath(xpathOrCssLocator);
        } else return By.cssSelector(xpathOrCssLocator);

    }

    // Вызов поиска элемента, по cssSelector
    public static WebDriverLocalWrapper $s(String cssSelector) {
        saveXpathOrCssLocator(cssSelector);
        return (WebDriverLocalWrapper) getInstanceWebDriver().findElement(
                By.cssSelector(cssSelector));
    }

    public static WebDriverLocalWrapper $(By locator) {
        return (WebDriverLocalWrapper) getInstanceWebDriver().findElement(locator);
    }

    // Вызов поиска элемента, по тексту
    public static WebDriverLocalWrapper $text(String linkText) {
        return (WebDriverLocalWrapper) getInstanceWebDriver().findElement(
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

    public static WebDriverLocalWrapper shouldBe(ExpectedCondition<WebElement> webElementExpectedCondition) {
        WebDriverWait wait = new WebDriverWait(getInstanceWebDriver(), Duration.ofSeconds(15));
        return (WebDriverLocalWrapper) wait.until(webElementExpectedCondition);
    }

    public static WebElement shouldBe(WebConditionals webConditionals) {

        if (xpathOrCssLocator == null) throw new NullPointerException();

        WebDriverWait wait = new WebDriverWait(getInstanceWebDriver(), Duration.ofSeconds(15));

        return switch (webConditionals.name()) {
            case ("visible") ->
                    wait.until(ExpectedConditions.visibilityOfElementLocated(stringLocatorToByLocator(xpathOrCssLocator)));

            case ("present") ->
                    wait.until(ExpectedConditions.presenceOfElementLocated(stringLocatorToByLocator(xpathOrCssLocator)));
            default -> throw new IllegalStateException("Unexpected value");
        };
    }

}


