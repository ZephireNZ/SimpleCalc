package me.zephirenz.simplecalc.util;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Used to check that math in the calculator works like it should
 */
public class MathUtilTest {

    @Test
    public void testCalculate() {

        assertEquals(Double.valueOf(2), MathUtil.calculate("1+1"));
        assertEquals(Double.valueOf(10), MathUtil.calculate("2+4*2"));
        assertEquals(Double.valueOf(21), MathUtil.calculate("(5+2)*3"));
        assertNull(MathUtil.calculate("5**5"));
        assertNull(MathUtil.calculate("5.0.1"));
        assertNull(MathUtil.calculate(""));

    }

    @Test
    public void testIsTooBig() {
        assertFalse(MathUtil.isTooBig(500D));
        assertFalse(MathUtil.isTooBig(500.4125D));
        assertFalse(MathUtil.isTooBig(1234567891234D));
        assertFalse(MathUtil.isTooBig(1234567891234.5476D));
        assertTrue(MathUtil.isTooBig(12345678912345D));

    }

    @Test
    public void testFormatDecimalForDisplay() {

        assertEquals("500", MathUtil.formatDecimalForDisplay(500D));
        assertEquals("500.234", MathUtil.formatDecimalForDisplay(500.234D));
        assertEquals("1234567891234", MathUtil.formatDecimalForDisplay(1234567891234D));
        assertEquals("123456789123", MathUtil.formatDecimalForDisplay(123456789123.4D));

    }

}
