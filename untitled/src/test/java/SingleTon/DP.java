package SingleTon;

import DataProvidersusingExcelSheet.ExcelReadTheData;
import org.testng.annotations.DataProvider;

public class DP {
    @DataProvider(name="testCase01")
    public static String[][] testCase01(){
        return ExcelReadTheData.testData("TestCase01");
    }
}
