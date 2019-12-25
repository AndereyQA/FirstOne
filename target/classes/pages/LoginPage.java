package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPages.ParentPage;
import ru.yandex.qatools.htmlelements.element.Link;

import static org.junit.Assert.fail;


public class LoginPage extends ParentPage {
    @FindBy(name="login")
    private WebElement inputLogin;

    @FindBy(name="password")
    private WebElement inputPassword;

    @FindBy(name = "Ідентифікаційний номер (ІПН)")     // //input[@name='taxCode']     name = "taxCode"
    private WebElement inputInn;

    @FindBy(xpath = "//input[@type='tel']")
    private WebElement inputPhone;

    @FindBy(xpath = "//div[@class='_3SSx_7wcQF8YTr5NPpH5jn _21cg_jXbM_xLCkMZ2i2zQK']")
    private WebElement buttonLogin;

    @FindBy(xpath = "//a[text()='Відкрити рахунок']")
    private Link buttonCreateAcc;

    @FindBy(xpath = "//span[text()='Забули пароль?']")
    private WebElement buttonForgotPass;

    @FindBy(xpath = "//img[@src='/static/883e0f09dae6e05e01a29e476e79e5ae.jpg']")
    private Link buttonChat;

    @FindBy(xpath = "//span[@data-error-type='_error']")
    private Link messageWrongPass;

    @FindBy(xpath = "//p[text()='Обраний тариф TEST-Drive']")
    private  Link tariffTestDrive1;

    @FindBy(xpath = "//span[text()='Забули логін?']")
    private Link presentButtonForgotPass;

    @FindBy(xpath = "//h3[text()='Альфа-чат']")
    private Link chatIsOpen;



    public LoginPage(WebDriver webDriver) {
        super(webDriver, "/login?lang=uk&refId=");

    }

    public void openLogPage() {
        try{
            webDriver.get("https://ok.alfabank.com.ua");
        }catch (Exception e ){
            fail("Browser error");
        }
    }

    public void inputLoginTo(String login) {
        actionsWithElements.enterTextInToInput(inputLogin, login);

    }

    public void inputPassTo(String password){
        actionsWithElements.enterTextInToInput(inputPassword, password);
    }



    public void clickOnButtonNext() {
        actionsWithElements.clickOnElement(buttonLogin);
    }


    public void wrongPassMessage(){
        actionsWithElements.isElementDisplayed(messageWrongPass);

    }

    public void isNameTarrifIsDisplayed(){
        actionsWithElements.isElementDisplayed(tariffTestDrive1);

    }

    public void isButtonForgotPassDisplayed(){
        actionsWithElements.isElementDisplayed(buttonForgotPass);
    }

    public void stepToNextTab(){
        String windowHandler = webDriver.getWindowHandle();
        webDriver.switchTo().window(windowHandler);
    }


    public void clickOnButtonCreateAcc() {
        actionsWithElements.clickOnElement(buttonCreateAcc);

    }

    public void openChat(){
        actionsWithElements.clickOnElement(buttonChat);

    }
    public void isChatIsOpen(){
        actionsWithElements.isElementDisplayed(chatIsOpen);
    }

    public void isChatPresent(){
        actionsWithElements.isElementDisplayed(buttonChat);
    }

}

