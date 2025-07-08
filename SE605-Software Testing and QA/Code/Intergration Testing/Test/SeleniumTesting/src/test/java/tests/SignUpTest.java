package tests;
import org.junit.Test;
import org.junit.Assert;
import pages.SignUpPage;

public class SignUpTest extends BaseTest {

    @Test
    public void registerWithValidData() {
        registerUser("Arfat", "Ayon", "aaaaa@gmail.com", "12345678");
        // Add assertion for successful registration if possible
    }

    @Test
    public void registerWithInsufficientData() {
        SignUpPage signUpPage = new SignUpPage(driver);
        signUpPage.clickRegisterUser();
        signUpPage.enterEmail("asasa87@gmail.com");
        signUpPage.enterPassword("12345678");
        signUpPage.enterPasswordConfirmation("12345678");
        signUpPage.clickRegisterButton();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals("http://localhost:4000/sign_up", currentUrl);
    }
}