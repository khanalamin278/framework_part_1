package utils;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.HashMap;
import java.util.Map;

import static org.example.BaseTest.driver;

public class IOSActions extends AppiumUtils{
    IOSDriver driver;

    public IOSActions(IOSDriver driver){

        this.driver = driver;
    }

    public void longPressAction(WebElement ele, IOSDriver driver) {
        Map<String, Object> params = new HashMap<>();
        params.put("element", ((RemoteWebElement)ele).getId());
        params.put("duration",5);
        driver.executeScript("mobile:touchAndHold", params);
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

    public void scrollToWebElement(WebElement ele){
        Map<String, Object> params = new HashMap<>();
        params.put("direction", "down");
        params.put("element", ((RemoteWebElement)ele).getId());
        driver.executeScript("mobile:scroll",params);
    }

    public void swipeToAction(WebElement element, String str) {
        Map<String, Object> params = new HashMap<>();
        params.put("bundleId" , "com.apple.mobileslideshow");
        driver.executeScript("mobile:launchApp" , params);
    }
}

/*
// IOSActions ক্লাস ডিফাইন করা হচ্ছে এবং AppiumUtils ক্লাস থেকে এক্সটেন্ড করা হচ্ছে।
public class IOSActions extends AppiumUtils {

    // IOSDriver ডিক্লেয়ার করা হচ্ছে।
    IOSDriver driver;

    // IOSActions কনস্ট্রাক্টর যা IOSDriver রিসোর্সের জন্য ব্যবহৃত এবং PageFactory ইনিশিয়ালাইজ করা হচ্ছে।
    public IOSActions(IOSDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver) , this);
    }

    // লংপ্রেস অ্যাকশনের জন্য লংপ্রেসঅ্যাকশন মেথড, এলিমেন্ট প্যারামিটার হিসাবে গ্রহণ করে এবং টাচ এন্ড হোল্ড ইভেন্ট অনুলিপি হচ্ছে।
    public void longPressAction(WebElement ele) {
        Map<String, Object> params = new HashMap<>();
        params.put("element", ((RemoteWebElement)ele).getId());
        params.put("duration",5);
        driver.executeScript("mobile:touchAndHold", params);
    }

    // স্ক্রোল অ্যাকশনের জন্য স্ক্রোলটুঅ্যাকশন মেথড, এলিমেন্ট প্যারামিটার হিসাবে গ্রহণ করে এবং স্ক্রোল ইভেন্ট অনুলিপি হচ্ছে।
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

    // ওয়েব এলিমেন্টে স্ক্রোল করার জন্য স্ক্রোলটুওয়েবএলিমেন্ট মেথড, এলিমেন্ট প্যারামিটার হিসাবে গ্রহণ করে এবং স্ক্রোল ইভেন্ট অনুলিপি হচ্ছে।
    public void scrollToWebElement(WebElement ele){
        Map<String, Object> params = new HashMap<>();
        params.put("direction", "down");
        params.put("element", ((RemoteWebElement)ele).getId());
        driver.executeScript("mobile:scroll",params);
    }

    // স্যুইপ অ্যাকশনের জন্য স্যুইপটুঅ্যাকশন মেথড, এলিমেন্ট এবং স্ট্রিং প্যারামিটার হিসাবে গ্রহণ করে এবং এক্সিকিউট স্ক্রিপ্ট অনুলিপি হচ্ছে।
    public void swipeToAction(WebElement element, String str) {
        Map<String, Object> params = new HashMap<>();
        params.put("bundleId" , "com.apple.mobileslideshow");
        driver.executeScript("mobile:launchApp" , params);
    }
}

 */