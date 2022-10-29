package ders12_Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C05_FizikiKullanılanSatırSayısı {


    @Test
    public void  test01() throws IOException {

        // ülkeler excelindeki Sayfa2'de fiziki olarak kullanılan satır sayısının
        // 15 olduğnu test edin

        String dosyaYolu = System.getProperty("user.home");

        FileInputStream fis = new FileInputStream(dosyaYolu);

        Workbook workbook = WorkbookFactory.create(fis);

        int toplamSatırSayısı = workbook
                                 .getSheet("Sayfa2")
                                  .getLastRowNum();

        //index kullandığı için satır sayısını bulmak için 1 ekleyelim

        System.out.println("Toplam satır sayısı : " + (toplamSatırSayısı+1));

        int fizikiKullanılanSatırSayısı = workbook
                                           .getSheet("Sayfa2")
                                            .getPhysicalNumberOfRows();

        System.out.println("Fiziki kullanılan satır sayısı : " + fizikiKullanılanSatırSayısı);


    }
}
