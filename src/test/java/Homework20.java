import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework20 extends BaseTest {

    @Test
    public void deletePlaylist() throws InterruptedException {

        String confirmationNotification = "Deleted playlist \"playlist to delete.\"";

        provideEmail("karina.usmanova01@testpro.io");
        providePassword("YrEdlRVe");
        clickLoginBtn();
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

