package edu.ktu.ds.lab2.demo;

import edu.ktu.ds.lab2.utils.Set;
import org.junit.Test;
import edu.ktu.ds.lab2.utils.BstSet;

import java.util.Iterator;

import static org.junit.Assert.*;

public class BstSetTest {
    Car c0 = new Car("Renault Laguna 2007 50000 1700");
    Car c1 = new Car("Renault Laguna 2007 50000 1700");
    Car c2 = new Car("Renault Megane 2011 20000 3500");
    Car c3 = new Car("Honda   Civic  2017  36400 850.3");
    Car c4 = new Car("Renault Laguna 2011 115900 700");
    Car c5 = new Car("Renault Megane 2001 365100 9500");
    Car c6 = new Car("Honda   Civic  2011  36400 800.3");
    Car c7 = new Car("Renault Laguna 2011 115900 7500");
    Car c8 = new Car("Renault Megane 2002 365100 950");
    Car c9 = new Car("Renault Laguna 2005 50000 700");

    @Test
    public void containsAll_EmptySet() {
        BstSet<Car> bstSet = new BstSet<>();
        Set<Car> emptySet = new BstSet<>();

        assertTrue(bstSet.containsAll(emptySet));
    }

    @Test
    public void containsAll_NotAll() {
        BstSet<Car> bstSet = new BstSet<>();
        bstSet.add(c1);
        bstSet.add(c2);
        bstSet.add(c3);
        //bstSet.add(1);
        //bstSet.add(2);
        //bstSet.add(3);

        Set<Car> testSet = new BstSet<>();
        testSet.add(c2);
        testSet.add(c4);
        //testSet.add(2);
        //testSet.add(4);

        assertFalse(bstSet.containsAll(testSet));

        //String visualizedString = bstSet.toVisualizedString(",");
        //System.out.println(visualizedString);
    }

    @Test
    public void containsAll_ContainsAll() {
        BstSet<Car> bstSet = new BstSet<>();
        bstSet.add(c1);
        bstSet.add(c2);
        bstSet.add(c3);
        //bstSet.add(1);
        //bstSet.add(2);
        //bstSet.add(3);

        Set<Car> testSet = new BstSet<>();
        testSet.add(c1);
        testSet.add(c2);
        //testSet.add(1);
        //testSet.add(2);

        assertTrue(bstSet.containsAll(testSet));

        //String visualizedString = bstSet.toVisualizedString(",");
        //System.out.println(visualizedString);
    }

    @Test
    public void addAll_EmptySet() {
        BstSet<Car> bstSet = new BstSet<>();
        Set<Car> emptySet = new BstSet<>();

        bstSet.addAll(emptySet);

        assertEquals(0, bstSet.size());
        assertTrue(bstSet.isEmpty());

        //String visualizedString = bstSet.toVisualizedString(",");
        //System.out.println(visualizedString);
    }

    @Test
    public void addAll_AddsWithNoRepeats() {
        BstSet<Car> bstSet = new BstSet<>();
        bstSet.add(c1);
        bstSet.add(c2);
        //bstSet.add(1);
        //bstSet.add(2);

        Set<Car> testSet = new BstSet<>();
        testSet.add(c3);
        testSet.add(c4);
        //testSet.add(3);
        //testSet.add(4);

        bstSet.addAll(testSet);

        Iterator<Car> iterator = bstSet.iterator();

        assertEquals(4, bstSet.size());
        assertTrue(bstSet.contains(c1));
        assertTrue(bstSet.contains(c2));
        assertTrue(bstSet.contains(c3));
        assertTrue(bstSet.contains(c4));
        assertEquals(c1, iterator.next());

        iterator.next();
        iterator.next();

        assertEquals(c4, iterator.next());

        //String visualizedString = bstSet.toVisualizedString(",");
        //System.out.println(visualizedString);
    }

    @Test
    public void addAll_AddsHasRepeats() {
        BstSet<Car> bstSet = new BstSet<>();
        bstSet.add(c1);
        bstSet.add(c2);
        //bstSet.add(1);
        //bstSet.add(2);

        Set<Car> testSet = new BstSet<>();
        testSet.add(c2);
        testSet.add(c3);
        //testSet.add(2);
        //testSet.add(3);

        bstSet.addAll(testSet);

        Iterator<Car> iterator = bstSet.iterator();

        assertEquals(3, bstSet.size());
        assertTrue(bstSet.contains(c1));
        assertTrue(bstSet.contains(c2));
        assertTrue(bstSet.contains(c3));

        iterator.next();
        iterator.next();

        assertEquals(c3, iterator.next());

        //String visualizedString = bstSet.toVisualizedString(",");
        //System.out.println(visualizedString);
    }

