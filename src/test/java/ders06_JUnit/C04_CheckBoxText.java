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

public class C04_CheckBoxText {


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

        // a. Verilen web sayfasına gidin.
        //  https://the-internet.herokuapp.com/checkboxes
        driver.get("https://the-internet.herokuapp.com/checkboxes");

        //  b. Checkbox1 ve checkbox2 elementlerini locate edin.
        WebElement checkBox1= driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        WebElement checkBox2= driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));

        //  c. Checkbox1 seçili olmadığını ve
        // d. Checkbox2 seçili olduğunu test edin

        if (checkBox1.isSelected()){
            System.out.println("Checkbox1 Seçili Test FAILED");
        }else {
            System.out.println("Checkbox1 Seçili Değil Test PASSED");
        }

        if (checkBox2.isSelected()){
            System.out.println("Checkbox2 Seçili Test PASSED");
        }else {
            System.out.println("Checkbox2 Seçili Değil Test FAILED");
        }
    }

    @After
    public void tearndown(){
        driver.close();
    }
}
