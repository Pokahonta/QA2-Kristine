package page.Delfi.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import page.Delfi.DelfiFunctions;
import page.Delfi.helpers.CommentsHelper;

import java.util.List;

public class HP {
    private final By ARTICLE_HP = By.xpath("article");
    private final By TITLE_HP = By.xpath(".//h1[contains(@class, 'headline__title')]");
    private final By COMMENT_COUNTS_HP = By.xpath(".//a [contains(@class, 'comment-count')]");

    private DelfiFunctions df;

    public HP (DelfiFunctions df){
        this.df = df;
    }

    public static int getCommentsCount(int i) {
        return 0;
    }

    public String getTitleById(int id) {
        return getArticleById(id).findElement(TITLE_HP).getText();
    }

    public AP openArticle(int id){
        df.click(getArticleById(id));
        return new AP(df);
 //       getArticleById(id).click();

    }
    public WebElement getArticleById(int id) {
        List<WebElement> articles = df.findElements(ARTICLE_HP);
        Assertions.assertFalse(articles.isEmpty(), "There is no articles");
        return articles.get(id);
    }
    public int getCommentCount(int id) {
        int commentCount = 0;
        if (getCommentsById(id).isDisplayed()) {
            commentCount = CommentsHelper.parseCommentCount(getCommentsById(id).getText());
        }
        return commentCount;
    }

    public WebElement getCommentsById(int id){
        return getArticleById(id).findElement(COMMENT_COUNTS_HP);
    }

}
