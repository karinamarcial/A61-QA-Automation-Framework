import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.HomePage;
import pages.LoginPage;

import static java.sql.DriverManager.getDriver;

public class HomePageTest extends BaseTest {

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

}

