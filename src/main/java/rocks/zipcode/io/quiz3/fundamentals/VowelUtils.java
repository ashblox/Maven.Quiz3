package rocks.zipcode.io.quiz3.fundamentals;

/**
 * @author leon on 09/12/2018.
 */
public class VowelUtils {

    private static PigLatinGenerator pigLatinGenerator = new PigLatinGenerator();

    public static Boolean hasVowels(String word) {
        return !pigLatinGenerator.containsNoVowels(word);
    }

    public static Integer getIndexOfFirstVowel(String word) {
        return pigLatinGenerator.findFirstVowel(word);
    }


    public static Boolean startsWithVowel(String word) {
        return pigLatinGenerator.startsWithVowel(word);
    }

    public static Boolean isVowel(Character character) {
        Boolean isVowel = false;
        character = (character + "").toLowerCase().charAt(0);
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};
        for (int i = 0; i < vowels.length; i++) {
            if (character == vowels[i]) {
                isVowel = true;
            }
        }
        return isVowel;
    }
}
