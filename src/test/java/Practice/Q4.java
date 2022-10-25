package Practice;

import org.junit.Assert ;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import static org.junit.Assert.assertEquals ;

public class Q4 extends TestBase {

       /*
    1. Launch browser
    2. Navigate to url 'http://automationexercise.com'
    3. Verify that home page is visible successfully
    4. Click on 'Contact Us' button
    5. Verify 'GET IN TOUCH' is visible
    6. Enter name, email, subject and message
    7. Upload file
    8. Click 'Submit' button
    9. Click OK button
    10. Verify success message 'Success! Your details have been submitted successfully.' is visible
    11. Click 'Home' button and verify that landed to home page successfully
       */

    @Test
    public void test01(){

        driver.navigate().to("http://automationexercise.com");
        System.out.println(driver.getTitle());
        String expectedTitle = "Automation Exercise";

        assertEquals(expectedTitle,driver.getTitle());

        driver.findElement(By.xpath("//*[text()=' Contact us']")).click();
    }


    }


