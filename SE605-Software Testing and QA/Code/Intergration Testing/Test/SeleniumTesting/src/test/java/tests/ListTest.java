package tests;

import org.junit.Test;
import pages.ListPage;

public class ListTest extends BaseTest {

    @Test
    public void createList() {
        validLogin();
        createBoard("test_list_creation");

        ListPage listPage = new ListPage(driver);
        listPage.clickAddList();
        listPage.insertListName("not_the_list_name_i_want");
        listPage.clickCancelButton();

        createList("list_created_successfully");
    }

    @Test
    public void changeListName() {
        validLogin();
        createBoard("test_changing_list_name");
        createList("name_before_change");

        ListPage listPage = new ListPage(driver);
        listPage.clickListTitle("name_before_change");
        listPage.updateListName("name_after_change");
        listPage.clickUpdateListButton();
    }
}