package edu.ktu.ds.lab2.demo;

import edu.ktu.ds.lab2.utils.AvlSet;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;

public class AvlSetTest {
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
    Car c10 = new Car("BMW Laguna 2005 50000 700");
    Car c11 = new Car("Erelis Laguna 2005 50000 700");
    Car c12 = new Car("Audi Laguna 2005 50000 700");
    Car c13 = new Car("Wolvo Laguna 2005 50000 700");
    Car c14 = new Car("Bulka Laguna 2005 50000 700");
    Car c15 = new Car("Kirvis Laguna 2005 50000 700");
    Car c16 = new Car("Saulenas Laguna 2005 50000 700");
    Car c17 = new Car("Honda Laguna 2005 50000 700");
    Car c18 = new Car("Renault Laguna 2005 50000 700");
    Car c19 = new Car("Renault Laguna 2005 50000 700");
    Car c20 = new Car("Renault Laguna 2005 50000 700");

    @Test
    public void remove_ElementIsNull() {
        AvlSet<Car> avlSet = new AvlSet<>();

        assertThrows(IllegalArgumentException.class, () -> avlSet.remove(null));
    }

    @Test
    public void remove_RemoveRoot() {
        AvlSet<Car> avlSet = new AvlSet<>();

        avlSet.add(c1);
        //avlSet.add(1);

        avlSet.remove(c1);

        assertTrue(avlSet.isEmpty());

        avlSet.add(c5);
        avlSet.add(c2);
        avlSet.add(c7);
//        avlSet.add(5);
//        avlSet.add(2);
//        avlSet.add(7);

        //String visualizedString = avlSet.toVisualizedString(",");
        //System.out.println(visualizedString);

        avlSet.remove(c5);

        Iterator<Car> test = avlSet.iterator();

        assertEquals(2, avlSet.size());
        assertFalse(avlSet.contains(c5));
        assertTrue(avlSet.contains(c2));
        assertTrue(avlSet.contains(c7));

        assertEquals(c2, test.next());
        assertEquals(c7, test.next());

        //visualizedString = avlSet.toVisualizedString(",");
        //System.out.println(visualizedString);
    }

    @Test
    public void remove_RemoveLeaf() {
        AvlSet<Car> avlSet = new AvlSet<>();

        avlSet.add(c5);
        avlSet.add(c2);
        avlSet.add(c7);
//        avlSet.add(5);
//        avlSet.add(2);
//        avlSet.add(7);

        //String visualizedString = avlSet.toVisualizedString(",");
        //System.out.println(visualizedString);

        avlSet.remove(c2);

        Iterator<Car> test = avlSet.iterator();

        assertEquals(2, avlSet.size());
        assertFalse(avlSet.contains(c2));
        assertTrue(avlSet.contains(c7));
        assertTrue(avlSet.contains(c5));

        assertEquals(c5, test.next());
        assertEquals(c7, test.next());

        //visualizedString = avlSet.toVisualizedString(",");
        //System.out.println(visualizedString);
    }

    @Test
    public void remove_RemoveWithOneChild() {
        AvlSet<Car> avlSet = new AvlSet<>();

        avlSet.add(c5);
        avlSet.add(c2);
        avlSet.add(c7);
        avlSet.add(c6);
//        avlSet.add(5);
//        avlSet.add(2);
//        avlSet.add(7);
//        avlSet.add(6);

        //String visualizedString = avlSet.toVisualizedString(",");
        //System.out.println(visualizedString);

        avlSet.remove(c7);

        Iterator<Car> test = avlSet.iterator();

        assertEquals(3, avlSet.size());
        assertTrue(avlSet.contains(c6));
        assertFalse(avlSet.contains(c7));
        assertTrue(avlSet.contains(c5));
        assertTrue(avlSet.contains(c2));

        test.next();
        assertEquals(c5, test.next());
        assertEquals(c6, test.next());

        //visualizedString = avlSet.toVisualizedString(",");
        //System.out.println(visualizedString);
    }

