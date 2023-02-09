package helper;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class AusgabeTon {

    public static void playSound(String soundFile) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        File f = new File("./src/main/resources/sound/" + soundFile);
        AudioInputStream audioIn = AudioSystem.getAudioInputStream(f.toURI().toURL());
        Clip clip = AudioSystem.getClip();
        clip.open(audioIn);
        clip.start();
    }

    public static void melodie() {
        try {
        playSound("melodie.wav");
        } catch (UnsupportedAudioFileException e) {
            throw new RuntimeException(e);
        } catch (LineUnavailableException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
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
