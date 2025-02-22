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


    @Test
    public void hoverOverPlayButton() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

       loginPage.login();
       Thread.sleep(5000);
       Assert.assertTrue(homePage.hoverOver().isDisplayed());
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

       String updatedPlaylistMsg = "Updated playlist \"TestPRO.\"";
       String newPlaylistName = "TestPRO";

        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);


        //login
       //doubleClickPlaylist
       //enter new name
       //Assert that new name has been updated

        loginPage.login();
        homePage.doubleClickPlaylist();
        homePage.enterNewPlaylistName(newPlaylistName);
        Assert.assertEquals(homePage.getRenamePlaylistSuccessfulMsg(),updatedPlaylistMsg);
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
