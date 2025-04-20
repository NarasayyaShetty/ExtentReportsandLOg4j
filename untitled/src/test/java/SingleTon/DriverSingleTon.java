package SingleTon;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSingleTon {
    public static WebDriver driver=null;

    private DriverSingleTon(){}

    public static WebDriver driverInit(String browserName){
        if(driver==null){
            switch(browserName){
                case "chrome":
                    driver=new ChromeDriver();
                    break;
                case "firefox":
                    driver=new FirefoxDriver();
                    break;
                default:
                    break;
            }
        }
        driver.manage().window().maximize();
        return driver;
    }
}
