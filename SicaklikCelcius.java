package cihaz;

import java.util.Random;

public class SicaklikCelcius implements ISicaklikTuru {
    private static SicaklikCelcius instance;
    public static synchronized SicaklikCelcius getInstance(){
        if(instance==null)
            instance = new SicaklikCelcius();
        return instance;
    }

    @Override
    public float sicaklikAlgila() {
        Random r = new Random();
        float randomSicaklik = -20 + (45 - (-20)) * r.nextFloat();
        return randomSicaklik;
    }
}
