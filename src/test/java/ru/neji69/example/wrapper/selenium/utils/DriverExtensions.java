package ru.neji69.example.wrapper.selenium.utils;

import org.junit.jupiter.api.extension.*;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class DriverExtensions implements AfterEachCallback, BeforeEachCallback {

    private final WebDriver driver = WebDriverLocalWrapper.getInstanceWebDriver();

    @Override
    public void beforeEach(ExtensionContext context) {
        //Страница перфоманс лаб очень долго прогружается.
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(90));
        driver.manage().window().maximize();
    }

    @Override
    // закрываем вебдрайвер после прохождения теста.
    public void afterEach(ExtensionContext context) {
        if (driver != null) driver.quit();
    }
}
