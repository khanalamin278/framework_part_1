package org.example;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.AndroidActions;

import java.util.List;

public class CartPage extends AndroidActions {
    AndroidDriver driver;

    public CartPage(AndroidDriver driver){
        super(driver);

        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver) , this);
    }

    public double getProductSum(){
        List<WebElement> productPrices = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
        int count = productPrices.size();
        double sum = 0;

        for (int i=0;i<count;i++){
            String amountString = productPrices.get(i).getText();
            Double price = getFormattedAmount(amountString);
            sum = sum+price;
        }
        return sum;
    }

    public double getTotalAmountDisplayed(){
        String displaySum = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
        Double displayFormattedSum = getFormattedAmount(displaySum);
        return displayFormattedSum;
    }
}

/*
// CartPage ক্লাস যা AndroidActions ক্লাসকে ইনহেরিট করছে।
public class CartPage extends AndroidActions {

    // AndroidDriver ইনস্ট্যান্স ডিক্লেয়ার করা হচ্ছে।
    AndroidDriver driver;

    // কনস্ট্রাক্টর যা AndroidDriver গ্রহণ করে এবং প্যারেন্ট ক্লাসকে কল করে এবং PageFactory ইনিশিয়ালাইজ করে।
    public CartPage(AndroidDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver) , this);
    }

    // প্রোডাক্ট সাম গেট করার মেথড।
    public double getProductSum(){
        List<WebElement> productPrices = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
        int count = productPrices.size();
        double sum = 0;

        for (int i=0;i<count;i++){
            String amountString = productPrices.get(i).getText();
            Double price = getFormattedAmount(amountString);
            sum = sum+price;
        }
        return sum;
    }

    // ডিসপ্লে হওয়া মোট সাম গেট করার মেথড।
    public double getTotalAmountDisplayed(){
        String displaySum = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
        Double displayFormattedSum = getFormattedAmount(displaySum);
        return displayFormattedSum;
    }
}

 */