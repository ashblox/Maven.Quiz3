package rocks.zipcode.io.quiz3.arrays;

import java.util.Arrays;
import java.util.List;

/**
 * @author leon on 09/12/2018.
 */
public class SquareArrayAnalyzer {
    public static Boolean compare(Integer[] input, Integer[] squaredValues) {
        List<Integer> inputList = Arrays.asList(input);
        List<Integer> squaredValuesList = Arrays.asList(squaredValues);
        boolean contains = true;
        for (Integer value: inputList) {
            if (!squaredValuesList.contains(value * value)) {
                contains = false;
            }
        }
        return contains;
    }
}
