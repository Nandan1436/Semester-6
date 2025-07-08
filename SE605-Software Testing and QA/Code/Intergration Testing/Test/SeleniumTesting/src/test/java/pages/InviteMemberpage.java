package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InviteMemberpage {
    private WebDriver driver;

    private By addMemberButton = By.cssSelector("li > .add-new");
    private By emailInput = By.id("crawljax_member_email");
    private By submitButton = By.cssSelector("button");

    public InviteMemberpage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickInviteMember() {
        driver.findElement(addMemberButton).click();
    }

    public void enterEmail(String email) {
        driver.findElement(emailInput).click();
        driver.findElement(emailInput).sendKeys(email);
    }

    public void submitInvite() {
        driver.findElement(submitButton).click();
    }
}
