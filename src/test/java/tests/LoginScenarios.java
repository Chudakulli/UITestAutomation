package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import tools.BasicTestConditions;
import tools.PropertiesProvider;


public class LoginScenarios extends BasicTestConditions {

    private static String username = PropertiesProvider.getProperty("serviceName");
    private static String password = PropertiesProvider.getProperty("servicePass");
    private static String domain1User = PropertiesProvider.getProperty("domain1User");
    private static String domain1UserPass = PropertiesProvider.getProperty("domain1UserPass");
    private static String domain2User = PropertiesProvider.getProperty("domain2User");
    private static String domain2UserPass = PropertiesProvider.getProperty("domain2UserPass");
    private static String domain1 = PropertiesProvider.getProperty("domain1");
    private static String domain2 = PropertiesProvider.getProperty("domain2");

    @Test(groups = {"SysAuthLoginTests"})
    public void loginWithCorrectCredentials() {
        startPage.enterCredentials(username,password);
        startPage.clickLoginButton();
        Assert.assertTrue(driver.getCurrentUrl().endsWith("/Default.aspx"));
    }

    @Test(groups = {"SysAuthLoginTests"})
    public void loginWithWrongUserName() {
        startPage.enterUserName("wrong");
        startPage.enterPassword(password);
        startPage.clickLoginButton();
        Assert.assertFalse(driver.getCurrentUrl().endsWith("/Default.aspx"));
        startPage.clearCredentials();
    }

    @Test(groups = {"SysAuthLoginTests"})
    public void loginWithWrongPassword() {
        startPage.enterUserName(username);
        startPage.enterPassword("wrong");
        startPage.clickLoginButton();
        Assert.assertFalse(driver.getCurrentUrl().endsWith("/Default.aspx"));
        startPage.clearCredentials();
    }

    @Test(groups = {"SysAuthLoginTests"})
    public void loginWithEmptyUserName() {
        startPage.enterPassword(password);
        startPage.clickLoginButton();
        Assert.assertFalse(driver.getCurrentUrl().endsWith("/Default.aspx"));
        startPage.clearPassword();
    }

    @Test(groups = {"SysAuthLoginTests"})
    public void loginWithEmptyPassword() {
        startPage.enterUserName(username);
        startPage.clickLoginButton();
        Assert.assertFalse(driver.getCurrentUrl().endsWith("/Default.aspx"));
        startPage.clearUserName();
    }

    @Test(groups = {"DomainAuthLoginTests"})
    public void loginWithCorrectDomain(){
        startPage.enterUserName(domain1+"\\"+domain1User);
        startPage.enterPassword(domain1UserPass);
        startPage.clickLoginButton();
        Assert.assertTrue(driver.getCurrentUrl().endsWith("/Default.aspx"));
    }
    @Test(groups = {"DomainAuthLoginTests"})
    public void loginWithWrongDomain(){
        startPage.enterUserName(domain2+"\\"+domain1User);
        startPage.enterPassword(domain1UserPass);
        startPage.clickLoginButton();
        Assert.assertFalse(driver.getCurrentUrl().endsWith("/Default.aspx"));
        startPage.clearCredentials();
    }

    @Test(groups = {"DomainAuthLoginTests"})
    public void loginWithEmptyDomain(){
        startPage.enterCredentials(domain1User,domain1UserPass);
        startPage.clickLoginButton();
        Assert.assertFalse(driver.getCurrentUrl().endsWith("/Default.aspx"));
        startPage.clearCredentials();
    }
    @Test(groups = {"DomainAuthLoginTests"})
    public void loginWithDomainOnSysUser(){
        startPage.enterUserName(domain2+"\\"+username);
        startPage.enterPassword(password);
        startPage.clickLoginButton();
        Assert.assertFalse(driver.getCurrentUrl().endsWith("/Default.aspx"));
        startPage.clearCredentials();
    }

    @AfterMethod (alwaysRun = true)
    public void checkIfUserIsLoggedIn() {
        if (driver.getCurrentUrl().endsWith("/Default.aspx")) {
            driver.manage().deleteAllCookies();
            driver.navigate().back();
        }
    }
}
