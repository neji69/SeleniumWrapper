package ru.neji69.example.wrapper.selenium.pageobjects;

public abstract class HeaderSubMenuComponent {

    public static final String SITE_TESTING = "Тестирование сайта";
    public static final String FUNCTIONAL_TESTING = "Функциональное тестирование";
    public static final String AUTOMATION_TESTING = "Автоматизация тестирования";
    public static final String STRESS_TESTING = "Нагрузочное тестирование";
    public static final String MOBILE_APPLICATION_TESTING = "Тестирование мобильных приложений";
    public static final String OPERATIVE_HELP = "Оперативная помощь";

    public abstract void clickFromSubMenu(String subMenuName);
}
