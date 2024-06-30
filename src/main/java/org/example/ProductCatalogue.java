package org.example;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.AndroidActions;

import java.util.List;

public class ProductCatalogue extends AndroidActions {
    AndroidDriver driver;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='ADD TO CART']")
    private List<WebElement> addToCart;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/appbar_btn_cart")
    private WebElement cart;

    public ProductCatalogue(AndroidDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver) , this);
    }

    public void addItemCartByIndex(int index){
        addToCart.get(index).click();
    }

    public CartPage goToCartPage() throws InterruptedException {
        cart.click();
        Thread.sleep(2000);
        return new CartPage(driver);
    }
}

/*
// ProductCatalogue ক্লাস ডিফাইন করা হচ্ছে এবং AndroidActions ক্লাস থেকে এক্সটেন্ড করা হচ্ছে।
public class ProductCatalogue extends AndroidActions {

    // AndroidDriver ডিক্লেয়ার করা হচ্ছে।
    AndroidDriver driver;

    // @AndroidFindBy অ্যানোটেশন দ্বারা addToCart এলিমেন্টগুলির তালিকা বিশেষ ইভেন্ট এলিমেন্টে রিপ্রেজেন্ট করা হচ্ছে।
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='ADD TO CART']")
    private List<WebElement> addToCart;

    // @AndroidFindBy অ্যানোটেশন দ্বারা cart এলিমেন্টটি বিশেষ ইভেন্ট এলিমেন্টে রিপ্রেজেন্ট করা হচ্ছে।
    @AndroidFindBy(id = "com.androidsample.generalstore:id/appbar_btn_cart")
    private WebElement cart;

    // ProductCatalogue কনস্ট্রাক্টর যা AndroidDriver রিসোর্সের জন্য ব্যবহৃত এবং PageFactory ইনিশিয়ালাইজ করা হচ্ছে।
    public ProductCatalogue(AndroidDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver) , this);
    }

    // ইনডেক্সের সাথে পণ্য কার্টে যোগ করার জন্য এডআইটেমকার্ট বাই ইনডেক্স মেথড, ইনডেক্সের পজিশনের addToCart ক্লিক করা হচ্ছে।
    public void addItemCartByIndex(int index){
        addToCart.get(index).click();
    }

    // কার্ট পেজে যাওয়ার জন্য গোটুকার্টপেজ মেথড, কার্ট ক্লিক করা হচ্ছে এবং থ্রেড স্লিপ করা হচ্ছে এবং কার্টপেজ রিটার্ন হচ্ছে।
    public CartPage goToCartPage() throws InterruptedException {
        cart.click();
        Thread.sleep(2000);
        return new CartPage(driver);
    }
}

 */
