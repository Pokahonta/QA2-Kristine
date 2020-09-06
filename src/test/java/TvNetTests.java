import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class TvNetTests {
    //home page
    private final By ARTICLE = By.tagName("article");
    private final By TITLE = By.xpath(".//span[@itemprop = 'headline name']");
    private final By COMMENTS_COUNT = By.xpath(".//span[@itemprop = 'url']");
    //article page
    private final By ARTICLE_PAGE_TITLE = By.xpath(".//h1[@itemprop = 'headline name']");
    private final By ARTICLE_PAGE_COMMENTS =By.xpath(".//a[contains(@class, 'item--comments')]");
    //na stranice komentariev
    private final By COMMENTS_PAGE_COUNTS  = By.xpath (".//span [contains (@class, 'article-comments')]");
    //kopija logger. imenno log4j.
    private final Logger LOGGER = LogManager.getLogger(this.getClass()); //imenno tekuwij klass=getClass//


    @Test
    //method
    public void articleTitleCommentsCheck(){
        LOGGER.info("This test is checking titles and comment count");
        System.setProperty("webdriver.chrome.driver", "c://chromedriver.exe");

        LOGGER.info("Opening browser");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        LOGGER.info("Openning home page");
        driver.get("http://tvnet.lv");

//------------------------------------------test plan----------------------------------------------//
        //find articles
        LOGGER.info("Getting all articles");
        List<WebElement> articles = driver.findElements(ARTICLE);

        //find 3rd
        LOGGER.info("Get 3rd one");
        WebElement article = articles.get(2);

        //find title
        LOGGER.info("Getting title");
        String homePageTitle = article.findElement(TITLE).getText();

        //find comments counts
        int homePageCommentsCount = 0; //peremennaja. commentarii po umolcaniju
        if (!article.findElements(COMMENTS_COUNT).isEmpty()) { // ! - peredelivaet true = false i false = true
            homePageCommentsCount = parseCommentCount(article.findElement(COMMENTS_COUNT).getText());
        }
        //System.out.println(homePageTitle + " " + homePageCommentsCount);//proverili, cto rabotaet

        //click on it
        article.findElement(TITLE).click();

        //Wait for title
        WebDriverWait wait = new WebDriverWait(driver, 10); //budet zdatj v okne driver, 10 sekund
        wait.until(ExpectedConditions.visibilityOfElementLocated(ARTICLE_PAGE_TITLE));

        //find title
        String articlePageTitle = driver.findElement(ARTICLE_PAGE_TITLE).getText(); //v driver piwem, tk iwem po statje

        //find comments count
        int articlePageCommentCount = Integer.parseInt(driver.findElement(ARTICLE_PAGE_COMMENTS).getText());

        //check
        Assertions.assertTrue(homePageTitle.startsWith(articlePageTitle), "Wrong title!");
        //chto dva string soderzhat odinakovij tekst
        Assertions.assertEquals(homePageCommentsCount, articlePageCommentCount, "Wrong comment count!");

        //open comments page
        driver.findElement(ARTICLE_PAGE_COMMENTS).click();

       //Wait for title
        wait.until(ExpectedConditions.visibilityOfElementLocated(ARTICLE_PAGE_TITLE));

        //find title
        String commentsPageTitle = driver.findElement(ARTICLE_PAGE_TITLE).getText();

        //find comments count
        int commentsPageCommentsCount = Integer.parseInt(driver.findElement(COMMENTS_PAGE_COUNTS).getText());

        //check
        //chto home page startuet s comment page
        Assertions.assertTrue(homePageTitle.startsWith(commentsPageTitle), "Wrong title!");
        Assertions.assertEquals(homePageCommentsCount, commentsPageCommentsCount, "Wrong comment count!");

    }
    //funkcija, kotoraja peredelivaet komentarii
    private int parseCommentCount(String textToParse){
        //otbrasivaem skobki
        textToParse = textToParse.substring(1, textToParse.length() -1); //substring -podsrtoka, birdannaja iz stroki//textToParse.l.-dlina vsej stroki
        //peredelivaem v integer
        return Integer.parseInt(textToParse); //polucaet string, probuet pereelatj v int//rezultat etoj strokin vozvrawaem kak rezultat etoj strochk
    }
}
