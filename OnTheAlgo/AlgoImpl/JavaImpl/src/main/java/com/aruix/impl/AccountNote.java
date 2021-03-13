package com.aruix.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class AccountNote {
    public static void main(String[] args) {
        String words = "is 1000 and 2000 but 1000 -500";
        StringBuffer sb = new StringBuffer();
        words = sb.append(" ").append(words).append(" ").toString();
        // 当前的数字
        List<Integer> intWordList = new ArrayList<>();
        // 所有数字的 list
        List<Integer> intList = new ArrayList<>();
        // 遍历整个句子, 从第二个到倒数第二个
        for (int i = 1; i < words.length() - 1; i++) {
            char currChar = words.charAt(i);
            char lastChar = words.charAt(i - 1);
            if (Character.isDigit(currChar)) {
                intWordList.add(Character.getNumericValue(currChar));
            } else {
                // 这一位不是数字, 但是上一位是数字
                if (Character.isDigit(lastChar)) {
                    int bit = 1;
                    int result = 0;
                    for (int j = intWordList.size() - 1; j > 0; j--) {
                        result += intWordList.get(j) * bit;
                        bit *= 10;
                    }
                    intList.add(result);
                }
            }
        }
        Integer ans = 0;
        for (Integer integer : intList) {
            ans += integer;
        }
        System.out.println(ans);
    }
}