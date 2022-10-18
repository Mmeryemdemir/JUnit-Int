package Practice;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class Q2 {


         //..Exercise2...
    //  http://www.bestbuy.com 'a gidin,
    //  Sayfa basliginin "Best" icerdigini(contains) dogrulayin
    //  Ayrica Relative Locator kullanarak;
    //      logoTest => BestBuy logosunun gorunutulenip goruntulenmedigini dogrulayin
    //  Ayrica Relative Locator kullanarak;
    //      mexicoLinkTest => Linkin gorunutulenip goruntulenmedigini dogrulayin


    static WebDriver driver ;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterClass
    public static void tearDown(){
        driver.close();
    }

    @Before public void beforeTest(){

        driver.get("http://www.bestbuy.com");
    }

    @After
    public void afterTest(){


    }

    @Test
    public void baslıkTest(){

        //  Sayfa basliginin "Best" icerdigini(contains) dogrulayin

       String actualTitle = driver.getTitle();
       boolean içeriyorMu= actualTitle.contains("Best");

       Assert.assertTrue("Title Best Kelimesi İçermiyor ", içeriyorMu);
    }

    @Test
    public void logoTesti(){
        //  Ayrica Relative Locator kullanarak;
        // logoTest => BestBuy logosunun goruntulenip goruntulenmedigini dogrulayin

        WebElement helloHeading = driver.findElement(By.xpath("(//div[@class='heading'])[1]"));
        WebElement bestBuyLogo = driver.findElement(RelativeLocator.with(By.tagName("img")).above(helloHeading));

        Assert.assertTrue(bestBuyLogo.isDisplayed());
    }



    @Test
    public void linkTesti(){

        //Ayrica Relative Locator kullanarak;
        //mexicoLinkTest => Linkin goruntulenip goruntulenmedigini dogrulayin

        WebElement usFlag = driver.findElement(By.xpath("(//img[@alt='United States'])[1]"));
        WebElement mexicoFlag = driver.findElement(RelativeLocator.with(By.tagName("img")).toRightOf(usFlag));

        Assert.assertTrue(mexicoFlag.isDisplayed());
    }
}
