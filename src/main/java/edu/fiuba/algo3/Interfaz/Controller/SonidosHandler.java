package edu.fiuba.algo3.Interfaz.Controller;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class SonidosHandler {

    public static void play(String rutaArchivoSonido, int volume) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        File sonido = new File(rutaArchivoSonido);
        AudioInputStream audio = AudioSystem.getAudioInputStream(sonido);
        Clip clip = AudioSystem.getClip();
        clip.open(audio);
        if (volume!=0) {
            FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(-volume); // (-10.0f) = -10 DB}
        }
        clip.start();
        }

    public static void sonidoDerrota() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        play("src/main/java/edu/fiuba/algo3/modelo/Resources/sounds/defeat.wav",30);
    }

    public static void sonidoBoton() throws UnsupportedAudioFileException, LineUnavailableException, IOException, InterruptedException {
        play("src/main/java/edu/fiuba/algo3/modelo/Resources/sounds/buttonS.wav",0);
    }

    public static void sonidoVictoria() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        play("src/main/java/edu/fiuba/algo3/modelo/Resources/sounds/victory.wav",30);
    }
}
