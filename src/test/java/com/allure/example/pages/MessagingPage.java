package com.allure.example.configs.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MessagingPage extends BasePage{
    public MessagingPage() {
        super();
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(id = "Login.lblEmail")
    private WebElement emailTextField;
    @FindBy(id = "Login.lblPassword")
    private WebElement passwordTextField;

    @FindBy(id = "btnLogin")
    private WebElement loginButton;

    @FindBy(id = "profile_ec4e26b7-2c88-4364-bbd3-58fea44972ac_PROVIDER")
    private WebElement practiceSelection;

    @FindBy(id = "btnContinue")
    private WebElement continueBtn;

    @FindBy(xpath = "//p[contains(text(),'Hello MEL')]")
    private WebElement homePageHeader;

    @FindBy(id = "QA_SideNav.menuItem.messages")
    private WebElement messagingIcon;

    @FindBy(id = "QA_btnCompose")
    private WebElement composeBtn;

    @FindBy(id = "QA_ThreadsHeader.input.APatient")
    private WebElement patientIcon;

    @FindBy(id = "QA_selectpatient")
    private WebElement selectRecipientsField;

    @FindBy(id = "QA_check_box")
    private WebElement selectRecipients;

    @FindBy(id = "subjectLine")
    private WebElement subject;

    @FindBy(id = "message")
    private WebElement messageBox;

    @FindBy(id = "QA_btnSendTopatient")
    private WebElement messageSendBtn;

    @FindBy(id = "PATIENT")
    private WebElement patientTab;

    @FindBy(id = "//h6[contains(text(),'Just Now')]")
    private WebElement messageTime;

    @FindBy(id = "qa_profiles_dd")
    private WebElement profileIcon;

    @FindBy(id = "qa_logout")
    private WebElement logoutBtn;
    public void openWebPage() {
        driver.get("https://app.althdev.io/login");
        driver.manage().window().maximize();
        waitForVisibilityOf(loginButton);
    }
    public void enterCredentials(String email, String password) {
        emailTextField.sendKeys(email);
        passwordTextField.sendKeys(password);
    }
    public void hitsButton() {
        loginButton.click();
        practiceSelection.click();
        continueBtn.click();
    }
    public void homePage() {

        waitForVisibilityOf(homePageHeader);
    }

    public void toMessagingScreen(){
        messagingIcon.click();
    }

    public void composeMessage(String toName, String subjectName, String message){
        composeBtn.click();
        patientIcon.click();
        selectRecipientsField.sendKeys(toName);
        selectRecipients.click();
        subject.sendKeys(subjectName);
        messageBox.sendKeys(message);
        messageSendBtn.click();
    }

    public void enterSubject(String subjectName) {
        subject.sendKeys(subjectName);
    }

    public void enterMessage(String message) {
        messageBox.sendKeys(message);
        messageSendBtn.click();
    }

    public void checkForComposedMessage(){
        patientTab.click();
        driver.navigate().refresh();
        waitForVisibilityOf(messageTime);
    }

    public void logout(){
        profileIcon.click();
        logoutBtn.click();
        waitForVisibilityOf(loginButton);
    }

}


