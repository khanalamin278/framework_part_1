//package org.example;
//
//import io.appium.java_client.AppiumBy;
//import io.appium.java_client.android.nativekey.AndroidKey;
//import io.appium.java_client.android.nativekey.KeyEvent;
//import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.net.UrlChecker.TimeoutException;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//import io.appium.java_client.android.AndroidDriver;
//
//import java.time.Duration;
//import java.util.List;
//import java.util.Set;
//
//
//public class HybridAutomation extends BaseTest{
//        @Test
//        public void FillForm() throws InterruptedException {
//            fromPage.setNameField("Al amin khan");
//            fromPage.setGender("Male");
//            fromPage.setCountrySelection("Bangladesh");
//            ProductCatalogue productCatalogue = fromPage.submitFrom();
//            productCatalogue.addItemCartByIndex(0);
//            productCatalogue.addItemCartByIndex(0);
//            CartPage cartPage = productCatalogue.goToCartPage();
//
//            double totalSum = cartPage.getProductSum();
//
//            double displayFormattedSum = cartPage.getTotalAmountDisplayed();
//            Assert.assertEquals(totalSum,displayFormattedSum);
//
//
//            WebElement ele = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
//            longPressAction(ele);
//
//            driver.findElement(By.id("android:id/button1")).click();
//            driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
//            driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
//            Thread.sleep(6000);
//
//        }
//
//
//        @Test
//        public void FillForm() throws InterruptedException {
//            driver.findElement(By.id("android:id/text1")).click();
//            driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Bangladesh\"))"));
//            driver.findElement(By.xpath("//android.widget.TextView[@text='Bangladesh']")).click();
//            driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Al amin khan");
//            driver.hideKeyboard();
//            driver.findElement(By.id("com.androidsample.generalstore:id/radioMale")).click();
//            driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
//            driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan 6 Rings\"))"));
//
//            int productCount = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
//            for (int i = 0; i < productCount; i++) {
//                String productName = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
//                if (productName.equalsIgnoreCase("Jordan 6 Rings")) {
//                    driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
//                }
//            }
//            driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
//
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//
//            String lastPageProduct = driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
//            Assert.assertEquals(lastPageProduct, "Jordan 6 Rings");
//
//            Thread.sleep(3000);
//        }
//
//}
//
