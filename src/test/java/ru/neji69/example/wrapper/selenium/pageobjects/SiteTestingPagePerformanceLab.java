package ru.neji69.example.wrapper.selenium.pageobjects;

import static ru.neji69.example.wrapper.selenium.utils.WebDriverLocalWrapper.$x;

public class SiteTestingPagePerformanceLab extends PerformanceLabAbstractPage {

    public String getCheckPricesButton() {
        return "//*[text()='Узнать цены']/parent::*/parent::a";
    }

    public String getBackgroundColorElement(String webElement) {
        return $x(webElement).getCssValue("background-color");
    }
}
