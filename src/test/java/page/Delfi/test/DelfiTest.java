package page.Delfi.test;

import org.junit.jupiter.api.Test;
import page.Delfi.DelfiFunctions;
import page.Delfi.pages.AP;
import page.Delfi.pages.CP;
import page.Delfi.pages.HP;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class DelfiTest {

    @Test
    public void delfiTest(){
        DelfiFunctions df = new DelfiFunctions();
        df.openPage("delfi.lv");

        HP homePage = new HP(df);
        String homePageTitle = homePage.getTitleById(2);
        AP articlePage = homePage.openArticle(2);
  //      AP articlePage = new AP(df);

        assertEquals(homePageTitle, articlePage.getTitle(),"Wrong title on article page");

        CP commentsPage = articlePage.openComments();
        assertEquasls (homePageTitle, commentsPage.getTitle(),"Wrong title");

        // HomePage homePage = new HomePage(baseFunc); //создаем копию главной стр
         int COMMENT_COUNTS_HP = HP.getCommentsCount(2);
        //   ArticlePage articlePage = homePage.openArticle(2);
        assertEquals(COMMENT_COUNTS_HP,articlePage.getComments(),"Wrong comments count on article page");
        
        //CP commentsPage = articlePage.openComments();
        assertEquals(COMMENT_COUNTS_HP,commentsPage.getComments(2), "Wrong comments count");

    }

    private void assertEquasls(String homePageTitle, String title, String wrong_title) {
    }
}
