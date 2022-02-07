package tests.day20;

import org.apache.poi.ss.usermodel.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_ReadExcel {
    @Test
    public void test01() throws IOException {

        String path="src/test/java/resources/ulkeler.xlsx";
        FileInputStream fis=new FileInputStream(path);
    //Biz FIS ile okuduguz excel dosyasının proemiz içerisinde kullanabilmek için
    //Apachi POI depencey yardimi ile bir workbook olusturduk
    //Workbook excelin bir kopyasını olustuur(proede kullanbilmemiz için)
    //hücreye ulaşabilmek için soırasıyla shhet,row,ve cell classlarında obje
    //olusturduk
        Workbook workbook= WorkbookFactory.create(fis);
        Sheet sheet=workbook.getSheet("Sayfa1");
        Row row=sheet.getRow(4);
        Cell cell=row.getCell(2);
        System.out.println(cell);

        //indexi 4 olan satir ve indexi 2 olan sutun dan getirdik cevabı

        String expectedData="Andorra";
        Assert.assertEquals(cell.getStringCellValue(),expectedData);
      //  Assert.assertEquals(cell.toString(),expectedData);
        //5.indexin satiri ,3. indexin  hücre bilgisini yazsdirealim
        row=sheet.getRow(5);
        cell=row.getCell(3);
        System.out.println(cell);

    }
}
