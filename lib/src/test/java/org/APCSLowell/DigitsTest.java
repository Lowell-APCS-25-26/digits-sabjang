package org.APCSLowell;

import org.junit.Test;
import static org.junit.Assert.*;

public class DigitsTest {
    int[] tests = { 
        57362, 18587, 21600, 15858,
        20786, 19398, 1106,  57254,
        37318, 3469,  1860,  36752,
        9050,  24895, 30845, 13776,
     };

    @Test
    public void constructor() {
        Digits digits;
        for (int test : tests) {
            digits = new Digits(test);

            for (int i = digits.digits.size()-1; i >= 0 ; i--) {
                assertEquals(digits.digits.get(i).intValue(), test % 10);
                test /= 10;
            }
        }
    }
    @Test
    public void isStrictlyIncreasing() {
        Digits digits;
        for (int test : tests) {
            digits = new Digits(test);
            boolean expected = true;
            for (int i = 1; i < digits.digits.size(); i++)
                if (digits.digits.get(i) <= digits.digits.get(i-1))
                    expected = false;
            assertEquals(expected, digits.isStrictlyIncreasing());
        }
    }
}
