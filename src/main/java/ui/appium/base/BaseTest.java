package ui.appium.base;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {
	public AppiumDriver driver;
	public AppiumDriverLocalService service;
	int port = 4723;

	@BeforeTest
	public void configureAppium() throws InterruptedException, MalformedURLException {

		killProcessOnPort(port);

		Map<String, String> env = new HashMap<>(System.getenv());

		env.put("ANDROID_HOME", "/Users/rahulsingh/Library/Android/sdk");
		env.put("ANDROID_SDK_ROOT", "/Users/rahulsingh/Library/Android/sdk");
		env.put("JAVA_HOME", System.getProperty("java.home"));

		// 🌐 Start Appium server
		service = new AppiumServiceBuilder()
				.withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"))
				.withIPAddress("127.0.0.1").usingPort(port).withEnvironment(env).build();

		service.start();

		System.out.println("Appium server started at: " + service.getUrl());

		// ⏱ Optional delay to ensure server is ready
		Thread.sleep(20000);

		// 📱 App & device configuration
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("emulator-5554");
		options.setApp("/Users/rahulsingh/Documents/Appium/src/test/java/resources/ApiDemos-debug.apk");
		options.setNoReset(false);
		// options.setFullReset(false);

		// Users//rahulsingh//Documents//Appium//src//test//java//resources//ApiDemos-debug.apk

		driver = new AndroidDriver(new URL("http://127.0.0.1:" + port), options);

		Thread.sleep(10000); // Let the app run for 10 seconds

	}

	@AfterTest
	public void tearDown() throws InterruptedException {

		driver.quit();
		Thread.sleep(10000);
		service.stop();

	}

	public static void killProcessOnPort(int port) {
		try {
			Process findProcess = Runtime.getRuntime().exec(new String[] { "bash", "-c", "lsof -t -i:" + port });
			BufferedReader reader = new BufferedReader(new InputStreamReader(findProcess.getInputStream()));
			String pid = reader.readLine();

			if (pid != null && !pid.isEmpty()) {
				System.out.println("Killing process on port " + port + " with PID: " + pid);
				Process killProcess = Runtime.getRuntime().exec(new String[] { "kill", "-9", pid });
				killProcess.waitFor();
				System.out.println("Process killed successfully.");
			} else {
				System.out.println("No process found on port " + port);
			}

		} catch (Exception e) {
			System.out.println("Error while killing process on port " + port);
			e.printStackTrace();
		}

	}
}
