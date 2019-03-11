package rocks.zipcode.io.quiz3.generics;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author leon on 09/12/2018.
 */
public class ArrayUtility<SomeType> {
    private final SomeType[] array;
    private final List<SomeType> arrayList;
    private final List<SomeType> arrayListUnique;
    private final Set<SomeType> hashSet;

    public ArrayUtility(SomeType[] array) {
        this.array = array;
        this.arrayList = Arrays.asList(array);
        hashSet = new LinkedHashSet<>();
        for (int i = 0; i < array.length; i++) {
            hashSet.add(array[i]);
        }
        arrayListUnique = new ArrayList<>(hashSet);
    }

    public SomeType findOddOccurringValue() {
        SomeType st = null;
        for (int i = 0; i < arrayListUnique.size(); i++) {
            if (Collections.frequency(arrayList, arrayListUnique.get(i)) % 2 != 0) {
                st = arrayListUnique.get(i);
            }
        }
        return st;
    }

    public SomeType findEvenOccurringValue() {
        SomeType st = null;
        for (int i = 0; i < arrayListUnique.size(); i++) {
            if (Collections.frequency(arrayList, arrayListUnique.get(i)) % 2 == 0) {
                st = arrayListUnique.get(i);
            }
        }
        return st;
    }

    public Integer getNumberOfOccurrences(SomeType valueToEvaluate) {
        return Collections.frequency(arrayList, valueToEvaluate);
    }

    public SomeType[] filter(Function<SomeType, Boolean> predicate) {
        List<SomeType> someTypeList = Arrays.stream(array)
                .filter(SomeType -> predicate.apply(SomeType))
                .collect(Collectors.toList());
        return someTypeList.toArray((SomeType[]) Array.newInstance(array[0].getClass(), someTypeList.size()));
    }
}
