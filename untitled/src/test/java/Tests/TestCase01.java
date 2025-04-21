package Tests;

import SingleTon.DriverSingleTon;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestCase01 extends BaseTest {

    @Test(description = "testcaseo1")
    public void testcase01(){
        driver.get("https://crio-qkart-frontend-qa.vercel.app/");
    }
    @Test(description = "testcaseo2")
    public void testcase02(){
        Assert.assertTrue(true);
    }

    @Test(description = "testcaseo3")
    public void testcase03(){
        Assert.assertTrue(true);
    }

}
