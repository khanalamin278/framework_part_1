package IOS;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.IOSActions;

public class HomePage extends IOSActions {
    IOSDriver driver;
    public HomePage(IOSDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver) , this);
   }

    @iOSXCUITFindBy(accessibility = "Alert Views")
    private WebElement alertViews;

    public AlertViews selectAlertViews(){
        alertViews.click();
        return new AlertViews(driver);
    }
}


/*
// HomePage ক্লাস যা IOSActions ক্লাসকে ইনহেরিট করছে।
public class HomePage extends IOSActions {

    // IOSDriver ইনস্ট্যান্স ডিক্লেয়ার করা হচ্ছে।
    IOSDriver driver;

    // কনস্ট্রাক্টর যা IOSDriver গ্রহণ করে এবং প্যারেন্ট ক্লাসকে কল করে এবং PageFactory ইনিশিয়ালাইজ করে।
    public HomePage(IOSDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver) , this);
   }

    // @iOSXCUITFindBy অ্যানোটেশন দ্বারা "Alert Views" এক্সেসিবিলিটি দিয়ে এলিমেন্ট খুঁজে পেতে সাহায্য করা হচ্ছে।
    @iOSXCUITFindBy(accessibility = "Alert Views")
    private WebElement alertViews;

    // AlertViews পেজে যাওয়ার জন্য selectAlertViews() মেথড।
    public AlertViews selectAlertViews(){
        alertViews.click();
        return new AlertViews(driver);
    }
}

 */