package ders11_cookies_webTables;

import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

public class C01_Cookies extends TestBase {

    @Test
    public void  test01(){

        driver.get("https://www.youtube.com");

        Set<Cookie> cookieSeti = driver.manage().getCookies();


        for (Cookie eachCookie:cookieSeti
        ) {
            System.out.println(eachCookie);
        }

        System.out.println("=========");

        Cookie cookie= new Cookie("en güzel cookie", "bizim cookie");
        driver.manage().addCookie(cookie);

        cookieSeti = driver.manage().getCookies();

        for (Cookie eachCookie:cookieSeti
        ) {
            System.out.println(eachCookie);
        }


        bekle(30);

    }


}
