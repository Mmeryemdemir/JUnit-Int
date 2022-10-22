package ders07_handleDropdownMenu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C04_HandleDDM {


     /*
   1. http://zero.webappsecurity.com/ Adresine gidin
   2. Sign in butonuna basin
   3. Login kutusuna “username” yazin
   4. Password kutusuna “password.” yazin
   5. Sign in tusuna basin
   6. Pay Bills sayfasina gidin
   7. “Purchase Foreign Currency” tusuna basin
   8. “Currency” drop down menusunden Eurozone’u secin
   9. “amount” kutusuna bir sayi girin
   10. “US Dollars” in secilmedigini test edin
   11. “Selected currency” butonunu secin
   12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
   13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin.
     */


    WebDriver driver;

    @Before
    public void setup(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }


    @Test
    public void test01() throws InterruptedException {

        driver.get("http://zero.webappsecurity.com/");

        driver.findElement(By.xpath("//button[@id='signin_button']")).click();

        driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("username");
        driver.findElement(By.xpath("//input[@id='user_password']")).sendKeys("password");
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        driver.navigate().back();

        driver.findElement(By.xpath("//a[@id='online-banking']")).click();
        driver.findElement(By.xpath("(//span[@class='headers'])[4]")).click();

        driver.findElement(By.xpath("(//li[@class='ui-state-default ui-corner-top'])[2]")).click();

        WebElement DDM=driver.findElement(By.id("pc_currency"));

        Select select=new Select(DDM);

        select.selectByVisibleText("Eurozone (euro)");
        select.getFirstSelectedOption().click();

        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@id='pc_amount']")).sendKeys("4000");

        WebElement radioUSD=driver.findElement(By.xpath("//input[@id='pc_inDollars_true']"));
        Assert.assertFalse(radioUSD.isSelected());

        Thread.sleep(2000);

        driver.findElement(By.id("pc_inDollars_false")).click();
        driver.findElement(By.id("pc_calculate_costs")).click();
        driver.findElement(By.id("purchase_cash")).click();

        Thread.sleep(2000);

        String expectedText="Foreign currency cash was successfully purchased.";
        String actualText=driver.findElement(By.id("alert_content")).getText();

        Assert.assertEquals(expectedText,actualText);

        Thread.sleep(2000);
    }


    @After
    public void tearndown(){
      driver.close();
    }
}
