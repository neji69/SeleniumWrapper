package ru.neji69.example.wrapper.selenium.pageobjects.components;

import static ru.neji69.example.wrapper.selenium.utils.WebDriverLocalWrapper.$x;
import static ru.neji69.example.wrapper.selenium.utils.WebDriverLocalWrapper.moveToElement;

public interface HeaderMenuNavigate<T> {

    default T moveToElementsFromMenu(String menuName) {
        moveToElement($x("//*[.='" + menuName + "']")).perform();
        return (T) this;
    }

    default void clickToSubMenu(String subMenuName) {
        $x("//div[@id='nav_top']//*[text()='" + subMenuName + "']").click();
    }

}