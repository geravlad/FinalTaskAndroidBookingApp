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

public class PropertyPage {

    protected AndroidDriver driver;

    @AndroidFindBy(id = "com.booking:id/decor_content_parent")
    private RemoteWebElement propertyPageContainer;

    @AndroidFindBy(accessibility = "Add to list")
    private RemoteWebElement addToListHeartButton;

    @AndroidFindBy(accessibility = "Navigate up")
    private RemoteWebElement backArrowButton;

    public PropertyPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Step("Saved page page is loaded")
    public boolean propertyPageLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(propertyPageContainer)).isDisplayed();
    }

    @Step("Click add to list button")
    public void clickAddToListHeartButton() {
        addToListHeartButton.click();
    }

    @Step("Click back button")
    public void clickBackArrowButton() {
        backArrowButton.click();
    }
}
