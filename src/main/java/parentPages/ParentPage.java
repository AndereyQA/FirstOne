package parentPages;

import libs.ActionWithElements;
import libs.ConfigProperties;
import org.aeonbits.owner.ConfigFactory;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

public class ParentPage {

    protected WebDriver webDriver;
    protected Logger logger = Logger.getLogger(getClass());
    protected ActionWithElements actionsWithElements;
    public ConfigProperties configProperties = ConfigFactory.create(ConfigProperties.class);
    String baseUrl;
    String expectedUrl;

    @FindBy(name="login")
    private Link inputLogin;

    @FindBy(xpath = "//input[@type='checkbox']")
    private Link checkBox;

    @FindBy(xpath = "//div[text()='Продовжити']")
    private Link nextButton;


    public ParentPage(WebDriver webDriver, String partUrl) {
        this.webDriver = webDriver;
        baseUrl = configProperties.base_url();
        PageFactory.initElements(new HtmlElementDecorator(new HtmlElementLocatorFactory(webDriver)),this);
        actionsWithElements = new ActionWithElements(webDriver);
        expectedUrl = baseUrl + partUrl;
    }

    public void checkCurrentUrl(){
        try{
            Assert.assertEquals(
                    "URL is not expected",
                    expectedUrl,
                    webDriver.getCurrentUrl()
            );

        } catch (Exception e){
            logger.error("Can get url" + e);
            Assert.fail("Can get url" + e);
        }
    }




    private void stopTestAndPrintMessage() {
        logger.error("Can not work with element ");
        Assert.fail("Can not work with element ");
    }

    public void GoGoButton() {
        actionsWithElements.clickOnElement(nextButton);
    }
}
