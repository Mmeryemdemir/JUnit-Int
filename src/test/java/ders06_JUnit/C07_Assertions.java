package ders06_JUnit;

import org.junit.Assert;
import org.junit.Test;

public class C07_Assertions {


    int sayı1 = 10;
    int sayı2= 20;
    int sayı3= 30;

    /*
    JUnit de Assert class'ındaki hazır method'lar gerçekleşen sonuçların
    beklentimize uygun olup olmadığını kabul eder

    expected result ile actual result aynı ise test PASSED
    AMA;
    expected result ile actual result farklı ise test FAILED

    genel olarak ifade etmek istersek
    test cümlesi olumlu ise asserTrue
    test cümlesi olumsuz ise asserFalse tercih edilir

    Assertion'nın FAILED olduğu satırda kodların çalışması durur
    o method'un içerisinde FAILED olan assertion'dan sonraki satırlar ÇALIŞTIRILMAZ


     */


    @Test
    public void test01(){



        /*
        Assert class'ından çok kullanacağımız 4 hazır method bulunur
        Assert.assertTrue
        Assert.assertFalse
        Assert.assertEquals
        Assert.assertNotEquals

         */
        // sayı1'in sayı2'den küçük olduğunu test edin

        Assert.assertTrue(sayı1<sayı2);

        // sayı1'in sayı2'den buyuk olmadığını test edin
        Assert.assertFalse(sayı1>sayı2);

        //sayı1'in sayı2'ye eşit olduğunu test edin
        Assert.assertEquals(sayı1,sayı2);
    }

    @Test
    public void test02(){

        Assert.assertEquals(sayı3,sayı1+sayı2); // PASSED
    }


    @Test
    public void test03(){

        Assert.assertNotEquals(sayı3,sayı2); // PASSED
    }



    @Test
    public void test04(){

        Assert.assertTrue(sayı3==sayı2); // FAILED
    }



    @Test
    public void test05(){

        Assert.assertFalse(sayı3==sayı2); // PASSED
    }


    @Test
    public void test06(){

        Assert.assertNotEquals(sayı3,sayı1+sayı2); // FAILED
    }


    @Test
    public void test07(){

        Assert.assertTrue(sayı3<sayı2); // FAILED
    }


    @Test
    public void test08(){

        Assert.assertFalse(sayı3>sayı2); // FAILED
        System.out.println("Bu satır yazdırılacak mı ?");
    }
}
