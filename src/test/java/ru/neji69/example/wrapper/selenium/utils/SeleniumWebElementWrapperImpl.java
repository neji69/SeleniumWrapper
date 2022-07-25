package ru.neji69.example.wrapper.selenium.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

/**
 * Класс обертка для WebElement'a.
 */
public class SeleniumWebElementWrapperImpl implements SeleniumWebElementWrapper {

    private WebDriver webDriver;
    private WebElement webElement;
    private String xpathExpression;

    public SeleniumWebElementWrapperImpl(WebDriver webDriver, WebElement webElement, String xpathExpression) {
        this.webDriver = webDriver;
        this.webElement = webElement;
        this.xpathExpression = xpathExpression;
    }

    /**
     * Метод для проверки состояния WebElement'а на странице.
     */
    @Override
    public WebElement shouldBe(WebConditionals webConditionals) {
        if (xpathExpression == null) throw new NullPointerException("XpathExpression == null");

        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(15));

        return switch (webConditionals.getWebConditionalName()) {
            case ("visible") -> wait.until(ExpectedConditions.visibilityOf(webElement));

            case ("present") -> wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpathExpression)));
            default ->
                    throw new IllegalStateException("Unexpected value - " + webConditionals.getWebConditionalName() + " " +
                            "You are using a method with an unknown input parameter. " +
                            "Use one of ru.neji69.example.wrapper.selenium.utils.WebConditionals");
        };
    }

    /**
     * Метод для выполнения javaScript над WebElement'ом на странице.
     */
    @Override
    public void executeJavaScript(String script) {
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript(script, webElement);
    }

    /**
     * Метод двигает курсор пока он не окажется над WebElement'ом на странице.
     */
    @Override
    public Actions moveToElement() {
        Actions actions = new Actions(webDriver);
        return actions.moveToElement(webElement);
    }

    // Делегирую управление классу "RemoteWebElement"
    @Override
    public void click() {
        webElement.click();
    }

    // Делегирую управление классу "RemoteWebElement"
    @Override
    public void submit() {
        webElement.submit();
    }

    // Делегирую управление классу "RemoteWebElement"
    @Override
    public void sendKeys(CharSequence... keysToSend) {
        webElement.sendKeys(keysToSend);
    }

    // Делегирую управление классу "RemoteWebElement"
    @Override
    public void clear() {
        webElement.clear();
    }

    // Делегирую управление классу "RemoteWebElement"
    @Override
    public String getTagName() {
        return webElement.getTagName();
    }

    // Делегирую управление классу "RemoteWebElement"
    @Override
    public String getAttribute(String name) {
        return webElement.getAttribute(name);
    }

    // Делегирую управление классу "RemoteWebElement"
    @Override
    public boolean isSelected() {
        return webElement.isSelected();
    }

    // Делегирую управление классу "RemoteWebElement"
    @Override
    public boolean isEnabled() {
        return webElement.isEnabled();
    }

    // Делегирую управление классу "RemoteWebElement"
    @Override
    public String getText() {
        return webElement.getText();
    }

    // Делегирую управление классу "RemoteWebElement"
    @Override
    public List<WebElement> findElements(By by) {
        return webElement.findElements(by);
    }

    // Делегирую управление классу "RemoteWebElement"
    @Override
    public WebElement findElement(By by) {
        return webElement.findElement(by);
    }

    // Делегирую управление классу "RemoteWebElement"
    @Override
    public boolean isDisplayed() {
        return webElement.isDisplayed();
    }

    // Делегирую управление классу "RemoteWebElement"
    @Override
    public Point getLocation() {
        return webElement.getLocation();
    }

    // Делегирую управление классу "RemoteWebElement"
    @Override
    public Dimension getSize() {
        return webElement.getSize();
    }

    // Делегирую управление классу "RemoteWebElement"
    @Override
    public Rectangle getRect() {
        return webElement.getRect();
    }

    // Делегирую управление классу "RemoteWebElement"
    @Override
    public String getCssValue(String propertyName) {
        return webElement.getCssValue(propertyName);
    }

    // Делегирую управление классу "RemoteWebElement"
    @Override
    public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
        return webElement.getScreenshotAs(target);
    }
}
