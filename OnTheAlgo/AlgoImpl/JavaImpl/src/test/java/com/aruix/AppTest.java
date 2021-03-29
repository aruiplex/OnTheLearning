package com.aruix;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.aruix.impl.lab.week3.CheckSubstring;

import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void test1() {

        System.out.println("hello test world");
        assertTrue(false);
    }

    @Test
    public void testCheckSubString() {
        assertEquals(true, CheckSubstring.checkSubstring("ababaxxxaba", "aba", 3));
    }

}
