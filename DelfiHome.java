package homework;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomeDelfi {
    private final String HOME_PAGE = "http://www.delfi.lv";
    private final By BUTTON = By.xpath(".//button[@mode = 'primary']");
    private final By ART_TITLE = By.xpath(".//a[@class = 'text-mine-shaft']");
    private final By ART_TITLE2 = By.xpath((".//h1[@class = 'text-size-22 text-size-md-30 d-inline']"));
    private final By ART_COMENT = By.xpath(".//a[@class = 'comment-count text-red-ribbon']");
    private final By ART_COMENT_TITLE = By.xpath(".//h1[@class = 'article-title']");

    @Test
    public void homeDelfi () {
        System.setProperty("webdriver.chrome.driver", "c://chromedriver.exe");
        WebDriver browzer = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(browzer, Duration.ofSeconds(5));
        browzer.manage().window().maximize();

        browzer.get(HOME_PAGE);
        WebElement firstTitle = browzer.findElement(ART_TITLE);
        wait.until(ExpectedConditions.elementToBeClickable(ART_TITLE));
        System.out.println(firstTitle.getText());

        browzer.get(firstTitle.getAttribute("href"));
        WebElement secondTitle = browzer.findElement(ART_TITLE2);
        wait.until(ExpectedConditions.elementToBeClickable(ART_TITLE2));
        System.out.println(secondTitle.getText());

        browzer.get(HOME_PAGE);
        WebElement firstTitleCommentLink = browzer.findElement(ART_COMENT);
        wait.until(ExpectedConditions.elementToBeClickable(ART_COMENT));
        browzer.get(firstTitleCommentLink.getAttribute("href"));
        WebElement secondCommentTitle = browzer.findElement(ART_COMENT_TITLE);
        wait.until(ExpectedConditions.elementToBeClickable(ART_COMENT_TITLE));
        System.out.println(secondCommentTitle.getText());

        browzer.get(HOME_PAGE);
        List<WebElement> allTitles = browzer.findElements(ART_TITLE);
        wait.until(ExpectedConditions.elementToBeClickable(ART_TITLE));

       for (int i=0; i< allTitles.size(); i++) {
           System.out.println(i+1 + ":" + allTitles.get(i).getText()+ "->"+ (i+1));
        }
    }
}
