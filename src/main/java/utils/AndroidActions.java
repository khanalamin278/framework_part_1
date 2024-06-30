package utils;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

public class AndroidActions extends AppiumUtils{

    AndroidDriver driver;

    public AndroidActions(AndroidDriver driver){
        super(driver);
        this.driver = driver;
    }

    public void longPressAction(WebElement webElement) {

        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
                ImmutableMap.of("elementId", ((RemoteWebElement) webElement).getId(), "duration", 2000
                ));
    }

    public void scrollToAction() {

        boolean canScrollMore;
        do {
            canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "left", 100, "top", 100, "width", 200, "height", 200,
                    "direction", "down",
                    "percent", 1.0
            ));

        } while (canScrollMore);
    }

    public void scrollToText(String text){
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"))"));
    }

    public void swipeToAction(WebElement element, String str) {

        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "direction", str,
                "percent", 0.50
        ));
    }

}

/*
// AndroidActions ক্লাস যা AppiumUtils ক্লাসকে ইনহেরিট করছে।
public class AndroidActions extends AppiumUtils{

    // AndroidDriver ইনস্ট্যান্স ডিক্লেয়ার করা হচ্ছে।
    AndroidDriver driver;

    // কনস্ট্রাক্টর যা AndroidDriver গ্রহণ করে এবং প্যারেন্ট ক্লাসকে কল করে।
    public AndroidActions(AndroidDriver driver){
        super(driver);
        this.driver = driver;
    }

    // একটি এলিমেন্টে লং প্রেস অ্যাকশন সম্পন্ন করার মেথড।
    public void longPressAction(WebElement webElement) {

        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
                ImmutableMap.of("elementId", ((RemoteWebElement) webElement).getId(), "duration", 2000
                ));
    }

    // স্ক্রল অ্যাকশন সম্পন্ন করার মেথড।
    public void scrollToAction() {

        boolean canScrollMore;
        do {
            canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "left", 100, "top", 100, "width", 200, "height", 200,
                    "direction", "down",
                    "percent", 1.0
            ));
        } while (canScrollMore);
    }

    // নির্দিষ্ট টেক্সট খুঁজে স্ক্রল করার মেথড।
    public void scrollToText(String text){
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"))"));
    }

    // একটি এলিমেন্টে সোয়াইপ অ্যাকশন সম্পন্ন করার মেথড।
    public void swipeToAction(WebElement element, String str) {

        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "direction", str,
                "percent", 0.50
        ));
    }
}

 */