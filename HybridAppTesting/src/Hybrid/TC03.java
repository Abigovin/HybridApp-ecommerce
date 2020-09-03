package Hybrid;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class TC03 extends Capability{

	public static void main(String[] args) throws MalformedURLException {
		AndroidDriver<AndroidElement> driver = DesiredCapability();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Niharika");
		driver.hideKeyboard();
		driver.findElement(By.xpath("//*[@text='Female']")).click();
		driver.findElement(By.id("android:id/text1")).click();
		//Scrolling the element to identify India
		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Australia\"))");
		//This is to click(Select) on India
		driver.findElement(By.xpath("//*[@text='Australia']")).click();
		
		//To click on Lets Shop
		//driver.findElement(MobileBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		//i am trying to scroll but with product list
	//driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(new UiSelector().textMatches(\"Jordan 6 Rings\").Instance(0))");
		driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(new UiSelector().textMatches(\"Jordan 6 Rings\").instance(0))"));
			// Trying tofetch the list of product
	int count = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
	System.out.println(count);
	for(int i=0;i<count;i++)
	{
		//To fetcht the text of the list
		String ProdcutName = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
		System.out.println(ProdcutName);
		if(ProdcutName.equalsIgnoreCase("Jordan 6 Rings"))
		{
			driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
			break;
		}
	}
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		String Actual = driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
		String Expected = "Jordan 6 Rings";
		Assert.assertEquals(Actual, Expected);
	}

}
