package rocks.zipcode.io.quiz3.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author leon on 09/12/2018.
 */
public class WaveGenerator {
    public static String[] wave(String str) {
        List<String> wave = new ArrayList<>();
        str = str.toLowerCase();
        for (int i = 0; i < str.length(); i++) {
            StringBuilder sb = new StringBuilder(str);
            String substr = str.substring(i, i+1);
            if (isCharacter(substr)) {
                sb.replace(i, i+1, substr.toUpperCase());
                wave.add(sb.toString());
            }
        }
        String[] waveArr = new String[wave.size()];
        return wave.toArray(waveArr);
    }

    public static int countCharacters(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if ((c >= 65 && c <= 90) || c >= 97 && c <= 122) {
                count++;
            }
        }
        return count;
    }

    public static Boolean isCharacter(String str) {
        boolean isChar = false;
        char c = str.charAt(0);
        if ((c >= 65 && c <= 90) || c >= 97 && c <= 122) {
            isChar = true;
        }
        return isChar;
    }
}
