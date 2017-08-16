package tools;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.ITestContext;
import org.testng.ITestListener;
import static tools.BasicTestConditions.driver;
import static tools.TimeStampFileCreator.GetCurrentTimeStamp;


public class ScreenshotMaker implements ITestListener {

    String filePath = "C:\\QA\\CompassWebAutomationResults\\"+"FailedTestScreensOn "+GetCurrentTimeStamp().replace(":","_").replace(".","_")+"\\";
    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("***** Error "+result.getName()+" test has failed *****");
        String methodName=result.getName().trim();
        takeScreenShot(methodName);
    }

    public void takeScreenShot(String methodName) {
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        //The below method will save the screen shot in destination folder with test method name
        try {
            FileUtils.copyFile(scrFile, new File(filePath+ methodName + GetCurrentTimeStamp().replace(":","_").replace(".","_")+".jpg"));
            System.out.println("***Placed screen shot in "+filePath+" ***");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void onFinish(ITestContext context) {}

    public void onTestStart(ITestResult result) {   }

    public void onTestSuccess(ITestResult result) {   }

    public void onTestSkipped(ITestResult result) {   }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {   }

    public void onStart(ITestContext context) {   }
}
