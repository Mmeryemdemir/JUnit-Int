package Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q3 {

    /*
       ...Exercise4...

    https://www.teknosa.com/ adresine gidiniz
    arama cubuguna oppo yazip enter deyiniz
    sonuc sayisini yazdiriniz
    cikan ilk urune tiklayiniz
    sepete ekleyiniz
    sepetime git e tiklayiniz
    consol da "Sipariş Özeti" webelementinin text ini yazidiriniz
    Alisverisi tamamlayiniz
    son alarak da "Teknosa'ya hoş geldiniz"  webelementinin text ini yazidiriniz
    driver i kapatiniz
   */

    static WebDriver driver ;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();
    }

    @AfterClass
    public static void tearDown(){
        driver.close();
    }

    @Before
    public void beforeTest(){

        driver.get("https://www.teknosa.com/");
    }



    @Test
    public void test01() throws InterruptedException {


        driver.findElement(By.id("search-input")).

             sendKeys("oppo"+Keys.ENTER);



        Thread.sleep(2000);
        System.out.println("Sonuç Sayısı :" + driver.findElement(By.xpath("//div[@class='plp-info']")).getText());

        Thread.sleep(2000);

        driver.findElement(By.xpath("//a[@class='prd-link']")).click();
        driver.findElement(By.xpath("//button[@id='addToCartButton']")).click();

        driver.findElement(By.xpath("//a[@class='btn btn-secondary']")).click();

        System.out.println( driver.findElement(By.xpath("//div[@class='cart-sum-body']")).getText());

        Thread.sleep(2000);

        driver.findElement(By.xpath("//span[text()='Alışverişi Tamamla']")).click();
        System.out.println( driver.findElement(By.xpath("//div[text()='Teknosa’ya hoş geldiniz']")).getText());
    }

}
