package Tests;

import SingleTon.DriverSingleTon;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestCase01 {
    WebDriver driver=null;
    @BeforeTest
    @Parameters({"browserName"})
    public void initSetup(String browserName){
        driver=DriverSingleTon.driverInit(browserName);
    }
    @Test(description = "testcaseo1")
    public void testcase01(){
        driver.get("https://crio-qkart-frontend-qa.vercel.app/");
    }
}
