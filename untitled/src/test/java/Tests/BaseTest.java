package Tests;

import static SingleTon.DriverSingleTon.*;

import static SeleniumUtils.ExtentReportData.*;

import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class BaseTest {
    WebDriver driver;
    @BeforeTest(alwaysRun = true)
@Parameters("browserName")
    public void driverinit(String browserName){
        driver=driverInit(browserName);
    }

    @BeforeMethod(alwaysRun = true)
    public void beforeEachMethod(Method m){
        startTest(m.getName());
    }

    @AfterMethod(alwaysRun = true)
    public void afterEachMethod(ITestResult iTestResult){
        if(iTestResult.getStatus()==ITestResult.SUCCESS){
            logPass("Step is passed");
        } else if (iTestResult.getStatus()==ITestResult.FAILURE) {
            getTest().log(LogStatus.FAIL, "Take the screenShot");

        }
        else{
            logSkip("Step is skipped");
        }
    }
    @AfterTest(alwaysRun = true)
    public void afterSuite(){
        driver.quit();
        endTest();
    }

}
