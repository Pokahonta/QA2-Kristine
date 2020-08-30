package page.HomeworkDelfi.pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import page.HomeworkDelfi.BaseDelfi;

import java.util.List;

public class HomePage {
    private final By ARTICLE = By.tagName("article");
    private final By TITLE = By.xpath(".//h1 [contains (@class, 'headline__title')]");

    private BaseDelfi baseDelfi;

    public HomePage(BaseDelfi baseDelfi){
        this.baseDelfi = baseDelfi;
    }
    public String  getTitleById(int id) {
        return getArticleById(id).findElement(TITLE).getText();
    }

    public  ArticlePage openArticle(int id) {
        baseDelfi.click(getArticleById(id));
        return new ArticlePage(baseDelfi);
    }

    public WebElement getArticleById(int id) {
        List<WebElement> articles = baseDelfi.findElements(ARTICLE);
        Assertions.assertFalse(articles.isEmpty(), "There is no articles");
        return articles.get(id);
    }
}
