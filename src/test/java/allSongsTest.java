import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class allSongsTest extends BaseTest {

@Test
public void playSong() {

    // login
    //choose all song list
    //contextClickFirstSong
    //choosePlayOption
    //verify that song is playing

  provideEmail("karina.usmanova01@testpro.io");
  providePassword("YrEdlRVe");
  clickLoginBtn();

  clickAllSongs();
  contextClickFirstSong();
  choosePlayOptions();

  Assert.assertTrue(isSongPlaying());

}

    public void choosePlayOptions() {
        WebElement playOptions = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li.playback")));
        playOptions.click();
    }

    public void contextClickFirstSong() {
        WebElement firstSong = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".all-songs tr.song-item:nth-child(1)")));
        actions.contextClick(firstSong).perform();
    }

    public void clickAllSongs() {
        // WebElement allSongs = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".menu a.songs")));
        //allSongs.click();
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li a.songs"))).click();

    }

}
