package ders13_excel_screenshot_isExecutor;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C02_ScreenShotTümSayfa extends TestBase {

    @Test
    public void test01() throws IOException {

        // amazon anasayfaya gidin
        driver.get("https://www.amazon.com");

        //Nutellla için arama yapın

        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

        // sonuçların Nutella içerdiğini test edelim

        WebElement sonuçYazıElementi = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));

        String expectedKelime = "Nutella";
        String actualKelime = sonuçYazıElementi.getText();

        Assert.assertTrue(actualKelime.contains(expectedKelime));

        // Tüm sayfanın screenshot'ını olmak için 4 adım gerekiyor

        // 1- TakesScreenShot objesi oluşturup
        // değer olarak cast ettiğimiz driver'i atayalım

        TakesScreenshot tss= (TakesScreenshot) driver;

        // 2- resmi kaydedeceğimiz bir dosya oluşturulur

        File tumSayfaSShot = new File("target/ScreenShot/tumSayfaSShot.jpeg");

        // 3- screenShot objesi kullanarak fotograf çekip geçici bir dosyaya kaydet

        File geçiciResim = tss.getScreenshotAs(OutputType.FILE);

        // 4- geçici dosyayı hazırladığımız file'a kopyalayalım

        FileUtils.copyFile(geçiciResim,tumSayfaSShot);


    }
}
