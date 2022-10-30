package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestBase {


  protected static WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }



    @After
    public void teardown(){
        driver.close();
    }


    public static  void bekle(int beklenecekSaniye){

        try {
            Thread.sleep(beklenecekSaniye*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void tumSayfaResimÇek() throws IOException {


        // 1- TakesScreenShot objesi oluşturup
        // değer olarak cast ettiğimiz driver'i atayalım

        TakesScreenshot tss = (TakesScreenshot) driver;

        // 2- resmi kaydedeceğimiz bir dosya oluşturulur
        // Resim isimlerini dinamik yapmak ve resmin tarihini eklmek için
        // resim dosya yoluna tarih ekleyelim

        LocalDateTime ldt = LocalDateTime.now();
        DateTimeFormatter dtf= DateTimeFormatter.ofPattern("YYMMddHHmmss");


        File tumSayfaSShot = new File("target/ScreenShot/tumSayfaSShot" +ldt.format(dtf) + ".jpeg");

        // 3- screenShot objesi kullanarak fotograf çekip geçici bir dosyaya kaydet

        File geçiciResim = tss.getScreenshotAs(OutputType.FILE);

        // 4- geçici dosyayı hazırladığımız file'a kopyalayalım

        FileUtils.copyFile(geçiciResim,tumSayfaSShot);
    }
}
