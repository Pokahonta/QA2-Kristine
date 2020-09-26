package page.object.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import page.object.BaseFunc;

import static org.openqa.selenium.By.xpath;

public class ArticlePage {
    private final By TITLE = xpath(".//h1[contains (@class, 'd-inline')]");
    private final By COMMENTS = xpath(".//a[contains(@class, 'd-print-none')]");
    private final By TIME = xpath(".// time[contains (@class, 'd-block')]");

    private final Logger LOGGER = LogManager.getLogger(this.getClass());
    private BaseFunc baseFunc;

    public ArticlePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;

        //besplatnie proverki- ne privetstvujutsja razrabotchikami
        Assertions.assertTrue(baseFunc.isElementPresents(TIME), "There is no time on Article page");
        LOGGER.info("We are on Article page");
    }

    public String getTitle(){
        LOGGER.info("Getting article title");

        return baseFunc.getText(TITLE).trim();
    }

    public CommentsPage openComments() {
        LOGGER.info("Try to open comments page");

            baseFunc.click(COMMENTS);
            return new CommentsPage(baseFunc);
    }

}
