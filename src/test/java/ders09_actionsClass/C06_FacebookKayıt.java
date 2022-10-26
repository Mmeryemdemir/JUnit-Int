package ders09_actionsClass;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C06_FacebookKayıt extends TestBase {

    @Test
    public void test01(){


        // 1- https://www.facebook.com adresine gidelim
        driver.get("https://www.facebook.com");

        //2- Cookies'i kabul edin yeni hesap olustur butonuna basalim
     //   driver.findElement(By.xpath("//*[@title='Only allow essential cookies']")).click();

        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        //3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna basalim
        WebElement isimKutusu = driver.findElement(By.xpath("//input[@name='firstname']"));

        Actions actions= new Actions(driver);

        actions.click(isimKutusu)
                .sendKeys("Meryem")
                 .sendKeys("Demir")
                  .sendKeys(Keys.TAB)
                   .sendKeys("mrymdmr@gamil.com")
                    .sendKeys(Keys.TAB)
                     .sendKeys("12345Artı")
                      .sendKeys(Keys.TAB)
                       .sendKeys(Keys.TAB)
                        .sendKeys("15")
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
        //4- Kaydol tusuna bas alim

        bekle(25);



    }
}
