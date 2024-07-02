package org.example;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.junit.AfterClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.BeforeClass;
import utils.AppiumUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.time.Duration;
import java.util.Properties;


public class BaseTest extends AppiumUtils {


    public static AndroidDriver driver;
    public static AppiumDriverLocalService service;
    public FromPage fromPage;



    @BeforeClass //
    public void ConfigarAppium() throws IOException, URISyntaxException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//test//java//org//example//pageObject//resources//data.properties");

        prop.load(fis);
        String ipAddress = prop.getProperty("ipAddress");
        String port = prop.getProperty("port");

        service = startAppiumServer(ipAddress, Integer.parseInt(port));

    }

    public void setDriver() throws MalformedURLException, URISyntaxException {
        Properties prop = new Properties();
        UiAutomator2Options options = new UiAutomator2Options();

        options.setDeviceName(prop.getProperty("AndroidDeviceName"));

        //options.setChromedriverExecutable("C://Programming//QaWorks//khan//src//test//java//resource//chromedriver.exe");

        //options.setApp("D://shohag_dada//framework_part_1//src//test//java//org//example//pageObject//resources//General-Store.apk");

        //options.setApp("C://Programming//QaWorks//khan//src//test//java//resource//ApiDemos-debug.apk");

        options.setApp("C://Programming//QaWorks//framework_part_1//src//test//java//org//example//pageObject//resources//General-Store.apk");

        driver = new AndroidDriver(service.getUrl(), options);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        fromPage = new FromPage(driver);

    }


    public void longPressAction(WebElement webElement) {

        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
                ImmutableMap.of("elementId", ((RemoteWebElement) webElement).getId(), "duration", 2000
                ));
    }

    public void scrolloToAction() {

        boolean canScrollMore;
        do {
            canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "left", 100, "top", 100, "width", 200, "height", 200,
                    "direction", "down",
                    "percent", 1.0
            ));

        } while (canScrollMore);
    }

    public void swipeToAction(WebElement element, String str) {

        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "direction", str,
                "percent", 0.50
        ));
    }

    public Double getFormattedAmount(String amount){
        Double price = Double.parseDouble(amount.substring(1));
        return price;
    }

    @AfterClass
    public static void tearDown() {
//        driver.quit();
        service.stop();
    }

}



/*
public class BaseTest {

    // ড্রাইভার যা অ্যান্ড্রয়েড অ্যাপের সঙ্গে যোগাযোগ করে।
    public static AndroidDriver driver;
    // অ্যাপিয়াম সার্ভিস যা স্থানীয় সার্ভারে চলে।
    public static AppiumDriverLocalService service;
    public FromPage fromPage;

    // @BeforeClass অ্যানোটেশন যা ConfigarAppium মেথডটি ক্লাসের আগে একবার রান করায়।
    @BeforeClass
    public void ConfigarAppium() throws MalformedURLException, URISyntaxException {
        // অ্যাপিয়াম সার্ভিস বিল্ডার ব্যবহার করে সার্ভিস সেটআপ করা হচ্ছে।
        service = new AppiumServiceBuilder()
                // অ্যাপিয়াম জেএস ফাইলের অবস্থান উল্লেখ করা হচ্ছে।
                .withAppiumJS(new File("C://Users//hp//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"))
                // আইপি এড্রেস ও পোর্ট নম্বর সেট করা হচ্ছে।
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .build();

        // সার্ভিস শুরু করা হচ্ছে।
        service.start();
    }

    // ড্রাইভার সেট করার মেথড।
    public void setDriver() throws MalformedURLException, URISyntaxException {
        UiAutomator2Options options = new UiAutomator2Options();

        // ডিভাইসের নাম সেট করা হচ্ছে।
        options.setDeviceName("Pixel 2 API 34");

        // অ্যাপের অবস্থান উল্লেখ করা হচ্ছে।
        options.setApp("C://Programming//QaWorks//khan//src//test//java//resource//General-Store.apk");

        // অ্যান্ড্রয়েড ড্রাইভার ইনস্ট্যান্স তৈরি করা হচ্ছে।
        driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);

        // ইনপ্লিসিট ওয়েট টাইমআউট সেট করা হচ্ছে।
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        fromPage = new FromPage(driver);
    }

    // একটি এলিমেন্টে লং প্রেস অ্যাকশন সম্পন্ন করার মেথড।
    public void longPressAction(WebElement webElement) {
        ((JavascriptExecutor) driver).executeScript("mobile: longClickGesture",
                ImmutableMap.of("elementId", ((RemoteWebElement) webElement).getId(), "duration", 2000
                ));
    }

    // স্ক্রল অ্যাকশন সম্পন্ন করার মেথড।
    public void scrolloToAction() {
        boolean canScrollMore;
        do {
            canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
                    "left", 100, "top", 100, "width", 200, "height", 200,
                    "direction", "down",
                    "percent", 1.0
            ));
        } while (canScrollMore);
    }

    // একটি এলিমেন্টে সোয়াইপ অ্যাকশন সম্পন্ন করার মেথড।
    public void swipeToAction(WebElement element, String str) {
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
                "elementId", ((RemoteWebElement) element).getId(),
                "direction", str,
                "percent", 0.50
        ));
    }

    // একটি অ্যামাউন্ট ফর্ম্যাট করা (ডবল এ কনভার্ট) করার মেথড।
    public Double getFormattedAmount(String amount){
        Double price = Double.parseDouble(amount.substring(1));
        return price;
    }

    // @AfterClass অ্যানোটেশন যা tearDown মেথডটি ক্লাসের পরে একবার রান করায়।
    @AfterClass
    public static void tearDown() {
        // ড্রাইভার বন্ধ করা হচ্ছে (আপাতত কমেন্ট আউট)।
        // driver.quit();
        // সার্ভিস বন্ধ করা হচ্ছে।
        service.stop();
    }
}


 */