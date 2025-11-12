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

    
}
