package fr.istic.vv;

import org.junit.jupiter.api.Test;

import static fr.istic.vv.StringUtils.isBalanced;
import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {
	
	@Test
    public void testEmptyString() {
        assertTrue(StringUtils.isBalanced(""));
    }

    @Test
    public void testSingle() {
        assertFalse(StringUtils.isBalanced("{"));
        assertFalse(StringUtils.isBalanced("["));
        assertFalse(StringUtils.isBalanced("("));
        assertFalse(StringUtils.isBalanced("}"));
        assertFalse(StringUtils.isBalanced("]"));
        assertFalse(StringUtils.isBalanced(")"));
    }

    @Test
    public void testValideStringUtils() {
        assertTrue(StringUtils.isBalanced("{}"));
        assertTrue(StringUtils.isBalanced("[]"));
        assertTrue(StringUtils.isBalanced("()"));
        assertTrue(StringUtils.isBalanced("{[]}"));
        assertTrue(StringUtils.isBalanced("({[]})"));
        assertTrue(StringUtils.isBalanced("()[]{}"));
    }

    @Test
    public void testInvalideStringUtils() {
        assertFalse(StringUtils.isBalanced("{[}"));
        assertFalse(StringUtils.isBalanced("([)]"));
        assertFalse(StringUtils.isBalanced("{]"));
        assertFalse(StringUtils.isBalanced("}{"));
        assertFalse(StringUtils.isBalanced("[(])"));
    }

    @Test
    public void testStringsWithExtraOuvertureOuFermeture() {
        assertFalse(StringUtils.isBalanced("{]"));
        assertFalse(StringUtils.isBalanced("()}"));
        assertFalse(StringUtils.isBalanced("{([]"));
        assertFalse(StringUtils.isBalanced("())"));
        assertFalse(StringUtils.isBalanced("(()"));
    }

}