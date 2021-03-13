package com.aruix.impl;

public class ConcatContain {
    public static int concatContain(String source, String target) {
        String base = source;
        int times = 0;
        if (source.contains(target)) {
            return 0;
        }

        while (source.length() <= target.length() + 2 * base.length()) {
            source = source.concat(base);
            times++;
            if (source.contains(target)) {
                return times;
            }
        }
        return -1;
    }
}
// public static void main(String[] args) {
// System.out.println(concatContain("ab", "baba"));
// System.out.println(concatContain("abc", "cabca"));
// }
