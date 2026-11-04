import java.util.Random;

public class Soundeffects {
    private static final Random random = new Random();

    public static void playSound(String sound) {
        switch (sound.toLowerCase()) {
            case "punch" -> beep(1 + random.nextInt(2), 100);
            case "kick" -> beep(2, 200);
            case "spit" -> beep(3, 80);
            case "heal" -> beep(2, 350);
            case "victory" -> {
                beep(3, 150);
                pause(350);
                beep(4, 100);
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
}