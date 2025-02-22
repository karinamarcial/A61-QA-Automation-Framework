package pageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class HomePageFactory extends BasePage {
    public HomePageFactory(WebDriver givenDriver) {
        super(givenDriver);
    }
    //Page Factory Element
    @FindBy(xpath = "//i[@class='next fa fa-step-forward control']")
    WebElement nextSong;
    @FindBy(xpath = "//span[@class='play']//i[@class='fa fa-play']")
    WebElement playButton;
    @FindBy(xpath = "//span[@class='pause']//i[@class='fa fa-pause']")
    WebElement pauseBtn;



    //Helper methods
    public void playNextSong() {
        nextSong.click();
    }
    public void clickPlayButton() {
        playButton.click();
    }
    public boolean pauseBtnIsDisplayed(){
      return pauseBtn.isDisplayed();

    }

    //WebElement pauseBtn = driver.findElement(By.xpath("//span[@class='pause']//i[@class='fa fa-pause']"));
}
