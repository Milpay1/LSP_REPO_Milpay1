package org.howard.edu.lsp.assignment6;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class IntegerSetTest {
    private IntegerSet set1;
    private IntegerSet set2;

    @BeforeEach
    public void setUp() {
        set1 = new IntegerSet();
        set2 = new IntegerSet();
    }

    @Test
    public void testAddAndToString() {
        set1.add(1);
        set1.add(2);
        set1.add(2);
        assertEquals("[1, 2]", set1.toString());
        assertEquals(2, set1.length());
    }

    @Test
    public void testClearAndIsEmpty() {
        set1.add(1);
        set1.clear();
        assertTrue(set1.isEmpty());
    }

    @Test
    public void testContains() {
        set1.add(5);
        assertTrue(set1.contains(5));
        assertFalse(set1.contains(3));
    }

    @Test
    public void testEquals() {
        set1.add(1);
        set1.add(2);
        set2.add(2);
        set2.add(1);
        assertTrue(set1.equals(set2));

        set2.add(3);
        assertFalse(set1.equals(set2));
    }

    @Test
    
}
