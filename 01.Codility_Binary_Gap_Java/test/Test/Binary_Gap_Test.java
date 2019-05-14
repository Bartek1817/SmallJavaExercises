package Test;

import org.junit.Test;
import static org.junit.Assert.*;
import static pkg01.codility_binary_gap_java.Codility_Binary_Gap_Java.binaryGap;

public class Binary_Gap_Test {

    @Test
    public void binary_Gap_EqualsTest() {
        assertEquals(8, binaryGap(513));
    }

    public void binary_Gap_EqualsTrueTest() {
        assertTrue(Integer.toString(binaryGap(513)).equals(Integer.toString(8)));
    }

    public void binary_Gap_EqualsFalseTest() {
        assertFalse(!Integer.toString(binaryGap(821)).equals(Integer.toString(2)));
    }
}
