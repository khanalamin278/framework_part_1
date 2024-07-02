package org.example;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.AndroidActions;


public class FromPage extends AndroidActions {
    AndroidDriver driver;
    public FromPage(AndroidDriver driver){
        super(driver);

        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver) , this);
    }

    @AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
    public WebElement nameField;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/radioMale")
    public WebElement maleOption;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/radioFemale")
    public WebElement femaleOption;

    @AndroidFindBy(id = "android:id/text1")
    public WebElement countrySelection;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
    public WebElement shopButton;

    public void setNameField(String name){
        nameField.sendKeys(name);
        driver.hideKeyboard();
    }

    public void setGender(String gender){
        if (gender.contains("Male"))
            maleOption.click();
        else
            femaleOption.click();
    }

    public void setCountrySelection(String countryName){
         countrySelection.click();
        scrollToText(countryName);
        driver.findElement(By.xpath("//android.widget.TextView[@text='"+countryName+"']")).click();
        //driver.findElement(By.xpath("//android.widget.TextView[@resource-id='android:id/text1' and @text='"+countryName+"']")).click();
    }

    public ProductCatalogue submitFrom(){
        shopButton.click();
        return new ProductCatalogue(driver);
    }
}

/*
// FromPage ক্লাস ডিফাইন করা হচ্ছে এবং AndroidActions ক্লাস থেকে এক্সটেন্ড করা হচ্ছে।
public class FromPage extends AndroidActions {

    // AndroidDriver ডিক্লেয়ার করা হচ্ছে।
    AndroidDriver driver;

    // FromPage কনস্ট্রাক্টর যা AndroidDriver রিসোর্সের জন্য ব্যবহৃত।
    public FromPage(AndroidDriver driver){
        super(driver);
        this.driver = driver;
        // ড্রাইভারের জন্য PageFactory ইনিশিয়ালাইজ করা হচ্ছে।
        PageFactory.initElements(new AppiumFieldDecorator(driver) , this);
    }

    // @AndroidFindBy অ্যানোটেশন দ্বারা nameField এলিমেন্টটি বিশেষ ইভেন্ট এলিমেন্টে রিপ্রেজেন্ট করা হচ্ছে।
    @AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
    private WebElement nameField;

    // @AndroidFindBy অ্যানোটেশন দ্বারা maleOption এলিমেন্টটি বিশেষ ইভেন্ট এলিমেন্টে রিপ্রেজেন্ট করা হচ্ছে।
    @AndroidFindBy(id = "com.androidsample.generalstore:id/radioMale")
    private WebElement maleOption;

    // @AndroidFindBy অ্যানোটেশন দ্বারা femaleOption এলিমেন্টটি বিশেষ ইভেন্ট এলিমেন্টে রিপ্রেজেন্ট করা হচ্ছে।
    @AndroidFindBy(id = "com.androidsample.generalstore:id/radioFemale")
    private WebElement femaleOption;

    // @AndroidFindBy অ্যানোটেশন দ্বারা countrySelection এলিমেন্টটি বিশেষ ইভেন্ট এলিমেন্টে রিপ্রেজেন্ট করা হচ্ছে।
    @AndroidFindBy(id = "android:id/text1")
    private WebElement countrySelection;

    // @AndroidFindBy অ্যানোটেশন দ্বারা shopButton এলিমেন্টটি বিশেষ ইভেন্ট এলিমেন্টে রিপ্রেজেন্ট করা হচ্ছে।
    @AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
    private WebElement shopButton;

    // নাম ফিল্ডের জন্য নেমফিল্ড মেথড, স্ট্রিং নেম প্যারামিটার গ্রহণ করে এবং কীবোর্ড লুকানো হচ্ছে।
    public void setNameField(String name){
        nameField.sendKeys(name);
        driver.hideKeyboard();
    }

    // জেন্ডার সেটকরণের জন্য সেটজেন্ডার মেথড, যদি জেন্ডার "Male" এর মধ্যে থাকে তবে মেলঅপশন ক্লিক করা হবে, অন্যথায় ফিমেলঅপশন ক্লিক করা হবে।
    public void setGender(String gender){
        if (gender.contains("Male"))
            maleOption.click();
        else
            femaleOption.click();
    }

    // দেশ নির্বাচনের জন্য সেটকান্ট্রিসিলেকশন মেথড, কান্ট্রি নাম প্যারামিটার গ্রহণ করে এবং টেক্সট স্ক্রোল করা হচ্ছে এবং দেশ নির্বাচন করা হচ্ছে।
    public void setCountrySelection(String countryName){
        countrySelection.click();
        scrollToText(countryName);
        driver.findElement(By.xpath("//android.widget.TextView[@text='"+countryName+"']")).click();
    }

    // ফর্ম জমা দেওয়ার জন্য সাবমিট ফ্রম মেথড, শপ বাটন ক্লিক করা হচ্ছে এবং প্রোডাক্ট ক্যাটালগ রিটার্ন হচ্ছে।
    public ProductCatalogue submitFrom(){
        shopButton.click();
        return new ProductCatalogue(driver);
    }
}

 */