    @Test
    public void remove_ElementIsNull() {
        BstSet<Car> bstSet = new BstSet<>();

        assertThrows(IllegalArgumentException.class, () -> bstSet.remove(null));
    }

    @Test
    public void remove_RemoveRoot() {
        BstSet<Car> bstSet = new BstSet<>();
        bstSet.add(c1);
        //bstSet.add(1);

        bstSet.remove(c1);

        assertTrue(bstSet.isEmpty());

        bstSet.add(c5);
        bstSet.add(c2);
        bstSet.add(c7);
        bstSet.add(c6);
        bstSet.add(c8);
        bstSet.add(c4);
        bstSet.add(c3);
        bstSet.add(c1);
        //bstSet.add(5);
        //bstSet.add(2);
        //bstSet.add(7);
        //bstSet.add(6);
        //bstSet.add(8);
        //bstSet.add(4);
        //bstSet.add(3);
        //bstSet.add(1);

//        String visualizedString = bstSet.toVisualizedString(",");
//        System.out.println(visualizedString);

        bstSet.remove(c5);

        Iterator<Car> iterator = bstSet.iterator();

        assertEquals(7, bstSet.size());
        assertFalse(bstSet.contains(c5));
        assertEquals(c1, iterator.next());
        assertEquals(c2, iterator.next());

//        visualizedString = bstSet.toVisualizedString(",");
//        System.out.println(visualizedString);
    }

    @Test
    public void remove_RemoveLeaf() {
        BstSet<Car> bstSet = new BstSet<>();
        bstSet.add(c5);
        bstSet.add(c2);
        bstSet.add(c7);
        //bstSet.add(5);
        //bstSet.add(2);
        //bstSet.add(7);

//        String visualizedString = bstSet.toVisualizedString(",");
//        System.out.println(visualizedString);

        bstSet.remove(c2);

        Iterator<Car> iterator = bstSet.iterator();

        assertEquals(2, bstSet.size());
        assertFalse(bstSet.contains(c2));

        iterator.next();
        assertEquals(c7, iterator.next());

//        visualizedString = bstSet.toVisualizedString(",");
//        System.out.println(visualizedString);
    }

    @Test
    public void remove_RemoveWithOneChild() {
        BstSet<Car> bstSet = new BstSet<>();
        bstSet.add(c5);
        bstSet.add(c2);
        bstSet.add(c7);
        bstSet.add(c6);
//        bstSet.add(5);
//        bstSet.add(2);
//        bstSet.add(7);
//        bstSet.add(6);

        //String visualizedString = bstSet.toVisualizedString(",");
        //System.out.println(visualizedString);

        bstSet.remove(c7);

        Iterator<Car> iterator = bstSet.iterator();

        assertEquals(3, bstSet.size());
        assertTrue(bstSet.contains(c6));
        assertFalse(bstSet.contains(c7));

        iterator.next();
        iterator.next();
        assertEquals(c6, iterator.next());

        //visualizedString = bstSet.toVisualizedString(",");
        //System.out.println(visualizedString);
    }

    @Test
    public void remove_RemoveWithTwoChildren() {
        BstSet<Car> bstSet = new BstSet<>();
        bstSet.add(c5);
        bstSet.add(c2);
        bstSet.add(c7);
        bstSet.add(c6);
        bstSet.add(c8);
//        bstSet.add(5);
//        bstSet.add(2);
//        bstSet.add(7);
//        bstSet.add(6);
//        bstSet.add(8);

        //String visualizedString = bstSet.toVisualizedString(",");
        //System.out.println(visualizedString);

        bstSet.remove(c7);

        Iterator<Car> iterator = bstSet.iterator();

        assertEquals(4, bstSet.size());
        assertTrue(bstSet.contains(c6));
        assertFalse(bstSet.contains(c7));
        assertTrue(bstSet.contains(c8));

        iterator.next();
        iterator.next();
        assertEquals(c6, iterator.next());
        assertEquals(c8, iterator.next());

        //visualizedString = bstSet.toVisualizedString(",");
        //System.out.println(visualizedString);
    }

