package edu.fiuba.algo3.Interfaz.Controller;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class SonidosHandler {

    public static void play(String rutaArchivoSonido) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        File sonido = new File(rutaArchivoSonido);
        AudioInputStream audio = AudioSystem.getAudioInputStream(sonido);
        Clip clip = AudioSystem.getClip();
        clip.open(audio);
        clip.start();
        }

    private void volume(Clip clip,int db){
        FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
        gainControl.setValue(db); // (-10.0f) = -10 DB
    }

    public static void sonidoBoton() throws UnsupportedAudioFileException, LineUnavailableException, IOException, InterruptedException {
        play("src/main/java/edu/fiuba/algo3/modelo/Resources/sounds/buttonS.wav");
    }
}
