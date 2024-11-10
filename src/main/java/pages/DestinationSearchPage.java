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

public class DestinationSearchPage {

    protected AndroidDriver driver;

    @AndroidFindBy(id = "com.booking:id/facet_with_bui_free_search_booking_header_appbar_layout")
    private RemoteWebElement enterDestinationHeader;

    @AndroidFindBy(id = "com.booking:id/facet_with_bui_free_search_booking_header_toolbar_content")
    private RemoteWebElement enterDestinationField;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.view.ViewGroup\").instance(1)")
    private RemoteWebElement searchResultDestination;

    public DestinationSearchPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Step("Booking landing page is loaded")
    public boolean destinationSearchPageLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(enterDestinationHeader)).isDisplayed();
    }

    @Step("Enter destination: {0}")
    public void enterDestination(String destination) {
        enterDestinationField.sendKeys(destination);
    }

    @Step("Select search result destination")
    public void selectSearchResultDestination() {
        new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(searchResultDestination)).isDisplayed();
        searchResultDestination.click();
    }
}
