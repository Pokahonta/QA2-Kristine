package page.Delfi.pages;

import org.openqa.selenium.By;
import page.Delfi.DelfiFunctions;
import page.Delfi.helpers.CommentsHelper;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AP {

    private final By TITLE_AP = By.xpath(".//h1[contains(@class, 'd-inline')]");
    private final By COMMENT_COUNT_AP = By.xpath(".//a[contains(@class, 'd-print')]");
    private final By TIME = By.xpath(".//time[contains(@class, 'd-block')]");

    private DelfiFunctions df;

    public AP(DelfiFunctions df) {
        this.df = df;


        assertTrue(df.isElementPresents(TIME), "There is no time on");
    }
    public String getTitle(){
        return df.getText(TITLE_AP).trim();

    }
    public CP openComments(){
        df.click(COMMENT_COUNT_AP);
        return new CP(df);
    }
    public int getComments() {
        return CommentsHelper.parseCommentCount(df.findElement(COMMENT_COUNT_AP).getText());
    }
}
