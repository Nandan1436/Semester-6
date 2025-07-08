package tests;
import org.junit.Test;
import org.junit.Assert;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void loginWithValidCredentialsSucceeds() {
        validLogin();
        // Add assertion for successful login if possible
    }

    @Test
    public void loginWithEmptyFields() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goToLoginPage();
        String urlBefore = driver.getCurrentUrl();
        loginPage.insertEmail("");
        loginPage.insertPassword("");
        loginPage.clickLogin();
        try { Thread.sleep(500); } catch (InterruptedException ignored) {}
        String urlAfter = driver.getCurrentUrl();
        Assert.assertEquals(urlBefore, urlAfter);
    }

    @Test
    public void loginWithInvalidCredentialsShowsError() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.goToLoginPage();
        String urlBefore = driver.getCurrentUrl();
        loginPage.insertEmail("abcdef");
        loginPage.insertPassword("1234567as8");
        loginPage.clickLogin();
        try { Thread.sleep(500); } catch (InterruptedException ignored) {}
        String urlAfter = driver.getCurrentUrl();
        Assert.assertEquals(urlBefore, urlAfter);
    }
}