package ders06_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_RadioButtons {
    //1. Bir class oluşturun : RadioButtonTest
    //2. Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.


    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @Test
    public void Test01() throws InterruptedException {

        //-https://www.facebook.com adresine gidin
        driver.get("https://www.facebook.com");

        //-Cookies’i kabul edin
        WebElement cookiesButonu= driver.findElement(By.xpath("//button[@title='Only allow essential cookies']"));
        cookiesButonu.click();

        //-“Create an Account” button’una basin
        driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();

        //-“radio buttons” elementlerini locate edin
        WebElement cinsiyetRadioButonu = driver.findElement(By.xpath("(//input[@type='radio'])[3]"));

        //-Secili degilse cinsiyet butonundan size uygun olani secin
        if (!cinsiyetRadioButonu.isSelected()){
            cinsiyetRadioButonu.click();
        }

        Thread.sleep(5000);

    }

    @After
    public void tearndown(){
        driver.close();
    }
}
