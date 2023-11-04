package constants;

public class WDWait {

    public static void waitForSeconds(int seconds) {
        seconds *= 1000;
        try {
            Thread.sleep(seconds);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
