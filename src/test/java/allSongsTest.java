import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AllSongsPage;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;

public class allSongsTest extends BaseTest {

@Test
public void playSong() throws InterruptedException {
    LoginPage loginPage = new LoginPage(getDriver());
    HomePage homePage = new HomePage(getDriver());
    AllSongsPage allSongsPage = new AllSongsPage(getDriver());

    // login
    //choose all song list
    //contextClickFirstSong
    //choosePlayOption
    //verify that song is playing

  loginPage.login();
  Thread.sleep(2000);
  allSongsPage.clickAllSongs();
  allSongsPage.contextClickFirstSong();
  allSongsPage.choosePlayOptions();
  //clickAllSongs and isSongPlaying are in BasePage

  Assert.assertTrue(allSongsPage.isSongPlaying());

}
@Test
public void playNextSong() throws InterruptedException {
    LoginPage loginPage = new LoginPage(getDriver());
    HomePage homePage = new HomePage(getDriver());
    AllSongsPage allSongsPage = new AllSongsPage(getDriver());

    loginPage.login();
    Thread.sleep(2000);
    allSongsPage.playNextSong();
    Thread.sleep(2000);
    homePage.clickPlayButton();

    Assert.assertTrue(homePage.pauseButtonIsDisplayed());
 }

}


