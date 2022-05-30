package ru.neji69.example.wrapper.selenium.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.extension.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static ru.neji69.example.wrapper.selenium.utils.Utils.open;

public class DriverExtensions implements AfterEachCallback, BeforeEachCallback, ParameterResolver {

    WebDriver driver;

    @Override
    public void beforeEach(ExtensionContext context) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        open(driver, "https://mail.ru/");
    }

    @Override
    public void afterEach(ExtensionContext context) {
        driver.quit();
    }

    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext.getParameter().getType() == WebDriver.class;
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return driver;
    }
}
