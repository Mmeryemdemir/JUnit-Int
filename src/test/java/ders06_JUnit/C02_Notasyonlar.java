package ders06_JUnit;

import org.junit.*;

public class C02_Notasyonlar {

    @BeforeClass
    public static void setupClass(){
        System.out.println("Before Class Çalıştı");
    }


    @AfterClass
    public static void teardownClass(){
        System.out.println("After Class Çalıştı");
    }


    @Before
    public void setupMethod(){
        System.out.println("Before Çalıştı");
    }


    @After
    public void teardownMethod(){
        System.out.println("After Çalıştı");
    }


    @Test
    public void test1(){
        System.out.println("Test1 çalıştı");
    }



    @Test@Ignore
    public void test2(){
        System.out.println("Test2 çalıştı");
    }



    @Test
    public void test3(){
        System.out.println("Test3 çalıştı");
    }
}
