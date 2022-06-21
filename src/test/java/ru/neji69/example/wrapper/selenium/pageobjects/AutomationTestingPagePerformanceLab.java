package ru.neji69.example.wrapper.selenium.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static ru.neji69.example.wrapper.selenium.utils.WebDriverLocalWrapper.*;

public class AutomationTestingPagePerformanceLab extends PerformanceLabAbstractPage {

    String s = "//iframe[@id='hubspot-Modal-Iframe']";
    public String getImageXpath() {
        return "//strong[text()= 'Узнайте как мы помогли банку из ТОП-10 автоматизировать тестирование']//..//following-sibling::p//img";
    }

    public void scrollToElement(String xpathLocator){
        executeJavaScript("arguments[0].scrollIntoView(true);", $x(xpathLocator));
    }

    public void clickToImageAndCheckFormContact(){
        scrollToElement(getImageXpath());
        $x(getImageXpath()).click();
        WebDriverWait wait = new WebDriverWait(getInstanceWebDriver(), Duration.ofSeconds(7));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By
                .xpath("//iframe[@id='hubspot-Modal-Iframe']")));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By
                .xpath("//iframe[@id='hs-form-iframe-0']")));
        shouldBe(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='скачивание брошюры']")));
        $x("//*[text()='скачивание брошюры']");

    }
}
