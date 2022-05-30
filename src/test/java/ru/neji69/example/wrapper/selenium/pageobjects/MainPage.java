package ru.neji69.example.wrapper.selenium.pageobjects;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MainPage {

    public WebDriver driver;

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//*[@data-testid='news-content']")
    private WebElement newsContent;

    @FindBy(xpath = "//*[@data-testid='general-news-item-rb']")
    private List<WebElement> generalNewsItemRb;

    @FindBy(xpath = "//*[@data-testid='extra-news-item-ml']")
    private List<WebElement> extraNewsItemMl;

    @FindBy(xpath = "//*[@data-testid='news-item-title']")
    private List<WebElement> newsItemsTitle;

    public WebElement getNewsContent() {
        return newsContent;
    }

    public List<WebElement> getGeneralNewsItemRb() {
        return generalNewsItemRb;
    }

    public List<WebElement> getExtraNewsItemMl() {
        return extraNewsItemMl;
    }

    public List<WebElement> getNewsItemsTitle() {
        return newsItemsTitle;
    }

    public WebElement choiceNewsItemFromList(int number) {
        try {
            return newsItemsTitle.get(number);
        } catch (IndexOutOfBoundsException exception) {
            throw new NoSuchElementException("Номер выбранной новости не соответствует количеству в Списке");
        }
    }
}
