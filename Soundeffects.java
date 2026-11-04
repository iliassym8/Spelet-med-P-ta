import java.util.Random;
import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;

public class Soundeffects {
    private static final Random random = new Random();

    public static void playSound(String sound) {
        switch (sound.toLowerCase()) {
            case "punch" -> playWav("Punch clipped.wav");
            case "kick" -> playWav("Kick.1 clipped.wav");
            case "spit" -> playWav("Spit.1 clipped.wav");
            case "heal" -> playWav("Heal clipped.wav");
            case "victory" -> { playWav("Victory.1 clipped.wav");
                
            }
            default -> System.out.println("Unknown sound: " + sound);
        }
    }

    private static void beep(int count, int delayMs) {
        for (int i = 0; i < count; i++) {
            if (Thread.currentThread().isInterrupted()) {
                return;
            }

            System.out.print("\u0007");
            System.out.flush();

            if (i < count - 1) {
                pause(delayMs);
            }
        }
    }

    private static void pause(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void playWav(String filename) {

    try { URL soundURL = Soundeffects.class.getResource("/SoundEffects/" + filename);

        if (soundURL == null) {
            System.out.println("Sound not found: " + filename);
            return;
        }

        AudioInputStream audioStream =
                AudioSystem.getAudioInputStream(soundURL);

        Clip clip = AudioSystem.getClip();
        clip.open(audioStream);
        audioStream.close();

        clip.addLineListener(event -> {
            if (event.getType() == LineEvent.Type.STOP) {
                clip.close();
            }
        });

        clip.start();

    } catch (Exception e) {
        System.out.println("Could not play sound: " + e.getMessage());
    }
}
}