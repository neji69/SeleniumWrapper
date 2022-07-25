package ru.neji69.example.wrapper.selenium.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.neji69.example.wrapper.selenium.utils.WebConditionals;

import java.time.Duration;

import static ru.neji69.example.wrapper.selenium.utils.SeleniumWebDriverWrapperImpl.$x;
import static ru.neji69.example.wrapper.selenium.utils.SeleniumWebDriverWrapperImpl.getInstanceWebDriver;

public class AutomationTestingPage extends BasePage<AutomationTestingPage> {

    public void scrollToElement(String xpathLocator) {
        $x(xpathLocator).executeJavaScript("arguments[0].scrollIntoView(true);");
    }

    //Проскрулить до картинки "автоматизация тестирования" и кликнуть на нее.
    public AutomationTestingPage clickToImage() {
        scrollToElement("//img[@alt='автоматизация тестирования']");
        $x("//img[@alt='автоматизация тестирования']").click();
        return this;
    }

    // проверить, что открылась форма для заполнения контактов.
    public AutomationTestingPage checkFormContact() {

        WebDriverWait wait = new WebDriverWait(getInstanceWebDriver(), Duration.ofSeconds(7));

        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By
                .xpath("//iframe[@id='hubspot-Modal-Iframe']")));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By
                .xpath("//iframe[@id='hs-form-iframe-0']")));

        $x("//*[text()='скачивание брошюры']").shouldBe(WebConditionals.VISIBLE);
        return this;
    }
}
