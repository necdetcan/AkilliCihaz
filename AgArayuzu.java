package cihaz;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class AgArayuzu implements IAkilliCihaz{

    private static AgArayuzu instance;

    public static synchronized AgArayuzu getInstance() {
        if (instance == null)
            instance = new AgArayuzu();
        return instance;
    }

    private String kullaniciAdi;
    private String sifre;

    public void arayuz() throws InterruptedException {
        Scanner myObj = new Scanner(System.in);

        System.out.println("******************************************");
        System.out.println("AĞ ARAYÜZÜ");
        System.out.println("******************************************");
        System.out.println("Kullanıcı adı  :");
        kullaniciAdi = myObj.nextLine();  //
        System.out.println("Şifre          :");
        sifre = myObj.nextLine();  //
        System.out.println("******************************************");
        Veritabani.getInstance().oku(kullaniciAdi,sifre);


    }


}

