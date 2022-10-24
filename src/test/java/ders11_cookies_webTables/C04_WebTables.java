package ders11_cookies_webTables;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C04_WebTables extends TestBase {

    @Test
    public void test01(){

        // amazon anasayfaya gidin
        driver.get("https://www.amazon.com");

       // en alttaki web table'da 10 satir oldugunu test edin
        List<WebElement> satırlarListesi = driver.findElements(By.xpath("//table//tr"));

        Assert.assertTrue(satırlarListesi.size()==10);

       // sutun sayisinin 14 oldugunu test edin

        List<WebElement> ilkSatırdataListesi = driver.findElements(By.xpath("//table//tr[1]/td"));
        Assert.assertTrue(ilkSatırdataListesi.size()==14);

      // 3. sutunu yazdirin

        List<WebElement> üçünçüSatırdataListesi = driver.findElements(By.xpath("//table//tr[3]/td"));

        for (WebElement each:üçünçüSatırdataListesi
             ) {
            System.out.println(each.getText());
        }

        // 5.satiri yazdirin

        System.out.println("==========");

        List<WebElement> beşinçiSatırdataListesi = driver.findElements(By.xpath("//table//tr[5]/td"));

        for (WebElement each:beşinçiSatırdataListesi
             ) {
            System.out.println(each.getText());
        }


        // 3.satir, 5.sutundaki basligin Home Service oldugunu test edin

        WebElement üçünçüSatırBeşinçiSutun = driver.findElement(By.xpath("//table//tr[3]/td[5]"));

        String expectedİçerik = "Home Service";
        String actualData = üçünçüSatırBeşinçiSutun.getText();

        Assert.assertTrue(actualData.contains(expectedİçerik));

        // satir ve sutun degerlerini verdigimizde tablodaki o bolumu yazdiracak bir method olusturun


        dataYazdır(3,5);

        bekle(5);
    }

    public void dataYazdır(int satır , int sütün){

        String dataXPathi = "//table//tr["+satır+"]/td["+sütün+"]";

        WebElement arananData= driver.findElement(By.xpath(dataXPathi));

        System.out.println(satır + ".satır, " + sütün + ".ci sütündaki data : " + arananData.getText());

    }
}
