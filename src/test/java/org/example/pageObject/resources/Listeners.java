package org.example.pageObject.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.AppiumUtils;

public class Listeners extends AppiumUtils implements ITestListener {

    ExtentTest text;
    ExtentReports extent = ExtenReportDemo.getExtentReports();

    @Override
    public void onTestStart(ITestResult result){
        //todo
        text = extent.createTest(result.getMethod().getMethodName());
    }
    @Override
    public void onTestSuccess(ITestResult result){
        //todo
        text.log(Status.PASS, "Test Passed");
    }
    @Override
    public void onTestFailure(ITestResult result){
        //todo
        text.fail(result.getThrowable());
    }
    @Override
    public void onTestSkipped(ITestResult result){
        //todo
    }
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result){
        //todo
    }
    @Override
    public void onStart(ITestContext context){
        //todo
    }
    @Override
    public void onFinish(ITestContext context){
        //todo
        extent.flush();
    }
}


/*
public class Listeners extends AppiumUtils implements ITestListener {

    // ExtentTest অবজেক্ট, যেখানে আমরা টেস্টের ফলাফল লিখবো
    ExtentTest text;

    // ExtentReports অবজেক্ট, যা ExtenReportDemo থেকে ইনিশিয়ালাইজ করা হয়েছে
    ExtentReports extent = ExtenReportDemo.getExtentReports();

    @Override
    public void onTestStart(ITestResult result) {
        // যখন টেস্ট শুরু হয়, তখন নতুন টেস্ট পাতা তৈরি করে সেটিতে টেস্টের নাম লিখবো
        text = extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // যখন টেস্ট সফল হয়, তখন টেস্ট পাতায় "Test Passed" লেখা হবে
        text.log(Status.PASS, "Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // যখন টেস্ট ব্যর্থ হয়, তখন টেস্ট পাতায় কী কারণে ব্যর্থ হলো সেটি লেখা হবে
        text.fail(result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // যখন টেস্ট বাদ দেওয়া হয়, তখন কিছু করা হবে না (এখানে কিছু করা হয়নি)
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // যখন টেস্ট আংশিকভাবে সফল হয়, তখন কিছু করা হবে না (এখানে কিছু করা হয়নি)
    }

    @Override
    public void onStart(ITestContext context) {
        // যখন টেস্ট স্যুট শুরু হয়, তখন কিছু করা হবে না (এখানে কিছু করা হয়নি)
    }

    @Override
    public void onFinish(ITestContext context) {
        // যখন সব টেস্ট শেষ হয়, তখন ExtentReports অবজেক্টটি গুছিয়ে (flush) রাখবো
        extent.flush();
    }
}

 */