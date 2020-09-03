package Hybrid;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class TC2NegativeScenario extends Capability{

	public static void main(String[] args) throws MalformedURLException {
		AndroidDriver<AndroidElement> driver = DesiredCapability();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//i am commenting the below two line to check negative scenario
		//driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Niharika");
		//driver.hideKeyboard();
		driver.findElement(By.xpath("//*[@text='Female']")).click();
		driver.findElement(By.id("android:id/text1")).click();
		//Scrolling the element to identify India
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"))");
		//This is to click(Select) on India
		driver.findElement(By.xpath("//*[@text='India']")).click();
		
		//To click on Lets Shop
		//driver.findElement(MobileBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		//the error message are called as toas message 
		String Actual =driver.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("name");
		String Expected = "Please enter your name";
		Assert.assertEquals(Actual, Expected);
		

	}

}
