package ders08_İframe_windows;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class C02_HandleWindows {


    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @Test
    public void windowtesti(){

        // https://the-internet.herokuapp.com/iframe adresine gidin
        driver.get("https://the-internet.herokuapp.com/iframe");

        String ilkSayfaWindowHandDeğeri = driver.getWindowHandle();
        // elemental selenium linkini tiklayin
        driver.findElement(By.linkText("Elemental Selenium")).click();

        /*
        Bir linke tıkladığımızda driver'ı acılan yeni window'a direk switch yapamayız
        öncelikle o sayfanın window handle değeri bulmalı
        ve o değeri kullanarak yeni sayfaya geçmeliyiz


       ilk sayfa WHD : CDwindow-28627133898E14448A33733211745B19

       Iki window’un window handle degerleri :
       [CDwindow-28627133898E14448A33733211745B19, CDwindow-16D881C607BD3D31BF6C8B124051C4A5]
         */

        Set<String> windowHandlesSeti = driver.getWindowHandles();
        String ikinciSayfaWinHandleDeğeri="";

        for (String eachHandleDeğer:windowHandlesSeti
             ) {
            if (!eachHandleDeğer.equals(ilkSayfaWindowHandDeğeri)){
                ikinciSayfaWinHandleDeğeri=eachHandleDeğer;
            }
        }

        driver.switchTo().window(ikinciSayfaWinHandleDeğeri);

        System.out.println("İlk sayfa WHD : " + ilkSayfaWindowHandDeğeri);
        System.out.println("İki window'un window handle değerleri :" + windowHandlesSeti);

        // Acilan sayfadaki en bastaki yazinin gorunur oldugu

        WebElement başlıkElenti = driver.findElement(By.tagName("h1"));

        Assert.assertTrue(başlıkElenti.isEnabled());

        // ve yazinin Elemental Selenium oldugunu test edin

        String expectedYazı = "Elemental Selenium";
        String actualYazı = başlıkElenti.getText();

       Assert.assertEquals(expectedYazı,actualYazı);

       /*
       driver.get() ile https://the-internet.herokuapp.com/iframe sayfasına gittik
       acılan yeni sayfanın url'i ise https://http://elementalselenium.com/

       bir test sırasında birden fazla window acılıyorsa
       driver'a bu window'lar arasında geçiş yaptırabiliriz



        */
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
