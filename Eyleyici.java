package cihaz;

import java.util.concurrent.TimeUnit;

public class Eyleyici implements IAkilliCihaz{

    private static Eyleyici instance;
    public static synchronized Eyleyici getInstance(){
        if(instance==null)
            instance = new Eyleyici();
        return instance;
    }

    public void sogutucuAc(Kullanici kullanici) throws InterruptedException {

        kullanici.bildirim("Soğutucu açılıyor.....");
        TimeUnit.SECONDS.sleep(2);
        kullanici.bildirim("Soğutucu açıldı.");
    }
    public void sogutucuKapat(Kullanici kullanici) throws InterruptedException {

        kullanici.bildirim("Soğutucu kapatılıyor.....");
        TimeUnit.SECONDS.sleep(2);
        kullanici.bildirim("Soğutucu kapatıldı.");
    }
}
