import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WrapsElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.print.DocFlavor;
import java.util.List;

public class HomeworfDelfi {
    private WebDriver driver;
    //---Home Page---//
    private final By ARTICLE_HP = By.tagName("article");
    private final By TITLE_HP  = By.xpath(".//h1[contains(@class, 'headline__title')]");
    private final By COMMENT_COUNTS_HP = By.xpath(".//a[contains(@class, 'comment-count')]");
    //---Article  Page---//
    private final By TITLE_AP = By.xpath(".//h1[contains(@class, 'd-inline')]");
    private final By COMMENTS_COUNTS_AP = By.xpath(".//a[contains(@class, 'd-print')]");
    //----Comments Page---//
    private final By COMMENTS_CP = By.xpath(".//span[@class = 'type-cnt']");

    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    @Test
    public void delfiHomeTest() {

        System.setProperty("webdriver.chrome.driver", "c://chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://delfi.lv");

    //----------------------Home Page----------------------//
                  //find articles on Home Page
        LOGGER.info("Get articles on Home Page");
        List<WebElement> articles = driver.findElements(ARTICLE_HP);

                   //find 3rd article on Home Page
        LOGGER.info("Get 3rd article on Home Page");
        WebElement article = articles.get(2);

                   //find article title on Home Page
        LOGGER.info("Get article title on Home Page");
        String homePageTitle = article.findElement(TITLE_HP).getText();

                    //find article comments count on Home Page
        LOGGER.info("Get article comments count on Home Page");
        int homePageCommentsCount = 0;
        if (!article.findElements(COMMENT_COUNTS_HP).isEmpty()){
            homePageCommentsCount = parseCommentCount(article.findElement(COMMENT_COUNTS_HP).getText());
        }
        //System.out.println(homePageTitle + " " + homePageCommentsCount);

                    //click on it
        LOGGER.info("Click on it");
        article.findElement(TITLE_HP).click();

       WebDriverWait wait = new WebDriverWait(driver, 10);
       wait.until(ExpectedConditions.visibilityOfElementLocated(TITLE_AP));

    //--------------------ARTICLE PAGE---------------------//
                     //find title on Article Page
        LOGGER.info("Get title on Atricle Page");
        String articlesPageTitle = driver.findElement(TITLE_AP).getText();

                     //find comments count on Article Page
        LOGGER.info("Get comments count on Article Page");
        int articlesPageCommentCount = parseCommentCount(driver.findElement(COMMENTS_COUNTS_AP).getText());

                     //check
        Assertions.assertTrue(homePageTitle.startsWith(articlesPageTitle), "Wrong title!");
        Assertions.assertEquals(homePageCommentsCount, articlesPageCommentCount, "Wrong comment count!");

                      //click(open) on it
        LOGGER.info("Click on it");
        driver.findElement(COMMENTS_COUNTS_AP).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(TITLE_AP));

    //------------------COMMENTS PAGE----------------------//
                      //find title on Comments Page
        LOGGER.info("Get title on Comments Page");
        String commentsPageTitle = driver.findElement(TITLE_AP).getText();

                      //find comments on Comments Page
        LOGGER.info("Get comments in Comments Page");
        int commentsPageCommentCount = Integer.parseInt(driver.findElement(COMMENTS_CP).getText());

                      //check
        Assertions.assertTrue(homePageTitle.startsWith(commentsPageTitle), "Wrong title!");
        Assertions.assertEquals(homePageCommentsCount, commentsPageCommentCount, "Wrong comment count!");

            }
    private int parseCommentCount(String textToParse){
        textToParse = textToParse.substring(1, textToParse.length() -1);
        return Integer.parseInt(textToParse);

            }
    }



