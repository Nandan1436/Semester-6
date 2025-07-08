package tests;

import org.junit.Before;
import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import pages.*;

public abstract class BaseTest {
    protected WebDriver driver;
    protected WebDriverWait wait;

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "/usr/local/bin/geckodriver");
        FirefoxOptions options = new FirefoxOptions();
        options.setBinary("/opt/firefox/firefox");
        driver = new FirefoxDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @After
    public void tearDown() {
        if (driver != null) driver.quit();
    }

    // --- Common helpers for all tests ---
    protected void validLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goToLoginPage();
        loginPage.insertEmail("john@phoenix-trello.com");
        loginPage.insertPassword("12345678");
        loginPage.clickLogin();
        wait.until(org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated(
                org.openqa.selenium.By.id("add_new_board")));
    }

    protected void createBoard(String boardName) {
        BoardPage boardPage = new BoardPage(driver);
        boardPage.clickAddNewBoard();
        boardPage.insertBoardName(boardName);
        boardPage.clickCreateBoard();
        try { Thread.sleep(50); } catch (InterruptedException ignored) {}
    }

    protected void createList(String listName) {
        ListPage listPage = new ListPage(driver);
        listPage.clickAddList();
        listPage.insertListName(listName);
        listPage.clickAddListButton();
        try { Thread.sleep(50); } catch (InterruptedException ignored) {}
    }

    protected void createCard(String cardName) {
        CardPage cardPage = new CardPage(driver);
        cardPage.clickAddCard();
        cardPage.insertCardName(cardName);
        cardPage.clickAddCardButton();
        try { Thread.sleep(50); } catch (InterruptedException ignored) {}
    }

    protected void registerUser(String firstName, String lastName, String email, String password) {
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.clickRegisterUser();
        signUpPage.enterFirstName(firstName);
        signUpPage.enterLastname(lastName);
        signUpPage.enterEmail(email);
        signUpPage.enterPassword(password);
        signUpPage.enterPasswordConfirmation(password);
        signUpPage.clickRegisterButton();
    }
}