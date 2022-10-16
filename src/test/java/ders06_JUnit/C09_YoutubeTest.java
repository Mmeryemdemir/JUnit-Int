package ders06_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C09_YoutubeTest {

    //1) Bir class oluşturun: YoutubeAssertions
    //2) https://www.youtube.com adresine gidin
    //3) Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin
    // ○ titleTest  => Sayfa başlığının “YouTube” oldugunu test edin
    // ○ imageTest  => YouTube resminin görüntülendiğini (isDisplayed()) test edin
    //  ○ Search Box ’in erisilebilir oldugunu test edin (isEnabled())
    // ○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin


    static WebDriver driver;

    @BeforeClass
    public static void setup(){

        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

    }

  @Test
  public void titleTest(){
        driver.get("https://www.youtube.com");
     // driver.findElement(By.xpath("//yt-formatted-string[text()='Accept all']"));
      // ○ titleTest  => Sayfa başlığının “YouTube” oldugunu test edin

      String expectedTitle ="YouTube";
      String actualTitle = driver.getTitle();
      Assert.assertEquals(expectedTitle,actualTitle);

  }

  @Test
  public void imageTest(){
        // ○ imageTest  => YouTube resminin görüntülendiğini (isDisplayed()) test edin
      driver.get("https://www.youtube.com");

       // driver.findElement(By.xpath("//yt-formatted-string[text()='Accept all']"));
      WebElement youtubeLogo = driver.findElement(By.xpath("(//yt-icon[@id='logo-icon'])[1]"));

      Assert.assertTrue(youtubeLogo.isDisplayed());
  }

  @Test
  public void aramaKutusu(){
      //  ○ Search Box ’in erisilebilir oldugunu test edin (isEnabled())
      driver.get("https://www.youtube.com");

      // driver.findElement(By.xpath("//yt-formatted-string[text()='Accept all']"));
      WebElement aramaKutusu= driver.findElement(By.xpath("//input[@id='search']"));

      Assert.assertTrue(aramaKutusu.isEnabled());
  }


  @Test
  public void negativeTitletest(){

      // ○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini test edin
      driver.get("https://www.youtube.com");

     //  driver.findElement(By.xpath("//yt-formatted-string[text()='Accept all']"));

      String expectedYanlışTitle = "youtube";
      String actualTitle = driver.getTitle();
      Assert.assertNotEquals(expectedYanlışTitle,actualTitle);

  }

    @AfterClass
    public static void tearndown(){
       driver.close();
    }
}
