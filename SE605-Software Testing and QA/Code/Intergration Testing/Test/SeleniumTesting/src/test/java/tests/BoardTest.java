package tests;

import org.junit.Test;
import org.junit.Assert;
import pages.BoardPage;

public class BoardTest extends BaseTest {

    @Test
    public void createBoard() {
        validLogin();
        createBoard("board_01");
        String currentUrl = driver.getCurrentUrl();
        Assert.assertNotEquals("http://localhost:4000/", currentUrl);
    }

    @Test
    public void clickCreateBoardButCancel() {
        validLogin();
        BoardPage boardPage = new BoardPage(driver);
        boardPage.clickAddNewBoard();
        boardPage.insertBoardName("board_01");
        boardPage.clickCancelBoard();
    }

    @Test
    public void clickBoardsDropdownAndSelectABoard() {
        validLogin();
        BoardPage boardPage = new BoardPage(driver);
        createBoard("test_board_dropdown");
        boardPage.clickBoardsDropdown();
        boardPage.clickBoardsDropdownItem("test_board_dropdown");
    }

    @Test
    public void clickBoardsDropdownAndViewAllBoards() {
        validLogin();
        BoardPage boardPage = new BoardPage(driver);
        boardPage.clickBoardsDropdown();
        boardPage.clickViewAllBoards();
    }
}