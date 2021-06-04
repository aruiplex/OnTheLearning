package lab1.ConcatContain;

public class ConcatContain {

    /**
     * Compute the smallest number of times source is concatenated with itself
     * so that the resulting string contains target.
     * For example, For example, source "ab" concatenated 2 times "ab"+"ab"+"ab" into "ababab"
     * contains target "baba".
     * @param source a non-empty string to be concatenated.
     * @param target a non-empty string that can be contained in repeatedly concatenated source.
     * @return the smallest number of times of the concatenation.
     */
    public static int concatContain(String source, String target) {
        String concatenated = source;
        int concatCount = 0;
        while (concatenated.length() < target.length()) {
            concatenated += source;
            concatCount++;
        }
        for (int i = 0; i < 3; i++) {
            if (concatenated.contains(target)) return concatCount;
            concatenated += source;
            concatCount++;
        }

        return -1;
    }

    
}