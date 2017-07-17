package tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import tools.BasicTestConditions;

public class LoginPageUITests extends BasicTestConditions {

    private static String correct_UserName_Label_Text = "User Name";
    private static String correct_Password_Label_Text = "Password";

    @Test (groups = "Loginpage UI Tests")
    public void verifyUserNameLine() {
        Assert.assertEquals(correct_UserName_Label_Text, startPage.getUserNameLabelText());
    }

    @Test (groups = "Loginpage UI Tests")
    public void verifyPasswordLine() {
        Assert.assertEquals(correct_Password_Label_Text, startPage.getPasswordLabelText());
    }
}
