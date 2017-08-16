package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class StartPage {
    private WebDriver driver;

    public StartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebDriver getDriver() {
        return driver;
    }

    @FindBy (id ="apf-login-input-value-username")
    private WebElement userNameField;

    @FindBy (id="apf-login-input-value-password")
    private WebElement passwordField;

    @FindBy (id ="apf-login-input-label-username")
    private WebElement userNameLabel;

    @FindBy (id="apf-login-input-label-password")
    private WebElement passwordLabel;

    @FindBy (id="apf-login-button-container")
    private WebElement loginButton;


    public void enterUserName(String UserName) {
        userNameField.sendKeys(UserName);
    }

    public void enterPassword(String Password) {
        passwordField.sendKeys(Password);
    }

    public void clearUserName() {
        userNameField.clear();
    }

    public void clearPassword() {
        passwordField.clear();
    }

    public void clearCredentials() {
        userNameField.clear();
        passwordField.clear();
    }

    public void enterCredentials(String userName, String password){
        userNameField.sendKeys(userName);
        passwordField.sendKeys(password);
    }

    public String getUserNameLabelText()  {
        return userNameLabel.getText();
    }


    public String getPasswordLabelText() {
        return passwordLabel.getText();
    }

    public void clickLoginButton(){
        loginButton.click();
    }


}
