package IOS;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class AlertViews extends IOSActions {
    IOSDriver driver;

    public AlertViews(IOSDriver driver){
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


    public void fillTextLabel(String name){
        textEntryManu.click();
        textEntryManu.sendKeys(name);
        acceptPopUp.click();
    }

    public String getConfirmMessage(){
        confirmMenu.click();
        return confirmMenu.getText();
    }
}
