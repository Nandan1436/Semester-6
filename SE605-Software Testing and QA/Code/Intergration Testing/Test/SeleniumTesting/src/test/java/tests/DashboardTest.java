package tests;

import org.junit.Test;
import org.junit.Assert;
import pages.DashboardPage;
import pages.BoardPage;

public class DashboardTest extends BaseTest {

    @Test
    public void loginAndLogout() {
        validLogin();
        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.clickLogout();
        // Add assertion for logout if possible
    }

    @Test
    public void clickPhoenixLogoNavigatesToDashboard() {
        validLogin();
        BoardPage boardPage = new BoardPage(driver);
        boardPage.clickAddNewBoard();
        boardPage.insertBoardName("board_01");
        boardPage.clickCreateBoard();

        DashboardPage dashboardPage = new DashboardPage(driver);
        dashboardPage.clickPhoenixLogo();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals("http://localhost:4000/", currentUrl);
    }
}