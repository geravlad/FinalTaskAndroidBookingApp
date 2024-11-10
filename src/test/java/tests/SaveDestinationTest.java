package tests;

import data.SaveDestinationTestData;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;

import org.testng.Assert;
import org.testng.annotations.Test;

@Epic("Mobile automation Booking app testing")
@Feature("Event")
public class SaveDestinationTest extends SaveDestinationTestData {

    @Description("Test Description: Save Destination Test")
    @Story("Successful Save Destination Test")
    @Test(testName = "Save Destination Test", dataProvider = "date_data")
    public void saveDestinationTest(String startDate, String endDate) {

        Assert.assertTrue(cookieSettingsPage.cookieSettingsPageLoaded(), "Cookie settings page is not loaded");

        cookieSettingsPage.clickAcceptButton();

        Assert.assertTrue(decorContentPage.decorContentPageLoaded(), "Decor content page is not loaded");

        decorContentPage.clickCloseButton();

        bookingLandingPage.swipeDesignBottomSheet();
        Assert.assertTrue(bookingLandingPage.bookingLandingPageLoaded(), "Booking landing page is not loaded");

        bookingLandingPage.clickEnterYourDestination();
        Assert.assertTrue(destinationSearchPage.destinationSearchPageLoaded(), "Destination search page is not loaded");

        destinationSearchPage.enterDestination("Skopje");

        destinationSearchPage.selectSearchResultDestination();
        Assert.assertTrue(bookingLandingPage.calendarBottomSheetLoaded(), "Calendar bottom sheet is not loaded");

        bookingLandingPage.selectDates(startDate, endDate);

        bookingLandingPage.clickRoomsAndGuestsButton();

        bookingLandingPage.selectRoomsAndGuests();

        bookingLandingPage.clickSearchButton();
        Assert.assertTrue(searchResultPage.searchResultPageLoaded(), "Search result page is not loaded");

        Assert.assertEquals(searchResultPage.assertDestinationName(), "Skopje", "Destination name doesn't have the expected value");
        Assert.assertEquals(searchResultPage.assertDestinationDates(), "Dec " + startDate + " - Dec " + endDate, "Destination date doesn't have the expected value");

        searchResultPage.clickFirstProperty();
        Assert.assertTrue(propertyPage.propertyPageLoaded(), "Property page is not loaded");

        propertyPage.clickAddToListHeartButton();

        propertyPage.clickBackArrowButton();
        Assert.assertTrue(searchResultPage.searchResultPageLoaded(), "Search result page is not loaded");

        searchResultPage.clickBackArrowButton();

        bookingLandingPage.clickSavedButton();
        Assert.assertTrue(savedPage.savedPageLoaded(), "Saved page is not loaded");

        Assert.assertTrue(savedPage.assertPropertyIsDisplayed(), "Properties are not displayed");

    }
}
