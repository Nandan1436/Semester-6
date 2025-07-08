package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class InvitePage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public InvitePage(WebDriver driver) {
        this.driver = driver; // url : http://localhost:4000/boards/board_id
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickAddNewUser() {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".fa-plus"))).click();
    }
    public void insertUserEmail(String email) {
        wait.until(ExpectedConditions.elementToBeClickable(By.id("crawljax_member_email"))).sendKeys(email);
    }
    public void clickAddUserButton() {
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button"))).click();
    }
    public void clickCancel() {
        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("cancel"))).click();
    }
}
