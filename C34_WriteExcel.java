package tests.day20;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class C06_WriteExcel {
    @Test
    public void test01() throws IOException {
        //ülkeler excel'ine 5.sutun olarak NUFUS sutunu ekleyelim
        //3.satirdaki ülkenin nufusunu 1000000 yapalim


        String path="src/test/java/resources/ulkeler.xlsx";
        FileInputStream fis=new FileInputStream(path);
        Workbook workbook= WorkbookFactory.create(fis);
        //ilk satırın 5. hücresine NUFUS baslıgı yazalım
        workbook.getSheet("Sayfa1").getRow(0).createCell(4).setCellValue("NUFUS");
        //3.satirdaki  ulkenin nufusunu 1000000 yapalım
        workbook.getSheet("Sayfa1").getRow(2).createCell(4).setCellValue("1000000");

        //kopyalardaki degisiklikleri dosyanın aslina kaydedelim
        FileOutputStream fos=new FileOutputStream(path);
        workbook.write(fos);
    }
}
