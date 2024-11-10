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

public class DecorContentPage {

    protected AndroidDriver driver;

    @AndroidFindBy(id = "com.booking:id/decor_content_parent")
    private RemoteWebElement decorContentContainer;

    @AndroidFindBy(accessibility = "Navigate up")
    private RemoteWebElement closeButton;

    public DecorContentPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Step("Cookie settings page is loaded")
    public boolean decorContentPageLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(decorContentContainer)).isDisplayed();
    }

    @Step("Click close button")
    public void clickCloseButton() {
        closeButton.click();
    }
}
