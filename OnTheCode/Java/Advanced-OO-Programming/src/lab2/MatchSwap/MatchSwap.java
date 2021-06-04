package lab2.MatchSwap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MatchSwap {

    /**
     * Modify a list of strings such that two strings with same
     * first letter are swapped.
     * For example, matchSwap(["ap", "bp", "cp", "aq", "cq", "bq"]) →
     * ["aq", "bq", "cq", "ap", "cp", "bp"].
     * @param list is a list of strings.
     * The strings are non-empty.
     * @return the modified list.
     */
    public static List<String> matchSwap(List<String> list) {
        Map<String, Integer> swapSafari = new HashMap<>();

        for (int i = 0; i < list.size(); i++) {
            String current = list.get(i);
            String key = String.valueOf(current.charAt(0));
            if (!swapSafari.containsKey(key)) swapSafari.put(key, i);
            else {
                int previousIndex = swapSafari.get(key);
                swapSafari.remove(key);
                String previous = list.get(previousIndex);
                list.set(i, previous);
                list.set(previousIndex, current);
            }
        }

		return list;
    }

}