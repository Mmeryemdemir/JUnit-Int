package ders09_actionsClass;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C05_KeyboardActions extends TestBase {

    @Test
    public void test01(){

        /*
        Klavye'de çok fazla tuş olsada her bir tuşla ilgili temel 2 işlem var

       1- tek seferlik basmak
          sendKeys(keys.ENTER)
       2- uzun sureli basmak ve isim bitince tuştan elimizi kaldırmak
         - basmak için keyDown()
         - basılı tusu bırakmak için keyUp()
         */

        // amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
          // arama tuşuna nutella yazın
         WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
         aramaKutusu.sendKeys("nutella");
       // aramayı yapmak için ENTER tuşuna basın
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(Keys.ENTER);

        bekle(2);

        // arama kutusunu temizleyelim
        driver.navigate().back();
        WebElement aramaKutusu1 = driver.findElement(By.id("twotabsearchtextbox"));

        //arama kutusuna actions class'ını kullanarak SamsungA71 yazdırın

        Actions actions = new Actions(driver);
          bekle(2);

           actions.click(aramaKutusu1)
                 .keyDown(Keys.SHIFT)
                  .sendKeys("s")
                   .keyUp(Keys.SHIFT)
                    .sendKeys("amsung")
                     .keyDown(Keys.SHIFT)
                      .sendKeys("a")
                       .keyUp(Keys.SHIFT)
                        .sendKeys("71")
                         .sendKeys(Keys.ENTER)
                          .perform();

        bekle(5);
    }
}