    @Test
    public void remove_RemoveWithTwoChildren() {
        AvlSet<Car> avlSet = new AvlSet<>();

        avlSet.add(c5);
        avlSet.add(c3);
        avlSet.add(c7);
        avlSet.add(c2);
        avlSet.add(c4);
        avlSet.add(c6);
        avlSet.add(c8);
//        avlSet.add(5);
//        avlSet.add(3);
//        avlSet.add(7);
//        avlSet.add(2);
//        avlSet.add(4);
//        avlSet.add(6);
//        avlSet.add(8);

        //String visualizedString = avlSet.toVisualizedString(",");
        //System.out.println(visualizedString);

        avlSet.remove(c3);

        Iterator<Car> test = avlSet.iterator();

        assertEquals(6, avlSet.size());
        assertTrue(avlSet.contains(c7));
        assertFalse(avlSet.contains(c3));
        assertTrue(avlSet.contains(c8));
        assertTrue(avlSet.contains(c4));
        assertTrue(avlSet.contains(c2));

        assertEquals(c2, test.next());
        assertEquals(c4, test.next());
        assertEquals(c5, test.next());

        //visualizedString = avlSet.toVisualizedString(",");
        //System.out.println(visualizedString);
    }

    @Test
    public void remove_EmptyAvlSet() {
        AvlSet<Car> avlSet = new AvlSet<>();
        avlSet.remove(c1);

        assertTrue(avlSet.isEmpty());
    }

    @Test
    public void remove_MultipleRemoves() {
        AvlSet<Car> avlSet = new AvlSet<>();

        avlSet.add(c5);
        avlSet.add(c3);
        avlSet.add(c7);
        avlSet.add(c2);
        avlSet.add(c4);
        avlSet.add(c6);
        avlSet.add(c8);
        avlSet.add(c9);
//        avlSet.add(5);
//        avlSet.add(3);
//        avlSet.add(7);
//        avlSet.add(2);
//        avlSet.add(4);
//        avlSet.add(6);
//        avlSet.add(8);
//        avlSet.add(9);

        //String visualizedString = avlSet.toVisualizedString(",");
        //System.out.println(visualizedString);

        avlSet.remove(c2);

        Iterator<Car> test = avlSet.iterator();

        assertEquals(c3, test.next());
        assertEquals(c4, test.next());

        avlSet.remove(c4);

        test = avlSet.iterator();

        assertEquals(6, avlSet.size());
        assertFalse(avlSet.contains(c2));
        assertFalse(avlSet.contains(c4));
        assertTrue(avlSet.contains(c6));
        assertTrue(avlSet.contains(c7));
        assertTrue(avlSet.contains(c3));

        assertEquals(c3, test.next());
        assertEquals(c5, test.next());
        assertEquals(c6, test.next());
        assertEquals(c7, test.next());
        assertEquals(c8, test.next());
        assertEquals(c9, test.next());

        //visualizedString = avlSet.toVisualizedString(",");
        //System.out.println(visualizedString);
    }

    @Test
    public void remove_CausesBalancing() {
        AvlSet<Car> avlSet = new AvlSet<>();

        avlSet.add(c5);
        avlSet.add(c3);
        avlSet.add(c7);
        avlSet.add(c2);
        avlSet.add(c4);
        avlSet.add(c6);
        avlSet.add(c8);
        avlSet.add(c9);
//        avlSet.add(5);
//        avlSet.add(3);
//        avlSet.add(7);
//        avlSet.add(2);
//        avlSet.add(4);
//        avlSet.add(6);
//        avlSet.add(8);
//        avlSet.add(9);

        //String visualizedString = avlSet.toVisualizedString(",");
        //System.out.println(visualizedString);

        avlSet.remove(c6);

        Iterator<Car> test = avlSet.iterator();

        assertEquals(7, avlSet.size());
        assertFalse(avlSet.contains(c6));
        assertTrue(avlSet.contains(c7));
        assertTrue(avlSet.contains(c8));
        assertTrue(avlSet.contains(c9));

        test.next();
        test.next();
        test.next();
        test.next();
        assertEquals(c7, test.next());
        assertEquals(c8, test.next());
        assertEquals(c9, test.next());

        //visualizedString = avlSet.toVisualizedString(",");
        //System.out.println(visualizedString);
    }

