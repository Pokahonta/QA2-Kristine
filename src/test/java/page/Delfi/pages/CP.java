package page.Delfi.pages;

import org.openqa.selenium.By;
import page.Delfi.DelfiFunctions;

public class CP {
    private DelfiFunctions df;

    private final By TITLE_CP = By.xpath(".//h1[@class = 'article-title']");
    private final By COMMENTS_CP = By.xpath(".//span[@class = 'type-cnt']");

    public CP(DelfiFunctions df) {
        this.df = df;
    }
    public String getTitle() {
        return  df.getText(TITLE_CP);
    }

    public int getComments(int id) {
        return Integer.parseInt(df.findElement(COMMENTS_CP).getText().trim());
    }
 }
