package page.Aveikals.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import page.Aveikals.AveikalsFunctions;

public class AveikalsHP {
    private final By XPATH = By.xpath("/html/body/div[1]/div[3]/div[1]/div/div[1]/ul/li[2]/div/div/div[1]/ul[1]/li[1]/a");


    private AveikalsFunctions avFunctions;

    public AveikalsHP(AveikalsFunctions avFunctions) {
        this.avFunctions = avFunctions;
    }



}
