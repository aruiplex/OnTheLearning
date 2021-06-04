package lab2.CountRuns;

import java.util.List;

public class CountRuns {

    /**
     * Count the number of runs in a list.
     * For example, countRuns([1, 2, 2, 2, 3]) = 1.
     * @param list is a list of integers.
     * @return the number of runs in list.
     */
    public static int countRuns(List<Integer> list) {
        if (list.size() < 2) return 0;
        int runs = 0;
        int leftIndex = 0;
        int rightIndex = 1;

        while (rightIndex < list.size()) {
            if (list.get(leftIndex).equals(list.get(rightIndex))) {
                runs += 1;
                while (rightIndex < list.size() && list.get(leftIndex).equals(list.get(rightIndex))) {
                    rightIndex++;
                }
            }
            leftIndex = rightIndex;
            rightIndex++;
        }

        return runs;
    }
}