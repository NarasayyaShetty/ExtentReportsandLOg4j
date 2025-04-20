package DataProvidersusingExcelSheet;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.util.Scanner;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.UUID;

public class ExcelCreateTheData {
    public static void main(String[] args){

        try {

            Workbook workbook=new XSSFWorkbook();
            Sheet sheet=workbook.createSheet("TestCase01");
            Scanner sc=new Scanner(System.in);
            System.out.println("print the length of the row");
            int n=sc.nextInt();


            String[][] data=new String[n][4];
            data[0][0]="Slno";
            data[0][1]="UserName";
            data[0][2]="Password";
            data[0][3]="ConfirmPassword";


            for(int i=1;i<data.length;i++){
                String testData=String.format("%s %s %s %s","0"+i, UUID.randomUUID().toString(),"Test@123","Test@123");
                String[] tdata=testData.split(" ");
                for(int j=0;j<data[0].length;j++){
                    data[i][j]=tdata[j];
                }

            }

            for(int i=0;i<data.length;i++){
                Row row =sheet.createRow(i);
                for(int j=0;j<data[0].length;j++){
                    Cell cell=row.createCell(j);
                    cell.setCellValue(data[i][j]);
                }
            }
            FileOutputStream fos=new FileOutputStream("src/test/resources/TestData.xlsx");
            workbook.write(fos);

            fos.close();

        }catch(IOException r){
            r.printStackTrace();
        }
    }
}
