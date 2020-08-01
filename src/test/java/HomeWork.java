
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static java.lang.Math.pow;
import static java.lang.Math.sqrt;


public class HomeWork {
    private WebDriver driver;
    private final By TITLE = By.xpath(".//h1 [contains(@class, 'headline__title')]");



    @Test
    public void firstHomeWork(){
        double startingLoan = 70000.00 ;

        double percentRate = 0.02 ;
        int years = 15;

        double percentRateForThePeriod = 1 + years * percentRate;
        double totalLoan = startingLoan * percentRateForThePeriod;

        System.out.println( "Percent rate fot the period is " + percentRateForThePeriod +"," +
                " but total loan will be " +
                totalLoan + "EUR");

    }

    @Test
    public static void main (String []args ){
        String text = "Percent rate for period is 1.3, but total loan will be 91000.0 EUR";
        System.out.println("Length of text: " + text.length());

        System.out.println("Lenght of text without spaces: " + text.replace( " ", "").length());

        String[] words = text.split(" ");
        System.out.println(words.length);

    }

    @Test
    public void distanceBetweenToDots(){
        double x1 = 6;
        double y1 = 4;

        double x2 = 24;
        double y2 = 14;

        double AC = x2-x1;
        double BC = y2-y1;
        double AB = sqrt(pow(AC,2) + pow(BC,2));

        System.out.println("Distance between points A and B is " + AB + ".");

    }


    @Test
    public void delfiHomeTest() {
        final String TITLE_TO_FIND = "SPKC: pašvaldības var noteikt stingrākus epidemioloģiskās drošības " +
                "pasākumus pēc savas iniciatīvas";

        System.setProperty("webdriver.chrome.driver", "c://chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://delfi.lv");

        List<WebElement> title = driver.findElements(By.xpath(".//h1[contains(@class, 'headline__title')]"));

        List<WebElement> comments = driver.findElements(By.xpath(".//a [contains(@class, 'comment-count')]"));
            for (int i = 0; i < title.size(); i++) {
            System.out.println( (i + 1) + ": " + title.get(i).getText() + comments.get(i).getText());
            }

        driver.findElement(By.xpath(".//h1[contains(@class, 'headline__title')]")).getText();
            String firstTitle =  driver.findElement(By.xpath(".//h1[contains(@class, 'headline__title')]")).getText();

        driver.findElement(By.xpath(".//a [contains(@class, 'comment-count')]")).getText();
        String count  = driver.findElement(By.xpath(".//a [contains(@class, 'comment-count')]")).getText();

        System.out.println(firstTitle + count);


        }

    }


  //  public void homeWorkDelfi(){
      //  final By ARTICLE_PAGE_TITLE = By.xpath(".//h1 [contains (@class, 'd-inline')]");
       // final String FIRST_TITLE = "Mācības organizēs klātienē, nosakot virkni piesardzības pasākumu";


