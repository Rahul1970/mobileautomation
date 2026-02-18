package mobileautomation.Appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumBasics  extends BaseTest{

    

    @Test
    public void AppiumTest() throws MalformedURLException, InterruptedException {
    	
    	
    	 driver.findElement(AppiumBy.accessibilityId("Preference")).click();
         Thread.sleep(5000);
         driver.findElement(By.xpath("//android.widget.TextView[@content-desc='3. Preference dependencies']")).click();
         Thread.sleep(5000);
         driver.findElement(By.id("android:id/checkbox")).click();
         Thread.sleep(10000);
         driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();

         
     
         
        // driver.findElement(By.xpath("//android.widget.ListView[@resource-id='android:id/list']/android.widget.LinearLayout[2]/android.widget.RelativeLayout")).click();
         Thread.sleep(10000);
         driver.findElement(By.id("android:id/edit")).sendKeys("rahulwifi");
         Thread.sleep(5000);
         driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
         Thread.sleep(5000);
         
        
      
    }

   
   
    
}
