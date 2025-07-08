package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CommentPage {
    private WebDriver driver;

    // Locators
    private By board = By.cssSelector("#\\38-first-board > .inner");
    private By card = By.cssSelector(".card-content");
    private By commentTextArea = By.cssSelector("textarea");
    private By submitButton = By.cssSelector("button");

    public CommentPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openBoard() {
        driver.findElement(board).click();
    }

    public void openCard() {
        driver.findElement(card).click();
    }

    public void addComment(String comment) {
        driver.findElement(commentTextArea).click();
        driver.findElement(commentTextArea).sendKeys(comment);
        driver.findElement(submitButton).click();
    }
}
