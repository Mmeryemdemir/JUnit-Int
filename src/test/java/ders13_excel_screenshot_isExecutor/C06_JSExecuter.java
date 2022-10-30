package ders13_excel_screenshot_isExecutor;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C06_JSExecuter extends TestBase {

    @Test
    public void test01(){

        // amazon anasayfasına gidelim

        driver.get("https://www.amazon.com");

        // sell butonuna JS executor ile basalım


        WebElement sellLinki = driver.findElement(By.xpath("//a[text()='Sell']"));

        JavascriptExecutor jse = (JavascriptExecutor) driver;

        jse.executeScript("arguments[0].click();",sellLinki);

        // bir alert oluşturup "Yaşasınn!!!" yazdıralım

        jse.executeScript("alert('Yaşasınn!!!');");

        bekle(3);

        driver.switchTo().alert().accept();


    }
}
