package page.object.tests;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;
import page.object.BaseFunc;
import page.object.pages.ArticlePage;
import page.object.pages.CommentsPage;
import page.object.pages.HomePage;

import static org.junit.jupiter.api.Assertions.*;

public class PageObjectTest {
    private final Logger LOGGER = LogManager.getLogger(this.getClass());
    @Test
    public void pageObjectTest() {
        LOGGER.info("This test will check article title on Home, Article and Comments pages");

        BaseFunc baseFunc = new BaseFunc();
        baseFunc.openPage("delfi.lv");

        //sejchas budem rabotatj s glavnoj stranicej Home Page
        HomePage homePage = new HomePage(baseFunc);     //peredaem nuznij parametr = basefunc
        String homePageTitle = homePage.getTitleById(2);
        //perehod na stranicu statj
        ArticlePage articlePage = homePage.openArticle(2);

        assertEquals(homePageTitle, articlePage.getTitle(), "Wrong title on article page");

        CommentsPage commentsPage = articlePage.openComments();
        assertEquals(homePageTitle, commentsPage.getTitle(), "Wrong title on Comment page");
    }
}
