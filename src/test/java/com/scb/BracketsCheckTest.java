package com.scb;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BracketsCheckTest {

    @Test
    public void testIsBalances(){


        boolean isBalanced = BracketsCheck.isBalances("{}");
        Assertions.assertTrue(isBalanced);

        boolean isBalanced2 = BracketsCheck.isBalances("{}[]()");
        Assertions.assertTrue(isBalanced2);

        boolean isBalanced3 = BracketsCheck.isBalances("{}[]())");
        Assertions.assertFalse(isBalanced3);


        boolean isBalanced4 = BracketsCheck.isBalances("");
        Assertions.assertFalse(isBalanced4);

        boolean isBalanced5 = BracketsCheck.isBalances("{{[]()}}");
        Assertions.assertTrue(isBalanced5);

        boolean isBalanced6 = BracketsCheck.isBalances("{{[](223)}}");
        Assertions.assertTrue(isBalanced6);

        boolean isBalanced7 = BracketsCheck.isBalances("{{[](22}}");
        Assertions.assertFalse(isBalanced7);
    }
}
