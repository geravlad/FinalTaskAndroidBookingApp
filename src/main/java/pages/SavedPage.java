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

public class SavedPage {

    protected AndroidDriver driver;

    @AndroidFindBy(id = "com.booking:id/decor_content_parent")
    private RemoteWebElement savedPageContainer;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.ImageView\").instance(4)")
    private RemoteWebElement heartButton;

    @AndroidFindBy(id = "com.booking:id/wishlist_properties_number")
    private RemoteWebElement savedProperties;

    public SavedPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Step("Saved page page is loaded")
    public boolean savedPageLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(savedPageContainer)).isDisplayed();
    }

    @Step("Verify property was added to saved page")
    public boolean assertPropertyIsDisplayed() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(savedProperties)).isDisplayed();
    }
}
