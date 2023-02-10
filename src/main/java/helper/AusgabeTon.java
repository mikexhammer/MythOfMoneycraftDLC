package helper;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class AusgabeTon {

    public static void playSound(String soundFile) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        File f = new File("sound/" + soundFile);
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

    public static void melodieNEU() {
        try {
            // Load the audio file
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("sound/melodie.wav"));

            // Get the audio clip
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);

            // Get the volume control for the audio clip
            FloatControl volumeControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);

            // Reduce the volume by 6 dB (half of the original volume)
            float volume = volumeControl.getValue();
            volumeControl.setValue(volume - 30.0f);

            // Play the audio clip
            clip.start();

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
