package Testing;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class IIntArrayTest {

    private IIntArray array;

    @BeforeEach
    public void setUp() {
        int[] values = {1, 2, 3, 4, 5};
        array = new IntArray(values);
    }


    @Test
    public void testGetAverage() {
        double expected = 3.0;
        double actual = array.getAverage();
        assertEquals(expected, actual);
    }

    @Test
    public void testFindPositions() {
        int[] expected = new int[] {1};
        int[] actual = array.findPositions(2);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testFindPositionsNoMatch() {
        int[] expected = new int[] {};
        int[] actual = array.findPositions(6);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testFindPositionsBoundary() {
        int[] expected = new int[] {0};
        int[] actual = array.findPositions(1);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testAppendLast() {
        array.appendLast(6);
        int[] expected = new int[] {1, 2, 3, 4, 5, 6};
        int[] actual = new int[expected.length];
        for (int i = 0; i < actual.length; i++) {
            actual[i] = array.getAt(i);
        }
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testInsertAt() {
        array.insertAt(2, 6);
        int[] expected = new int[] {1, 2, 6, 3, 4, 5};
        int[] actual = new int[expected.length];
        for (int i = 0; i < actual.length; i++) {
            actual[i] = array.getAt(i);
        }
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testInsertAtInvalidIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            array.insertAt(-1, 6);
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            array.insertAt(6, 6);
        });
    }

    @Test
    public void testGetAt() {
        int expected = 3;
        int actual = array.getAt(2);
        assertEquals(expected, actual);
    }

    @Test
    public void testGetAtInvalidIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            array.getAt(-1);
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            array.getAt(5);
        });
    }

    @Test
    public void testSetAt() {
        array.setAt(2, 6);
        int[] expected = new int[] {1, 2, 6, 4, 5};
        int[] actual = new int[expected.length];
        for (int i = 0; i < actual.length; i++) {
            actual[i] = array.getAt(i);
        }
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testSetAtInvalidIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            array.setAt(-1, 6);
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            array.setAt(5, 6);
        });
    }

    @Test
    public void testDeleteAt() {
        int expected = 3;
        int actual = array.deleteAt(2);
        assertEquals(expected, actual);
        int[] expectedArray = new int[] {1, 2, 4, 5};
        int[] actualArray = new int[expectedArray.length];
        for (int i = 0; i < actualArray.length; i++) {
            actualArray[i] = array.getAt(i);
        }
        assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    public void testDeleteAtInvalidIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            array.deleteAt(-1);
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            array.deleteAt(5);
        });
    }

}




