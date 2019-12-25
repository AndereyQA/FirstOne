package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.element.TypifiedElement;

public class ActionWithElements {
    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());
    WebDriverWait webDriverWait_10, webDriverWait_15;

    public ActionWithElements(WebDriver webDriver){
        this.webDriver = webDriver;
        webDriverWait_10 = new WebDriverWait(webDriver, 10);
        webDriverWait_15 = new WebDriverWait(webDriver, 15);

    }



    public void enterTextInToInput(WebElement webElement, String text){
        try{
            webElement.clear();
            webElement.sendKeys(text);
            logger.info(text + " was inputed in to input");
        }catch (Exception e){
            stopTestAndPrintMessage();

        }

    }

    public void clickOnElement(WebElement webElement){
        try{
            webDriverWait_10.until(ExpectedConditions.elementToBeClickable(webElement));
            webElement.click();
            logger.info("Element was clicked " + getElementName(webElement))  ;
        }catch (Exception e){
            stopTestAndPrintMessage();
        }
    }

    private  String getElementName(WebElement webElement){
        String elementName = "";
        if (webElement instanceof TypifiedElement){
            elementName = "'" + ((TypifiedElement) webElement).getName() + "'";
        }
        return elementName;
    }

    public boolean isElementDisplayed(WebElement webElement){
        try{
            boolean state = webElement.isDisplayed();
            logger.info("Is element displayed -> " + state + ", " + webElement + " is displayed");
            return webElement.isDisplayed();
        }catch (Exception e){
            logger.info("Is element displayed -> " + false+ ", " + webElement + " is not displayed");
            return false;
        }
    }

    private void stopTestAndPrintMessage() {
        logger.error("Can not work with element ");
        Assert.fail("Can not work with element ");

    }

    public void selectValueInDropDByJava(WebElement dropDown, String value) {
        try{
            Select select = new Select(dropDown);
            select.selectByValue(value);
            logger.info(value + " was selected in Drop Down");
        }catch (Exception e){
            stopTestAndPrintMessage();
        }
    }
    public void selectVisibleTextInDropDByJava(WebElement dropDown, String text) {
        try {
            Select select = new Select(dropDown);
            select.selectByVisibleText(text);
            logger.info(text + " was selected in Drop Down");
        } catch (Exception e) {
            stopTestAndPrintMessage();
        }
    }

//    public void stepToNextTab(){
//        String windowHandler = webDriver.getWindowHandle();
//        webDriver.switchTo().window(windowHandler);
//    }



    public void setStateToCheckBox(WebElement checkBox, String state){
        boolean isStateChek = state.toLowerCase().equals("check");
        boolean isStateUnCheck = state.toLowerCase().equals("uncheck");
        boolean isCheckBoxSelected = checkBox.isSelected();

        if(isStateChek || isStateUnCheck){
            if((isStateChek && isCheckBoxSelected ) || (isStateUnCheck && !isCheckBoxSelected)){
                logger.info("Checkbox is alredy in ineededstate");
            }else if((isStateChek && !isCheckBoxSelected) ||(isStateUnCheck && isCheckBoxSelected)){
                clickOnElement(checkBox);
            }
        }else {
            logger.error("State shold be only 'check' or 'uncheck'");
            stopTestAndPrintMessage();
        }
    }
}