    @Test
    public void pollLast() {
        BstSet<Car> bstSet = new BstSet<>();
        bstSet.add(c5);
        bstSet.add(c2);
        bstSet.add(c7);
        bstSet.add(c6);
        bstSet.add(c8);
        bstSet.add(c9);

        String visualizedString = bstSet.toVisualizedString(",");
        System.out.println(visualizedString);

        assertEquals(c9, bstSet.pollLast());
        assertTrue(bstSet.contains(c6));
        assertTrue(bstSet.contains(c7));
        assertTrue(bstSet.contains(c8));
        assertFalse(bstSet.contains(c9));

        visualizedString = bstSet.toVisualizedString(",");
        System.out.println(visualizedString);
    }

    @Test
    public void remove_EmptyBstSet() {
        BstSet<Car> bstSet = new BstSet<>();
        bstSet.remove(c1);

        assertTrue(bstSet.isEmpty());
    }

    @Test
    public void retainAll_EmptySet() {
        BstSet<Car> bstSet = new BstSet<>();
        Set<Car> emptySet = new BstSet<>();

        bstSet.retainAll(emptySet);

        assertEquals(0, bstSet.size());
        assertTrue(bstSet.isEmpty());

        bstSet.add(c1);
        bstSet.add(c2);
//        bstSet.add(1);
//        bstSet.add(2);

        bstSet.retainAll(emptySet);

        assertEquals(0, bstSet.size());
        assertTrue(bstSet.isEmpty());

        //String visualizedString = bstSet.toVisualizedString(",");
        //System.out.println(visualizedString);
    }

    @Test
    public void retainAll_EmptyBstSet() {
        BstSet<Car> bstSet = new BstSet<>();
        Set<Car> testSet = new BstSet<>();

        bstSet.add(c1);
        bstSet.add(c2);
//        testSet.add(1);
//        testSet.add(2);

        bstSet.retainAll(testSet);
        assertEquals(0, bstSet.size());
        assertTrue(bstSet.isEmpty());

        //String visualizedString = bstSet.toVisualizedString(",");
        //System.out.println(visualizedString);
    }

    @Test
    public void retainAll_AllStays() {
        BstSet<Car> bstSet = new BstSet<>();
        bstSet.add(c1);
        bstSet.add(c2);
        bstSet.add(c3);
//        bstSet.add(1);
//        bstSet.add(2);
//        bstSet.add(3);

        Set<Car> testSet = new BstSet<>();
        testSet.add(c1);
        testSet.add(c2);
        testSet.add(c3);
//        testSet.add(1);
//        testSet.add(2);
//        testSet.add(3);

        bstSet.retainAll(testSet);

        assertEquals(3, bstSet.size());
        assertTrue(bstSet.contains(c1));
        assertTrue(bstSet.contains(c2));
        assertTrue(bstSet.contains(c3));

        //String visualizedString = bstSet.toVisualizedString(",");
        //System.out.println(visualizedString);
    }

    @Test
    public void retainAll_NotAllStays() {
        BstSet<Car> bstSet = new BstSet<>();
        bstSet.add(c1);
        bstSet.add(c2);
        bstSet.add(c3);
//        bstSet.add(1);
//        bstSet.add(2);
//        bstSet.add(3);

        Set<Car> testSet = new BstSet<>();
        testSet.add(c1);
        testSet.add(c2);
//        testSet.add(1);
//        testSet.add(2);

        bstSet.retainAll(testSet);

        Iterator<Car> iterator = bstSet.iterator();

        assertEquals(2, bstSet.size());
        assertTrue(bstSet.contains(c1));
        assertTrue(bstSet.contains(c2));
        assertFalse(bstSet.contains(c3));

        assertEquals(c1, iterator.next());
        assertEquals(c2, iterator.next());

        String visualizedString = bstSet.toVisualizedString(",");
        System.out.println(visualizedString);
    }

    @Test
    public void headSet_ElementIsNull() {
        BstSet<Car> bstSet = new BstSet<>();

        bstSet.add(c1);
        //bstSet.add(1);

        assertThrows(IllegalArgumentException.class, () -> bstSet.headSet(null));
    }

