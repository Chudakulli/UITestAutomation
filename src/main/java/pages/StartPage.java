package pages;


import org.openqa.selenium.WebDriver;
import tools.Browser;


public class StartPage {
    protected Browser browser;


    private static final String LOGIN_INPUT_FIELD_ID = "apf-login-input-value-username";
    private static final String PASSWORD_INPUT_FIELD_ID = "apf-login-input-value-password";
    private static final String SIGN_IN_BUTTON_ID = "apf-login-button-text";

    public StartPage(WebDriver driver) {
        browser = new Browser(driver);
    }

    public Browser getBrowser() {
        return this.browser;
    }

    public StartPage login(String userName, String password) {
        browser.findElementById(LOGIN_INPUT_FIELD_ID).sendKeys(userName);
        browser.findElementById(PASSWORD_INPUT_FIELD_ID).sendKeys(password);
        browser.findElementById(SIGN_IN_BUTTON_ID).click();
        return new StartPage(browser.getDriver());
    }

    public void enterUserName() {
        browser.findElementById(LOGIN_INPUT_FIELD_ID).sendKeys();
    }

    public void enterPassword() {
        browser.findElementById(PASSWORD_INPUT_FIELD_ID).sendKeys();
    }

    public void findUserNameText() {
        browser.findElementById("apf-login-input-label-username");
    }

    public String getUserNameText() {
        return browser.findElementById("apf-login-input-label-username").getText();
    }

    public String getPasswordText() {
        return browser.findElementById("apf-login-input-label-password").getText();
    }


}
