import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

import java.util.List;

public class HomePageTest extends BaseTest {
    String newPlaylistName = "TestPRO";

    @Test
    public void hoverOverPlayButton() throws InterruptedException {

        provideEmail("karina.usmanova01@testpro.io");
        providePassword("YrEdlRVe");
        clickLoginBtn();
        Thread.sleep(2000);
        Assert.assertTrue(hoverOver().isDisplayed());
    }

    @Test
    public void countSongsInPlaylist() throws InterruptedException {

        //login
        //choosePlaylistByName
        //displayAllSongs
        //Assert - contains amount of songs as mentioned in the playlist info section

        provideEmail("karina.usmanova01@testpro.io");
        providePassword("YrEdlRVe");
        clickLoginBtn();
        choosePlaylistByName("karina playlist new");
        Thread.sleep(2000);
        //choosePlaylistName();
        displayAllSongs();
        Thread.sleep(2000);
        Assert.assertTrue(getPlaylistDetail().contains(String.valueOf(countSongs())));
    }

        //public void choosePlaylistByName() {
        //WebElement playListByName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'karina playlist new')]")));
        //playListByName.click();
    public void choosePlaylistByName (String playlistName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'"+playlistName+"')]"))).click();

    }

    public int countSongs() {
        return driver.findElements(By.cssSelector("section#playlistWrapper td.title")).size();
    }

    public String getPlaylistDetail() {
        return driver.findElement(By.cssSelector("span.meta.text-secondary span.meta")).getText();
    }

    public void displayAllSongs() {
        List<WebElement> songList = driver.findElements(By.cssSelector("section#playlistWrapper td.title"));
        System.out.println("Number of songs found: " +countSongs());
        for (WebElement e: songList) {
            System.out.println(e.getText());
        }
    }

   @Test
   public void renamePlaylist() throws InterruptedException {

        String expectedSuccessfulMsg = "Updated playlist \"TestPRO.\"";

        //login
       //doubleClickPlaylist
       //enter new name
       //Assert that new name has been updated

        provideEmail("karina.usmanova01@testpro.io");
        providePassword("YrEdlRVe");
        clickLoginBtn();
        Thread.sleep(2000);
        doubleClickPlaylist();
        Thread.sleep(2000);
        enterNewPlaylistName();
       Assert.assertEquals(getRenamePlaylistSuccessfulMsg(),expectedSuccessfulMsg);
   }

    public void doubleClickPlaylist() {
        WebElement playlist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(3)")));
        actions.doubleClick(playlist).perform();
    }

    public void enterNewPlaylistName() {
        WebElement playlistInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        //clear() does not work
        //workaround is ctrl A (to select all) then backspace to clear then replace with new playlist name
        playlistInputField.sendKeys(Keys.chord(Keys.COMMAND,"A",Keys.BACK_SPACE));
        playlistInputField.sendKeys(newPlaylistName);
        playlistInputField.sendKeys(Keys.ENTER);
    }

    public String getRenamePlaylistSuccessfulMsg () {
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.success.show")));
        return notification.getText();
    }

    @Test
    public void addSongToPlaylist() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        String expectedSongAddedMsg = "Added 1 song into \"karina playlist new.\"";
        loginPage.login();
        Thread.sleep(2000);
        homePage.typeInSearchField("dee");
        homePage.clickOnViewAllButton();
        homePage.clickFirstSong();
        homePage.clickAddToButton();
        homePage.choosePlaylist();
        Assert.assertEquals(homePage.getAddToPlaylistSuccessfulMsg(),expectedSongAddedMsg);
    }
}
