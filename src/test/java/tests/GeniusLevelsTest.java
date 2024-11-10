package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;

import org.testng.Assert;
import org.testng.annotations.Test;

import utils.DriverSetup;

@Epic("Mobile automation Booking app testing")
@Feature("Event")
public class GeniusLevelsTest extends DriverSetup {

    @Description("Test Description: Genius Levels Test")
    @Story("Successful Genius Levels Test")
    @Test(testName = "Genius Levels Test")
    public void geniusLevelsTest() {

        Assert.assertTrue(cookieSettingsPage.cookieSettingsPageLoaded(), "Cookie settings page is not loaded");

        cookieSettingsPage.clickAcceptButton();

        Assert.assertTrue(decorContentPage.decorContentPageLoaded(), "Decor content page is not loaded");

        decorContentPage.clickCloseButton();

        bookingLandingPage.swipeDesignBottomSheet();
        Assert.assertTrue(bookingLandingPage.bookingLandingPageLoaded(), "Booking landing page is not loaded");

        bookingLandingPage.clickSignInButton();
        Assert.assertTrue(signInPage.signInPageLoaded(), "Sign in page is not loaded");

        Assert.assertTrue(signInPage.assertUserIsNotLoggedIn(), "User is logged in");

        signInPage.clickGeniusLoyaltyProgramButton();
        Assert.assertTrue(geniusPage.geniusPageLoaded(), "Genius page is not loaded");

        geniusPage.swipeToAboutGeniusLevels();

        geniusPage.clickAboutGeniusLevelsButton();
        Assert.assertTrue(geniusPage.aboutGeniusLevelsPageLoaded(), "About genius levels page is not loaded");

        geniusPage.swipeToLevelThree();
        Assert.assertTrue(geniusPage.assertLevelThreeIsDisplayed(), "Genius level 3 is not displayed");

        geniusPage.clickGotItButton();

        geniusPage.clickBackArrowButton();
        Assert.assertTrue(signInPage.signInPageLoaded(), "Sign in page is not loaded");


    }


}
