package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{
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

    //helper method
    public WebElement getUserAvatarIcon(){
        return findElement(userAvatarIcon);
    }
    public void typeInSearchField (String name){findElement(searchField).sendKeys(name);}
    public void clickOnViewAllButton(){findElement(viewAllButton).click();}
    public void clickFirstSong(){findElement(firstSong).click();}
    public void clickAddToButton(){findElement(addToButton).click();}
    public void choosePlaylist(){findElement(playlist).click();}
    public String getAddToPlaylistSuccessfulMsg(){return findElement(notificationMsg).getText();}
}
