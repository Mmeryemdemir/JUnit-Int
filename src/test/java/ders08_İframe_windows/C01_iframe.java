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

public class C01_iframe {


    // ● Bir class olusturun: IframeTest
    //  ● https://the-internet.herokuapp.com/iframe adresine gidin.
    //  ● Bir metod olusturun: iframeTest
    // ○ “An IFrame containing….” textinin erisilebilir oldugunu test edin ve  konsolda  yazdirin.
    // ○ Text Box’a “Merhaba Dunya!” yazin.
    // ○ TextBox’in altinda bulunan “Elemental Selenium”
    // linkini textinin gorunur oldugunu  dogrulayin ve  konsolda yazdirin.

    WebDriver driver ;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @Test
    public void iframeTest() throws InterruptedException {

        //  ● https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");

        //  ● Bir metod olusturun: iframeTest
        // ○ “An IFrame containing….” textinin erisilebilir oldugunu test edin

        WebElement anIframeYazıElementi = driver.findElement(By.tagName("h3"));
        Assert.assertTrue(anIframeYazıElementi.isEnabled());

        // ve  konsolda  yazdirin.
        System.out.println(anIframeYazıElementi.getText());

        // ○ Text Box’a “Hello Word!” yazin.

        /*
        Ulaşmak istediğimiz webElement bir iframe içerisinde ise driver o webelemente direk ulaşamaz
        önce webelement'in içerisinde olduğu iframe'ee geçiş yapmamız gerekir

        Bir iframe'e geçiş için o iframe'in
        - index
        - name veya id atribute'ün değeri
        - webeşement olarak locate edilen obje
        seceneklerinden biri ile switchto().frame() method' kullanılır
         */

        WebElement iframeElementi = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']"));
        driver.switchTo().frame(iframeElementi);

        WebElement yazıAlanıElementi = driver.findElement(By.tagName("p"));

        yazıAlanıElementi.clear();
        Thread.sleep(2000);
        yazıAlanıElementi.sendKeys("Hello Word!");

        // ○ TextBox’in altinda bulunan “Elemental Selenium”

        // linkini textinin gorunur oldugunu  dogrulayin ve  konsolda yazdirin.

        driver.switchTo().defaultContent();
        WebElement elemtalSeleniumLinki = driver.findElement(By.linkText("Elemental Selenium"));

        Assert.assertTrue(elemtalSeleniumLinki.isEnabled());

        System.out.println(elemtalSeleniumLinki.getText());


        /*
        Bir iframe'in içerisine girdikten sonra
        asıl sayfa ile ilgili bir işlem yapmak isterseniz
        öncelikle içerisine girdiğiniz iframe'den çıkmanız gerekir

        switchTo().defaulContent() ==> Ana sayfaya geçer
        VEYA
        switchTo().parentFrame() ==> İç içe birden fazla iframe varsa
                                     bulunduğu iframe'in bir üst iframe'ine çıkar
         */

        Thread.sleep(5000);

    }

    @After
    public void teardown(){

        driver.close();
    }
}
