package ru.neji69.example.wrapper.selenium.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static ru.neji69.example.wrapper.selenium.utils.WebDriverLocalWrapper.*;

public class MainPage extends HeaderSubMenuComponent {

    public MainPage closePopUp() {
        shouldBe(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@data-gr='popup-container']")));
        executeJavaScript("arguments[0].remove()", $x("//div[@data-gr='popup-container']"));
        return this;
    }

    @Override
    public MainPage moveToElementsFromMenu(String menuName) {
        moveToElement($x("//*[.='" + menuName + "']")).perform();
        return this;
    }

    @Override
    public void clickFromSubMenu(String subMenuName) {
        $x("//div[@id='nav_top']//*[text()='" + subMenuName + "']").click();
    }

}
