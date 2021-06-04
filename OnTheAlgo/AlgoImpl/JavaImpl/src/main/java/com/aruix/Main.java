package com.aruix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.aruix.impl.lab.Animal;
import com.aruix.impl.lab.Dog;

public class Main {
    public static boolean cmp(String str1, String str2) {
        Map<Character, Integer> m1 = new HashMap<>();
        Map<Character, Integer> m2 = new HashMap<>();
        for (int i = 0; i < str1.length(); i++) {
            if (!m1.containsKey(str1.charAt(i))) {
                m1.put(str1.charAt(i), 1);
            } else {
                m1.put(str1.charAt(i), m1.get(str1.charAt(i) + 1));
            }
        }
        for (int i = 0; i < str1.length(); i++) {
            if (!m2.containsKey(str1.charAt(i))) {
                m2.put(str1.charAt(i), 1);
            } else {
                m2.put(str1.charAt(i), m2.get(str1.charAt(i) + 1));
            }
        }
        return m1.equals(m2);
    }

    public static boolean cmpStr(String str1, String str2) {
        if (str1.isEmpty() || str2.isEmpty()) {
            return false;
        }
        // base case 奇数
        if (str1.length() % 2 != 0) {
            return str1.equals(str2);
        }

        return str1.equals(str2)
                || cmpStr(str1.substring(str1.length() / 2), str2.substring(0, str2.length() / 2))
                        && cmpStr(str2.substring(0, str2.length() / 2), str1.substring(str1.length() / 2))
                || cmpStr(str1.substring(0, str1.length() / 2), str2.substring(0, str2.length() / 2))
                        && cmpStr(str2.substring(str2.length() / 2), str1.substring(str1.length() / 2));
    }

    public static String trans(boolean b) {
        if (b) {
            return "YES";
        }
        return "NO";
    }

    public static void input() {
        Scanner sc = new Scanner(System.in);
        List<String> l = new LinkedList<>();
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < 2 * n; i++) {
            String str = sc.nextLine();
            l.add(str);
        }

        for (int i = 0; i < l.size(); i = i + 2) {
            String str1 = l.get(i);
            String str2 = l.get(i + 1);
            if (cmp(str1, str2)) {
                System.out.println("NO");
            } else {
                System.out.println(trans(cmpStr(str1, str2)));
            }
        }
    }

    public static void main(String[] args) {
        // System.out.println(cmpStr("abac", "baba"));
        // input();
        // char a = 'a';
        // double ad = (double) a;
        // System.out.println(ad);
        Animal a = new Dog();
        Dog d = new Dog();
        a.cool(d);
        ;

    }
}
