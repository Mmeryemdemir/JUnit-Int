package ders12_Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class C04_ReadExcel {

    @Test
    public void  readExcelTest() throws IOException {

        //ülkeler excelinde türkçe ulke isimleri Senegal içeriyor mu test edin
        //toplam 190 ulke olduğunu test edin
        // en uzun ulke isminin Macaristan olduğunu test edin

        String dosyaYolu = System.getProperty("user.home");

        FileInputStream fis = new FileInputStream(dosyaYolu);

       Workbook workbook= WorkbookFactory.create(fis);

        List<String> ulkelerListesi = new ArrayList<>();

            int sonSatırİndexi = workbook
                                  .getSheet("Sayfa1")
                                   .getLastRowNum();

        for (int i = 0; i < sonSatırİndexi; i++) {

            ulkelerListesi.add(workbook
                               .getSheet("Sayfa1")
                                .getRow(i)
                                 .getCell(2)
                                  .toString());

        }


        ulkelerListesi.remove(0);

        //ülkeler excelinde türkçe ulke isimleri Senegal içeriyor mu test edin

           Assert.assertTrue(ulkelerListesi.contains("Senegal"));

        //toplam 190 ulke olduğunu test edin

           Assert.assertEquals(ulkelerListesi.size(),190);

        // en uzun ulke isminin Mikronezya Fedaral Devletleri olduğunu test edin

        String enUzunİsim = "Macaristan";

        for (String each:ulkelerListesi
             ) {

            if (each.length()>enUzunİsim.length()){
                enUzunİsim = each;
            }
        }

        System.out.println("En uzun İsimli Ulke : " + enUzunİsim);

        Assert.assertEquals("Mikronezya Fedaral Devletleri",enUzunİsim);

    }
}
