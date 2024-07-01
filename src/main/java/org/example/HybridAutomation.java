package org.example;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.junit.AfterClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.AppiumUtils;

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
        System.out.println(fromPage);
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
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

    @DataProvider
    public Object[][] getData() throws IOException {
        List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir")+"//src//test//java//org//example//pageObject//Json.json");
        return new Object[][] {  {data.get(0)}, {data.get(1)}   };
    }



    //    @Test
//    public void FillFormTwo() throws InterruptedException {
//        driver.findElement(By.id("android:id/text1")).click();
//        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Bangladesh\"))"));
//        driver.findElement(By.xpath("//android.widget.TextView[@text='Bangladesh']")).click();
//        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Al amin khan");
//        driver.hideKeyboard();
//        driver.findElement(By.id("com.androidsample.generalstore:id/radioMale")).click();
//        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
//        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan 6 Rings\"))"));
//
//        int productCount = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
//        for (int i = 0; i < productCount; i++) {
//            String productName = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
//            if (productName.equalsIgnoreCase("Jordan 6 Rings")) {
//                driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
//            }
//        }
//        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
//
//        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(5));
//
//        String lastPageProduct = driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
//        Assert.assertEquals(lastPageProduct , "Jordan 6 Rings");
//
//        Thread.sleep(3000);
//    }
//
//
    @AfterClass
    public static void startDriverStop() {
        driver.quit();
    }

}

/*
public class HybridAutomation extends BaseTest {

    // @BeforeMethod অ্যানোটেশন যা প্রতিটি টেস্ট মেথডের আগে startDriver মেথডটি রান করায়।
    @BeforeMethod
    public void startDriver() throws MalformedURLException, URISyntaxException {
        // ড্রাইভার সেট করা হচ্ছে।
        setDriver();
    }

    // @Test অ্যানোটেশন যা FillFormOne মেথডটি টেস্ট হিসেবে নির্ধারণ করে।
    @Test
    public void FillFormOne() throws InterruptedException {
        // নাম ফিল্ডে মান প্রদান করা হচ্ছে।
        fromPage.setNameField("Al amin khan");
        // লিঙ্গ নির্ধারণ করা হচ্ছে।
        fromPage.setGender("Male");
        // দেশ নির্বাচন করা হচ্ছে।
        fromPage.setCountrySelection("Bangladesh");
        // ফর্ম সাবমিট করে ProductCatalogue পৃষ্ঠা তে যাওয়া হচ্ছে।
        ProductCatalogue productCatalogue = fromPage.submitFrom();
        // প্রোডাক্ট কার্টে যোগ করা হচ্ছে।
        productCatalogue.addItemCartByIndex(0);
        productCatalogue.addItemCartByIndex(0);
        // কার্ট পৃষ্ঠায় যাওয়া হচ্ছে।
        CartPage cartPage = productCatalogue.goToCartPage();

        // প্রোডাক্টের মোট মূল্য গেট করা হচ্ছে।
        double totalSum = cartPage.getProductSum();
        // ডিসপ্লে হওয়া মোট মূল্য গেট করা হচ্ছে।
        double displayFormattedSum = cartPage.getTotalAmountDisplayed();
        // মোট মূল্য এবং ডিসপ্লে হওয়া মূল্য যাচাই করা হচ্ছে।
        Assert.assertEquals(totalSum , displayFormattedSum);

        // টার্মস বাটন আইডি দিয়ে এলিমেন্ট খুঁজে লং প্রেস অ্যাকশন করা হচ্ছে।
        WebElement ele = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
        longPressAction(ele);

        // এলিমেন্ট ক্লিক করা হচ্ছে।
        driver.findElement(By.id("android:id/button1")).click();
        driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
        // কিছুক্ষণ অপেক্ষা করা হচ্ছে।
        Thread.sleep(6000);
    }

    // @Test অ্যানোটেশন যা FillFormTwo মেথডটি টেস্ট হিসেবে নির্ধারণ করে।
    @Test
    public void FillFormTwo() throws InterruptedException {
        // এলিমেন্ট ক্লিক করা হচ্ছে।
        driver.findElement(By.id("android:id/text1")).click();
        // স্ক্রল করে বাংলাদেশ নির্বাচন করা হচ্ছে।
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Bangladesh\"))"));
        driver.findElement(By.xpath("//android.widget.TextView[@text='Bangladesh']")).click();
        // নাম ফিল্ডে মান প্রদান করা হচ্ছে।
        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Al amin khan");
        // কীবোর্ড হাইড করা হচ্ছে।
        driver.hideKeyboard();
        // লিঙ্গ নির্বাচন করা হচ্ছে।
        driver.findElement(By.id("com.androidsample.generalstore:id/radioMale")).click();
        // লেটস শপ বাটন ক্লিক করা হচ্ছে।
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        // স্ক্রল করে প্রোডাক্ট খুঁজে নেয়া হচ্ছে।
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan 6 Rings\"))"));

        // প্রোডাক্ট কাউন্ট গেট করা হচ্ছে।
        int productCount = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
        for (int i = 0; i < productCount; i++) {
            // প্রোডাক্টের নাম গেট করা হচ্ছে।
            String productName = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
            // যদি প্রোডাক্টের নাম "Jordan 6 Rings" হয় তবে কার্টে যোগ করা হচ্ছে।
            if (productName.equalsIgnoreCase("Jordan 6 Rings")) {
                driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
            }
        }
        // কার্ট বাটন ক্লিক করা হচ্ছে।
        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();

        // ওয়েট অবজেক্ট তৈরি করে অপেক্ষা করা হচ্ছে।
        WebDriverWait wait = new WebDriverWait(driver , Duration.ofSeconds(5));

        // শেষ পৃষ্ঠার প্রোডাক্টের নাম যাচাই করা হচ্ছে।
        String lastPageProduct = driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
        Assert.assertEquals(lastPageProduct , "Jordan 6 Rings");

        // কিছুক্ষণ অপেক্ষা করা হচ্ছে।
        Thread.sleep(3000);
    }

    // @AfterClass অ্যানোটেশন যা startDriverStop মেথডটি ক্লাসের পরে একবার রান করায়।
    @AfterClass
    public static void startDriverStop() {
        // ড্রাইভার বন্ধ করা হচ্ছে।
        driver.quit();
    }
}

 */