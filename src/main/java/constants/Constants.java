package constants;

import java.util.Random;

public class Constants {

    public static final String BASE_URL = "https://demoqa.com/books";
    public static final String RANDOM_USERNAME = "alex" + generateNumber();

    public static String generateNumber() {
        return String.valueOf(new Random().nextInt(1000000));
    }
}
