package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import parentPages.ParentPage;
import ru.yandex.qatools.htmlelements.element.Link;

public class LandingPage extends ParentPage {

    @FindBy(xpath = "//div[@class='header__inner']//span[text()='Увійти в ОК, Альфа!']")
    private Link buttonEnterToAlfa;

    @FindBy(xpath = "//a[text()='Укр']")
    private Link buttonLanguage;

    @FindBy(xpath = "//span[text()='Забули пароль?']")
    private Link buttonForgotPass;

    @FindBy(xpath = "//div[@class='tr tr_heading']//a[@href='https://ok.alfabank.com.ua/signup?tariffCode=38100&lang=uk&agent=&refId=']//div[text()='Обрати']" )
    private Link buttonTakeTarif1;

    @FindBy(xpath = "//div[@class='poster__inner']//div[text()='Відкрити рахунок']")
    private Link buttonOpenAcc;

    @FindBy(xpath = "//div[text()='Бонуси за відкриття рахунку']")
    private Link infoButtonBonuses;



    public LandingPage(WebDriver webDriver) {
        super(webDriver, "/landing/?");
    }

    public void openLandPage() {
        try{
            webDriver.get("https://ok.alfabank.com.ua/landing");
        }catch (Exception e ){
            Assert.fail("Browser error");
        }
    }


    public void clickOnButtonNext() {
        actionsWithElements.clickOnElement(buttonEnterToAlfa);
    }


    public void setLanguage(){
        actionsWithElements.clickOnElement(buttonLanguage);
    }

    public void setTariff(){
        actionsWithElements.clickOnElement(buttonTakeTarif1);
    }

    public void openAcc(){
        actionsWithElements.clickOnElement(buttonOpenAcc);
    }
    public void buttonOpenAccPresent(){
        actionsWithElements.isElementDisplayed(buttonOpenAcc);
    }

    public void checkBonusesButton(){
        actionsWithElements.isElementDisplayed(infoButtonBonuses);
    }

}



