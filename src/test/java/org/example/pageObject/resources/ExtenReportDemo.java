package org.example.pageObject.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExtenReportDemo {
    static ExtentReports extent;

    public static ExtentReports getExtentReports() {
        String path = System.getProperty("user.dir") + "//reports//index.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Web Automation Results");
        reporter.config().setDocumentTitle("Text Results");

        extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Al Amin");
        return extent;
    }

    public void initialDemo() {
        ExtentTest text = extent.createTest("Initial Demo");
        System.setProperty("webdriver.chrome.driver", "c://chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.foodpanda.com.bd/");
        System.out.println(driver.getTitle());
        driver.close();
        text.fail("Result do not match");

        extent.flush();
    }
}


/*
public class ExtenReportDemo {
    // ExtentReports অবজেক্ট, যা রিপোর্ট তৈরির জন্য ব্যবহার করা হবে
    static ExtentReports extent;

    // মেথড যা ExtentReports অবজেক্ট ইনিশিয়ালাইজ করবে এবং রিটার্ন করবে
    @Test
    public static ExtentReports getExtentReports() {
        // রিপোর্টের জন্য ফাইল পাথ সেট করছে
        String path = System.getProperty("user.dir") + "//reports//index.html";
        // ExtentSparkReporter অবজেক্ট তৈরি করছে, যা রিপোর্ট ফাইল তৈরি করবে
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        // রিপোর্টের নাম সেট করছে
        reporter.config().setReportName("Web Automation Results");
        // রিপোর্ট ডকুমেন্টের শিরোনাম সেট করছে
        reporter.config().setDocumentTitle("Text Results");

        // ExtentReports অবজেক্ট ইনিশিয়ালাইজ করছে
        extent = new ExtentReports();
        // ExtentReports অবজেক্টে রিপোর্টার সংযুক্ত করছে
        extent.attachReporter(reporter);
        // সিস্টেম ইনফরমেশন যোগ করছে
        extent.setSystemInfo("Tester", "Al Amin");
        // ExtentReports অবজেক্ট রিটার্ন করছে
        return extent;
    }

    // ডেমো টেস্ট মেথড
    @Test
    public void initialDemo() {
        // নতুন টেস্ট তৈরি করছে এবং সেটিতে টেস্টের নাম লিখছে
        ExtentTest text = extent.createTest("Initial Demo");
        // WebDriver এর জন্য সিস্টেম প্রোপার্টি সেট করছে
        System.setProperty("webdriver.chrome.driver", "c://chromedriver.exe");
        // ChromeDriver ইনিশিয়ালাইজ করছে
        WebDriver driver = new ChromeDriver();
        // নির্দিষ্ট URL এ যাচ্ছে
        driver.get("https://www.foodpanda.com.bd/");
        // পেজের টাইটেল প্রিন্ট করছে
        System.out.println(driver.getTitle());
        // ব্রাউজার বন্ধ করছে
        driver.close();
        // টেস্ট ফেইল হওয়ার মেসেজ যোগ করছে
        text.fail("Result do not match");

        // রিপোর্ট ফাইল আপডেট (flush) করছে
        extent.flush();
    }
}

 */