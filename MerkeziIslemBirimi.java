package cihaz;

import java.util.Scanner;

public class MerkeziIslemBirimi implements IAkilliCihaz{

    private static MerkeziIslemBirimi instance;
    public static synchronized MerkeziIslemBirimi getInstance(){
        if(instance==null)
            instance = new MerkeziIslemBirimi();
        return instance;
    }

    private static final int SICAKLIK_GORUNTULEME = 1;
    private static final int SOGUTUCUYU_ACMA = 2;
    private static final int SOGUTUCUYU_KAPATMA= 3;
    private static final int CIKIS = 4;



    public void islemSecimi(String yetki,String kullaniciAdi,String sifre) throws InterruptedException {
        Abone1 abone = new Abone1();
        Publisher p = new Publisher();
        p.attach(abone);
        Kullanici kullanici=new Kullanici(kullaniciAdi,sifre,yetki,p);
        kullanici.setYetki(yetki);

        int secim;
        do{
            secim=anaMenu();
            switch (secim) {
                case  SICAKLIK_GORUNTULEME:
                    if(yetki.contains("sicaklik goruntuleme")) {
                        System.out.println("AKILLI CİHAZ ALGILAMA DURUMUNA GEÇTİ");
                        System.out.println("SICAKLIK " + SicaklikAlgilayici.getInstance().sicaklikGonder() + " DERECE");
                    }
                    else{

                        System.out.println("BU İŞLEMİ GERÇEKLEŞTİRME YETKİNİZ YOK ! ....");
                        System.out.println("AKILLI CİHAZ BEKLEME DURUMUNA GEÇTİ");
                    }
                    break;
                case SOGUTUCUYU_ACMA:
                    if(yetki.contains("sogutucu acma")) {

                        System.out.println("SOĞUTUCUYU AÇMA İŞLEMİ SEÇİLDİ");

                        Eyleyici.getInstance().sogutucuAc(kullanici);

                    }
                    else{
                        System.out.println("BU İŞLEMİ GERÇEKLEŞTİRME YETKİNİZ YOK ! ....");
                        System.out.println("AKILLI CİHAZ BEKLEME DURUMUNA GEÇTİ");
                    }
                    break;

                case SOGUTUCUYU_KAPATMA:
                    if(yetki.contains("sogutucu kapatma")) {
                        System.out.println("SOĞUTUCUYU KAPATMA İŞLEMİ SEÇİLDİ");
                        Eyleyici.getInstance().sogutucuKapat(kullanici);

                    }
                    else{
                        System.out.println("BU İŞLEMİ GERÇEKLEŞTİRME YETKİNİZ YOK ! ....");
                        System.out.println("AKILLI CİHAZ BEKLEME DURUMUNA GEÇTİ");
                    }
                    break;


                case CIKIS:
                    System.out.println("AKILLI CİHAZ KAPALI DURUMUNA GEÇTİ");
                    System.out.println("Çıkılıyor");
                    break;
                default:
                    System.out.println("1-4 arasında bir sayı girmelisiniz");
            }
        }while(secim!=4);
    }
    private int anaMenu()
    {
        System.out.println("******************************************");
        System.out.println("Ana Menu");
        System.out.println("1-Sıcaklık Görüntüle");
        System.out.println("2-Soğutucuyu Aç");
        System.out.println("3-Soğutucuyu kapat");
        System.out.println("4-Cikis");
        System.out.println("Seciminiz:");
        System.out.println("******************************************");

        Scanner input=new Scanner(System.in);
        return input.nextInt();
    }

}

