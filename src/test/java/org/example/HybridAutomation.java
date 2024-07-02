package org.example;

import io.appium.java_client.AppiumBy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.List;


public class HybridAutomation extends BaseTest {

    @BeforeMethod
   public void startDriver() throws MalformedURLException, URISyntaxException {
       setDriver();
    }

    @Test(dataProvider = "getData")
    public void FillFormOne(HashMap<String, String> input) throws InterruptedException {
        fromPage.setNameField(input.get("name"));
        fromPage.setGender(input.get("gender"));
        fromPage.setCountrySelection(input.get("country"));
        ProductCatalogue productCatalogue = fromPage.submitFrom();
        productCatalogue.addItemCartByIndex(0);
        productCatalogue.addItemCartByIndex(0);
        CartPage cartPage = productCatalogue.goToCartPage();
        double totalSum = cartPage.getProductSum();
        double displayFormattedSum = cartPage.getTotalAmountDisplayed();
        Assert.assertEquals(totalSum , displayFormattedSum);
        WebElement ele = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
        longPressAction(ele);
        driver.findElement(By.id("android:id/button1")).click();
        driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
        Thread.sleep(6000);
    }
    @Test(dataProvider = "getData")
    public void FillFormTwo(HashMap<String, String> input) throws InterruptedException {
       Assert.fail("Result dose not match");
    }

    @DataProvider
    public Object[][] getData() throws IOException {
        List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir")+"//src//test//java//testData//en.json");
        return new Object[][] {  {data.get(0)}, {data.get(1)}   };
    }

    @AfterClass
    public static void startDriverStop() {
        driver.quit();
    }

}

/*
// HybridAutomation ক্লাসটি BaseTest ক্লাস থেকে ইন্টারিট করছে
public class HybridAutomation extends BaseTest {

    // টেস্টের আগে ড্রাইভার শুরু করার জন্য মেথড
    @BeforeMethod
    public void startDriver() throws MalformedURLException, URISyntaxException {
        // ড্রাইভার সেটআপ করার মেথড
        setDriver();
    }

    // প্রথম টেস্ট মেথড যা ডেটা প্রোভাইডার থেকে ডেটা নিয়ে কাজ করবে
    @Test(dataProvider = "getData")
    public void FillFormOne(HashMap<String, String> input) throws InterruptedException {
        // নাম ফিল্ডে ইনপুট সেট করছে
        fromPage.setNameField(input.get("name"));
        // জেন্ডার ফিল্ডে ইনপুট সেট করছে
        fromPage.setGender(input.get("gender"));
        // দেশ নির্বাচন করছে
        fromPage.setCountrySelection(input.get("country"));
        // ফর্ম সাবমিট করে প্রোডাক্ট ক্যাটালগ পেজে যাচ্ছে
        ProductCatalogue productCatalogue = fromPage.submitFrom();
        // প্রথম প্রোডাক্ট কার্টে যোগ করছে
        productCatalogue.addItemCartByIndex(0);
        // দ্বিতীয়বার প্রথম প্রোডাক্ট কার্টে যোগ করছে
        productCatalogue.addItemCartByIndex(0);
        // কার্ট পেজে যাচ্ছে
        CartPage cartPage = productCatalogue.goToCartPage();
        // প্রোডাক্টগুলোর মোট দাম পাচ্ছে
        double totalSum = cartPage.getProductSum();
        // ডিসপ্লেতে প্রদর্শিত মোট দাম পাচ্ছে
        double displayFormattedSum = cartPage.getTotalAmountDisplayed();
        // মোট দাম এবং প্রদর্শিত দাম মিলে কিনা যাচাই করছে
        Assert.assertEquals(totalSum, displayFormattedSum);
        // টার্মস বাটনের এলিমেন্ট খুঁজছে
        WebElement ele = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
        // লং প্রেস অ্যাকশন করছে
        longPressAction(ele);
        // ডায়ালগ বক্সে ওকে বাটন ক্লিক করছে
        driver.findElement(By.id("android:id/button1")).click();
        // চেকবক্স নির্বাচন করছে
        driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
        // প্রসিড বাটন ক্লিক করছে
        driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
        // কিছু সময় অপেক্ষা করছে (৬ সেকেন্ড)
        Thread.sleep(6000);
    }

    // দ্বিতীয় টেস্ট মেথড যা ডেটা প্রোভাইডার থেকে ডেটা নিয়ে কাজ করবে
    @Test(dataProvider = "getData")
    public void FillFormTwo(HashMap<String, String> input) throws InterruptedException {
        // টেস্ট ব্যর্থ হওয়ার মেসেজ
        Assert.fail("Result does not match");
    }

    // ডেটা প্রোভাইডার মেথড যা টেস্টের জন্য ডেটা সরবরাহ করে
    @DataProvider
    public Object[][] getData() throws IOException {
        // JSON ফাইল থেকে ডেটা নিয়ে একটি লিস্ট তৈরি করছে
        List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir") + "//src//test//java//testData//en.json");
        // লিস্টের প্রথম দুটি ডেটা রিটার্ন করছে
        return new Object[][] { {data.get(0)}, {data.get(1)} };
    }

    // টেস্টের পর ড্রাইভার বন্ধ করার জন্য মেথড
    @AfterClass
    public static void startDriverStop() {
        // ড্রাইভার বন্ধ করছে
        driver.quit();
    }
}

 */