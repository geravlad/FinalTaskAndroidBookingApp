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

public class SignInPage {

    protected AndroidDriver driver;

    @AndroidFindBy(id = "com.booking:id/home_screen_content_view_id")
    private RemoteWebElement signInPageContainer;

    @AndroidFindBy(id = "com.booking:id/facet_profile_header_sign_in_cta")
    private RemoteWebElement signInButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Genius loyalty program\")")
    private RemoteWebElement geniusLoyaltyProgramButton;

    public SignInPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Step("Sign In page is loaded")
    public boolean signInPageLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(signInPageContainer)).isDisplayed();
    }

    @Step("Verify user is not logged in")
    public boolean assertUserIsNotLoggedIn() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(signInButton)).isDisplayed();
    }

    @Step("Click genius loyalty program button")
    public void clickGeniusLoyaltyProgramButton() {
        geniusLoyaltyProgramButton.click();
    }
}
