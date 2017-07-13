package tools;
import org.openqa.selenium.WebDriver;
import pages.StartPage;



public class LoginManager  {
    private WebDriver driver;

    public LoginManager(WebDriver driver) {
        this.driver = driver;
    }
    public WebDriver getDriver() {
        return this.driver;
    }
    StartPage startpage;

    private  String username = PropertiesProvider.getProperty("serviceName");
    private  String password = PropertiesProvider.getProperty("servicePass");


    public void login (String login, String pass) {
        startpage.enterUserName(username);
        startpage.enterPassword(password);
        startpage.clickLoginButton();
    }
}
