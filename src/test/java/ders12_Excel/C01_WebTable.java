package ders12_Excel;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C01_WebTable extends TestBase {


    @Test
    public void WebTableTest(){

        //  1. “https://demoqa.com/webtables” sayfasina gidin

        driver.get("https://demoqa.com/webtables");

        //  2. Headers da bulunan basliklari yazdirin

        List<WebElement> başlıkElemntlerininListesi =
                driver.findElements(By.xpath("//div[@class='rt-th rt-resizable-header -cursor-pointer']"));

           for (WebElement eachElemnti : başlıkElemntlerininListesi
                ){
               System.out.println(eachElemnti.getText() + "----");
           }

        //  3. 3.sutunun basligini yazdirin

           System.out.println("");

        System.out.println(başlıkElemntlerininListesi.get(2).getText());


        //  4. Tablodaki tum datalari yazdirin

        List<WebElement> dataElementleriListesi= driver.findElements(By.xpath("\"//div[@class='rt-td']\""));

            for (WebElement eachElement : dataElementleriListesi
                 ){
                System.out.println(eachElement.getText());
            }


        //  5. Tabloda kac tane bos olmayan cell (data) oldugunu yazdirin

          int sayaç = 0;

            for (WebElement eachElement: dataElementleriListesi
                 ){

                if (!eachElement.getText().isBlank()){
                    sayaç++;
                }

            }

              System.out.println("Toblada boş olmayan hücre sayısı : " +sayaç);


        //  6. Tablodaki satir sayisini yazdirin

        List<WebElement> satırElementleriListesi = driver.findElements(By.xpath("/div[@class='rt-tr-group']"));

        System.out.println("Tobloda satır sayısı : " + satırElementleriListesi.size());

        //  7. Tablodaki sutun sayisini yazdirin

        System.out.println("Toblodaki sutun sayısı : "+ başlıkElemntlerininListesi.size());

        //  8. Tablodaki 3.kolonu yazdirin
        //      tablo table tag'lari ile olusturulmadigindan data bilgisine dinamik olarak ulasamadik

        for (int i = 2; i < dataElementleriListesi.size(); i++) {

            System.out.println(dataElementleriListesi.get(i).getText());
        }

        //  9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin

        for (int i = 0; i <dataElementleriListesi.size() ; i++) {

            if
              (dataElementleriListesi.get(i).getText().equalsIgnoreCase("Kierra")){

                System.out.println("Kierra'nın maaşı : " +dataElementleriListesi.get(i+4).getText());
            }

        }

        //10. class icerisinde bir method olusturun,
        // Test sayfasindan satir ve sutun sayisini girdigimde bana datayi yazdirsin













    }
}
