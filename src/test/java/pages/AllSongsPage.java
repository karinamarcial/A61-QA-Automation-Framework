package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class AllSongsPage extends BasePage{
    public AllSongsPage(WebDriver givenDriver) {
        super(givenDriver);
    }


    //Elements
    By playbackBtn = By.cssSelector("li.playback");
    By firstSong = By.cssSelector(".all-songs tr.song-item:nth-child(1)");
    By firstSongLikeBtn = By.cssSelector(".all-songs tr.song-item:nth-child(1) td.favorite");
    By likeBtnSelected = By.cssSelector(".all-songs tr.song-item:nth-child(1) .fa.fa-heart.text-maroon");


    //Helper methods

    public void choosePlayOptions() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(playbackBtn)).click();

    }
    public void contextClickFirstSong() {
        contextClick(firstSong);
      // WebElement firstSong= wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".all-songs tr.song-item:nth-child(1)")));
      //  actions.contextClick(firstSong).perform();
    }

    public void playNextSong() {
        WebElement nextSong = driver.findElement(By.xpath("//i[@class='next fa fa-step-forward control']"));
        nextSong.click();
    }

    public void clickLikeBtn(){
        findElement(firstSongLikeBtn).click();
    }

    public boolean redHeartIsDisplayed() {
       return findElement(likeBtnSelected).isDisplayed();

    }


}
