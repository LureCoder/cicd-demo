package com.scb;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SearchItTest {

    @Test
    public void testSampleSearchNumber(){
        int[] numbers = {1,1,2,3,3,4,4};
        Integer result = SearchIt.searchNumber(numbers);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(2, result.intValue());
    }

    @Test
    public void testSingleNumber(){
        int[] numbers = {1};
        Integer result = SearchIt.searchNumber(numbers);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(1, result.intValue());
    }

    @Test
    public void testNoNumber(){
        int[] numbers = {};
        Integer result = SearchIt.searchNumber(numbers);

        Assertions.assertNull(result);
    }

    @Test
    public void testNegativeNumber(){
        int[] numbers = {-1,-2,-1,5,5,6,6};
        Integer result = SearchIt.searchNumber(numbers);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(-2, result.intValue());
    }
}
