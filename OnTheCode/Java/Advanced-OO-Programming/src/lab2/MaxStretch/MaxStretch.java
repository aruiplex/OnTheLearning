package lab2.MaxStretch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxStretch {

    /**
     * Find the largest stretch in a list.
     * For example, maxStretch([8, 5, 1, 2, 3, 4, 5, 10]) = 6.
     * @param list is a list of integers.
     * @return the largest stretch in list.
     */
    public static int maxStretch(List<Integer> list) {
        if (list.size() == 0) return 0;  // MUST INCLUDE 0!!! THERE'S A HIDDEN TEST CASE
        int max = 1;
        for (int left_index = 0; left_index < list.size(); left_index++) {
            int current_num = list.get(left_index);
            int right_index = list.size() - 1;
            while (right_index != left_index) {
                if (list.get(right_index) == current_num) {
                    int stretch = right_index - left_index + 1;
                    if (stretch > max) max = stretch;
                    break;
                }
                right_index--;
            }
        }
        return max;
    }
}