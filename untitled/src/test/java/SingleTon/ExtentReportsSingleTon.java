package SingleTon;

import com.relevantcodes.extentreports.ExtentReports;

import java.io.File;

public class ExtentReportsSingleTon {
    static ExtentReports extentReports=null;
    private ExtentReportsSingleTon(){}
    final static String reportFilePath = System.getProperty("user.dir") + File.separator + "reports"
            + File.separator + "qTripTestResults.html";

    public static ExtentReports getReport(){
        if(extentReports==null){
            extentReports=new ExtentReports(reportFilePath,true);
        }
        return extentReports;
    }
}
