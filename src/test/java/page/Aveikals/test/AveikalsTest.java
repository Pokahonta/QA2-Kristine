package page.Aveikals.test;

import org.junit.jupiter.api.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import page.Aveikals.AveikalsFunctions;
import page.Aveikals.pages.AveikalsHP;


public class AveikalsTest {
    private WebDriver driver;




    @Test
    public void aveikalsTest(){


        AveikalsFunctions AvFunctions = new AveikalsFunctions();
        AvFunctions.openPage("1a.lv");

         AveikalsHP homepage = new AveikalsHP(AvFunctions);

        Actions builder = new Actions(driver);
        WebElement element = driver.findElement(By.xpath("/html/body/div[1]/div[3]/div[1]/div/div[1]/ul/li[2]/div/div/div[1]/ul[1]/li[1]/a"));
        builder.moveToElement(element).build().perform();


        }

    }

