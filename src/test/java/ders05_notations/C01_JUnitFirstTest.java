package ders05_notations;

import org.junit.Test;

public class C01_JUnitFirstTest {

    /*
    JUnit ile;

    1- Bir class'da birden fazla bağımsız test method'u oluşturabiliriz

    2- Bu test method'larını istersek bağımsız olarak çalıştırbiliriz
       istersek class level'dan tüm method'ları çalıştırbiliriz

    3- @Test notasyonu ile main method bağımlılığı ortadan kalkar
       @Test notasyonu kullanılan method'lar bagımsız olarak çalıştırabiliriz

    4- JUnit standart olarak çalıştırılan test method'ların başarılı bir şekilde çalıştığını
       veya failed olduğunu raporlar

    5- JUnit Assert class'ından hazır method'lar yaparak testleri gerçekleştirir
       böylece if-else ile expected ve actual sonuçları karşılaştırmamıza gerek kalmaz

    6- JUnit failed olan testlerde actual ve expected dataların farkını da raporlar
     */
    @Test
    public void test01(){

        System.out.println("test01");
    }

    @Test
    public void test02(){
        System.out.println("test02");

    }

    @Test
    public void test03(){
        System.out.println("test03");

    }
}
