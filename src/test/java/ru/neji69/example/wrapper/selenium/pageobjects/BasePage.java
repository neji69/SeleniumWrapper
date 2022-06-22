package ru.neji69.example.wrapper.selenium.pageobjects;

import ru.neji69.example.wrapper.selenium.pageobjects.components.HeaderMenu;
import ru.neji69.example.wrapper.selenium.pageobjects.components.HeaderMenuNavigate;

public abstract class BasePage<T> implements HeaderMenuNavigate<T> {
    private final HeaderMenu headerMenu = new HeaderMenu();

    public HeaderMenu getHeaderMenu() {
        return headerMenu;
    }
}
