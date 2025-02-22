package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AllSongsPage extends BasePage{
    public AllSongsPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    //Elements
    By playbackBtn = By.cssSelector("li.playback");



    //Helper methods

    public void choosePlayOptions() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(playbackBtn)).click();

    }
    public void contextClickFirstSong() {
       WebElement firstSong= wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".all-songs tr.song-item:nth-child(1)")));
        actions.contextClick(firstSong).perform();
    }

}