    @Test
    public void headSet_ReturnsOneElement() {
        BstSet<Car> bstSet = new BstSet<>();

        bstSet.add(c5);
        bstSet.add(c2);
        bstSet.add(c7);
        bstSet.add(c6);
        bstSet.add(c8);
        bstSet.add(c4);
        bstSet.add(c3);
        bstSet.add(c1);

//        bstSet.add(5);
//        bstSet.add(2);
//        bstSet.add(7);
//        bstSet.add(6);
//        bstSet.add(8);
//        bstSet.add(4);
//        bstSet.add(3);
//        bstSet.add(1);

        Set<Car> testSet = bstSet.headSet(c1);

        assertEquals(1, testSet.size());
        assertTrue(testSet.contains(c1));
        assertFalse(testSet.contains(c2));
        assertFalse(testSet.contains(c3));
    }

    @Test
    public void headSet_ReturnsFourElements() {
        BstSet<Car> bstSet = new BstSet<>();

        bstSet.add(c5);
        bstSet.add(c2);
        bstSet.add(c7);
        bstSet.add(c6);
        bstSet.add(c8);
        bstSet.add(c4);
        bstSet.add(c3);
        bstSet.add(c1);
//        bstSet.add(5);
//        bstSet.add(2);
//        bstSet.add(7);
//        bstSet.add(6);
//        bstSet.add(8);
//        bstSet.add(4);
//        bstSet.add(3);
//        bstSet.add(1);

        Set<Car> testSet = bstSet.headSet(c4);

        assertEquals(4, testSet.size());
        assertTrue(testSet.contains(c1));
        assertTrue(testSet.contains(c2));
        assertTrue(testSet.contains(c3));
        assertTrue(testSet.contains(c4));
    }

    @Test
    public void headSet_ReturnsAllElements() {
        BstSet<Car> bstSet = new BstSet<>();

        bstSet.add(c5);
        bstSet.add(c2);
        bstSet.add(c7);
        bstSet.add(c6);
        bstSet.add(c8);
        bstSet.add(c4);
        bstSet.add(c3);
        bstSet.add(c1);
//        bstSet.add(5);
//        bstSet.add(2);
//        bstSet.add(7);
//        bstSet.add(6);
//        bstSet.add(8);
//        bstSet.add(4);
//        bstSet.add(3);
//        bstSet.add(1);

        Set<Car> testSet = bstSet.headSet(c8);

        assertEquals(8, testSet.size());
        assertTrue(testSet.contains(c1));
        assertTrue(testSet.contains(c2));
        assertTrue(testSet.contains(c3));
        assertTrue(testSet.contains(c8));
    }

    @Test
    public void headSet_BstSetIsEmpty() {
        BstSet<Car> bstSet = new BstSet<>();

        Set<Car> testSet = bstSet.headSet(c8);

        assertEquals(0, testSet.size());
        assertTrue(bstSet.isEmpty());
        assertTrue(testSet.isEmpty());
    }

    @Test
    public void subSet_ElementIsNull() {
        BstSet<Car> bstSet = new BstSet<>();

        bstSet.add(c1);
        //bstSet.add(1);

        assertThrows(IllegalArgumentException.class, () -> bstSet.subSet(null, null));
    }

    @Test
    public void subSet_Element1BiggerThan2() {
        BstSet<Car> bstSet = new BstSet<>();

        bstSet.add(c1);
//        bstSet.add(1);

        Set<Car> testSet = new BstSet<>();

        assertThrows(IllegalArgumentException.class, () -> bstSet.subSet(c2, c1));

        assertEquals(0, testSet.size());
        assertTrue(testSet.isEmpty());
    }

    @Test
    public void subSet_BstSetIsEmpty() {
        BstSet<Car> bstSet = new BstSet<>();

        Set<Car> testSet = bstSet.subSet(c1, c2);

        assertEquals(0, testSet.size());
        assertTrue(bstSet.isEmpty());
        assertTrue(testSet.isEmpty());
    }

    @Test
    public void subSet_ReturnsOneElement() {
        BstSet<Car> bstSet = new BstSet<>();

        bstSet.add(c5);
        bstSet.add(c2);
        bstSet.add(c7);
        bstSet.add(c6);
        bstSet.add(c8);
        bstSet.add(c4);
        bstSet.add(c3);
        bstSet.add(c1);
//        bstSet.add(5);
//        bstSet.add(2);
//        bstSet.add(7);
//        bstSet.add(6);
//        bstSet.add(8);
//        bstSet.add(4);
//        bstSet.add(3);
//        bstSet.add(1);

        Set<Car> testSet = bstSet.subSet(c2, c2);

        assertEquals(1, testSet.size());
        assertTrue(testSet.contains(c2));
        assertFalse(testSet.contains(c1));
    }

