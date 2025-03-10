package pages;

import org.openqa.selenium.*;

import java.util.List;

public class HomePage extends BasePage {
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    //Page Elements


    By userAvatarIcon = By.cssSelector("img.avatar");
    By searchField = By.cssSelector("input[type='search']");
    By viewAllButton = By.xpath("//section[@class='songs']//button[@data-test='view-all-songs-btn']");
    By firstSong = By.xpath("//section[@id='songResultsWrapper']//tr[@class='song-item'][1]");
    By addToButton = By.cssSelector("button.btn-add-to");
    By playlist = By.xpath("//section[@id='songResultsWrapper']//li[contains(text(),'karina playlist new')]");
    By notificationMsg = By.cssSelector("div.success.show");
    By firstPlaylist = By.cssSelector(".playlist:nth-child(3)");
    By playlistNameField = By.cssSelector("[name='name']");
    By renamePlaylistSuccessfulMsg = By.cssSelector("div.success.show");
    By playListByName = By.xpath("//a[contains(text(),'playlist for count')]");
    By playlistDetails = By.cssSelector("span.meta.text-secondary span.meta");
    By pauseButton = By.xpath("//span[@class='pause']//i[@class='fa fa-pause']");
    By playButton = By.xpath("//span[@class='play']//i[@class='fa fa-play']");
    By playlistToDelete = By.cssSelector(".playlist:nth-child(6)");
    By deletePlaylistBtn = By.cssSelector(".del.btn-delete-playlist");


    //helper methods
    public WebElement getUserAvatarIcon() {
        return findElement(userAvatarIcon);
    }

    public void typeInSearchField(String name) {
        findElement(searchField).sendKeys(name);
    }

    public void clickOnViewAllButton() {
        findElement(viewAllButton).click();
    }

    public void clickFirstSong() {
        findElement(firstSong).click();
    }

    public void clickAddToButton() {
        findElement(addToButton).click();
    }

    public void choosePlaylist() {
        findElement(playlist).click();
    }

    public String getAddToPlaylistSuccessfulMsg() {
        return findElement(notificationMsg).getText();
    }

    public void doubleClickPlaylist() {
        doubleClick(firstPlaylist);
    }

    public void enterNewPlaylistName(String newPlaylistName) {
        findElement(playlistNameField).sendKeys(Keys.chord(Keys.COMMAND, "A", Keys.BACK_SPACE));
        findElement(playlistNameField).sendKeys(newPlaylistName);
        findElement(playlistNameField).sendKeys(Keys.ENTER);
        //WebElement playlistInputField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name='name']")));
        //clear() does not work
        //workaround is ctrl A (to select all) then backspace to clear then replace with new playlist name

    }

    public String getRenamePlaylistSuccessfulMsg() {
        return findElement(renamePlaylistSuccessfulMsg).getText();
    }

    public void choosePlaylistByName(String name) {
        findElement(playListByName).click();

    }

    public String getPlaylistDetail() {
        return findElement(playlistDetails).getText();
    }


    public int countSongs() {
        return driver.findElements(By.cssSelector("section#playlistWrapper td.title")).size();
    }

    public void displayAllSongs() {
        List<WebElement> songList = driver.findElements(By.cssSelector("section#playlistWrapper td.title"));
        System.out.println("Number of songs found: " +countSongs());
        for (WebElement e: songList) {
            System.out.println(e.getText());
        }
    }

    public boolean pauseButtonIsDisplayed() {
      return findElement(pauseButton).isDisplayed();
    }

    public void clickPlayButton() {
        findElement(playButton).click();
    }

    public String deletedPlaylistSuccessfulMsg() {
       return findElement(notificationMsg).getText();

    }

    public void clickOnDeletePlaylistBtn() {
       findElement(deletePlaylistBtn).click();
    }

    public void clickOnThePlaylist() {
       findElement(playlistToDelete).click();

    }
}