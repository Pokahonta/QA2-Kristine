package page.object;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

//hranit browser okno  i  vse chto v nem hranitsja
public class BaseFunc {
    private WebDriver driver;
    private WebDriverWait wait;
    private final Logger LOGGER = LogManager.getLogger(this.getClass());

    public BaseFunc() { //nazvanie vsegda takoe ze, kak u klassa
        System.setProperty("webdriver.chrome.driver", "c://chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 10);   //ozhidanie pri otkritie okna 10 sek
    }
    //obwij funkcional
    public void openPage(String url) {
        LOGGER.info("Trying to open page: " + url);

        if (!url.startsWith("http://") && !url.startsWith("https://")) { //  "||" = ili
            //esli(!) url ne nacinaetsja na http i (&&) ne nachinaetsja na https, to ----> sledujuwaja funkcija
            url = "http://" + url;
        }
        driver.get(url);
    }

    public List<WebElement> findElements (By locator) {    //funkcija polucajuwaja spisom, vozvrawajuwaja cerez locator
        return driver.findElements(locator);
    }

    public void click(WebElement element){
        wait.until(elementToBeClickable(element));      //pered tem kak kliknutj, budet zdatj poka element stanit klikabeljnim
        element.click();
    }

    public void click(By locator) {
        wait.until(elementToBeClickable(locator));
        findElement(locator).click();
        //click(findElement(locator));
    }

    public String getText(By locator){
        //1. find element
        //2. get Text
        LOGGER.info("Lana! Here we are looking for text");

        return findElement(locator).getText();

    }
    //1.
    public WebElement findElement(By locator) {
        LOGGER.info("Lana asks to find element here");
        wait.until(visibilityOfElementLocated(locator));
        return driver.findElement(locator);
    }

    public boolean isElementPresents(By locator) {
        try {
            wait.until(presenceOfElementLocated(locator));
            return true;

        } catch (NoSuchElementException e) { //e-pod nej budet xranitsja owibka, esli vipadit
            return false;
        }
    }
}