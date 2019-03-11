package rocks.zipcode.io.quiz3.fundamentals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author leon on 09/12/2018.
 */
public class StringUtils {
    public static String capitalizeNthCharacter(String str, Integer indexToCapitalize) {
//        String capitalized = str.substring(indexToCapitalize, indexToCapitalize + 1).toUpperCase();
//        StringBuilder sb = new StringBuilder(str);
//        sb.replace(indexToCapitalize, indexToCapitalize + 1, capitalized);
//        return sb.toString();
        String answer = "";
        for (int i = 0; i < str.length(); i++) {
            if (i != indexToCapitalize) {
                answer += str.charAt(i) + "";
            } else {
                answer += (str.charAt(i) + "").toUpperCase();
            }
        }
        return answer;
    }

    public static Boolean isCharacterAtIndex(String baseString, Character characterToCheckFor, Integer indexOfString) {
        return baseString.charAt(indexOfString) == characterToCheckFor;
    }

    public static String[] getAllSubStrings(String string) {
        ArrayList<String> allSubstrings = findAllSubstrings(string);
        Set<String> dupsRemoved = new HashSet<>();
        for (String str: allSubstrings) {
            dupsRemoved.add(str);
        }
        String[] substringArr = new String[dupsRemoved.size()];
        return dupsRemoved.toArray(substringArr);
    }

    public static ArrayList<String> findAllSubstringsStartingAtN (String input, int n){
        ArrayList<String> allSubstringsStartingatN = new ArrayList<>();
        for (int i = n + 1; i <= input.length(); i++) {
            allSubstringsStartingatN.add(input.substring(n, i));
        }
        return allSubstringsStartingatN;
    }

    public static ArrayList<String> findAllSubstrings (String input) {
        ArrayList<String> allSubstrings = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            allSubstrings.addAll(findAllSubstringsStartingAtN(input, i));
        }
        return allSubstrings;
    }

    public static Integer getNumberOfSubStrings(String input){
        return getAllSubStrings(input).length;
    }
}
