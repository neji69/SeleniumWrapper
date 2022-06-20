package ru.neji69.example.wrapper.selenium.pageobjects;

import static ru.neji69.example.wrapper.selenium.utils.WebDriverLocalWrapper.$x;
import static ru.neji69.example.wrapper.selenium.utils.WebDriverLocalWrapper.moveToElement;

public abstract class PerformanceLabAbstractPage extends HeaderMenuComponent {

    @Override
    public void moveToElementsFromMenu(String menuName) {
        moveToElement($x("//*[.='" + menuName + "']")).perform();
    }

    @Override
    public void clickFromSubMenu(String subMenuName) {
        $x("//div[@id='nav_top']//*[text()='" + subMenuName + "']").click();
    }
}
