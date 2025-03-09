import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class Homework20 extends BaseTest {

    @Test
    public void deletePlaylist() throws InterruptedException {
        LoginPage loginPage = new LoginPage(getDriver());

        String confirmationNotification = "Deleted playlist \"playlist to delete.\"";

        loginPage.provideEmail("karina.usmanova01@testpro.io");
        loginPage.providePassword("YrEdlRVe");
        loginPage.clickLoginButton();
        clickOnThePlaylist();
        clickOnDeletePlaylistBtn();
        Assert.assertEquals(deletedPlaylistSuccessfulMsg(),confirmationNotification);


    }

    public String deletedPlaylistSuccessfulMsg() {
        WebElement successfulMsg = driver.findElement(By.cssSelector("div.success.show"));
        return successfulMsg.getText();

    }

    public void clickOnDeletePlaylistBtn() {
        WebElement deletePlaylistBtn = driver.findElement(By.cssSelector(".del.btn-delete-playlist"));
        deletePlaylistBtn.click();
    }

    public void clickOnThePlaylist() {
        WebElement playList = driver.findElement(By.cssSelector(".playlist:nth-child(4)"));
        playList.click();

    }
}

