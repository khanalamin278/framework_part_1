package IOS;

import io.appium.java_client.AppiumBy;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IOSBasics extends IosBaseTest {
    @Test
    public void IOSBasicsTest(){
        AlertViews alertViews = homePage.selectAlertViews();
        alertViews.fillTextLabel("hello");
        String actualMessage = alertViews.getConfirmMessage();
        Assert.assertEquals(actualMessage, "A message should be a short, complete sentence.");
    }
}

/*
// IOSBasics ক্লাস ডিফাইন করা হচ্ছে এবং IosBaseTest থেকে এক্সটেন্ড করা হচ্ছে।
public class IOSBasics extends IosBaseTest {

    // @Test অ্যানোটেশন দ্বারা IOSBasicsTest মেথড কল করা হচ্ছে।
    @Test
    public void IOSBasicsTest(){
        // homePage থেকে AlertViews ইন্সট্যান্স পাঠানো হচ্ছে।
        AlertViews alertViews = homePage.selectAlertViews();

        // alertViews থেকে fillTextLabel মেথড কল করা হচ্ছে।
        alertViews.fillTextLabel("hello");

        // actualMessage থেকে getConfirmMessage মেথড কল করা হচ্ছে এবং মেসেজ স্ট্রিং রিটার্ন করা হচ্ছে।
        String actualMessage = alertViews.getConfirmMessage();

        // আসল মেসেজের সাথে তুলনা করা হচ্ছে এবং এসার্ট করা হচ্ছে।
        Assert.assertEquals(actualMessage, "A message should be a short, complete sentence.");
    }
}

 */