    @Test
    public void subSet_ReturnsThreeElements() {
        BstSet<Car> bstSet = new BstSet<>();

        bstSet.add(c5);
        bstSet.add(c2);
        bstSet.add(c7);
        bstSet.add(c6);
        bstSet.add(c8);
        bstSet.add(c4);
        bstSet.add(c3);
        bstSet.add(c1);
//        bstSet.add(5);
//        bstSet.add(2);
//        bstSet.add(7);
//        bstSet.add(6);
//        bstSet.add(8);
//        bstSet.add(4);
//        bstSet.add(3);
//        bstSet.add(1);

        Set<Car> testSet = bstSet.subSet(c2, c4);

        assertEquals(3, testSet.size());
        assertTrue(testSet.contains(c4));
        assertTrue(testSet.contains(c2));
        assertTrue(testSet.contains(c3));
        assertFalse(testSet.contains(c1));
    }

    @Test
    public void subSet_ReturnsAllElements() {
        BstSet<Car> bstSet = new BstSet<>();

        bstSet.add(c5);
        bstSet.add(c2);
        bstSet.add(c7);
        bstSet.add(c6);
        bstSet.add(c8);
        bstSet.add(c4);
        bstSet.add(c3);
        bstSet.add(c1);
//        bstSet.add(5);
//        bstSet.add(2);
//        bstSet.add(7);
//        bstSet.add(6);
//        bstSet.add(8);
//        bstSet.add(4);
//        bstSet.add(3);
//        bstSet.add(1);

        Set<Car> testSet = bstSet.subSet(c1, c8);

        assertEquals(8, testSet.size());
        assertTrue(testSet.contains(c4));
        assertTrue(testSet.contains(c2));
        assertTrue(testSet.contains(c3));
        assertTrue(testSet.contains(c1));
        assertTrue(testSet.contains(c8));
    }

    @Test
    public void tailSet_ElementIsNull() {
        BstSet<Car> bstSet = new BstSet<>();

        bstSet.add(c1);
        //bstSet.add(1);

        assertThrows(IllegalArgumentException.class, () -> bstSet.tailSet(null));
    }

    @Test
    public void tailSet_BstSetIsEmpty() {
        BstSet<Car> bstSet = new BstSet<>();

        Set<Car> testSet = bstSet.tailSet(c2);

        assertEquals(0, testSet.size());
        assertTrue(bstSet.isEmpty());
        assertTrue(testSet.isEmpty());
    }

    @Test
    public void tailSet_ReturnsOneElement() {
        BstSet<Car> bstSet = new BstSet<>();

        bstSet.add(c5);
        bstSet.add(c2);
        bstSet.add(c7);
        bstSet.add(c6);
        bstSet.add(c8);
        bstSet.add(c4);
        bstSet.add(c3);
        bstSet.add(c1);
//        bstSet.add(5);
//        bstSet.add(2);
//        bstSet.add(7);
//        bstSet.add(6);
//        bstSet.add(8);
//        bstSet.add(4);
//        bstSet.add(3);
//        bstSet.add(1);

        Set<Car> testSet = bstSet.tailSet(c8);

        assertEquals(1, testSet.size());
        assertTrue(testSet.contains(c8));
        assertFalse(testSet.contains(c4));
    }

    @Test
    public void tailSet_ReturnsThreeElements() {
        BstSet<Car> bstSet = new BstSet<>();

        bstSet.add(c5);
        bstSet.add(c2);
        bstSet.add(c7);
        bstSet.add(c6);
        bstSet.add(c8);
        bstSet.add(c4);
        bstSet.add(c3);
        bstSet.add(c1);
//        bstSet.add(5);
//        bstSet.add(2);
//        bstSet.add(7);
//        bstSet.add(6);
//        bstSet.add(8);
//        bstSet.add(4);
//        bstSet.add(3);
//        bstSet.add(1);

        Set<Car> testSet = bstSet.tailSet(c6);

        assertEquals(3, testSet.size());
        assertTrue(testSet.contains(c8));
        assertTrue(testSet.contains(c6));
        assertTrue(testSet.contains(c7));
        assertFalse(testSet.contains(c5));
    }

