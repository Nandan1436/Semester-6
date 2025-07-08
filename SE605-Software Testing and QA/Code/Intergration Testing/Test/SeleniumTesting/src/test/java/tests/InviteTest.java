package tests;

import org.junit.Test;
import pages.InvitePage;


public class InviteTest extends BaseTest {

    @Test
    public void addAnotherMemberToBoard() {
        registerUser("Arafat", "Ayon", "abcdefgh@gmail.com", "12345678");
        validLogin();
        createBoard("test_user_addition");

        InvitePage invitePage = new InvitePage(driver);
        invitePage.clickAddNewUser();
        invitePage.insertUserEmail("not the email I want");
        invitePage.clickCancel();

        invitePage.clickAddNewUser();
        invitePage.insertUserEmail("abcdefgh@gmail.com");
        invitePage.clickAddUserButton();
        try { Thread.sleep(500); } catch (InterruptedException ignored) {}
    }
}