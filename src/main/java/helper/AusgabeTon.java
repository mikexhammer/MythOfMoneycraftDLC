package helper;

import javax.sound.sampled.*;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * Nicht dokumentierte Hilfsklasse für die Tonausgabe im Spiel
 */
public class AusgabeTon {

    public static void playSound(String soundFile) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        InputStream audioSrc = AusgabeTon.class.getResourceAsStream("/sound/" + soundFile);
        InputStream bufferedIn = new BufferedInputStream(audioSrc);
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(bufferedIn);
        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);
        clip.start();
    }

    public static void backgroundSound(float reduce, String soundFile) {
        try {
            InputStream audioSrc = AusgabeTon.class.getResourceAsStream("/sound/" + soundFile);
            InputStream bufferedIn = new BufferedInputStream(audioSrc);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(bufferedIn);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);

            FloatControl volumeControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            float volume = volumeControl.getValue();
            volumeControl.setValue(volume - reduce);

            clip.start();
            clip.loop(10);

        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }


    public static void verloren() {
        try {
            playSound("loose.wav");
        } catch (UnsupportedAudioFileException e) {
            throw new RuntimeException(e);
        } catch (LineUnavailableException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void waehlen() {
        try {
            playSound("blip.wav");
        } catch (UnsupportedAudioFileException e) {
            throw new RuntimeException(e);
        } catch (LineUnavailableException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void gefallen() {
        try {
            playSound("dead.wav");
        } catch (UnsupportedAudioFileException e) {
            throw new RuntimeException(e);
        } catch (LineUnavailableException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void besiegt() {
        try {
            playSound("died.wav");
        } catch (UnsupportedAudioFileException e) {
            throw new RuntimeException(e);
        } catch (LineUnavailableException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



}
