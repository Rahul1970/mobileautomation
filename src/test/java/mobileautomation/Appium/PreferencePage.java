package mobileautomation.Appium;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import io.appium.java_client.AppiumBy;

public class PreferencePage {

    AndroidDriver driver;

    // ✅ Constructor must accept AndroidDriver
    public PreferencePage(AndroidDriver driver) {
        this.driver = driver;
    }

    // Locators
    private By preference = AppiumBy.accessibilityId("Preference");
    private By preferenceDependencies =
            By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']");
    private By wifiCheckbox = By.id("android:id/checkbox");
    private By wifiSettings = By.xpath("(//android.widget.RelativeLayout)[2]");
    private By wifiEditText = By.id("android:id/edit");
    private By headers =
            By.xpath("//android.widget.TextView[@content-desc='8. Headers']");

    // Methods
    public void clickPreference() {
        driver.findElement(preference).click();
    }

    public void clickPreferenceDependencies() {
        driver.findElement(preferenceDependencies).click();
    }

    public void enableWifi() {
        driver.findElement(wifiCheckbox).click();
    }

    public void openWifiSettings() {
        driver.findElement(wifiSettings).click();
    }

    public void enterWifiName(String name) {
        driver.findElement(wifiEditText).sendKeys(name);
    }

    public void clickOk() {
        driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
    }

    public String getHeadersText() {
        return driver.findElement(headers).getText();
    }

    public void clickHeaders() {
        driver.findElement(headers).click();
    }

    public void pressBack() {
        driver.navigate().back();
    }
}
