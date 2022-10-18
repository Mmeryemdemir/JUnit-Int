package Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q1 {

/*..........Exercise1............
    BeforeClass ile driver'i olusturun ve class icinde static yapin
    Maximixe edin ve 10 sn bekletin
    http://www.google.com adresine gidin
    arama kutusuna "The Lord of the Rings" yazip, cikan sonuc sayisini yazdirin
    arama kutusuna "Brave Heart" yazip, cikan sonuc sayisini yazdirin
    arama kutusuna "Harry Potter" yazip, cikan sonuc sayisini yazdirin
    AfterClass ile kapatin
     */

   static WebDriver driver ;

    @BeforeClass
    public static void beforeClass(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }


    @AfterClass
    public static void teardown(){

        driver.close();
    }


    @After
    public void tearDown(){
        System.out.println("Test sonucu : " +driver.findElement(By.xpath("//div[@id='result-stats']")).getText());
    }



    @Before
    public void setup(){

        driver.get("http://www.google.com");

    }


    @Test
    public  void test01(){

        driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("The Lord of the Rings"+ Keys.ENTER);

    }


    @Test
    public  void test02(){

        driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("Brave Heart"+ Keys.ENTER);

    }


    @Test
    public void test03(){

        driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("Harry Potter"+ Keys.ENTER);


    }




}
