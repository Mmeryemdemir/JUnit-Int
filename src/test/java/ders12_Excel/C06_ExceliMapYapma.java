package ders12_Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class C06_ExceliMapYapma {

    @Test
    public void  excelMapTest() throws IOException {

        // bazen excel'deki tum datayı kod alanımıza almak isteriz

        String dosyaYolu= System.getProperty("user.home");

        FileInputStream fis = new FileInputStream(dosyaYolu);

        Workbook workbook= WorkbookFactory.create(fis);

        // Excel'de birden fazla sutun olduğuna için list gibi bir yapıya
        // bu bilgileri depolamak munkun olmaz
        // reel database'e en yakın java yapısı olan map kullanabiliriz

        // ingilizce ülke ismi key
        // diğer 3 bilgiyi birleştirdiğimiz String ise value olsun

        Map<String, String > ulkelerMapi = new HashMap<>();

        int sonSatırIndexi = workbook.getSheet("Sayfa1").getLastRowNum();

        for (int i = 0; i <sonSatırIndexi ; i++) {

            String keyUlke = workbook
                              .getSheet("Sayfa1")
                               .getRow(i)
                                .getCell(0)
                                 .toString();

            String valueUlke = workbook.getSheet("Sayfa1").getRow(i).getCell(1).toString()
                    + ", "
                     +workbook.getSheet("Sayfa1").getRow(i).getCell(2).toString()
                    + ", "
                    +workbook.getSheet("Sayfa1").getRow(i).getCell(3).toString();

                ulkelerMapi.put(keyUlke,valueUlke);

        }

        System.out.println(ulkelerMapi);

        // ingilizce  ismi Barbados olan ülkenin başkent isminin
        // ingilizce olarak Bridgetown olduğunu test edin

        String barbadosValues = ulkelerMapi.get("Barbados");

        System.out.println(barbadosValues); // Bridgetown, Barbados, Bridgetown

        String[] barbadosValueArrayi= barbadosValues.split(", ");

        String actualBaskentIsmı = barbadosValueArrayi[0];
        String expectedBaşkentİsmi = "Bridgetown";

        Assert.assertEquals(expectedBaşkentİsmi,actualBaskentIsmı);


    }
}
