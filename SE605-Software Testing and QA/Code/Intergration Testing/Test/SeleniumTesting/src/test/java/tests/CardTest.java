package tests;

import org.junit.Test;
import pages.CardPage;

public class CardTest extends BaseTest {

    @Test
    public void createCard() {
        validLogin();
        createBoard("test_card_creation");
        createList("test_list");

        CardPage cardPage = new CardPage(driver);
        cardPage.clickAddCard();
        cardPage.insertCardName("not_the_card_name_i_want");
        cardPage.clickCancelCardButton();

        createCard("card_created_successfully");
    }

    @Test
    public void cardModalOpenClose() {
        validLogin();
        createBoard("modal_test");
        createList("test_list");
        createCard("card_for_modal_test");

        CardPage cardPage = new CardPage(driver);
        cardPage.CardModalOpen();
        cardPage.CardModalCross();
    }

    @Test
    public void cardAddComment() {
        validLogin();
        createBoard("commenting_test");
        createList("test_list");
        createCard("card_for_commenting_test");

        CardPage cardPage = new CardPage(driver);
        cardPage.CardModalOpen();
        cardPage.insertComment("testing commenting in the card");
        cardPage.saveComment();
        cardPage.CardModalCross();
    }

    @Test
    public void clickMembersButton() {
        validLogin();
        createBoard("members_button_test_board");
        createList("test_list");
        createCard("card_for_members_button_test_board");

        CardPage cardPage = new CardPage(driver);
        cardPage.CardModalOpen();
        cardPage.clickMembersButton();
        cardPage.clickMembersCross();
        cardPage.CardModalCross();
    }

    @Test
    public void selectTagsColor() {
        validLogin();
        createBoard("select_tags_color_test_board");
        createList("test_list");
        createCard("card_for_tags_color_test_board");

        CardPage cardPage = new CardPage(driver);
        cardPage.CardModalOpen();
        cardPage.clickTagsButton();
        cardPage.selectTagColor("green");
        cardPage.selectTagColor("red");
        cardPage.selectTagColor("blue");
        cardPage.deselectTagColor("red");
        cardPage.clickTagsCross();
        cardPage.CardModalCross();
    }

    @Test
    public void editCard() {
        validLogin();
        createBoard("editing_card");
        createList("test_list");
        createCard("card_for_editing_card");

        CardPage cardPage = new CardPage(driver);
        cardPage.CardModalOpen();

        cardPage.clickEditCard();
        cardPage.updateCardName("updated_card_name");
        cardPage.enterDescription("This is a description for the card.");
        cardPage.clickCancelEditButton();

        cardPage.clickEditCard();
        cardPage.updateCardName("updated_card_name");
        cardPage.enterDescription("This is a description for the card.");
        cardPage.clickSaveCardButton();

        cardPage.CardModalCross();
    }

    @Test
    public void deleteCard() {
        validLogin();
        createBoard("test_deleting_card");
        createList("test_list");
        createCard("card_will_be_deleted");

        CardPage cardPage = new CardPage(driver);
        cardPage.CardModalOpen();
        cardPage.clickDeleteCardButton();
    }
}