package lab2.EvenAppend;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class EvenAppend {

    /**
     * Append words that appear the 2nd, 4th, 6th, etc. time in a list.
     * For example, evenAppend(["a", "b", "b", "a", "a", "b", "b"]) → "bab".
     * @param list is a list of words.
     * @return a concatenation of even appearing words.
     */
    public static String evenAppend(List<String> list) {
        String result = "";
        Map<String, Integer> count = new HashMap<>();

        for (int i = 0; i < list.size(); i++) {
            String item = list.get(i);
            if (!count.containsKey(item)) {
                count.put(item, 1);
            } else {
                int n = count.get(item);
                n++;
                count.put(item, n);
                if (n % 2 == 0) {
                    result += item;
                }
            }
        }
		
		return result;
    }

}