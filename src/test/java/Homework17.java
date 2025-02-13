import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest {

 @Test
 public void addSongToPlaylist() throws InterruptedException{

     String expectedSongAddedMsg = "Added 1 song into \"karina playlist new.\"";
     //navigateToPage();
     provideEmail("karina.usmanova01@testpro.io");
     providePassword("YrEdlRVe");
     clickLoginBtn();
     Thread.sleep(2000);

     typeInSearchField("dee");
     Thread.sleep(2000);

     clickOnViewAllButton();
     Thread.sleep(2000);

     clickFirstSong();
     Thread.sleep(2000);

     clickAddToBtn();
     Thread.sleep(2000);

     choosePlaylist();
     Thread.sleep(2000);

     Assert.assertEquals(getAddToPlaylistSuccessfulMsg(),expectedSongAddedMsg);
 }

     public String getAddToPlaylistSuccessfulMsg() {
         WebElement notification = driver.findElement(By.cssSelector("div.success.show"));
         return notification.getText();


 }

    public void choosePlaylist() {
     WebElement playList = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//li[contains(text(),'karina playlist new')]"));
        playList.click();
    }

    public void clickAddToBtn() {
     WebElement addToBtn = driver.findElement(By.cssSelector("button.btn-add-to"));
     addToBtn.click();
    }

    public void clickFirstSong() {
     WebElement firstSong = driver.findElement(By.xpath("//section[@id='songResultsWrapper']//tr[@class='song-item'][1]"));
     firstSong.click();
    }

    public void clickOnViewAllButton() {
     WebElement viewAllBtn = driver.findElement(By.xpath("//button[@data-test='view-all-songs-btn']"));
     viewAllBtn.click();
    }

    public void typeInSearchField(String name) {
        WebElement searchField = driver.findElement(By.cssSelector("input[type='search']"));
        searchField.clear();
        searchField.sendKeys(name);
    }
}
