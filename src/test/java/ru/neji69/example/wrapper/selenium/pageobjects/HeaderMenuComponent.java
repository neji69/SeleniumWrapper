package ru.neji69.example.wrapper.selenium.pageobjects;

public abstract class HeaderMenuComponent extends HeaderSubMenuComponent {

    public static final String SERVICES_AND_PRODUCTS_MENU = "Услуги и продукты";
    public static final String JOBS_MENU = "Вакансии";
    public static final String BLOG_MENU = "Блог";

    public abstract void moveToElementsFromMenu(String menuName);
}
