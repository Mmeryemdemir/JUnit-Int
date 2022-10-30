package ders09_actionsClass;

import com.github.javafaker.Faker;
import org.checkerframework.checker.units.qual.K;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C07_FakerClassKullanimi extends TestBase {


    @Test
    public void test01(){

        // buradaki isim, soyisim, email, şifre gibi değerler için
        // rastgele isim oluşturup kullanın



        //1- https://www.facebook.com adresine gidelim
        driver.get("https://www.facebook.com");

        //2- cookies'i kabul edin ve yeni hesap olustur butonuna basalim

        driver.findElement(By.xpath("//*[@title='Only allow essential cookies']")).click();
        driver.findElement(By.linkText("Create New Account")).click();

        //3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim

        WebElement isimKutusu = driver.findElement(By.xpath("//input[@name='firstname']"));
        Actions actions= new Actions(driver);
        Faker faker= new Faker();
        String eamail = faker.internet().emailAddress();

        actions.click(isimKutusu)
                .sendKeys(faker.name().firstName())
                 .sendKeys(Keys.TAB)
                  .sendKeys(faker.name().lastName())
                   .sendKeys(Keys.TAB)
                    .sendKeys(eamail)
                     .sendKeys(Keys.TAB)
                      .sendKeys(eamail)
                       .sendKeys(Keys.TAB)
                        .sendKeys(faker.internet().password())
                         .sendKeys(Keys.TAB)
                          .sendKeys(Keys.TAB)
                           .sendKeys("13")
                            .sendKeys(Keys.TAB)
                             .sendKeys("Oct")
                            .sendKeys(Keys.TAB)
                           .sendKeys("2004")
                          .sendKeys(Keys.TAB)
                         .sendKeys(Keys.TAB)
                        .sendKeys(Keys.ARROW_RIGHT)
                       .sendKeys(Keys.ARROW_LEFT)
                      .sendKeys(Keys.TAB)
                     .sendKeys(Keys.TAB)
                    .sendKeys(Keys.TAB)
                   .sendKeys(Keys.TAB)
                  .sendKeys(Keys.TAB)
                 .sendKeys(Keys.ENTER)
                .perform();

        // 4- Kaydol tuşuna basalım

        bekle(25);










    }
}
