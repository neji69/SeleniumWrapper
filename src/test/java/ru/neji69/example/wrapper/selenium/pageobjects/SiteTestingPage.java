package ru.neji69.example.wrapper.selenium.pageobjects;

import static ru.neji69.example.wrapper.selenium.utils.SeleniumWebDriverWrapperImpl.$x;

public class SiteTestingPage extends BasePage<AutomationTestingPage> {

    // Получаем цвет елемента-кнопки со страницы.
    public String getBackgroundColorElement() {
        return $x("//*[text()='Узнать цены']/parent::*/parent::a").getCssValue("background-color");
    }
}
