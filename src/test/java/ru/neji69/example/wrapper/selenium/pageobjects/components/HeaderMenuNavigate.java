package ru.neji69.example.wrapper.selenium.pageobjects.components;

import static ru.neji69.example.wrapper.selenium.utils.SeleniumWebDriverWrapperImpl.$x;

public interface HeaderMenuNavigate<T> {

    default T moveToElementsFromMenu(String menuName) {
        $x("//*[.='" + menuName + "']").moveToElement().perform();
        return (T) this;
    }

    default void clickToSubMenu(String subMenuName) {
        $x("//div[@id='nav_top']//*[text()='" + subMenuName + "']").click();
    }

    //Передвинуть курсор на пункт меню - Услуги и продукты
    default T navigateToServicesAndProductsMenu() {
        $x("//*[.='Услуги и продукты']").moveToElement().perform();
        return (T) this;
    }

    //Передвинуть курсор на пункт меню - Вакансии
    default T navigateToJobsMenu() {
        $x("//*[.='Вакансии']").moveToElement().perform();
        return (T) this;
    }

    //Передвинуть курсор на пункт меню - Блог
    default T navigateToBlogMenu() {
        $x("//*[.='Блог']").moveToElement().perform();
        return (T) this;
    }

    //Передвинуть курсор на пункт подменю - Тестирование сайта
    default void navigateToSiteTestingSubMenu() {
        $x("//div[@id='nav_top']//*[text()='Тестирование сайта']").click();
    }

    //Передвинуть курсор на пункт подменю - Функциональное тестирование
    default void navigateToFunctionalTestingSubMenu() {
        $x("//div[@id='nav_top']//*[text()='Функциональное тестирование']").click();
    }

    //Передвинуть курсор на пункт подменю - Автоматизация тестирования
    default void navigateToAutomationTestingSubMenu() {
        $x("//div[@id='nav_top']//*[text()='Автоматизация тестирования']").click();
    }

    //Передвинуть курсор на пункт подменю - Нагрузочное тестирование
    default void navigateToStressTestingSubMenu() {
        $x("//div[@id='nav_top']//*[text()='Нагрузочное тестирование']").click();
    }

    //Передвинуть курсор на пункт подменю - Тестирование мобильных приложений
    default void navigateToMobileApplicationTestingSubMenu() {
        $x("//div[@id='nav_top']//*[text()='Тестирование мобильных приложений']").click();
    }
}