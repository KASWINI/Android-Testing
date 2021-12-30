package Android.Android;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import okhttp3.internal.Util;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import com.microsoft.appcenter.appium.Factory;
import com.microsoft.appcenter.appium.EnhancedAndroidDriver;
import org.junit.rules.TestWatcher;
import org.junit.Rule;

public class App 
{
   
    	
    	    @Rule
    	    public TestWatcher watcher = Factory.createWatcher();

    	    private static EnhancedAndroidDriver<MobileElement> driver;

    	    public static EnhancedAndroidDriver<MobileElement> startApp() throws MalformedURLException {
    	        DesiredCapabilities capabilities = new DesiredCapabilities();

    	        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "android");
    	        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Samsung Galaxy S21 Ultra");
    	        capabilities.setCapability(MobileCapabilityType.APP, "[path to local repo]/Android-Testing/blob/main/Android/src/main/java/Android/Android/App.java");
    	        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 7913);
    	       // capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");

    	        URL url = new URL("http://localhost:4723/wd/hub");

    	        return Factory.createAndroidDriver(url, capabilities);
    	        
    	        
    	    }


    	    @Test
    	    public void canStartAppInTest() throws MalformedURLException, InterruptedException {
    	        driver = startApp();

    	    /*    MobileElement elem = Util.findByByOrName(driver, By.id("com.moonpi.swiftnotes:id/newNote"), "+");
    	        elem.click();
    	        Thread.sleep(5000); */
    	        driver.get("https://wac.das.myatos.net/portal/auth.jsp");
    			  driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
    			  driver.findElement(By.xpath("//*[@id=\"dataForm\"]/fieldset/input[5]")).sendKeys("XXXXXX");
    			  driver.findElement(By.xpath("//*[@id=\"dataForm\"]/fieldset/input[6]")).sendKeys("password");
    			  driver.findElement(By.xpath("//*[@id=\"dataForm\"]/fieldset/input[8]")).sendKeys("064321");
    			  driver.findElement(By.xpath("/html/body/div/div/div[1]/div/form[2]/input[4]")).click();
    			  driver.quit();


    	    }

    	    @After
    	    public void after() throws Exception {
    	        if (driver != null) {
    	            driver.label("Stopping App");
    	            driver.quit();
    	        }
    	    }
}
