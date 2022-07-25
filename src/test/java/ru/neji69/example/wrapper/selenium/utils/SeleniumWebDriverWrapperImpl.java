package ru.neji69.example.wrapper.selenium.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;

import java.util.ArrayList;

/**
 * Класс обертка для WebDriver'a.
 */
public class SeleniumWebDriverWrapperImpl implements SeleniumWebDriverWrapper {

    // Позволяет в одном потоке хранить один вебдрайвер.
    private static final ThreadLocal<WebDriver> THREAD_LOCAL = ThreadLocal.withInitial(() ->
            WebDriverManager.chromedriver().create());

    // Получаем инстанс драйвера.
    public static WebDriver getInstanceWebDriver() {
        return THREAD_LOCAL.get();
    }

    /**
     * Метод ищет элемент на странице и создает его экземпляр через конструктор SeleniumWebElementWrapperImpl.
     */
    public static SeleniumWebElementWrapper $x(String xpathExpression) {
        return new SeleniumWebElementWrapperImpl(getInstanceWebDriver()
                , getInstanceWebDriver().findElement(By.xpath(xpathExpression))
                , xpathExpression);
    }

    /**
     * Открыть в браузере веб сайт по переданному url.
     */
    public static void open(String relativeOrAbsoluteUrl) {
        getInstanceWebDriver().get(relativeOrAbsoluteUrl);
    }

    /**
     * Перключиться на...
     */
    public static WebDriver.TargetLocator switchTo() {
        return getInstanceWebDriver().switchTo();
    }

    /**
     * Получить список окон
     */
    public static ArrayList<String> getWindows() {
        return new ArrayList<>(getInstanceWebDriver().getWindowHandles());
    }
}
