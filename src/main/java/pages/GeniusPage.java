package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import io.qameta.allure.Step;

import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.GlobalVariables;
import utils.Helpers;

public class GeniusPage extends Helpers {

    protected AndroidDriver driver;

    @AndroidFindBy(id = "com.booking:id/activity_genius_info_container")
    private RemoteWebElement geniusPageContainer;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Genius loyalty program\")")
    private RemoteWebElement geniusLoyaltyProgramButton;

    @AndroidFindBy(id = "com.booking:id/genius_see_all_levels")
    private RemoteWebElement aboutGeniusLevelsButton;

    @AndroidFindBy(id = "com.booking:id/constraint_layout")
    private RemoteWebElement geniusLevelsSheet;

    @AndroidFindBy(id = "com.booking:id/genius_levels_view")
    private RemoteWebElement geniusLevelsCarousel;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Genius Level 3\")")
    private RemoteWebElement levelThreeTitle;

    @AndroidFindBy(id = "com.booking:id/action_button")
    private RemoteWebElement gotItButton;

    @AndroidFindBy(accessibility = "Navigate up")
    private RemoteWebElement backArrowButton;

    public GeniusPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Step("Genius page is loaded")
    public boolean geniusPageLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(geniusPageContainer)).isDisplayed();
    }

    @Step("Swipe to about genius levels")
    public void swipeToAboutGeniusLevels() {
        scrollVerticallyTo(driver, Directions.UP, 3);
    }

    @Step("Click about genius levels button")
    public void clickAboutGeniusLevelsButton() {
        aboutGeniusLevelsButton.click();
    }

    @Step("About genius page loaded")
    public boolean aboutGeniusLevelsPageLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(geniusLevelsSheet)).isDisplayed();
    }

    @Step("Swipe to level 3")
    public void swipeToLevelThree() {
        scrollHorizontallyTo(driver, geniusLevelsCarousel, Directions.LEFT, 3);
    }

    @Step("Verify genius level 3 is displayed")
    public boolean assertLevelThreeIsDisplayed() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(levelThreeTitle)).isDisplayed();
    }

    @Step("Click Got it button")
    public void clickGotItButton() {
        gotItButton.click();
    }

    @Step("Click back arrow button")
    public void clickBackArrowButton() {
        new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(backArrowButton)).isDisplayed();
        backArrowButton.click();
    }
}