    @Test
    public void tailSet_ReturnsAllElements() {
        BstSet<Car> bstSet = new BstSet<>();

        bstSet.add(c5);
        bstSet.add(c2);
        bstSet.add(c7);
        bstSet.add(c6);
        bstSet.add(c8);
        bstSet.add(c4);
        bstSet.add(c3);
        bstSet.add(c1);
//        bstSet.add(5);
//        bstSet.add(2);
//        bstSet.add(7);
//        bstSet.add(6);
//        bstSet.add(8);
//        bstSet.add(4);
//        bstSet.add(3);
//        bstSet.add(1);

        Set<Car> testSet = bstSet.tailSet(c1);

        assertEquals(8, testSet.size());
        assertTrue(testSet.contains(c8));
        assertTrue(testSet.contains(c1));
    }

    @Test
    public void remove_LastIsNull() {
        BstSet<Car> bstSet = new BstSet<>();

        Iterator<Car> iterator = bstSet.iterator();

        iterator.next();
        assertThrows(IllegalArgumentException.class, () -> iterator.remove());
    }

    @Test
    public void remove_Leaf() {
        BstSet<Car> bstSet = new BstSet<>();

        bstSet.add(c5);
        bstSet.add(c2);
        bstSet.add(c7);
        bstSet.add(c6);
        bstSet.add(c8);
        bstSet.add(c4);
        bstSet.add(c3);
        bstSet.add(c1);
//        bstSet.add(5);
//        bstSet.add(2);
//        bstSet.add(7);
//        bstSet.add(6);
//        bstSet.add(8);
//        bstSet.add(4);
//        bstSet.add(3);
//        bstSet.add(1);

        //String visualizedString = bstSet.toVisualizedString(",");
        //System.out.println(visualizedString);

        Iterator<Car> iterator = bstSet.iterator();

        iterator.next();
        iterator.remove();

        Iterator<Car> test = bstSet.iterator();

        assertEquals(7, bstSet.size());
        assertFalse(bstSet.contains(c1));
        assertTrue(bstSet.contains(c2));

        assertEquals(c2, test.next());
        assertEquals(c3, test.next());

        //visualizedString = bstSet.toVisualizedString(",");
        //System.out.println(visualizedString);
    }

    @Test
    public void remove_HasOneChild() {
        BstSet<Car> bstSet = new BstSet<>();

        bstSet.add(c5);
        bstSet.add(c2);
        bstSet.add(c7);
        bstSet.add(c6);
        bstSet.add(c8);
        bstSet.add(c4);
        bstSet.add(c3);
        bstSet.add(c1);
//        bstSet.add(5);
//        bstSet.add(2);
//        bstSet.add(7);
//        bstSet.add(6);
//        bstSet.add(8);
//        bstSet.add(4);
//        bstSet.add(3);
//        bstSet.add(1);

//        String visualizedString = bstSet.toVisualizedString(",");
//        System.out.println(visualizedString);

        Iterator<Car> iterator = bstSet.iterator();

        iterator.next();
        iterator.next();
        iterator.next();
        iterator.next();
        iterator.remove();

        Iterator<Car> test = bstSet.iterator();

        assertEquals(7, bstSet.size());
        assertFalse(bstSet.contains(c4));
        assertTrue(bstSet.contains(c2));
        assertTrue(bstSet.contains(c3));

        test.next();
        test.next();
        assertEquals(c3, test.next());
        assertEquals(c5, test.next());

//        visualizedString = bstSet.toVisualizedString(",");
//        System.out.println(visualizedString);
    }

    @Test
    public void remove_HasOneChild2() {
        BstSet<Car> bstSet = new BstSet<>();

        bstSet.add(c7);
        bstSet.add(c6);
        bstSet.add(c5);
        bstSet.add(c4);
        bstSet.add(c8);
        bstSet.add(c9);
//        bstSet.add(7);
//        bstSet.add(6);
//        bstSet.add(5);
//        bstSet.add(4);
//        bstSet.add(8);
//        bstSet.add(9);

        //String visualizedString = bstSet.toVisualizedString(",");
        //System.out.println(visualizedString);

        Iterator<Car> iterator = bstSet.iterator();

        iterator.next();
        iterator.next();
        iterator.next();
        iterator.remove();

        Iterator<Car> test = bstSet.iterator();

        assertEquals(5, bstSet.size());
        assertFalse(bstSet.contains(c6));
        assertTrue(bstSet.contains(c5));
        assertTrue(bstSet.contains(c4));

        assertEquals(c4, test.next());
        assertEquals(c5, test.next());
        assertEquals(c7, test.next());

        //visualizedString = bstSet.toVisualizedString(",");
        //System.out.println(visualizedString);
    }

