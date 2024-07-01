package utils;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.ObjectMapper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
//import net.bytebuddy.jar.asm.TypeReference;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

public class AppiumUtils {

    public Double getFormattedAmount(String amount){
        Double price = Double.parseDouble(amount.substring(1));
        return price;
    }

    public List<HashMap<String, String>> getJsonData(String jsonFilePath) throws IOException {

        String jsonContent = FileUtils.readFileToString(new File(jsonFilePath), StandardCharsets.UTF_8);
        ObjectMapper objectMapper = new ObjectMapper();

        List<HashMap<String, String>> data = objectMapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {
        });
        return data;
    }
//    public List<HashMap<String, String>> getJsonData(String jsonFilePath) throws IOException{
//        //System.getProperty"user.dir")+"src//test//java//org//example//pageObject//Json.json"
//        String jsonContent = FileUtils.readFileToString(new File(jsonFilePath), StandardCharsets.UTF_8);
//        ObjectMapper mapper = new ObjectMapper();
//        List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>() {});
//
//        return data;
//    }

    public void waitForElementToAppear(WebElement ele, AppiumDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.attributeContains((ele),"text","Cart"));
    }
}

/*
// AppiumUtils ক্লাস ডিফাইন করা হচ্ছে।
public class AppiumUtils {

    // AppiumDriver ডিক্লেয়ার করা হচ্ছে।
    AppiumDriver driver;

    // AppiumUtils কনস্ট্রাক্টর যা AppiumDriver রিসোর্সের জন্য ব্যবহৃত।
    public AppiumUtils(AppiumDriver driver){
        this.driver = driver;
        // ড্রাইভারের জন্য PageFactory ইনিশিয়ালাইজ করা হচ্ছে।
        PageFactory.initElements(new AppiumFieldDecorator(driver) , this);
    }

    // দেয়া টেক্সট থেকে মূল্য প্রাপ্ত করার জন্য getFormattedAmount মেথড।
    public Double getFormattedAmount(String amount){
        Double price = Double.parseDouble(amount.substring(1));
        return price;
    }

    // এলিমেন্টের উপস্থিতির জন্য অপেক্ষা করার জন্য waitForElementToAppear মেথড।
    public void waitForElementToAppear(WebElement ele){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.attributeContains((ele),"text","Cart"));
    }
}

 */