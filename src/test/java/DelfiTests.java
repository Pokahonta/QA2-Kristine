import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;


public class DelfiTests {
    //locator tolko v pridelax etogo klassa
    //locator constant(final) = postojannij
    //esli peremennaja constant, piwem caps lock
    private final By ARTICLE = By.tagName("article");
    private final By TITLE = By.xpath(".//h1[contains(@class, 'headline__title')]"); //locator "title" na zagolovok statji
    private final By ARTICLE_PAGE_TITLE = By.xpath(".//h1 [contains(@class, 'd-inline')]");


    private WebDriver driver;
         //driver - peremenna urovnja klass. dostupna vsemu klassu//

    @BeforeEach
    public void preconditions() {
        System.setProperty("webdriver.chrome.driver", "c://chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://rus.delfi.lv");
    }


    @Test
    public void firstDelfiTest() {
                //propisivaem putj k Chrome driver//
        // System.setProperty("webdriver.chrome.driver", "c://chromedriver.exe");

                //driver - peremennaja, kotoraja rabotaet s browser//
        //WebDriver driver = new ChromeDriver();

                //okno otkrivaem na vesj ekran//
        // driver.manage().window().maximize();
                 //otkrivaem okno delfi na rus.jaz//
        // driver.get("http://rus.delfi.lv");

                 //vozvrawaem odin element//
        // driver.findElement(By.xpath(".//h1[contains(@class, 'headline__title')]")).getText();

                //sohranitj rezultat, sozdaem peremennuju String , v kotoruju zapiwin rezultat//
        // String text = driver.findElement(By.xpath(".//h1[contains(@class, 'headline__title')]")).getText();//
        // System.out.println(text);

                 //vse zagolovke
        List<WebElement> textes = driver.findElements(By.xpath(".//h1[contains(@class, 'headline__title')]"));
                 //kazdij zagolovok//
        for (int i = 0; i < textes.size(); i++) {
            //(i+1)- ctob pronumerovatj. tekuwij element.get-nuznij element. getText - polucaem tekst//
            System.out.println((i +1) + ": " + textes.get(i).getText());
        }


    }

    @Test
    public void titleTest() {
        final String TITLE_TO_FIND = "Северная Корея заявила о возможном первом случае случае заражения Covid-19";
        //get all articles -statja
        List<WebElement> articles = driver.findElements(ARTICLE); //peremennaja vozvrawaet spisok elementov

        //find given article by text
        boolean isFound = false;
        for (WebElement article : articles){
                //vibratj locator title - zagolovok
            if (article.findElement(TITLE).getText().equals(TITLE_TO_FIND)) {  //v statje iwem zagolovok(WebElement), poluchaem tekst iz webElementa, sravnivaem ego
                //click on it
                article.findElement(TITLE).click();//esli tekst sovpadaet, to nahodim Title i klikaem na tekst zagolovka
               isFound = true;
                break; //vijti iz cikla = ostonavitj cikl, chto dalwe ne pereveral
            }
        }
        Assertions.assertTrue(isFound, "Article is not found!");

        //find article title
        String articlePageTitle = driver.findElement(ARTICLE_PAGE_TITLE).getText();

        //check it
        Assertions.assertEquals(TITLE_TO_FIND, articlePageTitle, "Titles are not equal!"); //chto ozidali poluchit, chto poluchili,
    }



    @AfterEach
    private void closeBrowser() {
        driver.close();
    }


    @Test
    public void workingWithLists() {
             //pustoj spisok
        List<String> studentNames = new ArrayList<String>();

             //proverim pustoj spisok ili net//
        System.out.println(studentNames.isEmpty());

             //zapolnjaem//
        studentNames.add("Zoja");
        studentNames.add("Petja");
        studentNames.add("Vovan");

             //proverjaem spisok//
        System.out.println(studentNames.isEmpty());
             //obwee kolicestvo zapisej,elementov vnitri. budet ispoljzovatj  cikle//
        System.out.println(studentNames.size());
             //hotim vtoroj element//
        System.out.println(studentNames.get(1));

    }

    // lekcijas 16.08.
//Logger napisan v TvNetTests.java//
    //Object... Page object...



}