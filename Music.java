import java.io.File;
import javax.sound.sampled.*;

public class Music {
    private static Clip music;

    public static void playMusic() {
        stopMusic(); // Prevent multiple copies playing together.

        try (AudioInputStream audio = AudioSystem.getAudioInputStream(
                new File("BackgroundMusic/Backgrounds.wav"))) {

            music = AudioSystem.getClip();
            music.open(audio);
            music.loop(Clip.LOOP_CONTINUOUSLY);

        } catch (Exception e) {
            System.out.println("Could not play music: " + e.getMessage());
        }
    }

    public static void stopMusic() {
        if (music != null) {
            music.stop();
            music.close();
            music = null;
        }
    }
}