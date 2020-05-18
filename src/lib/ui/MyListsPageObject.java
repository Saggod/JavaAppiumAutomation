package lib.ui;

import io.appium.java_client.AppiumDriver;

public class MyListsPageObject extends MainPageObject {

    public static final String
            FOLDER_BV_NAME_TPL = "xpath://*[@text = '{FOLDER_NAME}']",
            ARTICLE_BY_TITLE_TPL = "xpath://*[@text = '{TITLE}']";


    private static String getFolderXpathByName(String name_of_folder) {
        return FOLDER_BV_NAME_TPL.replace("{FOLDER_NAME}", name_of_folder);
    }

    private static String getSaveArticleXpathByTitle(String article_title) {
        return ARTICLE_BY_TITLE_TPL.replace("{TITLE}", article_title);
    }

    public MyListsPageObject(AppiumDriver driver) {
        super(driver);
    }

    public void openFolderByName(String name_of_folder) {
        String folder_name_xpath = getFolderXpathByName(name_of_folder);
        this.waitForElementAndClick(
              folder_name_xpath,
                "Cannot find folder by name " + name_of_folder,
                5
        );
    }

    public void waitForArticleToAppearByTitle(String article_title)
    {
        String article_xpath = getFolderXpathByName(article_title);
        this.waitForElementPresent(article_xpath, "CAnnot find saved article by title " + article_title, 15);
    }

    public void waitForArticleToDisappiearByTitle(String article_title)
    {
        String article_xpath = getFolderXpathByName(article_title);
        this.waitForElementNotPresent(article_xpath, "Saved article still present with title " + article_title, 15);
    }

    public void swipeByArticleToDelete(String article_title) {
        this.waitForArticleToAppearByTitle(article_title);
        String article_xpath = getFolderXpathByName(article_title);
        this.swipeElementToLeft(
                article_xpath,
                "Cannot find save article"
        );
        this.waitForArticleToDisappiearByTitle(article_title);
    }
    public void assertThereIsNoArticleWithsThatTitle(String article_title)
    {
        String article_xpath = getSaveArticleXpathByTitle(article_title);
        this.assertElementNotPresent(article_xpath, "We've found deleted article title in the My List");
    }

    public void waitForTitleArticleAndOpenIt(String article_title)
    {
        String article_xpath = getSaveArticleXpathByTitle(article_title);
        this.waitForElementAndClick(
                article_xpath,
                "Cannot open article with title " + article_title,
                5
        );
    }

}
