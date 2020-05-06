package cihaz;

import java.util.Random;

public class SicaklikFahrenheit implements ISicaklikTuru {
    private static SicaklikFahrenheit instance;
    public static synchronized SicaklikFahrenheit getInstance(){
        if(instance==null)
            instance = new SicaklikFahrenheit();
        return instance;
    }


    @Override
    public float sicaklikAlgila() {
        Random r = new Random();
        float randomSicaklik = -4 + (104 - (-4)) * r.nextFloat();
        return randomSicaklik;
    }
}
