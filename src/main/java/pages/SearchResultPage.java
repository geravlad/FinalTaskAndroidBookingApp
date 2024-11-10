package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import io.qameta.allure.Step;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.GlobalVariables;

public class SearchResultPage {

    protected AndroidDriver driver;

    @AndroidFindBy(id = "com.booking:id/sr_activity_root")
    private RemoteWebElement searchResultPageContainer;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.ImageView\").instance(3)")
    private RemoteWebElement firstProperty;

    @AndroidFindBy(accessibility = "Navigate up")
    private RemoteWebElement backArrowButton;


    public SearchResultPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Step("Search result page is loaded")
    public boolean searchResultPageLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(searchResultPageContainer)).isDisplayed();
    }

    @Step("Verify search result destination name")
    public String assertDestinationName() {
        String destinationName = String.format("com.booking:id/searchbox_destination");
        return driver.findElement(AppiumBy.id(destinationName)).getText();
    }

    @Step("Verify search result dates")
    public String assertDestinationDates() {
        String destinationName = String.format("com.booking:id/searchbox_dates");
        return driver.findElement(AppiumBy.id(destinationName)).getText();
    }

    @Step("Click on first property")
    public void clickFirstProperty() {
        firstProperty.click();
    }

    @Step("Click back button")
    public void clickBackArrowButton() {
        backArrowButton.click();
    }
}
