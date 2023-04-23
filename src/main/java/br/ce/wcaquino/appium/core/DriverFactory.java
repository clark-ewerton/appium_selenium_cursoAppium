package br.ce.wcaquino.appium.core;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class DriverFactory {

	private static AndroidDriver<MobileElement> driver;
	
	public static AndroidDriver<MobileElement> getDriver() {
		if(driver == null) {
			//createDriver();
			createTestObjectDriver();
		}
		return driver;
	}
    
    private static void createDriver() {
    	  DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
          desiredCapabilities.setCapability("platformName", "Android");
          desiredCapabilities.setCapability("deviceName", "ASUS ZENFONE 3");
          desiredCapabilities.setCapability("automationName", "uiautomator2");
          desiredCapabilities.setCapability("udid", "H1AZB602E567CBL");
          desiredCapabilities.setCapability("noReset", true);
          desiredCapabilities.setCapability("appPackage", "com.ctappium");
          desiredCapabilities.setCapability("appActivity", "com.ctappium.MainActivity");
       //   desiredCapabilities.setCapability(MobileCapabilityType.APP, "C:\\Users\\CLARK\\Documents\\CursoAppium\\src\\main\\resources\\CTAppium_1_0.apk");
          
        try {
			driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), desiredCapabilities);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    
    private static void createTestObjectDriver() {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("appium:deviceName","Android GoogleAPI Emulator");
        desiredCapabilities.setCapability("appium:deviceOrientation","portrait");
        desiredCapabilities.setCapability("appium:platformVersion","12.0");
        desiredCapabilities.setCapability("appium:automationName","UiAutomator2");
        desiredCapabilities.setCapability("appium:app","storage:filename=CTAppium_2_0.apk");
        DesiredCapabilities sauceOptions = new DesiredCapabilities();
    	sauceOptions.setCapability("build", "appium-build-AMIB6");
    	sauceOptions.setCapability("name", "<your test name>");
    	desiredCapabilities.setCapability("sauce:options", sauceOptions);
        //desiredCapabilities.setCapability("appium:deviceName","Android GoogleAPI Emulator");
        ////desiredCapabilities.setCapability("testobject_api_key", "91E74CCC23FC432EBF8F5C10F8685A15");
     //   desiredCapabilities.setCapability("appiumVersion", "1.7.2");
//        desiredCapabilities.setCapability("deviceName", "emulator-5554");
        //desiredCapabilities.setCapability("automationName", "uiautomator2");
//        desiredCapabilities.setCapability(MobileCapabilityType.APP, "/Users/wcaquino/Documents/dev/java/workspaceCurso/CursoAppium/src/main/resources/CTAppium_1_0.apk");
        
        try {
			driver = new AndroidDriver<MobileElement>(new URL("https://oauth-clark.ewerton-17bfd:62b27c1a-4422-4fd5-a052-7ba68a2a6a0b@ondemand.us-west-1.saucelabs.com:443/wd/hub"), desiredCapabilities);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    
    public static void killDriver() {
    	if(driver != null) {
    		driver.quit();
    		driver = null;
    	}
    }
}
