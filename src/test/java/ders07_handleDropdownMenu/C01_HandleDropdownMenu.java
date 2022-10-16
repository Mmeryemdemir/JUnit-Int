package ders07_handleDropdownMenu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C01_HandleDropdownMenu {

    WebDriver driver ;


    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }


    /*
    Dropdown menü'ler özel webElementleridir ve select tag'i ile oluşturulurlar
   1- dropdown menuyu locate edelim
   2- dropdown menulerden option seçebilmek için Select class'ından obje oluşturmalıyız
      obje'ye handle etmek istediğimiz dropdown'ı parametre olarak girmeliyiz
   3- Locate ettiğimiz ve select objesi oluşturduğumuz menü'den option seçmek için
     - index
     - value
     - visibletext
     ile istediğimiz seçebiliriz
     */


    @Test
    public void dropdownTest(){
        // amazona gidin
        driver.get("https://www.amazon.com");

        // Arama kutusunun solundaki search-in menusunden Electronics'i secin

        WebElement dropdownWebElement = driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(dropdownWebElement);
        select.selectByVisibleText("Electronics");

        // arama cubuguna Java yazip aratin

        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
       aramaKutusu.sendKeys("Java"+ Keys.ENTER);

        // bulunan sonuc sayisinin 1000'den fazla oldugunu test edin
         WebElement aramaSonuçElementi = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));

         String aramaSonuçStr= aramaSonuçElementi.getText();

         // System.out.println(aramaSonuçStr); // 1-24 of 327 results for "Java"

        int indexOfOf = aramaSonuçStr.indexOf("of");
        int indexOfResults= aramaSonuçStr.indexOf("results");

         int aramaSonuçSayısıInt =Integer
                                   .parseInt(aramaSonuçStr
                                          .substring(indexOfOf+3,indexOfResults-1));


          Assert.assertTrue(aramaSonuçSayısıInt>1000);

    }


    @After
    public void teardown(){
        driver.close();
    }
}
