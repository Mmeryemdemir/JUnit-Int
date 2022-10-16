package ders06_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_BeforeClass {


    /*
     @BeforeClass ve @AfterClass notasyonları kullanıldığı methodlar
     static olmak ZORUNDADIR

     JUnit Test method'ları öngöremeyeceğimiz bir sıra ile çalıştırır
     Test öethod'larını yazarken tamamını bağımsız olaraktan da
     çalıştırabileyeceğini göz önünde bulundurmalıyız
     */
   static WebDriver driver;


    @BeforeClass
    public static void setup(){

        WebDriverManager.chromedriver().setup();

        driver  = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

    }

    @Test
    public void testNutella(){
        driver.get("https://www.amazon.com");
        WebElement aramaBox = driver.findElement(By.id("twotabsearchtextbox"));
        aramaBox.sendKeys("Nutella"+ Keys.ENTER);
        WebElement aramaSonuçelementi = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(aramaSonuçelementi.getText());

    }


    @Test
    public void testJava(){
        driver.get("https://www.amazon.com");
        WebElement aramaBox = driver.findElement(By.id("twotabsearchtextbox"));
        aramaBox.sendKeys("Java"+ Keys.ENTER);
        WebElement aramaSonuçelementi = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(aramaSonuçelementi.getText());

    }



    @Test
    public void testSelenium(){
        driver.get("https://www.amazon.com");
        WebElement aramaBox = driver.findElement(By.id("twotabsearchtextbox"));
        aramaBox.sendKeys("Selenium"+ Keys.ENTER);
        WebElement aramaSonuçelementi = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(aramaSonuçelementi.getText());

    }

    @AfterClass
    public static void teardown(){

        driver.close();

    }
}

