package ders13_excel_screenshot_isExecutor;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C04_ScreenshotWebElement extends TestBase {

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

        // sadece sonuç yazısı elemntinin screenshot'ını çekelim
        // 1.adım screenshot çekeceğimiz webelemti locate edelim

        // 2. 3. ve 4. adımlar tüm sayfa screenshot ile aynı

        File tumSayfaSShot = new File("target/ScreenShot/SonuçYazısıScreenshot.jpeg");

        File geçiciResim = sonuçYazıElementi.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(geçiciResim,tumSayfaSShot);

    }
}
