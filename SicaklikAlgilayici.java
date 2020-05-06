package cihaz;

import java.text.DecimalFormat;
import java.util.Random;

public class SicaklikAlgilayici implements IAkilliCihaz{
    private static SicaklikAlgilayici instance;
    public static synchronized SicaklikAlgilayici getInstance(){
        if(instance==null)
            instance = new SicaklikAlgilayici();
        return instance;
    }

    private float sicaklik;

    public float sicaklikOku(){

       return SicaklikCelcius.getInstance().sicaklikAlgila();
       //return SicaklikFahrenheit.getInstance().sicaklikAlgila();
    }
    public String sicaklikGonder(){
        sicaklik=sicaklikOku();
        return new DecimalFormat("##.#").format(sicaklik);

    }

}
