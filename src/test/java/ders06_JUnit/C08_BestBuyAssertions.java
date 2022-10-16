package ders06_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C08_BestBuyAssertions {

    // 1) Bir class oluşturun: BestBuyAssertions
    //2) https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak asagidaki testleri yapin

  static  WebDriver driver;

    @BeforeClass
            public static void setup(){

        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

    }


    @Test
    public void urlTest(){
        // ○ Sayfa URL’inin https://www.bestbuy.com/ ’a esit oldugunu test edin

        String expectedUrl = "https://www.bestbuy.com/";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals(expectedUrl,actualUrl);



    }


    @Test
    public void titleTest(){
        // ○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
        driver.get("https://www.bestbuy.com/");

        String expectedYanlışİçerik = "Rest";
        String actualTittle = driver.getTitle();

        Assert.assertFalse(actualTittle.contains(expectedYanlışİçerik));
    }

    @Test
    public void logoTesti(){
        // ○ logoTest => BestBuy logosunun görüntülendigini test edin
        driver.get("https://www.bestbuy.com/");

        WebElement logoElementi= driver.findElement(By.xpath("(//img[@alt='Best Buy Logo'])[1]"));
        Assert.assertTrue(logoElementi.isDisplayed());

    }

    @Test
    public void francaisTest(){
        // ○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
        driver.get("https://www.bestbuy.com/");

        WebElement francaisElementi = driver.findElement(By.xpath("//button[text()='Français']"));
        Assert.assertTrue(francaisElementi.isDisplayed());

    }
    @AfterClass
    public static void tearndown(){
        driver.close();
    }
}
