package com.aruix.impl.lab.lab3;

/**
 * Lab Exercise 3.1
 * 
 * Check Substring Given an input string, a non-empty substring subs, and a
 * non-negative number n, compute recursively and return true if and only if at
 * least n copies of subs occur in the string, possibly with overlapping.
 * 
 * Do not use loops (do not write for or while anywhere in your code). Do not
 * use any regular expressions and methods such as matches, split, replaceAll.
 * 
 * 
 * Test case 1: checkSubstring("abcxxxxabc", "abc", 2) → true
 * 
 * Test case 2: checkSubstring("abcxxxxabc", "abc", 3) → false
 * 
 * Test case 3: checkSubstring("ababaxxxaba", "aba", 3) → true
 * 
 * 可以是公用字母
 * 
 */

public class CheckSubstring {
    /**
     * Check if at least n copies of a substring occur in input string. They may
     * overlap. For example, checkSubstring("ababaxxxaba", "aba", 3) → true
     * 
     * @param input is the input string.
     * @param subs  is the non-empty substring.
     * @param n     is non-negative number of occurrences.
     * @return true iff at least n copies of subs occur in input.
     */
    public static boolean checkSubstring(String input, String subs, int n) {
        // base case
        if (input.length() < subs.length()) {
            return false;
        } else {
            // recurise case
            if (n <= 0) {
                return true;
            }
            if (input.substring(0, 3).equals(subs)) {
                return checkSubstring(input.substring(3), subs, --n);
            } else {
                return checkSubstring(input.substring(3), subs, n);
            }
        }
    }
}
