package registrationTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import parentPages.ParentPage;
import ru.yandex.qatools.htmlelements.element.Link;



public class RegistrationPage extends ParentPage {

    @FindBy(xpath = "//input[@type='checkbox']")
    private Link checkBox;

    @FindBy(name = "Ідентифікаційний номер (ІПН)")     // //input[@name='taxCode']     name = "taxCode"
    private WebElement inputInn;

    @FindBy(xpath = "//input[@type='tel']")
    private WebElement inputPhone;



    public RegistrationPage(WebDriver webDriver, String partUrl) {
        super(webDriver, partUrl);

    }

    public void inputInn(String inn ){
        actionsWithElements.enterTextInToInput(inputInn, inn);
    }

    public void inputPhoneTo(String phone){
        actionsWithElements.enterTextInToInput(inputPhone, phone);
    }



    public void setCheckBoxAgree(){
        actionsWithElements.setStateToCheckBox(checkBox, "check");
    }




}
