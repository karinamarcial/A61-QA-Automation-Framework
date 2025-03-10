import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;

import static java.sql.DriverManager.getDriver;

public class HomePageTest extends BaseTest {

    @Test
    public void hoverOverPlayButton() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        BasePage basePage = new BasePage(getDriver());

        loginPage.login();
        Thread.sleep(5000);
        Assert.assertTrue(basePage.hoverOverPlay().isDisplayed());
    }

   @Test
    public void countSongsInPlaylist() throws InterruptedException {
       LoginPage loginPage = new LoginPage(getDriver());
       HomePage homePage = new HomePage(getDriver());

       //login
       //choosePlaylistByName
       //displayAllSongs
       //Assert - contains amount of songs as mentioned in the playlist info section

       loginPage.provideEmail("karina.usmanova01@testpro.io");
       loginPage.providePassword("YrEdlRVe");
       loginPage.clickLoginButton();
       homePage.choosePlaylistByName("playlist for count");
       Thread.sleep(2000);
       homePage.displayAllSongs();
       Thread.sleep(2000);
       Assert.assertTrue(homePage.getPlaylistDetail().contains(String.valueOf(homePage.countSongs())));
   }


    @Test
    public void renamePlaylist() throws InterruptedException {

        String updatedPlaylistMsg = "Updated playlist \"TestPRO.\"";
        String newPlaylistName = "TestPRO";

        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

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
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

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

    @Test
    public void deletePlaylist() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());
        HomePage homePage = new HomePage(getDriver());

        String confirmationNotification = "Deleted playlist \"playlist to delete.\"";

        loginPage.provideEmail("karina.usmanova01@testpro.io");
        loginPage.providePassword("YrEdlRVe");
        loginPage.clickLoginButton();
        Thread.sleep(2000);

        homePage.clickOnThePlaylist();
        Thread.sleep(2000);
        homePage.clickOnDeletePlaylistBtn();
        Thread.sleep(2000);

        Assert.assertEquals(homePage.deletedPlaylistSuccessfulMsg(),confirmationNotification);
        Thread.sleep(2000);

    }


}

