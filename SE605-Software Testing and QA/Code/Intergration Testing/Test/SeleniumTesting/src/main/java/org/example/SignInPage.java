package com.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignInPage {
    private WebDriver driver;

    // Web elements using @FindBy annotation
    @FindBy(id = "user_email")
    private WebElement emailField;

    @FindBy(id = "user_password")
    private WebElement passwordField;

    @FindBy(css = "button")
    private WebElement signInButton;

    @FindBy(css = "span:nth-child(3)")
    private WebElement welcomeMessage;

    @FindBy(css = ".fa-sign-out")
    private WebElement signOutIcon;

    @FindBy(css = "#crawler-sign-out > span")
    private WebElement signOutLink;

    // Constructor
    public SignInPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); // Initialize elements
    }

    // Methods to interact with the page
    public void navigateToSignIn() {
        driver.get("http://localhost:4000/sign_in");
    }

    public void enterEmail(String email) {
        emailField.click();
        emailField.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordField.click();
        passwordField.sendKeys(password);
    }

    public void clickSignInButton() {
        signInButton.click();
    }

    public boolean isWelcomeMessageDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(welcomeMessage));
        return welcomeMessage.isDisplayed();
    }

    public boolean isSignOutIconDisplayed() {
        return signOutIcon.isDisplayed();
    }

    public void clickSignOut() {
        signOutLink.click();
    }

    // Combined method for signing in
    public void signIn(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickSignInButton();
    }
}