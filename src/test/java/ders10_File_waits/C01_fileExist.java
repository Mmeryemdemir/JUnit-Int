package ders10_File_waits;

import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C01_fileExist {

    @Test
    public void test01(){

        System.out.println(System.getProperty("user.dir"));
        //C:\Users\HONOR\Desktop\My Desktop\JUnitInt

        System.out.println(System.getProperty("user.home"));
        //C:\Users\HONOR

        // masa üstünde oluşturduğumuz txt file'ın path'i
        // C:\Users\HONOR\OneDrive\Masaüstü\fileTesti\deneme.txt

        /*
        System.getProperty("user.home") tüm bilgisayarlarda
        kullanıcıya kadar olan path'i verir
        Ve bu kısım her bilgisayar ve her kullanıcı için farklıdır

        user.home'dan sonrası yüm kullanıcılar için ortak olabilir
        örneğin tüm kullanıcıların masaüstü

        user.home/Desktop

        dowloads %90 kullanıcı için

        user.home/Downloads

        eğer birden fazla bilgisayarda file ile ilgili bir test yapacaksanız
        dosya yolunu dinamik olarak oluşturmanız gerekir

         */


        // dinamik dosya yolu oluşturma
        // masa üstünde FileTesti diye bir klasor ve onun altında deneme diye bir txt dosyası için

        String dosyaYolu = System.getProperty("user.home")+"\\OneDrive\\Masaüstü\\fileTesti\\deneme.txt";

        System.out.println(Files.exists(Paths.get(dosyaYolu))); // true veya false döndürür


    }
}
