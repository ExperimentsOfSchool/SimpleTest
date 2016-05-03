package Utils;

/**
 * Created by Lawrence on 5/1/16.
 */
public class Utilities {
    public static int getCorrectAnswerNum(String correctAnswer) {
        switch (correctAnswer) {
            case "A":
                return 1;
            case "B":
                return 2;
            case "C":
                return 3;
            case "D":
                return 4;
            default:
                return 0;
        }
    }
}
