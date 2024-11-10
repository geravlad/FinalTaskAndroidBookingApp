package utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import org.testng.annotations.Listeners;

import pages.*;

import io.qameta.allure.Step;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

@Listeners(ITestListenerUtility.class)
public class DriverSetup extends ConfigReader{

    public static AndroidDriver driver;

    protected Helpers helpers;

    protected CookieSettingsPage cookieSettingsPage;
    protected DecorContentPage decorContentPage;
    protected BookingLandingPage bookingLandingPage;
    protected SignInPage signInPage;
    protected GeniusPage geniusPage;
    protected DestinationSearchPage destinationSearchPage;
    protected SearchResultPage searchResultPage;
    protected SavedPage savedPage;
    protected PropertyPage propertyPage;

    @Step("Driver started")
    @BeforeMethod
    public void setUP() {

        UiAutomator2Options options = new UiAutomator2Options();

        options.setAvd(getProperty("avd"))
                .setApp(getProperty("app"))
                .setAppPackage(getProperty("app.package"))
                .setAppActivity(getProperty("app.activity"))
                .setNoReset(false)
                .setFullReset(true)
                .setCapability("appium:autoGrantPermissions", true);

        try {
            driver = new AndroidDriver(new URI(GlobalVariables.localAppiumServerUrl).toURL(), options);
        } catch (MalformedURLException | URISyntaxException e) {
            throw new RuntimeException(e);
        }

        helpers = new Helpers();

        cookieSettingsPage = new CookieSettingsPage(driver);
        decorContentPage = new DecorContentPage(driver);
        bookingLandingPage = new BookingLandingPage(driver);
        signInPage = new SignInPage(driver);
        geniusPage = new GeniusPage(driver);
        destinationSearchPage = new DestinationSearchPage(driver);
        searchResultPage = new SearchResultPage(driver);
        savedPage = new SavedPage(driver);
        propertyPage = new PropertyPage(driver);
    }

    @Step("Driver closed")
    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (driver != null)
            driver.quit();
    }
}
