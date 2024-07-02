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
        List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir")+"//src//test//java//testData//en.json");
        return new Object[][] {  {data.get(0)}, {data.get(1)}   };
    }




    @AfterClass
    public static void startDriverStop() {
        driver.quit();
    }

}

