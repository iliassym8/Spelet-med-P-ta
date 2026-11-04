import java.io.File;
import javax.sound.sampled.*;

public class Music {
    private static Clip music;

    private static final float GAIN_DB = -10.0f;

    public static void playMusic() {
        stopMusic();

        try (AudioInputStream audio = AudioSystem.getAudioInputStream(
                new File("BackgroundMusic/Backgrounds.wav"))) {

            music = AudioSystem.getClip();
            music.open(audio);

            setVolume(GAIN_DB);

            music.loop(Clip.LOOP_CONTINUOUSLY);

        } catch (Exception e) {
            stopMusic();
            System.out.println("Could not play music: " + e.getMessage());
        }
    }

    public static void setVolume(float decibels) {
        if (music != null && music.isOpen()
                && music.isControlSupported(FloatControl.Type.MASTER_GAIN)) {

            FloatControl volume = (FloatControl)
                    music.getControl(FloatControl.Type.MASTER_GAIN);

            float gain = Math.max(volume.getMinimum(),
                    Math.min(volume.getMaximum(), decibels));

            volume.setValue(gain);
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