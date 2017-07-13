package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import tools.BasicTestConditions;
import tools.PropertiesProvider;


public class LoginScenarios extends BasicTestConditions {


    private static String correct_UserName_Label_Text = "User Name";
    private static String correct_Password_Label_Text = "Password";
    private static String username = PropertiesProvider.getProperty("serviceName");
    private static String password = PropertiesProvider.getProperty("servicePass");


    @Test (priority = 1)
    public void verifyUserNameLine() {
        Assert.assertEquals(correct_UserName_Label_Text, startPage.getUserNameLabelText());
    }

    @Test (priority = 2)
    public void verifyPasswordLine() {
        Assert.assertEquals(correct_Password_Label_Text, startPage.getPasswordLabelText());
    }

    @Test (priority = 5)
    public void loginWithCorrectCredentials(){
        startPage.enterUserName(username);
        startPage.enterPassword(password);
        startPage.clickLoginButton();
        Assert.assertTrue(driver.getCurrentUrl().endsWith("/Default.aspx"));
    }

    @Test (priority = 3)
    public void loginWithWrongUserName(){
        startPage.enterUserName("wrong");
        startPage.enterPassword(password);
        startPage.clickLoginButton();
        Assert.assertFalse(driver.getCurrentUrl().endsWith("/Default.aspx"));
        startPage.clearUserName();
        startPage.clearPassword();
    }

    @Test (priority = 4)
    public void loginWithWrongPassword(){
        startPage.enterUserName(username);
        startPage.enterPassword("wrong");
        startPage.clickLoginButton();
        Assert.assertFalse(driver.getCurrentUrl().endsWith("/Default.aspx"));
        startPage.clearUserName();
        startPage.clearPassword();
    }


}