    @Test
    public void Avl_Testing1() {
        AvlSet<Car> avlSet = new AvlSet<>();
        avlSet.add(c9);
        avlSet.add(c7);
        avlSet.add(c8);
        avlSet.add(c16);
        avlSet.add(c17);
        avlSet.add(c18);
        avlSet.add(c11);
        avlSet.add(c5);
        avlSet.add(c1);
        avlSet.add(c6);
        avlSet.add(c2);
        avlSet.add(c10);
        avlSet.add(c3);
        avlSet.add(c4);
        avlSet.add(c15);
        avlSet.add(c12);
        avlSet.add(c13);
        avlSet.add(c14);

        String visualizedString = avlSet.toVisualizedString(",");
        System.out.println(visualizedString);

        avlSet.remove(c1);

        visualizedString = avlSet.toVisualizedString(",");
        System.out.println(visualizedString);
    }

    @Test
    public void Avl_Testing2() {
        AvlSet<Car> avlSet = new AvlSet<>();
        avlSet.add(c9);
        avlSet.add(c7);
        avlSet.add(c8);
        avlSet.add(c16);
        avlSet.add(c17);
        avlSet.add(c18);
        avlSet.add(c11);
        avlSet.add(c5);
        avlSet.add(c1);
        avlSet.add(c6);
        avlSet.add(c2);
        avlSet.add(c10);
        avlSet.add(c3);
        avlSet.add(c4);
        avlSet.add(c15);
        avlSet.add(c12);
        avlSet.add(c13);
        avlSet.add(c14);

        String visualizedString = avlSet.toVisualizedString(",");
        System.out.println(visualizedString);

        avlSet.remove(c15);
        avlSet.remove(c11);
        avlSet.remove(c10);
        avlSet.remove(c9);

        visualizedString = avlSet.toVisualizedString(",");
        System.out.println(visualizedString);
    }

    @Test
    public void Avl_Testing3() {
        AvlSet<Car> avlSet = new AvlSet<>();
        avlSet.add(c9);
        avlSet.add(c7);
        avlSet.add(c8);
        avlSet.add(c16);
        avlSet.add(c17);
        avlSet.add(c18);
        avlSet.add(c11);
        avlSet.add(c5);
        avlSet.add(c1);
        avlSet.add(c6);
        avlSet.add(c2);
        avlSet.add(c10);
        avlSet.add(c3);
        avlSet.add(c4);
        avlSet.add(c15);
        avlSet.add(c12);
        avlSet.add(c13);
        avlSet.add(c14);

        String visualizedString = avlSet.toVisualizedString(",");
        System.out.println(visualizedString);

        avlSet.remove(c11);
        avlSet.remove(c13);
        avlSet.remove(c15);
        avlSet.remove(c14);

        visualizedString = avlSet.toVisualizedString(",");
        System.out.println(visualizedString);
    }

    @Test
    public void Avl_Testing4() {
        AvlSet<Car> avlSet = new AvlSet<>();
        avlSet.add(c9);
        avlSet.add(c7);
        avlSet.add(c8);
        avlSet.add(c16);
        avlSet.add(c17);
        avlSet.add(c18);
        avlSet.add(c11);
        avlSet.add(c5);
        avlSet.add(c1);
        avlSet.add(c6);
        avlSet.add(c2);
        avlSet.add(c10);
        avlSet.add(c3);
        avlSet.add(c4);
        avlSet.add(c15);
        avlSet.add(c12);
        avlSet.add(c13);
        avlSet.add(c14);

        String visualizedString = avlSet.toVisualizedString(",");
        System.out.println(visualizedString);

        avlSet.remove(c6);

        visualizedString = avlSet.toVisualizedString(",");
        System.out.println(visualizedString);
    }
}
