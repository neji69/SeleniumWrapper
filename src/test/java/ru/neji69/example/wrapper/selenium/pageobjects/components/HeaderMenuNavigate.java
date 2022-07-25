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

    default T navigateToServicesAndProductsMenu() {
        $x("//*[.='Услуги и продукты']").moveToElement().perform();
        return (T) this;
    }

    default T navigateToJobsMenu() {
        $x("//*[.='Вакансии']").moveToElement().perform();
        return (T) this;
    }

    default T navigateToBlogMenu() {
        $x("//*[.='Блог']").moveToElement().perform();
        return (T) this;
    }

    default void navigateToSiteTestingSubMenu() {
        $x("//div[@id='nav_top']//*[text()='Тестирование сайта']").click();
    }

    default void navigateToFunctionalTestingSubMenu() {
        $x("//div[@id='nav_top']//*[text()='Функциональное тестирование']").click();
    }

    default void navigateToAutomationTestingSubMenu() {
        $x("//div[@id='nav_top']//*[text()='Автоматизация тестирования']").click();
    }

    default void navigateToStressTestingSubMenu() {
        $x("//div[@id='nav_top']//*[text()='Нагрузочное тестирование']").click();
    }

    default void navigateToMobileApplicationTestingSubMenu() {
        $x("//div[@id='nav_top']//*[text()='Тестирование мобильных приложений']").click();
    }
}