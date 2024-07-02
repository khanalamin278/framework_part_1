package IOS;

//public class IosBaseTest extends AppiumUtils {
//    IOSDriver driver;
//    AppiumDriverLocalService service;
//    public HomePage homePage;
//
//    @BeforeClass
//    public void ConfigarAppium() throws IOException, URISyntaxException {
//        Properties prop = new Properties();
//        FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//test//java//org//example//pageObject//resources//data.properties");
//
//        prop.load(fis);
//        String ipAddress = prop.getProperty("ipAddress");
//        String port = prop.getProperty("port");
//
//        service = startAppiumServer(ipAddress, Integer.parseInt(port));
//
//
//
//        XCUITestOptions options = new XCUITestOptions();
//        options.setDeviceName("iPhone 14 Pro Max");
//        //options.setApp("//Users//mobile_2//Downloads//resources//TestApp3.app");
//        options.setApp("/Users/mobile_2/Downloads/ios-uicatalog-master/UIKitCatalog/build/Release-iphonesimulator/UIKitCatalog-iphonesimulator.app");
//        options.setPlatformVersion("16.4");
//        options.setWdaLocalPort(8150);
//        options.setWdaLaunchTimeout(Duration.ofSeconds(20));
//        driver = new IOSDriver(service.getUrl(), options);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        homePage = new HomePage(driver);
//    }
//
//    public  void longPressIos(WebElement element){
//        Map<String, Object> params = new HashMap<>();
//        params.put("element", ((RemoteWebElement)element).getId());
//        params.put("duration",5);
//        driver.executeScript("mobile:touchAndHold", params);
//    }
//
//    public  void  scrollViewIos(WebElement element){
//        Map<String, Object> params = new HashMap<>();
//        params.put("direction", "down");
//        params.put("element", ((RemoteWebElement)element).getId());
//        driver.executeScript("mobile:scroll",params);
//    }
//
//    @AfterClass
//    public void tearDown() {
//        driver.quit();
//        service.stop();
//        System.out.println("AfterClass");
//    }
//}

/*
// IosBaseTest ক্লাস ডিফাইন করা হচ্ছে।
public class IosBaseTest {

    // IOSDriver এক্সপোর্ট করা হচ্ছে।
    IOSDriver driver;

    // AppiumDriverLocalService এক্সপোর্ট করা হচ্ছে।
    AppiumDriverLocalService service;

    // HomePage ক্লাসের ইনস্ট্যান্স ডিক্লেয়ার করা হচ্ছে।
    public HomePage homePage;

    // @BeforeClass অ্যানোটেশন দ্বারা ConfigarAppium মেথড কল করা হচ্ছে যা Appium সেটাপ করে এবং ড্রাইভার ইনিশিয়ালাইজ করে।
    @BeforeClass
    public void ConfigarAppium() throws MalformedURLException, URISyntaxException {
        service = new AppiumServiceBuilder()
                // Appium সার্ভারের পথ সেট করা হচ্ছে।
                .withAppiumJS(new File("//opt//homebrew//lib//node_modules//appium//index.js"))
                // লোকাল আইপি এড্রেস সেট করা হচ্ছে।
                .withIPAddress("127.0.0.1")
                // পোর্ট সেট করা হচ্ছে।
                .usingPort(4750)
                // Appium সার্ভার শুরু করা হচ্ছে।
                .build();
        service.start();

        // XCUITestOptions ইনিশিয়ালাইজ করা হচ্ছে এবং অপশন সেট করা হচ্ছে।
        XCUITestOptions options = new XCUITestOptions();
        options.setDeviceName("iPhone 14 Pro Max");
        // অ্যাপ্লিকেশন ফাইলের পথ সেট করা হচ্ছে।
        options.setApp("/Users/mobile_2/Downloads/ios-uicatalog-master/UIKitCatalog/build/Release-iphonesimulator/UIKitCatalog-iphonesimulator.app");
        // প্ল্যাটফর্ম সংস্করণ সেট করা হচ্ছে।
        options.setPlatformVersion("16.4");
        options.setWdaLocalPort(8150);
        options.setWdaLaunchTimeout(Duration.ofSeconds(20));

        // IOSDriver ইনিশিয়ালাইজ করা হচ্ছে।
        driver = new IOSDriver(new URI("http://127.0.0.1:4750").toURL(), options);
        // ইমপ্লিসিট ওয়েট সেট করা হচ্ছে।
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // HomePage ইনিশিয়ালাইজ করা হচ্ছে এবং ড্রাইভার পাঠানো হচ্ছে।
        homePage = new HomePage(driver);
    }

    // longPressIos মেথড যা ড্রাইভারে লং প্রেস একশন পাঠানোর জন্য ব্যবহৃত।
    public void longPressIos(WebElement element){
        Map<String, Object> params = new HashMap<>();
        params.put("element", ((RemoteWebElement)element).getId());
        params.put("duration",5);
        driver.executeScript("mobile:touchAndHold", params);
    }

    // scrollViewIos মেথড যা ড্রাইভারে স্ক্রোল একশন পাঠানোর জন্য ব্যবহৃত।
    public void scrollViewIos(WebElement element){
        Map<String, Object> params = new HashMap<>();
        params.put("direction", "down");
        params.put("element", ((RemoteWebElement)element).getId());
        driver.executeScript("mobile:scroll",params);
    }

    // @AfterClass অ্যানোটেশন দ্বারা tearDown মেথড কল করা হচ্ছে যা ড্রাইভার বন্ধ করে এবং Appium সেবা বন্ধ করে।
    @AfterClass
    public void tearDown() {
        driver.quit();
        service.stop();
        System.out.println("AfterClass");
    }
}

 */