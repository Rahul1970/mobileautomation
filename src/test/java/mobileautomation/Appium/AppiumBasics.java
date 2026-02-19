package mobileautomation.Appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import mobileautomation.Appium.PreferencePage;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumBasics  extends BaseTest{

    

    @Test
    public void AppiumTest() throws MalformedURLException, InterruptedException {
    	
    	
    /*	 driver.findElement(AppiumBy.accessibilityId("Preference")).click();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

         driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

         driver.findElement(By.id("android:id/checkbox")).click();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

         driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

         driver.findElement(By.id("android:id/edit")).sendKeys("rahulwifi");
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

         driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

         driver.navigate().back();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

         
         
         String s = driver.findElement(By.xpath("//android.widget.TextView[@content-desc='8. Headers']")).getText();
         System.out.println(s);
       
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

         driver.findElement(By.xpath("//android.widget.TextView[@content-desc='8. Headers']")).click();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

         driver.navigate().back();
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));  */
    	
    	
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        PreferencePage preferencePage = new PreferencePage(driver);

        preferencePage.clickPreference();
        preferencePage.clickPreferenceDependencies();
        preferencePage.enableWifi();
        preferencePage.openWifiSettings();
        preferencePage.enterWifiName("rahulwifi");
        preferencePage.clickOk();

        preferencePage.pressBack();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        String text = preferencePage.getHeadersText();
        System.out.println(text);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        preferencePage.clickHeaders();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        preferencePage.pressBack();
    	
    	
    	
         
        		 
        		


         
        
      
    }

   
   
    
}
