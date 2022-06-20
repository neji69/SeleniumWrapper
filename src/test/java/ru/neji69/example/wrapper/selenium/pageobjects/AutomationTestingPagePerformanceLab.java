package ru.neji69.example.wrapper.selenium.pageobjects;

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
        switchTo().frame($x("//iframe[@id='hubspot-Modal-Iframe']"));
        $x("//*[text()='скачивание брошюры']");
    }
}
