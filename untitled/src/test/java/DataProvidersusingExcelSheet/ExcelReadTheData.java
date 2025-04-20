package DataProvidersusingExcelSheet;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelReadTheData {
    public static String[][] testData(String sheetName){
        int rowIndex=0, colIndex=0;
        String[][] result=null;
        List<List<String>> outerList=new ArrayList<>();
        File file=new File("src/test/resources/TestData");
        try {
            FileInputStream fs = new FileInputStream(file);
            Workbook workbook=new XSSFWorkbook(fs);
            Sheet sheet =workbook.getSheet(sheetName);
            Iterator<Row> row =sheet.rowIterator();
            while(row.hasNext()){
                Row eachRow=row.next();
                List<String> innerList=new ArrayList<>();
                Iterator<Cell> cell=eachRow.cellIterator();
                while(cell.hasNext()){
                   Cell eachCell= cell.next();
                   if(rowIndex>0&&colIndex>0){
                       if(eachCell.getCellType().equals(CellType.STRING)){
                           innerList.add(eachCell.getStringCellValue());
                       }
                   }
                   colIndex++;
                }
                colIndex=0;
                rowIndex++;
                if(!innerList.isEmpty()){
                    outerList.add(innerList);
                }

            }
            int r=outerList.size();
            int c=outerList.get(0).size();
             result=new String[r][c];
            for(int i=0;i<r;i++){
               result[i]= outerList.get(i).toArray(new String[0]);
            }


        }catch(IOException e){
            e.printStackTrace();
        }
        return result;
    }
}
