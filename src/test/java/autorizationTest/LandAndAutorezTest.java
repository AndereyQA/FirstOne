package autorizationTest;

import org.junit.Test;
import parentTest.ParentTest;


public class LandAndAutorezTest extends ParentTest {

    @Test
    public void flowToLoginPageTest(){

        landingPage.openLandPage();
        landingPage.setLanguage();
        landingPage.clickOnButtonNext();
        loginPage.isButtonForgotPassDisplayed(); //в этом кейсе проверка в новой вкладке проходитб проверил закомичиванием шага номер 3.


    }
    
    @Test
    public void openAccButtonTest(){
        landingPage.openLandPage();
        landingPage.setLanguage();
        landingPage.clickOnButtonNext();
        loginPage.isButtonForgotPassDisplayed();  //тут первая проверка на новой вкладке проходит, а вторая нет.
        loginPage.clickOnButtonCreateAcc();
        landingPage.checkBonusesButton(); //а эта уже нет, если смотреть как идут тесты в браузере, то переключение на новую вкладку происходит автоматом.

    }

    @Test
    public void tarifButtonTest() {
        landingPage.openLandPage();
        landingPage.setLanguage();
        landingPage.openAcc();
        landingPage.setTariff();
       // loginPage.stepToNextTab();
        //  webDriver.switchTo();
    //    webDriver.switchTo(newTab).window(newTab.get(1));
        loginPage.isNameTarrifIsDisplayed(); //не хочет проверять, хотя xpath правильный

    }

    @Test
    public void chatIconOnLoginPageTest(){
       landingPage.openLandPage();
       landingPage.setLanguage();
       landingPage.clickOnButtonNext();
       loginPage.isChatPresent();
       loginPage.openChat();
       loginPage.isChatIsOpen();



    }
    @Test
    public void wrongPassMessageCheckTest(){
        loginPage.openLogPage();
        loginPage.inputLoginTo("Vanya");
        loginPage.inputPassTo("123456");
        loginPage.clickOnButtonNext();
        loginPage.wrongPassMessage();
    }




}
