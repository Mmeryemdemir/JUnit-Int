package ders09_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;

public class C02_MouseActions extends TestBase {

    @Test
    public void test01() throws InterruptedException {

        // 1- Yeni bir class olusturalim: MouseActions1


        //2- https://the-internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu");
        //3- Cizili alan uzerinde sag click yapalim
        Actions actions = new Actions(driver);

        WebElement çizgiliAlanElementi = driver.findElement(By.id("hot-spot"));
        actions.contextClick(çizgiliAlanElementi).perform();

        //4- Alert’te cikan yazinin “You selected a context menu” oldugunu
        //   test edelim.

        String expectedAlertYazısı= "You selected a context menu";
        String actualAlertYazısı = driver.switchTo()
                                           .alert()
                                             .getText();
        Assert.assertEquals(expectedAlertYazısı,actualAlertYazısı);

        //5- Tamam diyerek alert’i kapatalim

        driver.switchTo().alert().accept();

        //6- Elemental Selenium linkine tiklayalim

        String ilkSayfaHandleDeğeri = driver.getWindowHandle();
        driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).click();

        //7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim

        // önce driver'ı ikinci sayfaya geçirmeliyiz, bunun için de 2. sayfanın handle değerini bulmalıyız

        Set<String> handleDeğerlerSeti = driver.getWindowHandles();
        String ikinciSayfaHandleDeğeri = "";

        for (String eachHandleDeğeri: handleDeğerlerSeti
             ) {
            if (!eachHandleDeğeri.equals(ilkSayfaHandleDeğeri)){
                ikinciSayfaHandleDeğeri= eachHandleDeğeri;
            }
        }

        driver.switchTo().window(ikinciSayfaHandleDeğeri);

        WebElement h1TagElementi = driver.findElement(By.tagName("h1"));

        String expectedTagYazısı ="Elemental Selenium";
        String actualTAgYazısı = h1TagElementi.getText();

        Assert.assertEquals(expectedTagYazısı,actualTAgYazısı);
        Thread.sleep(5000);

    }
}
