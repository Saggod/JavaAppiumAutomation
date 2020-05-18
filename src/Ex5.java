import lib.CoreTestCase;
import lib.ui.ArticlePageObject;
import lib.ui.MyListsPageObject;
import lib.ui.NavigationUI;
import lib.ui.SearchPageObject;
import org.junit.Test;

public class Ex5 extends CoreTestCase {


    @Test
    public void testSaveTwoArticleToMyListAndOneDelete() {

        SearchPageObject SearchPageObject = new SearchPageObject(driver);

        SearchPageObject.initSearchInput();
        SearchPageObject.typeSearchLine("Java");
        SearchPageObject.clickByArticleWithSubstring("Object-oriented programming language");

        ArticlePageObject ArticlePageObject = new ArticlePageObject(driver);
        ArticlePageObject.waitForTitleElement();
        String first_article_title = ArticlePageObject.getArticleTitle();
        String name_of_folder = "My Test Lists";
        ArticlePageObject.addArticleToMyList(name_of_folder);

        String second_article_title = "Java";
        ArticlePageObject.initSearchInput();
        SearchPageObject.typeSearchLine("JavaScript");
        SearchPageObject.clickByArticleWithSubstring(second_article_title);
        ArticlePageObject.addArticleToMyCreatedList(name_of_folder);
        ArticlePageObject.closeArticle();

        NavigationUI NavigationUI = new NavigationUI(driver);
        NavigationUI.clickMyLists();

        MyListsPageObject MyListsPageObject = new MyListsPageObject(driver);
        MyListsPageObject.openFolderByName(name_of_folder);
        MyListsPageObject.swipeByArticleToDelete(first_article_title);
        MyListsPageObject.assertThereIsNoArticleWithsThatTitle(first_article_title);
        MyListsPageObject.waitForTitleArticleAndOpenIt(second_article_title);

        assertEquals(
                "Cannot find title of remaining article",
                ArticlePageObject.getArticleTitle(), second_article_title);
    }


}
