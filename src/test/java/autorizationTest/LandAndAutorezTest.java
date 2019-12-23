package autorizationTest;

import org.junit.Test;
import parentTest.ParentTest;


public class LandAndAutorezTest extends ParentTest {

    @Test
    public void flowToLoginPage(){

        landingPage.openLandPage();
        landingPage.setLanguage();
        landingPage.clickOnButtonNext();
        loginPage.buttonForgotPass();

    }
    
    @Test
    public void openAccButtonTest(){
        landingPage.openLandPage();
        landingPage.setLanguage();
        landingPage.clickOnButtonNext();
        loginPage.buttonForgotPass();
        loginPage.clickOnButtonCreateAcc();
        landingPage.checkBonusesButton(); //не хочет проверять, хотя xpath правильный

    }

    @Test
    public void tarifButtonTest() {
        landingPage.openLandPage();
        landingPage.setLanguage();
        landingPage.openAcc();
        landingPage.setTariff();
        loginPage.isNameTarrifIsDisplayed(); //не хочет проверять, хотя xpath правильный

    }

    @Test
    public void chatIconOnLoginPage(){
       landingPage.openLandPage();
       landingPage.setLanguage();
       landingPage.clickOnButtonNext();
       loginPage.isChatPresent();
       loginPage.openChat();
       loginPage.isChatIsOpen();



    }
    @Test
    public void wrongPassMessageCheck(){
        loginPage.openLogPage();
        loginPage.inputLoginTo("Vanya");
        loginPage.inputPassTo("123456");
        loginPage.clickOnButtonNext();
        loginPage.wrongPassMessage();
    }




}
