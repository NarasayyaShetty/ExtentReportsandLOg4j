package SeleniumUtils;

import SingleTon.ExtentReportsSingleTon;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import java.util.HashMap;
import java.util.Map;

public class ExtentReportData {

   static ExtentReports extentReports= ExtentReportsSingleTon.getReport();

   static Map<Object,Object> extentMap=new HashMap<>();

   public static ExtentTest startTest(String testName){
       ExtentTest extentTest=extentReports.startTest(testName);
       extentMap.put(Thread.currentThread().threadId(),extentTest);

       return extentTest;
   }
   public static ExtentTest getTest(){
       return (ExtentTest) extentMap.get(Thread.currentThread().threadId());
   }

   public static void logInfo(String info){
       getTest().log(LogStatus.INFO,info);
   }
    public static void logPass(String info){
        getTest().log(LogStatus.PASS,info);
    }
    public static void logFail(String info){
        getTest().log(LogStatus.FAIL,info);
    }
    public static void logSkip(String info){
        getTest().log(LogStatus.SKIP,info);
    }

    public static void endTest(){
       extentReports.endTest(getTest());
       extentReports.flush();
    }

}
