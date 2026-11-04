import java.net.URL;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineEvent;

public class Soundeffects {

    private static final float GAIN_DB = 10.0f;

    public static void playSound(String sound) {
        switch (sound.toLowerCase()) {
            case "punch" -> playWav("Punch clipped.wav");
            case "kick" -> playWav("Kick.1 clipped.wav");
            case "spit" -> playWav("Spit.1 clipped.wav");
            case "heal" -> playWav("Heal clipped.wav");
            case "victory" -> playWav("Victory.1 clipped.wav");
            default -> System.out.println("Unknown sound: " + sound);
        }
    }

    public static void playWav(String filename) {
        URL soundURL =
                Soundeffects.class.getResource("/SoundEffects/" + filename);

        if (soundURL == null) {
            System.out.println("Sound not found: " + filename);
            return;
        }

        Clip clip = null;

        try (AudioInputStream original =
                     AudioSystem.getAudioInputStream(soundURL)) {

            AudioFormat source = original.getFormat();

            // Convert to 16-bit PCM while keeping sample rate and channels.
            AudioFormat target = new AudioFormat(
                    AudioFormat.Encoding.PCM_SIGNED,
                    source.getSampleRate(),
                    16,
                    source.getChannels(),
                    source.getChannels() * 2,
                    source.getSampleRate(),
                    false
            );

            try (AudioInputStream converted =
                         AudioSystem.getAudioInputStream(target, original)) {

                clip = AudioSystem.getClip();
                clip.open(converted);

                // Increase volume within the supported range.
                if (clip.isControlSupported(FloatControl.Type.MASTER_GAIN)) {
                    FloatControl volume = (FloatControl)
                            clip.getControl(FloatControl.Type.MASTER_GAIN);

                    float gain = Math.max(volume.getMinimum(),
                            Math.min(volume.getMaximum(), GAIN_DB));

                    volume.setValue(gain);
                }

                // Release the clip when playback finishes.
                Clip playingClip = clip;
                clip.addLineListener(event -> {
                    if (event.getType() == LineEvent.Type.STOP) {
                        playingClip.close();
                    }
                });

                clip.start();
            }

        } catch (Exception e) {
            if (clip != null) {
                clip.close();
            }

            System.out.println("Could not play sound: " + e.getMessage());
        }
    }
}