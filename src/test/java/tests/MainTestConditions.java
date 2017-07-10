package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import tools.BasicTestConditions;

public class MainTestConditions extends BasicTestConditions {


    private static String correct_UserName_Text = "User Name";
    private static String correct_Password_Text = "Password1";
/**
 * This test is verifying if User Name was written in correct way
 * */

    @Test
    public void verifyUserNameLine(){
        Assert.assertEquals(correct_UserName_Text, startPage.getUserNameText());
    }

}