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

public class CookieSettingsPage {

    protected AndroidDriver driver;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.LinearLayout\").instance(0)")
    private RemoteWebElement cookieSettingsContainer;

    @AndroidFindBy(id = "com.booking:id/bt_accept")
    private RemoteWebElement acceptButton;

    public CookieSettingsPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Step("Cookie settings page is loaded")
    public boolean cookieSettingsPageLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(cookieSettingsContainer)).isDisplayed();
    }

    @Step("Click accept button")
    public void clickAcceptButton() {
        new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(acceptButton)).isDisplayed();
        acceptButton.click();
    }
}
