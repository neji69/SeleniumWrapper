package ru.neji69.example.wrapper.selenium.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.neji69.example.wrapper.selenium.utils.WebConditionals;

import java.time.Duration;

import static ru.neji69.example.wrapper.selenium.utils.WebDriverLocalWrapper.*;

public class AutomationTestingPage extends BasePage<AutomationTestingPage> {

    public String getImageXpath() {
        return "//img[@alt='автоматизация тестирования']";
    }

    public void scrollToElement(String xpathLocator) {
        executeJavaScript("arguments[0].scrollIntoView(true);", $x(xpathLocator));
    }

    public AutomationTestingPage clickToImage() {
        scrollToElement(getImageXpath());
        $x(getImageXpath()).click();
        return this;
    }

    public AutomationTestingPage checkFormContact() {

        WebDriverWait wait = new WebDriverWait(getInstanceWebDriver(), Duration.ofSeconds(7));

        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By
                .xpath("//iframe[@id='hubspot-Modal-Iframe']")));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By
                .xpath("//iframe[@id='hs-form-iframe-0']")));

//        shouldBe(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='скачивание брошюры']")));
        $x("//*[text()='скачивание брошюры']").shouldBe(WebConditionals.VISIBLE);

        return this;
    }
}
