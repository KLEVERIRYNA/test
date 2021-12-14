package homework;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.invoke.WrongMethodTypeException;
import java.time.Duration;
import java.util.List;

public class HomeTvNet {
    private final By ACCEPT_COOKIES_BTN = By.xpath(".//button[@mode = 'primary']");
    private final String PAGE_TV_NET = "http://www.tvnet.lv/";
    private final By ARTICLE_MAIN_PAGE = By.xpath(".//a[@class = 'list-article__url']");
    private final By ARTICLE_PAGE_TITLE = By.xpath(".//h1[@class = 'article-superheader__headline']");
    private final String ARTICLE_MAIN_PAGE_TITLE = "Ieveda mežā ķerrā un apglabāja ";

    private final By COMENT_INT = By.xpath(".//span[@itemprop ='url']");
    private final By COMENT_INT_2 = By.xpath(".//span[@class = 'flex flex--align-items-center flex--justify-content-center article-comments-heading__count section-bg-color']");
    private final By PAGE_ARTICLE = By.tagName("article");
    private WebDriver browser;

    @Test
    public void title1() {
        System.setProperty("webdriver.chrome.driver", "c://chromedriver.exe");
        browser = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(browser, Duration.ofSeconds(3));
        browser.manage().window().maximize();

        browser.get(PAGE_TV_NET);
        wait.until(ExpectedConditions.elementToBeClickable(ACCEPT_COOKIES_BTN));
        browser.findElement(ACCEPT_COOKIES_BTN).click();

       wait.until(ExpectedConditions.elementToBeClickable(ARTICLE_MAIN_PAGE));
       List<WebElement> articleLink = browser.findElements(ARTICLE_MAIN_PAGE);
       articleLink.get(3).click();

        wait.until(ExpectedConditions.elementToBeClickable(ARTICLE_PAGE_TITLE));
        WebElement articleTitle = browser.findElement(ARTICLE_PAGE_TITLE);

        Assertions.assertEquals(ARTICLE_MAIN_PAGE_TITLE, articleTitle.getText(), "Wrong Title");
        Assertions.assertEquals(ARTICLE_MAIN_PAGE, articleTitle.getText(),"Ok" );

        
        List<WebElement> hpTitle = browser.findElements(ARTICLE_MAIN_PAGE);
        WebElement article = articleLink.get(3);

        String homePageTitle = article.findElement(ARTICLE_PAGE_TITLE).getText();
        int homePageComent = 0;
        if (!article.findElements(COMENT_INT).isEmpty()) {
            homePageComent = getComents(article.findElement(COMENT_INT).getText());
        }

        article.findElement(COMENT_INT).click();
        String articlePageTitle = browser.findElement(COMENT_INT).getText();
        int articlePageComment = 0;
        if (!browser.findElements(COMENT_INT_2).isEmpty()) {
            articlePageComment = getComents(browser.findElement(COMENT_INT_2).getText());
        }

        Assertions.assertEquals(homePageTitle, articlePageTitle, "Wrong Title");
        Assertions.assertEquals(homePageComent, articlePageComment, "ok");


    }

    private int getComents(String commentCountText) {
        commentCountText = commentCountText.substring(1, commentCountText.length() - 1);
        return Integer.parseInt(commentCountText);
    }

    @AfterEach
    public void closeBrowser() {

        browser.quit();
    }
}
