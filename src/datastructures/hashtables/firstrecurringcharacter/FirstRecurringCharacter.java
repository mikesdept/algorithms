package datastructures.hashtables.firstrecurringcharacter;

import java.util.HashMap;
import java.util.Map;

public class FirstRecurringCharacter {

    public String getFirstRecurringCharacter(Integer[] array) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (map.get(array[i]) == null) {
                map.put(array[i], i);
            } else {
                return array[i].toString();
            }
        }
        return "Undefined";
    }


    public static void main(String[] args) {
        // Given an array = [2, 5, 1, 2, 3, 5, 1, 2, 4]
        // It should return 2
        // Given an array = [2, 1, 1, 2, 3, 5, 1, 2, 4]
        // It should return 1
        // Given an array = [1, 2, 3, 4, 5]
        // It should return undefined
        Integer[] array1 = new Integer[]{2, 5, 1, 2, 3, 5, 1, 2, 4};
        Integer[] array2 = new Integer[]{2, 1, 1, 2, 3, 5, 1, 2, 4};
        Integer[] array3 = new Integer[]{1, 2, 3, 4, 5};
        FirstRecurringCharacter firstRecurringCharacter = new FirstRecurringCharacter();
        System.out.println("array 1 result -> " + firstRecurringCharacter.getFirstRecurringCharacter(array1));
        System.out.println("array 2 result -> " + firstRecurringCharacter.getFirstRecurringCharacter(array2));
        System.out.println("array 3 result -> " + firstRecurringCharacter.getFirstRecurringCharacter(array3));
    }

}
