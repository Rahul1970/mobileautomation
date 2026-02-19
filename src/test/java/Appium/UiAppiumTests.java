package Appium;

import java.net.MalformedURLException;
import java.time.Duration;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import ui.appium.base.BaseTest;
import ui.appium.pages.PreferencePage;

public class UiAppiumTests extends BaseTest {

    @Test
    public void AppiumTest() throws MalformedURLException, InterruptedException {

        // Set implicit wait once at the start
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // Initialize Page Object
        PreferencePage preferencePage = new PreferencePage(driver);

        // Click Preference
        preferencePage.clickPreference();

        // Click Preference Dependencies
        preferencePage.clickPreferenceDependencies();

        // Enable WiFi if not already enabled
        preferencePage.enableWifi();

        // Open WiFi settings popup
        preferencePage.openWifiSettings();

        // Enter WiFi name
        preferencePage.enterWifiName("rahulwifi");

        // Click OK button
        preferencePage.clickOk();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Press Android Back button safely
       // preferencePage.pressBack();

        // Read Headers text and print
        String text = preferencePage.getHeadersText();
        System.out.println("Headers Text: " + text);

        // Click Headers
        preferencePage.clickHeaders();

        // Press Back again
        ((AndroidDriver) driver).pressKey(new KeyEvent(AndroidKey.BACK));
    }
}