    @Test
    public void remove_HasOneChild3() {
        BstSet<Car> bstSet = new BstSet<>();

        bstSet.add(c6);
        bstSet.add(c5);
        bstSet.add(c2);
        bstSet.add(c4);
        bstSet.add(c3);
        bstSet.add(c1);
//        bstSet.add(6);
//        bstSet.add(5);
//        bstSet.add(2);
//        bstSet.add(4);
//        bstSet.add(3);
//        bstSet.add(1);

        //String visualizedString = bstSet.toVisualizedString(",");
        //System.out.println(visualizedString);

        Iterator<Car> iterator = bstSet.iterator();

        iterator.next();
        iterator.next();
        iterator.next();
        iterator.next();
        iterator.remove();

        Iterator<Car> test = bstSet.iterator();

        assertEquals(5, bstSet.size());
        assertFalse(bstSet.contains(c4));
        assertTrue(bstSet.contains(c3));
        assertTrue(bstSet.contains(c1));

        test.next();
        test.next();
        assertEquals(c3, test.next());
        assertEquals(c5, test.next());

        //visualizedString = bstSet.toVisualizedString(",");
        //System.out.println(visualizedString);
    }

    @Test
    public void remove_HasTwoChildren() {
        BstSet<Car> bstSet = new BstSet<>();

        bstSet.add(c5);
        bstSet.add(c2);
        bstSet.add(c7);
        bstSet.add(c6);
        bstSet.add(c8);
        bstSet.add(c4);
        bstSet.add(c3);
        bstSet.add(c1);
//        bstSet.add(5);
//        bstSet.add(2);
//        bstSet.add(7);
//        bstSet.add(6);
//        bstSet.add(8);
//        bstSet.add(4);
//        bstSet.add(3);
//        bstSet.add(1);

        //String visualizedString = bstSet.toVisualizedString(",");
        //System.out.println(visualizedString);

        Iterator<Car> iterator = bstSet.iterator();

        iterator.next();
        iterator.next();
        iterator.remove();

        Iterator<Car> test = bstSet.iterator();

        assertEquals(7, bstSet.size());
        assertFalse(bstSet.contains(c2));
        assertTrue(bstSet.contains(c3));
        assertTrue(bstSet.contains(c4));
        assertTrue(bstSet.contains(c1));

        assertEquals(c1, test.next());
        assertEquals(c3, test.next());
        assertEquals(c4, test.next());

        //visualizedString = bstSet.toVisualizedString(",");
        //System.out.println(visualizedString);
    }

    @Test
    public void remove_RootRemove() {
        BstSet<Car> bstSet = new BstSet<>();

        bstSet.add(c5);
        bstSet.add(c2);
        bstSet.add(c7);
        bstSet.add(c6);
        bstSet.add(c8);
        bstSet.add(c4);
        bstSet.add(c3);
        bstSet.add(c1);
//        bstSet.add(5);
//        bstSet.add(2);
//        bstSet.add(7);
//        bstSet.add(6);
//        bstSet.add(8);
//        bstSet.add(4);
//        bstSet.add(3);
//        bstSet.add(1);

//        String visualizedString = bstSet.toVisualizedString(",");
//        System.out.println(visualizedString);

        Iterator<Car> iterator = bstSet.iterator();

        iterator.next();
        iterator.next();
        iterator.next();
        iterator.next();
        iterator.next();
        iterator.remove();

        Iterator<Car> test = bstSet.iterator();

        assertEquals(7, bstSet.size());
        assertFalse(bstSet.contains(c5));
        assertTrue(bstSet.contains(c2));
        assertTrue(bstSet.contains(c7));
        assertTrue(bstSet.contains(c6));
        assertTrue(bstSet.contains(c3));

        test.next();
        assertEquals(c2, test.next());
        assertEquals(c3, test.next());
        assertEquals(c4, test.next());

//        visualizedString = bstSet.toVisualizedString(",");
//        System.out.println(visualizedString);
    }
}
