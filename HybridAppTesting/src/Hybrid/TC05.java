package Hybrid;

import java.net.MalformedURLException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static java.time.Duration.ofSeconds;

public class TC05 extends Capability{

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
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
		driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
		driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
		//Add to cart click
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		Thread.sleep(4000);
		String amount1 = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(0).getText();
		System.out.println(amount1);
		//i used substring to remove the first character 
		amount1 = amount1.substring(1);
		//printed it is giving me the number
		System.out.println(amount1);
		double amountvalue1 = Double.parseDouble(amount1);
		
		//want to replicate to the second number
		String amount2 = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(1).getText();
		System.out.println(amount2);
		//i used substring to remove the first character 
		amount2 = amount2.substring(1);
		//printed it is giving me the number
		System.out.println(amount2);
		double amountvalue2 = Double.parseDouble(amount2);
		//This is to sum the amount 
		double sumofproduct = amountvalue1 + amountvalue2;
		System.out.println(sumofproduct);
		
		String Totalamount = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		Totalamount = Totalamount.substring(1);
		double totalvalue = Double.parseDouble(Totalamount);
		System.out.println(totalvalue);
		Assert.assertEquals(totalvalue, sumofproduct);
		
		//last requirement
		// i am tapping on checkbox
		WebElement Checkbox = driver.findElement(By.className("android.widget.CheckBox"));
        TouchAction t = new TouchAction(driver);
        t.tap(tapOptions().withElement(element(Checkbox))).perform();
        
        //i want to longpress on please read out terms and condition
WebElement instructions = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
        
        t.longPress(longPressOptions().withElement(element(instructions)).withDuration(ofSeconds(2))).release().perform();
        
        // i want to close the pop-up
        driver.findElement(By.id("android:id/button1")).click();
        
        //i am clicking on proceed button
        
        driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
        Thread.sleep(8000);
        
        // my Native app is changed the context to webapp
        Set<String> contextNames = driver.getContextHandles();
        for (String contextName : contextNames) {
            System.out.println(contextName); //prints out something like NATIVE_APP \n WEBVIEW_1
        }

	}

}
