package cihaz;

public class Kullanici {


    private String kullaniciAdi;
    private String sifre;
    private String yetki;
    ISubject publisher;


    public Kullanici(String kullaniciAdi, String sifre,String yetki,ISubject publisher) {
        this.kullaniciAdi=kullaniciAdi;
        this.sifre = sifre;
        this.yetki=yetki;
        this.publisher = publisher;
    }

    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    public String getSifre() {
        return sifre;
    }
    public String getYetki() {
        return yetki;
    }

    public void setYetki(String yetki) {
        this.yetki = yetki;
        publisher.notify("{Kullanıcı:"+this.kullaniciAdi+",yetki : "+yetki+"}");
    }
    public void bildirim(String mesaj){
        publisher.notify(mesaj);    }
}
