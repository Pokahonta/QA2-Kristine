package page.HomeworkDelfi.test;

import org.junit.jupiter.api.Test;
import page.HomeworkDelfi.BaseDelfi;
import page.HomeworkDelfi.pages.ArticlePage;
import page.HomeworkDelfi.pages.HomePage;

public class DelfiTests {
    @Test
    public void delfiTests() {
        BaseDelfi baseDelfi = new BaseDelfi();
        baseDelfi.openPage("delfi.lv");

        HomePage homePage = new HomePage(baseDelfi);
        String homePageTitle = homePage.getTitleById(2);
        ArticlePage articlePage = homePage.openArticle(2);
    }
}
