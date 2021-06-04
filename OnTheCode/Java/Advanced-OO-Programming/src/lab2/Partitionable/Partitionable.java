package lab2.Partitionable;

import java.util.Arrays;
import java.util.List;

public class Partitionable {

    /**
     * Decide whether a list is partitionable.
     * For example, isPartitionable([1, 1, 1, 2, 1]) -> true,
     * and isPartitionable([2, 1, 1, 2, 1]) -> false.
     * @param list is a non-empty list of integers.
     * @return true iff list is partitionable.
     */
    public static boolean isPartitionable(List<Integer> list) {
        int left = 0;
        int right = 0;
        for (Integer value : list) right += value;
        for (Integer integer : list) {
            if (left == right) return true;
            left += integer;
            right -= integer;
        }
        return false;
    }

    public static void main(String[] args) {
        isPartitionable(Arrays.asList(0));
    }
}