package ders08_İframe_windows;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_HandleWindows {

    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }


    @Test
    public void windowTest() throws InterruptedException {

        // ● Amazon anasayfa adresine gidin.
        driver.get("https://www.amazon.com");

        //● Sayfa’nin window handle degerini String bir degiskene atayin
        String ilkSayfaHandleDeğeri = driver.getWindowHandle();

        //● Sayfa title’nin “Amazon” icerdigini test edin

        String expectedİçerik = "Amazon";
        String actualTitle = driver.getTitle();

        Assert.assertTrue(actualTitle.contains(expectedİçerik));

        //● Yeni bir tab olusturup, acilan tab’da wisequarter.com adresine gidin

      /*
      driver.switchTo().newWindow() method'u ile yeni bir sayfa oluşturup
      driver'ı o sayfaya switch ederiz

      Bu geçiş driver üzerinde yapıldığı için driver da yeni sayfaya geçer
      ve biz yeni sayfada işlem yapabiliriz
       */

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.wisequarter.com");

        //● Sayfa title’nin “Wise Quarter” icerdigini test edin

         expectedİçerik = "Wise Quarter";
         actualTitle = driver.getTitle();
         Assert.assertTrue(actualTitle.contains(expectedİçerik));

        //● Yeni bir window olusturup, acilan sayfada walmart.com adresine gidin

        driver.switchTo().newWindow(WindowType.WINDOW).get("https://www.walmart.com");

        //● Sayfa title’nin “Walmart” icerdigini test edin

        Thread.sleep(5000);
        expectedİçerik = "Walmart";
        actualTitle = driver.getTitle();

        Assert.assertTrue(actualTitle.contains(expectedİçerik));

        //● Ilk acilan sayfaya donun ve amazon sayfasina dondugunuzu test edin


        /*
           driver'ı swichTo(9 ile yeni bir tab veya window'a geçirebiliriz
           yeni window oluşturmak dışında
           herhangi bir window'a geçmenin TEK BİR YOLU VARDIR
           o da geçmek istediğimiz sayfanın window handle deperini kullanmak


          YANİ;
          bir test sırasında yeniden dönmemiz gereken bir window'da iseniz
          o sayfanın window handle değerini KAYDETMELİSİNİZ
         */
        driver.switchTo().window(ilkSayfaHandleDeğeri);

        expectedİçerik = "Amazon";
        actualTitle = driver.getTitle();

        Assert.assertTrue(actualTitle.contains(expectedİçerik));


      Thread.sleep(5000);
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
