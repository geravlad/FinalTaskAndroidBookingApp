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
import utils.Helpers;

public class BookingLandingPage extends Helpers {

    protected AndroidDriver driver;

    @AndroidFindBy(id = "com.booking:id/action_bar_root")
    private RemoteWebElement bookingLandingPageContainer;

    @AndroidFindBy(id = "com.booking:id/design_bottom_sheet")
    private RemoteWebElement designBottomSheet;

    @AndroidFindBy(accessibility = "Sign in")
    private RemoteWebElement signInButton;

    @AndroidFindBy(accessibility = "Enter your destination")
    private RemoteWebElement enterYourDestinationFieldLandingPage;

    @AndroidFindBy(id = "com.booking:id/facet_with_bottom_sheet_header_content")
    private RemoteWebElement calendarBottomSheet;

    @AndroidFindBy(id = "com.booking:id/facet_date_picker_confirm")
    private RemoteWebElement selectDatesButton;

    @AndroidFindBy(xpath = "//android.view.View/android.widget.Button[3]")
    private RemoteWebElement roomsAndGuestsButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.booking:id/bui_input_stepper_add_button\").instance(0)")
    private RemoteWebElement addRoomsButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.booking:id/bui_input_stepper_add_button\").instance(1)")
    private RemoteWebElement addAdultsButton;

    @AndroidFindBy(id = "com.booking:id/group_config_apply_button")
    private RemoteWebElement applyButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Search\").instance(0)")
    private RemoteWebElement searchButton;

    @AndroidFindBy(accessibility = "Saved")
    private RemoteWebElement savedButton;

    public BookingLandingPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Step("Swipe design bottom sheet")
    public void swipeDesignBottomSheet() {
        new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(designBottomSheet)).isDisplayed();
        swipeVertically(driver, Directions.DOWN);
    }

    @Step("Booking landing page is loaded")
    public boolean bookingLandingPageLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(bookingLandingPageContainer)).isDisplayed();
    }

    @Step("Click sign in button")
    public void clickSignInButton() {
        new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(signInButton)).isDisplayed();
        signInButton.click();
    }

    @Step("Click on enter destination field")
    public void clickEnterYourDestination() {
        new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(enterYourDestinationFieldLandingPage)).isDisplayed();
        enterYourDestinationFieldLandingPage.click();
    }

    @Step("Calendar bottom sheet is loaded")
    public boolean calendarBottomSheetLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(calendarBottomSheet)).isDisplayed();
    }

    @Step("Select start date {0} and end date {1}")
    public void selectDates(String startDate, String endDate) {
        driver.findElement(AppiumBy.accessibilityId(String.format("%s December 2024", startDate))).click();
        driver.findElement(AppiumBy.accessibilityId(String.format("%s December 2024", endDate))).click();
        selectDatesButton.click();
    }

    @Step("Click rooms and guests button")
    public void clickRoomsAndGuestsButton() {
        new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(roomsAndGuestsButton)).isDisplayed();
        roomsAndGuestsButton.click();
    }

    @Step("Select rooms and guests")
    public void selectRoomsAndGuests() {
        new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(addRoomsButton)).isDisplayed();
        addRoomsButton.click();
        addAdultsButton.click();
        applyButton.click();
    }

    @Step("Click search button")
    public void clickSearchButton() {
        new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(searchButton)).isDisplayed();
        searchButton.click();
    }

    @Step("Click saved button")
    public void clickSavedButton() {
        new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(savedButton)).isDisplayed();
        savedButton.click();
    }
}
