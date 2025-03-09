package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    WebDriver driver;
    WebDriverWait wait;
    Actions actions;

    public BasePage(WebDriver givenDriver) {
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
        PageFactory.initElements(driver,this);
    }
    public WebElement findElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public void click(By locator){
        findElement(locator).click();
    }
    public void doubleClick(By locator) {
        actions.doubleClick(findElement(locator)).perform();
    }

    public void contextClick(By locator) {
        actions.contextClick(findElement(locator)).perform();

    }

    public boolean isSongPlaying() {
        WebElement soundBarVisualizer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.bars")));
        return soundBarVisualizer.isDisplayed();
    }
    public void clickAllSongs() {
        // WebElement allSongs = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".menu a.songs")));
        //allSongs.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li a.songs"))).click();

    }
    public WebElement hoverOverPlay() {
        WebElement playButton = driver.findElement(By.cssSelector("[data-testid='play-btn']"));
        actions.moveToElement(playButton).perform();
        return wait.until(ExpectedConditions.visibilityOf(playButton));
    }
}
