package ru.neji69.example.wrapper.selenium.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public interface SeleniumWebElementWrapper extends WebElement {

    WebElement shouldBe(WebConditionals webConditionals);

    void executeJavaScript(String script);

    Actions moveToElement();
}