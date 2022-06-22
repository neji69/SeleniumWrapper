package ru.neji69.example.wrapper.selenium.pageobjects.components;

public class HeaderMenu<T> {
    private final SubMenu subMenu;

    //При создании обьекта Меню , получаем экземпляр обьекта подменю. Так как это вложенная структура.
    public HeaderMenu() {
        this.subMenu = new SubMenu();
    }

    public SubMenu getSubMenu() {
        return subMenu;
    }

    //Заголовки главного-центрального Меню.
    public final String SERVICES_AND_PRODUCTS_MENU = "Услуги и продукты";
    public final String JOBS_MENU = "Вакансии";
    public final String BLOG_MENU = "Блог";

    public class SubMenu {

        public final String SITE_TESTING = "Тестирование сайта";
        public final String FUNCTIONAL_TESTING = "Функциональное тестирование";
        public final String AUTOMATION_TESTING = "Автоматизация тестирования";
        public final String STRESS_TESTING = "Нагрузочное тестирование";
        public final String MOBILE_APPLICATION_TESTING = "Тестирование мобильных приложений";
        public final String OPERATIVE_HELP = "Оперативная помощь";

    }
}
