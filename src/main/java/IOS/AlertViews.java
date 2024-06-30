package IOS;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import utils.IOSActions;

public class AlertViews extends IOSActions {
    IOSDriver driver;

    public AlertViews(IOSDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver) , this);
    }

    @iOSXCUITFindBy(iOSClassChain = "**/XCUIElementTypeStaticText[`label=='Text Entry'`]")
    private WebElement textEntryManu;

    @iOSXCUITFindBy(accessibility = "OK")
    private WebElement acceptPopUp;

    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND value BEGINSWITH[C] 'Confirm'")
    private WebElement confirmMenu;

    @iOSXCUITFindBy(iOSNsPredicate = "name BEGINSWITH[C] 'A message'")
    private WebElement confirmMessage;

    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Confirm'")
    private WebElement confirm;

    public void fillTextLabel(String name) {
        textEntryManu.click();
        textEntryManu.sendKeys(name);
        acceptPopUp.click();
    }

    public String getConfirmMessage() {
        confirmMenu.click();
        return confirmMessage.getText();
    }
}

/*
    // AlertViews ক্লাস যা IOSActions ক্লাসকে ইনহেরিট করছে।
    public class AlertViews extends IOSActions {

    // IOSDriver ইনস্ট্যান্স ডিক্লেয়ার করা হচ্ছে।
    IOSDriver driver;

    // কনস্ট্রাক্টর যা IOSDriver গ্রহণ করে এবং প্যারেন্ট ক্লাসকে কল করে এবং PageFactory ইনিশিয়ালাইজ করে।
    public AlertViews(IOSDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver) , this);
    }

    // @iOSXCUITFindBy অ্যানোটেশন দ্বারা iOSClassChain ব্যবহার করে "Text Entry" লেবেল যুক্ত স্ট্যাটিক টেক্সট এলিমেন্ট খুঁজে পেতে সাহায্য করা হচ্ছে।
    @iOSXCUITFindBy(iOSClassChain = "XCUIElementTypeStaticText[`label=='Text Entry'`]")
    private WebElement textEntryManu;

    // @iOSXCUITFindBy অ্যানোটেশন দ্বারা accessibility ব্যবহার করে "OK" এক্সেসিবিলিটি দিয়ে এলিমেন্ট খুঁজে পেতে সাহায্য করা হচ্ছে।
    @iOSXCUITFindBy(accessibility = "OK")
    private WebElement acceptPopUp;

    // @iOSXCUITFindBy অ্যানোটেশন দ্বারা iOSNsPredicate ব্যবহার করে "Confirm" শুরু করে এমন XCUIElementTypeStaticText এলিমেন্ট খুঁজে পেতে সাহায্য করা হচ্ছে।
    @iOSXCUITFindBy(iOSNsPredicate = "type == 'XCUIElementTypeStaticText' AND value BEGINSWITH[C] 'Confirm'")
    private WebElement confirmMenu;

    // @iOSXCUITFindBy অ্যানোটেশন দ্বারা iOSNsPredicate ব্যবহার করে "A message" শব্দ দিয়ে শুরু করে এমন লেবেল খুঁজে পেতে সাহায্য করা হচ্ছে।
    @iOSXCUITFindBy(iOSNsPredicate = "name BEGINSWITH[C] 'A message'")
    private WebElement confirmMessage;

    // @iOSXCUITFindBy অ্যানোটেশন দ্বারা iOSNsPredicate ব্যবহার করে "Confirm" লেবেল খুঁজে পেতে সাহায্য করা হচ্ছে।
    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Confirm'")
    private WebElement confirm;

    // টেক্সট এন্ট্রি ম্যানু এলিমেন্টে নাম দিয়ে ফিল করার মেথড।
    public void fillTextLabel(String name){
        textEntryManu.click();
        textEntryManu.sendKeys(name);
        acceptPopUp.click();
    }

    // কনফার্ম মেনু ক্লিক করে কনফার্মেশন মেসেজ পাওয়ার মেথড।
    public String getConfirmMessage(){
        confirmMenu.click();
        return confirmMessage.getText();
    }
    }

 */