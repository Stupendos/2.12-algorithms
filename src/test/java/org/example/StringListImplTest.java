package org.example;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
public class StringListImplTest{

    private StringListImpl list;

    @BeforeEach
    void setUp() {
        list = new StringListImpl();
    }

    @Test
    void add() {
        assertEquals("Vladimir", list.add("Vladimir"));
        assertEquals("Donny", list.add("Donny"));
        assertEquals(2, list.size());
        assertEquals("Donny", list.get(1));
    }

    @Test
    void testAdd() {
        list.add("Vladimir");
        list.add("Donny");
        list.add(0, "Donny");
        assertEquals("Donny", list.get(0));
        assertEquals(3, list.size());
    }

    @Test
    void set() {
        list.add("Vladimir");
        list.add("Donny");
        list.set(0, "Hello");
        assertEquals("Hello", list.get(0));
    }

    @Test
    void remove() {
        list.add("Vladimir");
        list.add("Donny");
        assertEquals("Vladimir", list.remove("Vladimir"));
        assertFalse(list.contains("Vladimir"));
        assertEquals(1, list.size());
    }

    @Test
    void testRemove() {
        list.add("Vladimir");
        list.add("Donny");
        assertEquals("Vladimir", list.remove(0));
        assertFalse(list.contains("Vladimir"));
        assertEquals(1, list.size());
    }

    @Test
    void contains() {
        list.add("Vladimir");
        assertTrue(list.contains("Vladimir"));
        assertFalse(list.contains("Donny"));
    }

    @Test
    void indexOf() {
        list.add("Vladimir");
        list.add("Donny");
        list.add("Vladimir");
        assertEquals(0, list.indexOf("Vladimir"));
    }

    @Test
    void lastIndexOf() {
        list.add("Vladimir");
        list.add("Donny");
        list.add("Vladimir");
        assertEquals(2, list.lastIndexOf("Vladimir"));
    }

    @Test
    void get() {
        list.add("Vladimir");
        assertEquals("Vladimir", list.get(0));
    }

    @Test
    void testEquals() {
        StringList otherList = new StringListImpl();
        list.add("Vladimir");
        otherList.add("Vladimir");
        assertTrue(list.equals(otherList));

        otherList.add("Donny");
        assertFalse(list.equals(otherList));
    }

    @Test
    void sizeAndIsEmpty() {
        assertTrue(list.isEmpty());
        list.add("Vladimir");
        assertFalse(list.isEmpty());
        assertEquals(1, list.size());
    }

    @Test
    void clear() {
        list.add("Vladimir");
        list.add("Donny");
        list.clear();
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }

    @Test
    void toArray() {
        list.add("Vladimir");
        list.add("Donny");
        String[] array = list.toArray();
        assertArrayEquals(new String[]{"Vladimir", "Donny"}, array);
    }
}