package cihaz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

public class Veritabani {

    private static Veritabani instance;

    public static synchronized Veritabani getInstance() {
        if (instance == null)
            instance = new Veritabani();
        return instance;
    }

    public boolean oku(String ad,String parola) {
        try {   /***** Bağlantı kurulumu *****/
            Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Veritabani",
                    "postgres", "panasonic1");
            if (conn != null) {
                System.out.println("Veritabanına bağlandı!");
                System.out.println("Akıllı cihaz kontrol durumuna geçti.....");
                System.out.println("Kullanıcı adı şifre doğrulanıyor.....");

                TimeUnit.SECONDS.sleep(2);
            }
            else {
                System.out.println("Bağlantı girişimi başarısız!");
            }

            String sql = "SELECT \"kullaniciAdi\" ,\"sifre\",\"yetki\"  FROM \"Kullanici\"";


            /***** Sorgu çalıştırma *****/
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);


            /***** Bağlantı sonlandırma *****/
            conn.close();
            String kullaniciAdi = null;
            String sifre = null;
            String yetki = null;



            while (rs.next()) {

                /***** Kayda ait alan değerlerini değişkene ata *****/
                kullaniciAdi = rs.getString("kullaniciAdi");
                sifre = rs.getString("sifre");
                yetki = rs.getString("yetki");

                if(kullaniciAdi.equalsIgnoreCase(ad) && sifre.equalsIgnoreCase(parola)) {
                    System.out.println("Kullanıcı doğrulama işlemi başarılı...");
                    System.out.println("Sistem açılıyor.......");
                    TimeUnit.SECONDS.sleep(1);
                    MerkeziIslemBirimi.getInstance().islemSecimi(yetki,kullaniciAdi,sifre);

                    return true;
                }
            }
            /***** Kaynakları serbest bırak *****/
            rs.close();

            stmt.close();


        } catch (Exception e) {

            e.printStackTrace();
        }
        System.out.println("Kullanıcı doğrulama işlemi başarısız oldu..");
        return false;
    }
}