package tests;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import tools.BasicTestConditions;
import tools.PropertiesProvider;


public class LoginScenarios extends BasicTestConditions {

    private static String username = PropertiesProvider.getProperty("serviceName");
    private static String password = PropertiesProvider.getProperty("servicePass");

    @Test (groups = {"SysAuthLoginTests"})
    public void loginWithCorrectCredentials(){
        startPage.enterUserName(username);
        startPage.enterPassword(password);
        startPage.clickLoginButton();
        Assert.assertTrue(driver.getCurrentUrl().endsWith("/Default.aspx"));
    }

    @Test (groups = {"SysAuthLoginTests"})
    public void loginWithWrongUserName(){
        startPage.enterUserName("wrong");
        startPage.enterPassword(password);
        startPage.clickLoginButton();
        Assert.assertFalse(driver.getCurrentUrl().endsWith("/Default.aspx"));
        startPage.clearUserName();
        startPage.clearPassword();
    }

    @Test (groups = {"SysAuthLoginTests"})
    public void loginWithWrongPassword(){
        startPage.enterUserName(username);
        startPage.enterPassword("wrong");
        startPage.clickLoginButton();
        Assert.assertFalse(driver.getCurrentUrl().endsWith("/Default.aspx"));
        startPage.clearUserName();
        startPage.clearPassword();
    }

    @Test (groups = {"SysAuthEmptyLoginTests"})
    public void loginWithEmptyUserName(){
        startPage.enterPassword(password);
        startPage.clickLoginButton();
        Assert.assertFalse(driver.getCurrentUrl().endsWith("/Default.aspx"));
        startPage.clearPassword();
    }

    @Test (groups = {"SysAuthEmptyLoginTests"})
    public void loginWithEmptyPassword(){
        startPage.enterUserName(username);
        startPage.clickLoginButton();
        Assert.assertFalse(driver.getCurrentUrl().endsWith("/Default.aspx"));
        startPage.clearUserName();
    }


    @AfterMethod (alwaysRun = true)
    public void testLog(){
        if (driver.getCurrentUrl().endsWith("/Default.aspx")){
            driver.manage().deleteAllCookies();
            driver.navigate().back();
        }
    }

}