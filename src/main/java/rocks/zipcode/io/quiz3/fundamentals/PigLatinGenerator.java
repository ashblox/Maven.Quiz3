package rocks.zipcode.io.quiz3.fundamentals;

/**
 * @author leon on 09/12/2018.
 */
public class PigLatinGenerator {

    public String translate(String str) {
        String[] words = str.split(" ");
        String translated = "";
        for (String word: words) {
            translated += translateOneWord(word) + " ";
        }
        return translated.trim();
    }



    public String translateOneWord(String str) {
        if (!containsAllAlphaChars(str)) {
            return null;
        } else if (startsWithVowel(str)) {
            return translateWithVowelStart(str);
        } else if (containsNoVowels(str)) {
            return translateWithNoVowels(str);
        } else {
            return translateWithConsonantStart(str);
            }
    }

    public Boolean startsWithVowel(String str) {
        str = str.toLowerCase();
        Boolean startsWithVowel = false;
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};
        for (int i = 0; i < vowels.length; i++) {
            if (str.charAt(0) == vowels[i]) {
                startsWithVowel = true;
            }
        }
        return startsWithVowel;
    }

    public String translateWithVowelStart(String str) {
        return str.concat("way");
    }

    public String translateWithConsonantStart(String str) {
        int indexOfVowel = findFirstVowel(str);
        String startingConsonants = str.substring(0, indexOfVowel);
        String mainSubstring = str.substring(indexOfVowel);
        String pigLatin = mainSubstring + startingConsonants + "ay";
        return pigLatin;
    }

    public Integer findFirstVowel(String str) {
        str = str.toLowerCase();
        Integer index = null;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                index = i;
                break;
            }
        }
        return index;
    }

    public boolean containsAllAlphaChars(String str) {
        boolean containsAllAlphaChars = true;
        str = str.replaceAll(" ", "");
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!(c >= 65 && c <= 90) && !(c >= 97 && c <= 122)) {
                containsAllAlphaChars = false;
            }
        }
        return containsAllAlphaChars;
    }

    public boolean containsNoVowels(String str) {
        boolean containsNoVowels = true;
        str = str.toLowerCase();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                containsNoVowels = false;
            }
        }
        return containsNoVowels;
    }

    public String translateWithNoVowels(String str) {
        return str + "ay";
    }
}


