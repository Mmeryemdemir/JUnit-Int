package ders10_File_waits;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_FileUploadtesti extends TestBase {


    @Test
    public void UploadTesti(){

        // 1.Tests packagenin altina bir class oluşturun : C05_UploadFile
        //2.https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");

        //3.chooseFile butonuna basalim
        //4.Yuklemek istediginiz dosyayi secelim

      WebElement dosyaŞeçButonu = driver.findElement(By.id("file-upload"));

      /*
      Dosya şeç butonuna bastıktan sonra
      bilgisayardan selenium ile dosya seçmemiz mümkün değil
      onun yerine
      dosyaSeçButonu.sendKeys("dosyaYolu") yaparsak
      dosya seçme işlemi yapılmış olacaktır
       */

        String yüklenecekDosyaYolu = System.getProperty("user.home") +
                                       "\\OneDrive\\Masaüstü\\fileTesti\\deneme.txt";
        dosyaŞeçButonu.sendKeys(yüklenecekDosyaYolu);

        bekle(5);

        //5.Upload butonuna basalim.
        driver.findElement(By.id("file-submit"));

        //6.“File Uploaded!” textinin goruntulendigini test edelim.

        bekle(5);

        WebElement fileUploadYazıElementi = driver.findElement(By.tagName("h3"));

        Assert.assertTrue(fileUploadYazıElementi.isDisplayed());

    }
}
